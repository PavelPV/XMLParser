package com.pavel.xml;

import com.pavel.write.FileWriter;
import com.pavel.xml.entity.Generator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;

public class XMLReader {

    private FileInputStream inputStream;
    private String filePath;

    private static String TITLE = "title";
    private static String FIELDS_ITEM = "<fields_item>";
    private static String BL_FORM = "bl_form";
    private static String BL_REPORT = "bl_report";
    private static String COLUMNS_ITEM = "<columns_item>";

    public XMLReader(String filePath) throws FileNotFoundException {
        this.inputStream = new FileInputStream(filePath);
        this.filePath = filePath;
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
        String changesLine = "";
        String fieldName = "";
        while ((changesLine = bufferedReader.readLine()) != null) {
            String[] changesParameters = changesLine.split("=");
            if (changesParameters[0].equals("name")) {
                fieldName = changesParameters[1];
                continue;
            }
            writeIntoDetail(fieldName, changesParameters[0], changesParameters[1]);
            if (changesParameters[0].equals("new")) {
                fieldName = changesParameters[1];
            }
        }
    }

    /**
     * Method for writeIntoDetail all changes into xml file
     * Using FileWriter class from com.pavel.writeIntoDetail package
     *
     * @param fieldName  -  name of field to change
     * @param tag  - tag name of parameter to change
     * @param tagValue - value of tag(parameter) that must be changed
     *
     * @throws IOException
     */
    public void writeIntoDetail(String fieldName, String tag, String tagValue) throws IOException {
        FileWriter fileWriter = new FileWriter(this.filePath);

        int indexFrom = fileWriter.getFirstIndexOf(BL_FORM);
        if (tag.equals("titleD")) {
            this.findAndReplace(indexFrom, fileWriter.getFirstIndexOf(FIELDS_ITEM, indexFrom), TITLE, tagValue, fileWriter);
            return;
        }
        if (tag.equals("titleR")) {
            this.writeIntoReport(fieldName, tag, tagValue);
        }
        int index = fileWriter.getFirstIndexOf("<name>" + fieldName + "</name>", indexFrom);
        if (index == -1) {
            return;
        }

        int indexEnd = fileWriter.getFirstIndexOf(FIELDS_ITEM, index);

        if (tag.equals("placeD")) {
            this.moveElement(index, indexFrom, indexEnd, tagValue, FIELDS_ITEM, fileWriter);
            return;
        }

        if (tag.equals("placeR")) {
            this.writeIntoReport(fieldName, tag, tagValue);
        }


        if (tag.equals("new")) {
            if (!(fieldName.equals(tagValue))) {
                fileWriter.changeFilePartUsingMode("<name>" + fieldName + "</name>", " <name>" + tagValue + "</name>", index, 1);
                this.writeIntoReport(fieldName, tag, tagValue);
            }
            return;
        }
        /*
		 * find parameter for changing(marker) by regex pattern
		 */

        this.findAndReplace(index, indexEnd, tag, tagValue, fileWriter);

        if (tag.equals("label")) {
            this.writeIntoReport(fieldName, tag, tagValue);
        }
    }

    /**
     * Method for writeIntoDetail all changes into xml file into report part
     * Using FileWriter class from com.pavel.writeIntoDetail package
     *
     * @param columnName     of field to change
     * @param tag      of parameter to change
     * @param tagValue - value of tag(parameter) that must be changed
     *
     * @throws IOException
     */
    public void writeIntoReport(String columnName, String tag, String tagValue) throws IOException {
        FileWriter fileWriter = new FileWriter(this.filePath);

        int indexFrom = fileWriter.getFirstIndexOf(BL_REPORT);
        if (tag.equals(TITLE + "R")) {
            findAndReplace(indexFrom, fileWriter.getFirstIndexOf(COLUMNS_ITEM, indexFrom), TITLE, tagValue, fileWriter);
            return;
        }
        int index = fileWriter.getFirstIndexOf("<name>" + columnName + "</name>", indexFrom);
        int indexEnd = fileWriter.getFirstIndexOf(COLUMNS_ITEM, index);

        if (tag.equals("placeR")) {
            this.moveElement(index, indexFrom, indexEnd , tagValue, COLUMNS_ITEM, fileWriter);
            return;
        }

        if (tag.equals("new")) {
            if (!(columnName.equals(tagValue))) {
                fileWriter.changeFilePartUsingMode("<name>" + columnName + "</name>", " <name>" + tagValue + "</name>", index, 1);
            }
            return;
        }

		/*
		 * find parameter for changing(marker) by regex pattern
		 */

        this.findAndReplace(index, indexEnd, tag, tagValue, fileWriter);

    }

    public void findAndReplace(int index, int indexEnd, String tag, String tagValue, FileWriter fileWriter) throws IOException {
        String marker = fileWriter.getValueInFirstIndexByPattern("\\s*(<" + tag + ">\\S*</" + tag + ">)\\s*", index);
        String newText = "<"+ tag + ">" + tagValue + "</" + tag + ">";
        if ((!(marker.equals("-1")))&&(!(marker.equals(newText)))) {
            index = fileWriter.getFirstIndexOf(marker, index);
            if (index <= indexEnd) {
                fileWriter.changeFilePartUsingMode(marker.length(), " " + newText, index, 1);
            }
        }
    }

    public void moveElement(int index, int indexFrom, int indexEnd, String tagValue, String item, FileWriter fileWriter) throws IOException {
        index = fileWriter.getFirstPreviousIndex(item, indexFrom, index);
        List<Integer> indexesOfMarker = fileWriter.getAllIndexOf(item);
        /*
         * check location of element if it the same - return
         */
        int counter = 0;
        while(indexesOfMarker.get(counter) < indexFrom) {
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

        String piece = fileWriter.readFileFrom(index, indexEnd);
        fileWriter.changeFilePartUsingMode(piece, "", index, 1);
        fileWriter.changeFilePartUsingMode(item, piece, indexesOfMarker.get(counter), 0);
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

}