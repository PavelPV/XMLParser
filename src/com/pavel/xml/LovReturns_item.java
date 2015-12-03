package com.pavel.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class LovReturns_item {
	
	private String clazz;
	private String value;
	
	public LovReturns_item() {
	}
	
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
		return "LovReturns_item [clazz=" + clazz + ", value=" + value + "]";
	}
	
}