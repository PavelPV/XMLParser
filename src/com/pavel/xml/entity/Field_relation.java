package com.pavel.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity class that describe Field relation tag in field description in detail form
 * 
 * @author Pavel
 * Date 04-12-2015
 */
public class Field_relation {
	
	private String clazz;
	private String db_object;
	private List<Elements_item> elements_item;
	private String fieldRelationTemplate;
	
	public Field_relation() {}
	
	/**
	 * Inner static class
	 * for list of elements_item elements in xml
	 * @author Pavel
	 */
	public static class Elements_item {
		
		private String clazz;
		private String master_name;
		private String slave_name;
		
		public Elements_item(){}

		public String getClazz() {
			return clazz;
		}
		@XmlElement(name="class")
		public void setClazz(String clazz) {
			this.clazz = clazz;
		}

		public String getMaster_name() {
			return master_name;
		}
		@XmlElement
		public void setMaster_name(String master_name) {
			this.master_name = master_name;
		}

		public String getSlave_name() {
			return slave_name;
		}
		@XmlElement
		public void setSlave_name(String slave_name) {
			this.slave_name = slave_name;
		}

		@Override
		public String toString() {
			return ", master_name=" + master_name + ", slave_name=" + slave_name;
		}
		
	}

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

	public List<Elements_item> getElements_item() {
		return elements_item;
	}
	@XmlElementWrapper(name="elements")
	public void setElements_item(List<Elements_item> elements_item) {
		this.elements_item = elements_item;
	}

	public String getFieldRelationTemplate() {
		return fieldRelationTemplate;
	}
	@XmlElement
	public void setFieldRelationTemplate(String fieldRelationTemplate) {
		this.fieldRelationTemplate = fieldRelationTemplate;
	}
	@Override
	public String toString() {
		return "" + (db_object!=null ? "db_object=" + db_object : "")				
				+ (elements_item!=null ? ", elements_item=" + elements_item : "");
	}
}
