package com.pavel.xml;

import com.pavel.write.FileWriter;
import com.pavel.xml.entity.Generator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.util.List;
import java.util.stream.Stream;

public class XMLReader {

    private FileInputStream inputStream;
    private String filePath;
    private FileWriter fileWriter;

    private int indexStage;
    private int indexName;
    private int progress = 0;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private static String BLOCKS = "<blocks>";
    private static String FIELDS_ITEM = "<fields_item>";
    private static String BL_FORM = "bl_form";
    private static String BL_REPORT = "bl_report";
    private static String COLUMNS_ITEM = "<columns_item>";
    private static String NEW_COLUMN;
    private static String NEW_FIELD;
    static {
        try {
            StringWriter writer = new StringWriter();
            FileInputStream inputStreamNewEntity = new FileInputStream("XMLParser/src/new_column.txt");
            while(inputStreamNewEntity.available() > 0) {
                writer.write(inputStreamNewEntity.read());
            }
            NEW_COLUMN = writer.toString();
            writer = new StringWriter();
            inputStreamNewEntity = new FileInputStream("XMLParser/src/new_field.txt");
            while(inputStreamNewEntity.available() > 0) {
                writer.write(inputStreamNewEntity.read());
            }
            NEW_FIELD = writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public XMLReader(){}

    public XMLReader(String filePath) throws IOException {
        this.inputStream = new FileInputStream(filePath);
        this.filePath = filePath;
        this.fileWriter = new FileWriter(this.filePath);
    }

    public Generator parseXml() throws JAXBException, IOException {
        StringWriter writer = new StringWriter();
        while (inputStream.available() > 0) {
            writer.write(inputStream.read());
        }
        StringReader reader = new StringReader(this.dropDublicate(writer.toString()));
        JAXBContext context = JAXBContext.newInstance(Generator.class);
        Unmarshaller unmarshaler = context.createUnmarshaller();
        Generator xml = (Generator) unmarshaler.unmarshal(reader);
        return xml;
    }

    /**
     * Method that makes all changes in xml file
     *
     * @param bufferedReader
     *
     * @throws IOException
     */
    public void makeChanges(BufferedReader bufferedReader) throws IOException {
        String entityName = "";
        String stageName = "";
        Stream<String> stream = bufferedReader.lines();
        Object[] array = stream.toArray();
        long size = array.length;
        this.setProgress(0);
        for(Object line : array) {
            this.setProgress((int)(this.progress + (100 / size)));
            String changesLine = line.toString();
            String[] changesParameters = changesLine.split("=");
            switch (changesParameters[0]) {
                case "stage":
                    stageName = changesParameters[1];
                    this.indexStage = this.fileWriter.getFirstIndexOf(stageName);
                    break;
                case "name":
                    entityName = changesParameters[1];
                    this.indexName = this.fileWriter.getFirstIndexOf("<name>" + entityName + "</name>", this.indexStage);
                    break;
                case "new" :
                    try {
                        this.writeIntoStage(stageName, entityName, changesParameters[0], changesParameters[1]);
                        entityName = changesParameters[1];
                        break;
                    } catch(Exception e) {
                        e.printStackTrace();
                        break;
                    }
                case "add" :
                    try {
                        this.writeIntoStage(stageName, entityName, changesParameters[0], changesParameters[1]);
                        entityName = changesParameters[1];
                        this.indexName = this.fileWriter.getFirstIndexOf(
                                "<name>" + changesParameters[1] + "</name>", this.indexStage);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case "drop":
                    entityName = changesParameters[1];
                    this.indexName = this.fileWriter.getFirstIndexOf(
                            "<name>" + changesParameters[1] + "</name>", this.indexStage);
                    this.writeIntoStage(stageName, entityName, changesParameters[0], changesParameters[1]);
                    break;
                default:
                    try {
                        this.writeIntoStage(stageName, entityName, changesParameters[0], changesParameters[1]);
                    } catch(Exception e) {
                        e.printStackTrace();
                        continue;
                    }
            }
        }
        this.setProgress(100);
    }

    /**
     * Method for writeIntoStage all changes into xml file
     * Using FileWriter class from com.pavel.writeIntoStage package
     *
     * @param entityName  -  name of field to change
     * @param tag  - tag name of parameter to change
     * @param tagValue - value of tag(parameter) that must be changed
     *
     * @throws IOException
     */
    private void writeIntoStage(String stageName, String entityName, String tag, String tagValue) throws IOException {
        if ("".equals(entityName)) {
            this.findAndReplace(this.indexStage, this.fileWriter.getFirstIndexOf(BLOCKS, this.indexStage), tag, tagValue);
            return;
        }
        if (this.indexName == -1) { return; }

        String item;
        switch (stageName) {
            case "fields" :
                item = FIELDS_ITEM;
                break;
            case "columns":
                item = COLUMNS_ITEM;
                break;
            default       :
                item = FIELDS_ITEM;
        }

        int indexEnd = this.fileWriter.getFirstIndexOf(item, this.indexName);

        switch (tag) {
            case "place":
                this.moveElement(indexEnd, tagValue, item);
                this.indexName = this.fileWriter.getFirstIndexOf("<name>" + entityName + "</name>", this.indexStage);
                break;
            case "new"  :
                if (!(entityName.equals(tagValue))) {
                    this.fileWriter.changeFilePartUsingMode(
                            "<name>" + entityName + "</name>", "<name>" + tagValue + "</name>", this.indexName, 1);
                }
                break;
            case "add"  :
                this.fileWriter.changeFilePartUsingMode(item, createEntityBlock(stageName, tagValue), indexEnd, 0);
                break;
            case "drop" :
                int index = this.fileWriter.getFirstPreviousIndex(item, this.indexStage, this.indexName);
                this.fileWriter.changeFilePartUsingMode(this.fileWriter.readFileFrom(index, indexEnd), "", index, 1);
                break;
            default     :
                this.findAndReplace(this.indexName, indexEnd, tag, tagValue);
        }
    }

    public void findAndReplace(int index, int indexEnd, String tag, String tagValue) throws IOException {
        /*
		 * find parameter for changing(marker) by regex pattern
		 */
        String marker = this.fileWriter.getValueInFirstIndexByPattern("\\s*(<" + tag + ">\\S*</" + tag + ">)\\s*", index);
        String newText = "<"+ tag + ">" + tagValue + "</" + tag + ">";
        if ((!(marker.equals("-1")))&&(!(marker.equals(newText)))) {
            index = this.fileWriter.getFirstIndexOf(marker, index);
            if (index <= indexEnd) {
                this.fileWriter.changeFilePartUsingMode(marker.length(), newText, index, 1);
            }
        }
    }

    public void moveElement(int indexEnd, String tagValue, String item) throws IOException {
        int index = this.fileWriter.getFirstPreviousIndex(item, this.indexStage, this.indexName);
        List<Integer> indexesOfMarker = this.fileWriter.getAllIndexOf(item);
        /*
         * check location of element if it the same - return
         */
        int counter = 0;
        while(indexesOfMarker.get(counter) < this.indexStage) {
            counter++;
        }
        counter = counter + Integer.parseInt(tagValue);
        if (indexesOfMarker.get(counter).equals(index)){
            return;
        }
        /*
         * remove current element from list and change all next
         * work faster
         */
        int current = indexesOfMarker.indexOf(index);
        int difference = indexesOfMarker.get(current + 1) - indexesOfMarker.get(current);
        for(int i = current; i < indexesOfMarker.size()-1; i++) {
            indexesOfMarker.set(i, indexesOfMarker.get(i + 1) - difference);
        }
        indexesOfMarker.remove(indexesOfMarker.size()-1);

        String piece = this.fileWriter.readFileFrom(index, indexEnd);
        this.fileWriter.changeFilePartUsingMode(piece, "", index, 1);
        this.fileWriter.changeFilePartUsingMode(item, piece, indexesOfMarker.get(counter), 0);
    }

    private String createEntityBlock(String stageName, String tagValue) {
        String result;
        switch (stageName) {
            case "columns" :
                result = NEW_COLUMN;
                break;
            case "fields"  :
                result = NEW_FIELD;
                break;
            default        :
                result = "";
        }
        int index = result.indexOf("</name>");
        if (index!=-1) {
            result = result.substring(0, index) + tagValue + result.substring(index, result.length());
        }
        return result;
    }

    /**
     * This method clean xml from duplicate close tags
     * and other special characters : (^, <%, %>)
     * also it add prefix namespace definition into first tag
     * throw navigator field from return string
     *
     * @param xmlString - incorrect xml from file
     *
     * @return String value - correct xml
     *
     * @author Pavel
     */
    public String dropDublicate(String xmlString) {
		/*
		 * find duplicate tags
		 */
        int indexStart = xmlString.indexOf("</");
        int indexEnd = xmlString.indexOf(">", indexStart);
        int indexLast = xmlString.lastIndexOf(">");
        String tag = xmlString.substring(indexStart, indexEnd + 1);
        StringBuilder xmlBuilder = new StringBuilder(xmlString);
        while (indexEnd < indexLast) {
            indexStart = xmlBuilder.indexOf("<", indexEnd);
            indexEnd = xmlBuilder.indexOf(">", indexStart);
            String nextTag = xmlBuilder.substring(indexStart, indexEnd);
            if (tag.equals(nextTag)) {
                xmlBuilder.replace(indexStart, indexEnd + 1, "").toString();
            }
            tag = nextTag;
            indexLast = xmlBuilder.lastIndexOf(">");
        }
		/*
		 * add prefix namespace definition into first tag
		 */
        int index = xmlBuilder.indexOf(">");
        index = xmlBuilder.indexOf(">", index + 1);
        xmlBuilder.replace(index, index + 1, " xmlns:html='x' xmlns:bean='x'>");
		/*
		 * drop navigator field from return string
		 */
        index = xmlBuilder.indexOf("<name>_ge_navigator");
        if (index != -1) {
            xmlBuilder.replace(index, xmlBuilder.indexOf("</fields_item>", index), "");
        }
        index = xmlBuilder.indexOf("<name>bl_form</name>");
        if (index != -1) {
            xmlBuilder.replace(index, xmlBuilder.indexOf("</blocks_item>", index), "");
        }
        index = xmlBuilder.indexOf("<pluggableValidators_item>");
        if (index != -1) {
            xmlBuilder.replace(index, xmlBuilder.indexOf("</pluggableValidators>", index), "");
        }
		/*
		 * replace all special characters in xml
		 */
        xmlBuilder = new StringBuilder(xmlBuilder.toString().replaceAll("<%", "&lt;%"));
        xmlBuilder = new StringBuilder(xmlBuilder.toString().replaceAll("%>", "&gt;%"));
        xmlBuilder = new StringBuilder(xmlBuilder.toString().replaceAll("&", "&amp;"));
        return xmlBuilder.toString();

    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        int oldVal = this.progress;
        this.progress = progress;
        this.propertyChangeSupport.firePropertyChange("progress", oldVal, progress);
    }

    public FileInputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(FileInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
