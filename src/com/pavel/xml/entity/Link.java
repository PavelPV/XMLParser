package com.pavel.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Link {
	
	private String href;
	private String cursor;
	private List<Parameters_item> parameters_item;
	
	public Link(){}
	
	static class Parameters_item{
		private String clazz;
		private String value;
		
		public Parameters_item(){}

		public String getClazz() {
			return clazz;
		}
		@XmlElement(name="class")
		public void setClazz(String clazz) {
			this.clazz = clazz;
		}

		public String getValue() {
			return value;
		}
		@XmlElement
		public void setValue(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Parameters_item [clazz=" + clazz + ", value=" + value + "]";
		}
				
	}

	public String getHref() {
		return href;
	}
	@XmlElement
	public void setHref(String href) {
		this.href = href;
	}

	public String getCursor() {
		return cursor;
	}
	@XmlElement
	public void setCursor(String cursor) {
		this.cursor = cursor;
	}
	
	public List<Parameters_item> getParameters_item() {
		return parameters_item;
	}
	@XmlElementWrapper(name="parameters")
	public void setParameters_item(List<Parameters_item> parameters_item) {
		this.parameters_item = parameters_item;
	}
	@Override
	public String toString() {
		return "Link [href=" + href + ", cursor=" + cursor
				+ ", parameters_item=" + parameters_item + "]";
	}

}
