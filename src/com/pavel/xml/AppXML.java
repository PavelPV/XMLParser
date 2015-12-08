package com.pavel.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;

import com.pavel.write.App;
import com.pavel.xml.entity.Generator;


public class AppXML {
	
	private FileInputStream input;
	
	public AppXML(String file) throws FileNotFoundException {
		this.input = new FileInputStream(file);
	}
	
	public Generator parseXml() throws JAXBException, IOException {
		StringWriter writer = new StringWriter();
		while(input.available()>0) {
			writer.write(input.read());
		}
		StringReader reader = new StringReader(this.dropDublicate(writer.toString()));
		JAXBContext context = JAXBContext.newInstance(Generator.class);
		Unmarshaller unmarshaler = context.createUnmarshaller();
		Generator xml = (Generator) unmarshaler.unmarshal(reader);
		return xml;
	}

//	public static void main(String[] args) throws IOException, JAXBException, XMLStreamException{
//		FileInputStream input = new FileInputStream("C:/Users/Andreas/Desktop/workXMLfolder/test.txt");
//		BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/Andreas/Desktop/workXMLfolder/changes.txt"));
//		StringWriter writer = new StringWriter();
//		while(input.available()>0) {
//			writer.write(input.read());
//		}
//		StringReader reader = new StringReader(dropDublicate(writer.toString()));
//		JAXBContext context = JAXBContext.newInstance(Generator.class);
//
//		Unmarshaller unmarshaler = context.createUnmarshaller();
//
//		Generator xml = (Generator) unmarshaler.unmarshal(reader);
//		
//		System.out.println(xml);
//		
////		makeChanges(bufferedReader);
//	}
		

//	public static void main(String[] args) throws JAXBException {
//		JAXBContext context = JAXBContext.newInstance(Blocks_item.class);
//		Marshaller marshaller = context.createMarshaller();
//		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
////		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
////		XMLEventReader eventReader = inputFactory.createXMLEventReader(reader);
////		ItemsList xml = null;
//		
////		while(eventReader.hasNext()) {
////				XMLEvent eventS = eventReader.nextEvent();
////				if (eventS.isStartElement()) {
////					StartElement startElement = eventS.asStartElement();
////					if ((startElement.getName().getLocalPart()).equals("fields")) {
////						System.out.println();
////						xml = (ItemsList) unmarshaler.unmarshal(eventReader);
////					}
////				} else {
////					continue;
////				}
////		}		
//		Blocks_item item = new Blocks_item();
//		item.setBanner_type("banner");
//	
//		Fields_item xml = new Fields_item();
//		xml.setClazz("class");
//		List<Fields_item> list = new ArrayList<Fields_item> ();
//		list.add(xml);
//		list.add(xml);
//		item.setFields_item(list);
//		marshaller.marshal(item, System.out);		
//
//	}

	
	/**
	 * Method that makes all changes in xml file
	 * @param bufferedReader
	 * @throws IOException
	 */
	public void makeChanges(BufferedReader bufferedReader) throws IOException {
		String line = "";
		String name = "";
		while((line = bufferedReader.readLine())!=null) {
			String[] mas = line.split("=");
			if (mas[0].equals("name")) {
				name = mas[1];
				continue;
			}
			if (!(name.equals(""))) {
				write(name, mas[0], mas[1]);
			}
		}
	}
	
	
	/**
	 * Method for write all changes into xml file
	 * Using App class from com.pavel.write package
	 * @param name of field to change
	 * @param tag of parameter to change
	 * @param tagValue - value of tag(parameter) that must be changed
	 * @throws IOException
	 */
	public void write(String name, String tag, String tagValue) throws IOException {
		App write = new App("C:/Users/Andreas/Desktop/workXMLfolder/test.txt");
		int formIndex = write.getFirstIndexOf("bl_form");
		int index = write.getFirstIndexOf("<name>" + name + "</name>", formIndex);
		/*
		 * find parameter for changing(marker) by regex pattern
		 */
		String marker = write.getFirstIndexOfByPattern("\\s+(<" + tag + ">\\S*</" + tag + ">)", index);
		if (!(marker.equals("-1"))) {
			index = write.getFirstIndexOf(marker, index);
			write.run(marker, "<" + tag + ">" + tagValue + "</" + tag + ">", index, 1);
		}
	}
	
	/**
	 * This method clean xml from duplicate close tags
	 * and other special characters : (^, <%, %>)
	 * also it add prefix namespace definition into first tag
	 * throw navigator field from return string
	 * @author Pavel
	 * @param xmlString - incorrect xml from file
	 * @return String value - correct xml
	 */
	public String dropDublicate(String xmlString) {
		/*
		 * find duplicate tags
		 */
		int indexStart = xmlString.indexOf("</");
		int indexEnd = xmlString.indexOf(">", indexStart);
		int endIndex = xmlString.lastIndexOf(">");
		String tag = xmlString.substring(indexStart, indexEnd + 1);
		StringBuilder strXml = new StringBuilder(xmlString);
		while(indexEnd<endIndex) {
			indexStart = strXml.indexOf("<", indexEnd);
			indexEnd = strXml.indexOf(">", indexStart);
			String tempTag = strXml.substring(indexStart, indexEnd);
			if (tag.equals(tempTag)) {
				strXml.replace(indexStart, indexEnd+1, "").toString();
			}
			tag = tempTag;
			endIndex = strXml.lastIndexOf(">");
		}
		/*
		 * add prefix namespace definition into first tag
		 */
		int index = strXml.indexOf(">");
		index = strXml.indexOf(">", index+1);
		strXml.replace(index, index+1, " xmlns:html='x' xmlns:bean='x'>");
		/*
		 * throw navigator field from return string
		 */
		index = strXml.indexOf("<name>_ge_navigator");
		if (index != -1) {
			strXml.replace(index, strXml.indexOf("</fields_item>", index), "");
		}
		index = strXml.indexOf("<name>bl_form</name>");
		if (index != -1) {
			strXml.replace(index, strXml.indexOf("</blocks_item>",  index), "");
		}
		index = strXml.indexOf("<pluggableValidators_item>");
		if (index != -1) {
			strXml.replace(index, strXml.indexOf("</pluggableValidators>",  index), "");
		}
		/*
		 * replace all special characters in xml
		 */
		strXml = new StringBuilder(strXml.toString().replaceAll("<%", "&lt;%"));
		strXml = new StringBuilder(strXml.toString().replaceAll("%>", "&gt;%"));
		strXml = new StringBuilder(strXml.toString().replaceAll("&", "&amp;"));
		return strXml.toString();
		
	}

}
