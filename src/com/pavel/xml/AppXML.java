package com.pavel.xml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class AppXML {

	public static void main(String[] args) throws IOException, JAXBException, XMLStreamException{
		FileInputStream input = new FileInputStream("C:/Users/Andreas/Desktop/test.txt");
		StringWriter writer = new StringWriter();
		while(input.available()>0) {
			writer.write(input.read());
		}
		StringReader reader = new StringReader(dropDublicate(writer.toString()));
		JAXBContext context = JAXBContext.newInstance(ItemsList.class, EntityXML.class);
		Unmarshaller unmarshaler = context.createUnmarshaller();
		
//		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
//		XMLEventReader eventReader = inputFactory.createXMLEventReader(reader);
//		ItemsList xml = null;
//		
//		while(eventReader.hasNext()) {
//				XMLEvent eventS = eventReader.nextEvent();
//				if (eventS.isStartElement()) {
//					StartElement startElement = eventS.asStartElement();
//					if ((startElement.getName().getLocalPart()).equals("fields")) {
//						System.out.println();
//						xml = (ItemsList) unmarshaler.unmarshal(eventReader);
//					}
//				} else {
//					continue;
//				}
//		}
		ItemsList xml = (ItemsList) unmarshaler.unmarshal(reader);
		System.out.println(xml.itemsList);

	}
	
	public static String dropDublicate(String xmlString) {
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
		return strXml.toString(); 
	}

}
