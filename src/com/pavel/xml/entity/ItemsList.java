package com.pavel.xml.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="fields")
public class ItemsList {
	
	@XmlElement
	public List<Fields_item> fields_item;
	
	public ItemsList() {
		fields_item = new ArrayList<Fields_item>();
	}
	
}
