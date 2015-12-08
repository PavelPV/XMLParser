package com.pavel.xml.entity;

import javax.xml.bind.annotation.XmlElement;

public class Columns_item {
	
	private String name;
	private String block_name;
	private String database_column;
	private String i18n;
	private String label;
	private String type;
	private String align;
	private String visible;
	private String column_order;
	private String formula;
	private ColumnRelation columnRelation;
	private Link link;
	
	public Columns_item(){}

	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getBlock_name() {
		return block_name;
	}
	@XmlElement
	public void setBlock_name(String block_name) {
		this.block_name = block_name;
	}

	public String getDatabase_column() {
		return database_column;
	}
	@XmlElement
	public void setDatabase_column(String database_column) {
		this.database_column = database_column;
	}

	public String getI18n() {
		return i18n;
	}
	@XmlElement
	public void setI18n(String i18n) {
		this.i18n = i18n;
	}

	public String getLabel() {
		return label;
	}
	@XmlElement
	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}

	public String getAlign() {
		return align;
	}
	@XmlElement
	public void setAlign(String align) {
		this.align = align;
	}

	public String getVisible() {
		return visible;
	}
	@XmlElement
	public void setVisible(String visible) {
		this.visible = visible;
	}

	public String getColumn_order() {
		return column_order;
	}
	@XmlElement
	public void setColumn_order(String column_order) {
		this.column_order = column_order;
	}

	public String getFormula() {
		return formula;
	}
	@XmlElement
	public void setFormula(String formula) {
		this.formula = formula;
	}

	public ColumnRelation getColumnRelation() {
		return columnRelation;
	}
	@XmlElement
	public void setColumnRelation(ColumnRelation columnRelation) {
		this.columnRelation = columnRelation;
	}

	public Link getLink() {
		return link;
	}
	@XmlElement
	public void setLink(Link link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "\nColumns_item [name=" + name + "\n"
				+ ", block_name=" + block_name + "\n"
				+ ", database_column=" + database_column + "\n"
				+ ", i18n=" + i18n + "\n"
				+ ", label=" + label + "\n"
				+ ", type=" + type + "\n"
				+ ", align=" + align + "\n"
				+ ", visible=" + visible + "\n"
				+ ", column_order=" + column_order + "\n"
				+ ", formula=" + formula + "\n"
				+ ", columnRelation=" + columnRelation + "\n"
				+ ", link=" + link + "]";
	}
	
	

}
