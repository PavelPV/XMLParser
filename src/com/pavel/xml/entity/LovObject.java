package com.pavel.xml.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity class that describe lovObject parameter in each field in detail form
 * 
 * @author Pavel
 * Date 04-12-2015
 */
//@XmlRootElement
public class LovObject {
	
	private String clazzz;
	private String lovAction;
	private List<LovReturns_item> lovReturns_item = new ArrayList<LovReturns_item>();
	private String lovLabel;
	private String lovHeight;
	private String lovWidth;
	private String lovTop;
	private String lovLeft;
	
	public LovObject() {
	}
	
	/**
	 * Inner static class
	 * for list of lovReturns_item elements in xml
	 * @author Pavel
	 * Date 04-12-2015
	 */
	static class LovReturns_item {
		
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
	
	public String getClazz() {
		return clazzz;
	}
	@XmlElement(name = "class")
	public void setClazz(String clazz) {
		this.clazzz = clazz;
	}	
	public String getLovAction() {
		return lovAction;
	}
	@XmlElement
	public void setLovAction(String lovAction) {
		this.lovAction = lovAction;
	}
	public List<LovReturns_item> getLovReturns_item() {
		return lovReturns_item;
	}
	@XmlElementWrapper(name="lovReturns", nillable = true)
	public void setLovReturns_item(List<LovReturns_item> lovReturns_item) {
		this.lovReturns_item = lovReturns_item;
	}
	public String getLovLabel() {
		return lovLabel;
	}
	@XmlElement
	public void setLovLabel(String lovLabel) {
		this.lovLabel = lovLabel;
	}
	public String getLovHeight() {
		return lovHeight;
	}
	@XmlElement
	public void setLovHeight(String lovHeight) {
		this.lovHeight = lovHeight;
	}
	public String getLovWidth() {
		return lovWidth;
	}
	@XmlElement
	public void setLovWidth(String lovWidth) {
		this.lovWidth = lovWidth;
	}
	public String getLovTop() {
		return lovTop;
	}
	@XmlElement
	public void setLovTop(String lovTop) {
		this.lovTop = lovTop;
	}
	public String getLovLeft() {
		return lovLeft;
	}
	@XmlElement
	public void setLovLeft(String lovLeft) {
		this.lovLeft = lovLeft;
	}
	@Override
	public String toString() {
		return "LovObject [clazz=" + clazzz + ", lovAction=" + lovAction
				+ ", lovReturns=" + lovReturns_item + ", lovLabel=" + lovLabel
				+ ", lovHeight=" + lovHeight + ", lovWidth=" + lovWidth
				+ ", lovTop=" + lovTop + ", lovLeft=" + lovLeft + "]";
	}
	
	

}
