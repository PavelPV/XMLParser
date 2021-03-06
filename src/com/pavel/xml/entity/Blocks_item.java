package com.pavel.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

public class Blocks_item {
	
	private String clazz;
	private String name;
	private String title;
	private String i18n;
	private String database;
	private String db_object;
	private String message_type;
	private String banner_type;
	private String tab_pos;
	private String block_size;
	private String displayError;
	private String navigatorProperties;
	private List<Fields_item> fields_item;
	private List<Columns_item> columns_item;
	
	public Blocks_item(){}

	public String getClazz() {
		return clazz;
	}
	@XmlElement(name="class")
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	public String getI18n() {
		return i18n;
	}
	@XmlElement
	public void setI18n(String i18n) {
		this.i18n = i18n;
	}

	public String getDatabase() {
		return database;
	}
	@XmlElement
	public void setDatabase(String database) {
		this.database = database;
	}

	public String getDb_object() {
		return db_object;
	}
	@XmlElement
	public void setDb_object(String db_object) {
		this.db_object = db_object;
	}

	public String getMessage_type() {
		return message_type;
	}
	@XmlElement
	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}

	public String getBanner_type() {
		return banner_type;
	}
	@XmlElement
	public void setBanner_type(String banner_type) {
		this.banner_type = banner_type;
	}

	public String getTab_pos() {
		return tab_pos;
	}
	@XmlElement
	public void setTab_pos(String tab_pos) {
		this.tab_pos = tab_pos;
	}

	public String getBlock_size() {
		return block_size;
	}
	@XmlElement
	public void setBlock_size(String block_size) {
		this.block_size = block_size;
	}

	public String getDisplayError() {
		return displayError;
	}
	@XmlElement
	public void setDisplayError(String displayError) {
		this.displayError = displayError;
	}

	public String getNavigatorProperties() {
		return navigatorProperties;
	}
	@XmlElement
	public void setNavigatorProperties(String navigatorProperties) {
		this.navigatorProperties = navigatorProperties;
	}
	
	public List<Fields_item> getFields_item() {
		return fields_item;
	}
	@XmlElementWrapper(name="fields")
	public void setFields_item(List<Fields_item> fields_item) {
		this.fields_item = fields_item;
	}
	
	public List<Columns_item> getColumns_item() {
		return columns_item;
	}
	@XmlElementWrapper(name="columns")
	public void setColumns_item(List<Columns_item> columns_item) {
		this.columns_item = columns_item;
	}

	@Override
	public String toString() {
		return "Block_item: \n"
				+ "[clazz=" + clazz + "\n"
				+ "name=" + name  + "\n"
				+ "title=" + title + "\n"
				+ "i18n=" + i18n + "\n"
				+ "database=" + database + "\n"
				+ "db_object=" + db_object + "\n"
				+ "message_type=" + message_type + "\n"
				+ "banner_type=" + banner_type + "\n"
				+ "tab_pos=" + tab_pos + "\n"
				+ "block_size=" + block_size + "\n"
				+ "displayError=" + displayError + "\n"
				+ "navigatorProperties=" + navigatorProperties + "\n"
				+ "Fields: \n" + fields_item + "\n"
				+ "Columns: \n"+ columns_item + "]";
	}

}
