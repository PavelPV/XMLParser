package com.pavel.xml.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Entity class that describe each field tag in detail form
 * 
 * @author Pavel
 * Date 04-12-2015
 */
public class Fields_item {
	
	private String clazz;
	private String name;
	private String help;
	private String i18nHelp;	
	private String block_name;
	private String database_column;
	private String i18n;
	private String show_help;
	private String show_help_label;
	private String tabs;
	private String format;
	private String property;
	private String label;
	private String label_pos;
	private String not_null;
	private String type;
	private String case_restriction;
	private String break_line;
	private LovObject lovObject;
	private String lowest_value;
	private String highest_value;
	private String validate_not_null;
	private String select_allowed;
	private String update_allowed;
	private String insert_allowed;
	private String isCustomized;
	private String codeItem;
	private String disabled;
	private String onblur;
	private String onchange;
	private String onclick;
	private String ondblclick;
	private String onfocus;
	private String onkeydown;
	private String onkeypress;
	private String onkeyup;
	private String onmousedown;
	private String styleClass;
	private Field_relation field_relation;
	private String onmousemove;
	private String onmouseout;
	private String onmouseover;
	private String onmouseup;
	private String readonly;
	private String value;
	private String size;
	private String maxlength;
	private String falseValue;
	private Options options;
	
	
	public Fields_item() {}
	public String getClazz() {
		return clazz;
	}
	@XmlElement(name = "class")
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
	public String getHelp() {
	  return help;
	}
	@XmlElement
	public void setHelp(String help) {
	  this.help = help;
	}
	public String getI18nHelp() {
	  return i18nHelp;
	}
	@XmlElement
	public void setI18nHelp(String i18nHelp) {
	  this.i18nHelp = i18nHelp;
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
	public String getShow_help() {
	  return show_help;
	}
	@XmlElement
	public void setShow_help(String show_help) {
	  this.show_help = show_help;
	}
	public String getShow_help_label() {
	  return show_help_label;
	}
	@XmlElement
	public void setShow_help_label(String show_help_label) {
	  this.show_help_label = show_help_label;
	}
	public String getTabs() {
	  return tabs;
	}
	@XmlElement
	public void setTabs(String tabs) {
	  this.tabs = tabs;
	}
	public String getFormat() {
	  return format;
	}
	@XmlElement
	public void setFormat(String format) {
	  this.format = format;
	}
	public String getProperty() {
	  return property;
	}
	@XmlElement
	public void setProperty(String property) {
	  this.property = property;
	}
	public String getLabel() {
	  return label;
	}
	@XmlElement
	public void setLabel(String label) {
	  this.label = label;
	}
	public String getLabel_pos() {
	  return label_pos;
	}
	@XmlElement
	public void setLabel_pos(String label_pos) {
	  this.label_pos = label_pos;
	}
	public String getNot_null() {
	  return not_null;
	}
	@XmlElement
	public void setNot_null(String not_null) {
	  this.not_null = not_null;
	}
	public String getType() {
	  return type;
	}
	@XmlElement
	public void setType(String type) {
	  this.type = type;
	}
	public String getCase_restriction() {
	  return case_restriction;
	}
	@XmlElement
	public void setCase_restriction(String case_restriction) {
	  this.case_restriction = case_restriction;
	}
	public String getBreak_line() {
	  return break_line;
	}
	@XmlElement
	public void setBreak_line(String break_line) {
	  this.break_line = break_line;
	}
	public LovObject getLovObject() {
	  return lovObject;
	}
	@XmlElement
	public void setLovObject(LovObject lovObject) {
	  this.lovObject = lovObject;
	}
	public String getLowest_value() {
	  return lowest_value;
	}
	@XmlElement
	public void setLowest_value(String lowest_value) {
	  this.lowest_value = lowest_value;
	}
	public String getHighest_value() {
	  return highest_value;
	}
	@XmlElement
	public void setHighest_value(String highest_value) {
	  this.highest_value = highest_value;
	}
	public String getValidate_not_null() {
	  return validate_not_null;
	}
	@XmlElement
	public void setValidate_not_null(String validate_not_null) {
	  this.validate_not_null = validate_not_null;
	}
	public String getSelect_allowed() {
	  return select_allowed;
	}
	@XmlElement
	public void setSelect_allowed(String select_allowed) {
	  this.select_allowed = select_allowed;
	}
	public String getUpdate_allowed() {
	  return update_allowed;
	}
	@XmlElement
	public void setUpdate_allowed(String update_allowed) {
	  this.update_allowed = update_allowed;
	}
	public String getInsert_allowed() {
	  return insert_allowed;
	}
	@XmlElement
	public void setInsert_allowed(String insert_allowed) {
	  this.insert_allowed = insert_allowed;
	}
	public String getIsCustomized() {
	  return isCustomized;
	}
	@XmlElement
	public void setIsCustomized(String isCustomized) {
	  this.isCustomized = isCustomized;
	}
	public String getCodeItem() {
	  return codeItem;
	}
	@XmlElement
	public void setCodeItem(String codeItem) {
	  this.codeItem = codeItem;
	}
	public String getDisabled() {
	  return disabled;
	}
	@XmlElement
	public void setDisabled(String disabled) {
	  this.disabled = disabled;
	}
	public String getOnblur() {
	  return onblur;
	}
	@XmlElement
	public void setOnblur(String onblur) {
	  this.onblur = onblur;
	}
	public String getOnchange() {
	  return onchange;
	}
	@XmlElement
	public void setOnchange(String onchange) {
	  this.onchange = onchange;
	}
	public String getOnclick() {
	  return onclick;
	}
	@XmlElement
	public void setOnclick(String onclick) {
	  this.onclick = onclick;
	}
	public String getOndblclick() {
	  return ondblclick;
	}
	@XmlElement
	public void setOndblclick(String ondblclick) {
	  this.ondblclick = ondblclick;
	}
	public String getOnfocus() {
	  return onfocus;
	}
	@XmlElement
	public void setOnfocus(String onfocus) {
	  this.onfocus = onfocus;
	}
	public String getOnkeydown() {
	  return onkeydown;
	}
	@XmlElement
	public void setOnkeydown(String onkeydown) {
	  this.onkeydown = onkeydown;
	}
	public String getOnkeypress() {
	  return onkeypress;
	}
	@XmlElement
	public void setOnkeypress(String onkeypress) {
	  this.onkeypress = onkeypress;
	}
	public String getOnkeyup() {
	  return onkeyup;
	}
	@XmlElement
	public void setOnkeyup(String onkeyup) {
	  this.onkeyup = onkeyup;
	}
	public String getOnmousedown() {
	  return onmousedown;
	}
	@XmlElement
	public void setOnmousedown(String onmousedown) {
	  this.onmousedown = onmousedown;
	}
	public String getStyleClass() {
	  return styleClass;
	}
	@XmlElement
	public void setStyleClass(String styleClass) {
	  this.styleClass = styleClass;
	}
	public Field_relation getField_relation() {
	  return field_relation;
	}
	@XmlElement
	public void setField_relation(Field_relation field_relation) {
	  this.field_relation = field_relation;
	}
	public String getOnmousemove() {
	  return onmousemove;
	}
	@XmlElement
	public void setOnmousemove(String onmousemove) {
	  this.onmousemove = onmousemove;
	}
	public String getOnmouseout() {
	  return onmouseout;
	}
	@XmlElement
	public void setOnmouseout(String onmouseout) {
	  this.onmouseout = onmouseout;
	}
	public String getOnmouseover() {
	  return onmouseover;
	}
	@XmlElement
	public void setOnmouseover(String onmouseover) {
	  this.onmouseover = onmouseover;
	}
	public String getOnmouseup() {
	  return onmouseup;
	}
	@XmlElement
	public void setOnmouseup(String onmouseup) {
	  this.onmouseup = onmouseup;
	}
	public String getReadonly() {
	  return readonly;
	}
	@XmlElement
	public void setReadonly(String readonly) {
	  this.readonly = readonly;
	}
	public String getValue() {
	  return value;
	}
	@XmlElement
	public void setValue(String value) {
	  this.value = value;
	}
	public String getSize() {
	  return size;
	}
	@XmlElement
	public void setSize(String size) {
	  this.size = size;
	}
	public String getMaxlength() {
	  return maxlength;
	}
	@XmlElement
	public void setMaxlength(String maxlength) {
	  this.maxlength = maxlength;
	}
	public String getFalseValue() {
		return falseValue;
	}
	@XmlElement
	public void setFalseValue(String falseValue) {
		this.falseValue = falseValue;
	}
	public Options getOptions() {
		return options;
	}
	@XmlElement
	public void setOptions(Options options) {
		this.options = options;
	}


	@Override
	public String toString() {
		return "EntityXML \n"
	              + ((!("".equals(clazz))&&(clazz!=null)) ? "class=" + clazz + "\n" : "" )
	              + ((!("".equals(name))&&(name!=null)) ? "name=" + name + "\n" : "" )
	              + ((!("".equals(help))&&(help!=null)) ? "help=" + help + "\n" : "" )
	              + ((!("".equals(i18nHelp))&&(i18nHelp!=null)) ? "i18nHelp=" + i18nHelp + "\n" : "" )
	              + ((!("".equals(block_name))&&(block_name!=null)) ? "block_name=" + block_name + "\n"  : "")
	              + ((!("".equals(database_column))&&(database_column!=null)) ? "database_column=" + database_column + "\n"  : "")
	              + ((!("".equals(i18n))&&(i18n!=null)) ? "i18n=" + i18n + "\n"  : "")
	              + ((!("".equals(show_help))&&(show_help!=null)) ? "show_help=" + show_help + "\n" : "")
	              + ((!("".equals(show_help_label))&&(show_help_label!=null)) ? "show_help_label=" + show_help_label + "\n"  : "")
	              + ((!("".equals(tabs))&&(tabs!=null)) ? "tabs=" + tabs + "\n" : "")
	              + ((!("".equals(format))&&(format!=null)) ? "format=" + format + "\n"  : "")
	              + ((!("".equals(property))&&(property!=null)) ? "property=" + property + "\n"  : "")
	              + ((!("".equals(label))&&(label!=null)) ? "label=" + label + "\n" : "")
	              + ((!("".equals(label_pos))&&(label_pos!=null)) ? "label_pos=" + label_pos + "\n"  : "")
	              + ((!("".equals(not_null))&&(not_null!=null)) ? "not_null=" + not_null + "\n"  : "")
	              + ((!("".equals(type))&&(type!=null)) ? "type=" + type + "\n" : "")
	              + ((!("".equals(case_restriction))&&(case_restriction!=null)) ? "case_restriction=" + case_restriction + "\n"  : "")
	              + ((!("".equals(break_line))&&(break_line!=null)) ? "break_line="+ break_line + "\n"  : "")
	              + ((!("".equals(lovObject))&&(lovObject!=null)) ? "lovObject=" + lovObject + "\n"  : "")
	              + ((!("".equals(lowest_value))&&(lowest_value!=null)) ? "lowest_value="+ lowest_value + "\n"  : "")
	              + ((!("".equals(highest_value))&&(highest_value!=null)) ? "highest_value=" + highest_value + "\n" : "")
	              + ((!("".equals(validate_not_null))&&(validate_not_null!=null)) ? "validate_not_null="+ validate_not_null + "\n"  : "")
	              + ((!("".equals(select_allowed))&&(select_allowed!=null)) ? "select_allowed=" + select_allowed + "\n" : "")
	              + ((!("".equals(update_allowed))&&(update_allowed!=null)) ? "update_allowed=" + update_allowed + "\n"  : "")
	              + ((!("".equals(insert_allowed))&&(insert_allowed!=null)) ? "insert_allowed="+ insert_allowed + "\n"  : "")
	              + ((!("".equals(isCustomized))&&(isCustomized!=null)) ? "isCustomized=" + isCustomized + "\n" : "")
	              + ((!("".equals(codeItem))&&(codeItem!=null)) ? "codeItem=" + codeItem + "\n"  : "")
	              + ((!("".equals(disabled))&&(disabled!=null)) ? "disabled=" + disabled + "\n"  : "")
	              + ((!("".equals(onblur))&&(onblur!=null)) ? "onblur=" + onblur + "\n" : "")
	              + ((!("".equals(onchange))&&(onchange!=null)) ? "onchange=" + onchange + "\n"  : "")
	              + ((!("".equals(onclick))&&(onclick!=null)) ? "onclick=" + onclick + "\n" : "")
	              + ((!("".equals(ondblclick))&&(ondblclick!=null)) ? "ondblclick=" + ondblclick + "\n"  : "")
	              + ((!("".equals(onfocus))&&(onfocus!=null)) ? "onfocus=" + onfocus + "\n" : "")
	              + ((!("".equals(onkeydown))&&(onkeydown!=null)) ? "onkeydown=" + onkeydown + "\n"  : "")
	              + ((!("".equals(onkeypress))&&(onkeypress!=null)) ? "onkeypress=" + onkeypress + "\n" : "")
	              + ((!("".equals(onkeyup))&&(onkeyup!=null)) ? "onkeyup=" + onkeyup + "\n"  : "")
	              + ((!("".equals(onmousedown))&&(onmousedown!=null)) ? "onmousedown=" + onmousedown + "\n" : "")
	              + ((!("".equals(styleClass))&&(styleClass!=null)) ? "styleClass=" + styleClass + "\n" : "")
	              + ((!("".equals(field_relation))&&(field_relation!=null)) ? "field_relation=" + field_relation + "\n"  : "")
	              + ((!("".equals(onmousemove))&&(onmousemove!=null)) ? "onmousemove="+ onmousemove + "\n"  : "")
	              + ((!("".equals(onmouseout))&&(onmouseout!=null)) ? "onmouseout=" + onmouseout + "\n"  : "")
	              + ((!("".equals(onmouseover))&&(onmouseover!=null)) ? "onmouseover="+ onmouseover + "\n"  : "")
	              + ((!("".equals(onmouseup))&&(onmouseup!=null)) ? "onmouseup=" + onmouseup + "\n"  : "")
	              + ((!("".equals(readonly))&&(readonly!=null)) ? "readonly="+ readonly + "\n"  : "")
	              + ((!("".equals(value))&&(value!=null)) ? "value=" + value + "\n"  : "")
	              + ((!("".equals(size))&&(size!=null)) ? "size=" + size + "\n" : "")
	              + ((!("".equals(falseValue))&&(falseValue!=null)) ? "falseValue=" + falseValue + "\n" : "")
	              + ((!("".equals(options))&&(options!=null)) ? "options=" + options + "\n" : "")
	              + ((!("".equals(maxlength))&&(maxlength!=null)) ? "maxlength=" + maxlength + "\n" : ""); 
	}
}
