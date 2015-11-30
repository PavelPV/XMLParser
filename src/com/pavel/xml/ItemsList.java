package com.pavel.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="fields")
public class ItemsList {
	
	public List<EntityXML> itemsList;
	
}
