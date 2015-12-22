package com.pavel.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.pavel.xml.entity.Field_relation.Elements_item;

public class ColumnRelation {
	
	private String clazz;
	private String db_object;
	private String columnRelationTemplate;
	private String columnRelationEnumerationFile;
	private List<Elements_item> elements_item;


	public ColumnRelation(){}

	public String getClazz() {
		return clazz;
	}
	@XmlElement(name="class")
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getDb_object() {
		return db_object;
	}
	@XmlElement
	public void setDb_object(String db_object) {
		this.db_object = db_object;
	}

	public String getColumnRelationTemplate() {
		return columnRelationTemplate;
	}
	@XmlElement
	public void setColumnRelationTemplate(String columnRelationTemplate) {
		this.columnRelationTemplate = columnRelationTemplate;
	}

	public String getColumnRelationEnumerationFile() {
		return columnRelationEnumerationFile;
	}
	@XmlElement
	public void setColumnRelationEnumerationFile(
			String columnRelationEnumerationFile) {
		this.columnRelationEnumerationFile = columnRelationEnumerationFile;
	}
	
	public List<Elements_item> getElements_item() {
		return elements_item;
	}
	@XmlElementWrapper(name="elements")
	public void setElements_item(List<Elements_item> elements_item) {
		this.elements_item = elements_item;
	}

	@Override
	public String toString() {
		return "" + (db_object!=null ? "db_object=" + db_object : "")
				+ (columnRelationEnumerationFile!=null ? ", columnRelationEnumerationFile=" + columnRelationEnumerationFile : "")
				+ (elements_item!=null ? ", elements_item="+ elements_item : "");
	}
	
	

}
