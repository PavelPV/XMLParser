package com.pavel.xml.entity;

import javax.xml.bind.annotation.XmlElement;

/**
 * Entity class that describe options parameter in each enumeration field in detail form
 * 
 * @author Pavel
 * Date 04-12-2015
 */
public class Options {
	
	private String clazz;      
	private String property;
	private String labelProperty;
	private String db_object;
	private String db_value;
	private String db_label;
	private String template;
	private String listCode;
	private String fileName;
	
	public Options() {
	}

	public String getClazz() {
		return clazz;
	}
	@XmlElement(name="class")
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getProperty() {
		return property;
	}
	@XmlElement
	public void setProperty(String property) {
		this.property = property;
	}
	public String getLabelProperty() {
		return labelProperty;
	}
	@XmlElement
	public void setLabelProperty(String labelProperty) {
		this.labelProperty = labelProperty;
	}
	public String getDb_object() {
		return db_object;
	}
	@XmlElement
	public void setDb_object(String db_object) {
		this.db_object = db_object;
	}
	public String getDb_value() {
		return db_value;
	}
	@XmlElement
	public void setDb_value(String db_value) {
		this.db_value = db_value;
	}
	public String getDb_label() {
		return db_label;
	}
	@XmlElement
	public void setDb_label(String db_label) {
		this.db_label = db_label;
	}
	public String getTemplate() {
		return template;
	}
	@XmlElement
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getListCode() {
		return listCode;
	}
	@XmlElement
	public void setListCode(String listCode) {
		this.listCode = listCode;
	}
	public String getFileName() {
		return fileName;
	}
	@XmlElement
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String toString() {
		return fileName;
	}

}
