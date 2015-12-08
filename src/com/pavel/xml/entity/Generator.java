package com.pavel.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Generator {
	
	private String file_name;
	private String app_type;
	private String table_size;
	private String jspTemplate;
	private String multiclick;

	private List<Blocks_item> blocks_item;
	
	public Generator() {}
	
	
	public String getFile_name() {
		return file_name;
	}
	@XmlElement
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getApp_type() {
		return app_type;
	}
	@XmlElement
	public void setApp_type(String app_type) {
		this.app_type = app_type;
	}

	public String getTable_size() {
		return table_size;
	}
	@XmlElement
	public void setTable_size(String table_size) {
		this.table_size = table_size;
	}

	public String getJspTemplate() {
		return jspTemplate;
	}
	@XmlElement
	public void setJspTemplate(String jspTemplate) {
		this.jspTemplate = jspTemplate;
	}

	public String getMulticlick() {
		return multiclick;
	}
	@XmlElement
	public void setMulticlick(String multiclick) {
		this.multiclick = multiclick;
	}

	public List<Blocks_item> getBlocks_item() {
		return blocks_item;
	}
	@XmlElementWrapper(name="blocks")
	public void setBlocks_item(List<Blocks_item> blocks_item) {
		this.blocks_item = blocks_item;
	}

	@Override
	public String toString() {
		return "Generator ----- Page parameters:\n "
				+ "file_name=" + file_name + "\n"
				+ "app_type=" + app_type + "\n"
				+ "table_size=" + table_size + "\n"
				+ "jspTemplate=" + jspTemplate + "\n"
				+ "multiclick=" + multiclick + "\n"
				+ "Blocks: \n" + blocks_item;
	}
}
