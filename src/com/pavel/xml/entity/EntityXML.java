package com.pavel.xml.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "fields_item")
public class EntityXML {
	
	private String clazz;
	private String name;
	private String help;
	private String i18nHelp;
	private String develHelp;
	private String block_name;
	private String role_item;
	private String database_column;
	private String roleinclude;
	private String i18n;
	private String show_help;
	private String show_help_label;
	private String tabs;
	private String format;
	private String title;
	private String titleKey;
	private String left;
	private String top;
	private String z_index;
	private String property;
	private String label;
	private String label_pos;
	private String label_bg_color;
	private String label_fg_color;
	private String label_size;
	private String label_align;
	private String label_font;
	private String labelPropertytext;
	private String label_bold;
	private String label_italic;
	private String justification;
	private String not_null;
	private String type;
	private String validate_message;
	private String validate_message_user;
	private String case_restriction;
	private String break_line;
	private String lovObject;
	private String lowest_value;
	private String highest_value;
	private String validate_value;
	private String validate_type;
	private String validate_group;
	private String validate_email;
	private String validate_not_null;
	private String validate_minlength;
	private String validate_maxlength;
	private String validate_regex;
	private String src;
	private String select_allowed;
	private String update_allowed;
	private String insert_allowed;
	private String isCustomized;
	private String codeItem;
	private String labelStyle;
	private String labelTitle;
	private String labelTitleKey;
	private String fieldGridSize;
	private String queryOperator;
	private String round_value;
	private String field_prefix;
	private String field_sufix;
	private String write;
	private String fieldSetProperty;
	private String accesskey;
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
	private String style;
	private String styleClass;
	private String styleId;
	private String tabindex;
	private String field_relation;
	private String onmousemove;
	private String onmouseout;
	private String onmouseover;
	private String onmouseup;
	private String readonly;
	private String value;
	private String size;
	private String maxlength;
	
	
	public EntityXML() {}
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
	public String getDevelHelp() {
	  return develHelp;
	}
	@XmlElement
	public void setDevelHelp(String develHelp) {
	  this.develHelp = develHelp;
	}
	public String getBlock_name() {
	  return block_name;
	}
	@XmlElement
	public void setBlock_name(String block_name) {
	  this.block_name = block_name;
	}
	public String getRole_item() {
	  return role_item;
	}
	@XmlElement
	public void setRole_item(String role_item) {
	  this.role_item = role_item;
	}
	public String getDatabase_column() {
	  return database_column;
	}
	@XmlElement
	public void setDatabase_column(String database_column) {
	  this.database_column = database_column;
	}
	public String getRoleinclude() {
	  return roleinclude;
	}
	@XmlElement
	public void setRoleinclude(String roleinclude) {
	  this.roleinclude = roleinclude;
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
	public String getTitle() {
	  return title;
	}
	@XmlElement
	public void setTitle(String title) {
	  this.title = title;
	}
	public String getTitleKey() {
	  return titleKey;
	}
	@XmlElement
	public void setTitleKey(String titleKey) {
	  this.titleKey = titleKey;
	}
	public String getLeft() {
	  return left;
	}
	@XmlElement
	public void setLeft(String left) {
	  this.left = left;
	}
	public String getTop() {
	  return top;
	}
	@XmlElement
	public void setTop(String top) {
	  this.top = top;
	}
	public String getZ_index() {
	  return z_index;
	}
	@XmlElement
	public void setZ_index(String z_index) {
	  this.z_index = z_index;
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
	public String getLabel_bg_color() {
	  return label_bg_color;
	}
	@XmlElement
	public void setLabel_bg_color(String label_bg_color) {
	  this.label_bg_color = label_bg_color;
	}
	public String getLabel_fg_color() {
	  return label_fg_color;
	}
	@XmlElement
	public void setLabel_fg_color(String label_fg_color) {
	  this.label_fg_color = label_fg_color;
	}
	public String getLabel_size() {
	  return label_size;
	}
	@XmlElement
	public void setLabel_size(String label_size) {
	  this.label_size = label_size;
	}
	public String getLabel_align() {
	  return label_align;
	}
	@XmlElement
	public void setLabel_align(String label_align) {
	  this.label_align = label_align;
	}
	public String getLabel_font() {
	  return label_font;
	}
	@XmlElement
	public void setLabel_font(String label_font) {
	  this.label_font = label_font;
	}
	public String getLabelPropertytext() {
	  return labelPropertytext;
	}
	@XmlElement
	public void setLabelPropertytext(String labelPropertytext) {
	  this.labelPropertytext = labelPropertytext;
	}
	public String getLabel_bold() {
	  return label_bold;
	}
	@XmlElement
	public void setLabel_bold(String label_bold) {
	  this.label_bold = label_bold;
	}
	public String getLabel_italic() {
	  return label_italic;
	}
	@XmlElement
	public void setLabel_italic(String label_italic) {
	  this.label_italic = label_italic;
	}
	public String getJustification() {
	  return justification;
	}
	@XmlElement
	public void setJustification(String justification) {
	  this.justification = justification;
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
	public String getValidate_message() {
	  return validate_message;
	}
	@XmlElement
	public void setValidate_message(String validate_message) {
	  this.validate_message = validate_message;
	}
	public String getValidate_message_user() {
	  return validate_message_user;
	}
	@XmlElement
	public void setValidate_message_user(String validate_message_user) {
	  this.validate_message_user = validate_message_user;
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
	public String getLovObject() {
	  return lovObject;
	}
	@XmlElement
	public void setLovObject(String lovObject) {
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
	public String getValidate_value() {
	  return validate_value;
	}
	@XmlElement
	public void setValidate_value(String validate_value) {
	  this.validate_value = validate_value;
	}
	public String getValidate_type() {
	  return validate_type;
	}
	@XmlElement
	public void setValidate_type(String validate_type) {
	  this.validate_type = validate_type;
	}
	public String getValidate_group() {
	  return validate_group;
	}
	@XmlElement
	public void setValidate_group(String validate_group) {
	  this.validate_group = validate_group;
	}
	public String getValidate_email() {
	  return validate_email;
	}
	@XmlElement
	public void setValidate_email(String validate_email) {
	  this.validate_email = validate_email;
	}
	public String getValidate_not_null() {
	  return validate_not_null;
	}
	@XmlElement
	public void setValidate_not_null(String validate_not_null) {
	  this.validate_not_null = validate_not_null;
	}
	public String getValidate_minlength() {
	  return validate_minlength;
	}
	@XmlElement
	public void setValidate_minlength(String validate_minlength) {
	  this.validate_minlength = validate_minlength;
	}
	public String getValidate_maxlength() {
	  return validate_maxlength;
	}
	@XmlElement
	public void setValidate_maxlength(String validate_maxlength) {
	  this.validate_maxlength = validate_maxlength;
	}
	public String getValidate_regex() {
	  return validate_regex;
	}
	@XmlElement
	public void setValidate_regex(String validate_regex) {
	  this.validate_regex = validate_regex;
	}
	public String getSrc() {
	  return src;
	}
	@XmlElement
	public void setSrc(String src) {
	  this.src = src;
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
	public String getLabelStyle() {
	  return labelStyle;
	}
	@XmlElement
	public void setLabelStyle(String labelStyle) {
	  this.labelStyle = labelStyle;
	}
	public String getLabelTitle() {
	  return labelTitle;
	}
	@XmlElement
	public void setLabelTitle(String labelTitle) {
	  this.labelTitle = labelTitle;
	}
	public String getLabelTitleKey() {
	  return labelTitleKey;
	}
	@XmlElement
	public void setLabelTitleKey(String labelTitleKey) {
	  this.labelTitleKey = labelTitleKey;
	}
	public String getFieldGridSize() {
	  return fieldGridSize;
	}
	@XmlElement
	public void setFieldGridSize(String fieldGridSize) {
	  this.fieldGridSize = fieldGridSize;
	}
	public String getQueryOperator() {
	  return queryOperator;
	}
	@XmlElement
	public void setQueryOperator(String queryOperator) {
	  this.queryOperator = queryOperator;
	}
	public String getRound_value() {
	  return round_value;
	}
	@XmlElement
	public void setRound_value(String round_value) {
	  this.round_value = round_value;
	}
	public String getField_prefix() {
	  return field_prefix;
	}
	@XmlElement
	public void setField_prefix(String field_prefix) {
	  this.field_prefix = field_prefix;
	}
	public String getField_sufix() {
	  return field_sufix;
	}
	@XmlElement
	public void setField_sufix(String field_sufix) {
	  this.field_sufix = field_sufix;
	}
	public String getWrite() {
	  return write;
	}
	@XmlElement
	public void setWrite(String write) {
	  this.write = write;
	}
	public String getFieldSetProperty() {
	  return fieldSetProperty;
	}
	@XmlElement
	public void setFieldSetProperty(String fieldSetProperty) {
	  this.fieldSetProperty = fieldSetProperty;
	}
	public String getAccesskey() {
	  return accesskey;
	}
	@XmlElement
	public void setAccesskey(String accesskey) {
	  this.accesskey = accesskey;
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
	public String getStyle() {
	  return style;
	}
	@XmlElement
	public void setStyle(String style) {
	  this.style = style;
	}
	public String getStyleClass() {
	  return styleClass;
	}
	@XmlElement
	public void setStyleClass(String styleClass) {
	  this.styleClass = styleClass;
	}
	public String getStyleId() {
	  return styleId;
	}
	@XmlElement
	public void setStyleId(String styleId) {
	  this.styleId = styleId;
	}
	public String getTabindex() {
	  return tabindex;
	}
	@XmlElement
	public void setTabindex(String tabindex) {
	  this.tabindex = tabindex;
	}
	public String getField_relation() {
	  return field_relation;
	}
	@XmlElement
	public void setField_relation(String field_relation) {
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
	
	
//	@Override
//	public String toString() {
//		return "EntityXML [clazz=" + clazz + ", name=" + name + ", help="
//				+ help + ", i18nHelp=" + i18nHelp + ", develHelp=" + develHelp
//				+ ", block_name=" + block_name + ", role_item=" + role_item
//				+ ", database_column=" + database_column + ", roleinclude="
//				+ roleinclude + ", i18n=" + i18n + ", show_help=" + show_help
//				+ ", show_help_label=" + show_help_label + ", tabs=" + tabs
//				+ ", format=" + format + ", title=" + title + ", titleKey="
//				+ titleKey + ", left=" + left + ", top=" + top + ", z_index="
//				+ z_index + ", property=" + property + ", label=" + label
//				+ ", label_pos=" + label_pos + ", label_bg_color="
//				+ label_bg_color + ", label_fg_color=" + label_fg_color
//				+ ", label_size=" + label_size + ", label_align=" + label_align
//				+ ", label_font=" + label_font + ", labelPropertytext="
//				+ labelPropertytext + ", label_bold=" + label_bold
//				+ ", label_italic=" + label_italic + ", justification="
//				+ justification + ", not_null=" + not_null + ", type=" + type
//				+ ", validate_message=" + validate_message
//				+ ", validate_message_user=" + validate_message_user
//				+ ", case_restriction=" + case_restriction + ", break_line="
//				+ break_line + ", lovObject=" + lovObject + ", lowest_value="
//				+ lowest_value + ", highest_value=" + highest_value
//				+ ", validate_value=" + validate_value + ", validate_type="
//				+ validate_type + ", validate_group=" + validate_group
//				+ ", validate_email=" + validate_email + ", validate_not_null="
//				+ validate_not_null + ", validate_minlength="
//				+ validate_minlength + ", validate_maxlength="
//				+ validate_maxlength + ", validate_regex=" + validate_regex
//				+ ", src=" + src + ", select_allowed=" + select_allowed
//				+ ", update_allowed=" + update_allowed + ", insert_allowed="
//				+ insert_allowed + ", isCustomized=" + isCustomized
//				+ ", codeItem=" + codeItem + ", labelStyle=" + labelStyle
//				+ ", labelTitle=" + labelTitle + ", labelTitleKey="
//				+ labelTitleKey + ", fieldGridSize=" + fieldGridSize
//				+ ", queryOperator=" + queryOperator + ", round_value="
//				+ round_value + ", field_prefix=" + field_prefix
//				+ ", field_sufix=" + field_sufix + ", writeIntoStage=" + writeIntoStage
//				+ ", fieldSetProperty=" + fieldSetProperty + ", accesskey="
//				+ accesskey + ", disabled=" + disabled + ", onblur=" + onblur
//				+ ", onchange=" + onchange + ", onclick=" + onclick
//				+ ", ondblclick=" + ondblclick + ", onfocus=" + onfocus
//				+ ", onkeydown=" + onkeydown + ", onkeypress=" + onkeypress
//				+ ", onkeyup=" + onkeyup + ", onmousedown=" + onmousedown
//				+ ", style=" + style + ", styleClass=" + styleClass
//				+ ", styleId=" + styleId + ", tabindex=" + tabindex
//				+ ", field_relation=" + field_relation + ", onmousemove="
//				+ onmousemove + ", onmouseout=" + onmouseout + ", onmouseover="
//				+ onmouseover + ", onmouseup=" + onmouseup + ", readonly="
//				+ readonly + ", value=" + value + ", size=" + size
//				+ ", maxlength=" + maxlength + "]";
//	}

	



	@Override
	public String toString() {
		return "EntityXML \n"
	              + ((!("".equals(clazz))&&(clazz!=null)) ? "class=" + clazz + "\n" : "" )
	              + ((!("".equals(name))&&(name!=null)) ? "name=" + name + "\n" : "" )
	              + ((!("".equals(help))&&(help!=null)) ? "help=" + help + "\n" : "" )
	              + ((!("".equals(i18nHelp))&&(i18nHelp!=null)) ? "i18nHelp=" + i18nHelp + "\n" : "" )
	              + ((!("".equals(develHelp))&&(develHelp!=null)) ? "develHelp=" + develHelp + "\n" : "")
	              + ((!("".equals(block_name))&&(block_name!=null)) ? "block_name=" + block_name + "\n"  : "")
	              + ((!("".equals(role_item))&&(role_item!=null)) ? "role_item=" + role_item + "\n" : "")
	              + ((!("".equals(database_column))&&(database_column!=null)) ? "database_column=" + database_column + "\n"  : "")
	              + ((!("".equals(roleinclude))&&(roleinclude!=null)) ? "roleinclude=" + roleinclude + "\n"  : "")
	              + ((!("".equals(i18n))&&(i18n!=null)) ? "i18n=" + i18n + "\n"  : "")
	              + ((!("".equals(show_help))&&(show_help!=null)) ? "show_help=" + show_help + "\n" : "")
	              + ((!("".equals(show_help_label))&&(show_help_label!=null)) ? "show_help_label=" + show_help_label + "\n"  : "")
	              + ((!("".equals(tabs))&&(tabs!=null)) ? "tabs=" + tabs + "\n" : "")
	              + ((!("".equals(format))&&(format!=null)) ? "format=" + format + "\n"  : "")
	              + ((!("".equals(title))&&(title!=null)) ? "title=" + title + "\n"  : "")
	              + ((!("".equals(titleKey))&&(titleKey!=null)) ? "titleKey=" + titleKey + "\n"  : "")
	              + ((!("".equals(left))&&(left!=null)) ? "left=" + left + "\n"  : "")
	              + ((!("".equals(top))&&(top!=null)) ? "top=" + top + "\n"  : "")
	              + ((!("".equals(z_index))&&(z_index!=null)) ? "z_index=" + z_index + "\n"  : "")
	              + ((!("".equals(property))&&(property!=null)) ? "property=" + property + "\n"  : "")
	              + ((!("".equals(label))&&(label!=null)) ? "label=" + label + "\n" : "")
	              + ((!("".equals(label_pos))&&(label_pos!=null)) ? "label_pos=" + label_pos + "\n"  : "")
	              + ((!("".equals(label_bg_color))&&(label_bg_color!=null)) ? "label_bg_color=" + label_bg_color + "\n"  : "")
	              + ((!("".equals(label_fg_color))&&(label_fg_color!=null)) ? "label_fg_color=" + label_fg_color + "\n" : "")
	              + ((!("".equals(label_size))&&(label_size!=null)) ? "label_size=" + label_size + "\n"  : "")
	              + ((!("".equals(label_align))&&(label_align!=null)) ? "label_align=" + label_align + "\n" : "")
	              + ((!("".equals(label_font))&&(label_font!=null)) ? "label_font=" + label_font + "\n"  : "")
	              + ((!("".equals(labelPropertytext))&&(labelPropertytext!=null)) ? "labelPropertytext="+ labelPropertytext + "\n"  : "")
	              + ((!("".equals(label_bold))&&(label_bold!=null)) ? "label_bold=" + label_bold + "\n" : "")
	              + ((!("".equals(label_italic))&&(label_italic!=null)) ? "label_italic=" + label_italic + "\n"  : "")
	              + ((!("".equals(justification))&&(justification!=null)) ? "justification=" + justification + "\n"  : "")
	              + ((!("".equals(not_null))&&(not_null!=null)) ? "not_null=" + not_null + "\n"  : "")
	              + ((!("".equals(type))&&(type!=null)) ? "type=" + type + "\n" : "")
	              + ((!("".equals(validate_message))&&(validate_message!=null)) ? "validate_message=" + validate_message + "\n" : "")
	              + ((!("".equals(validate_message_user))&&(validate_message_user!=null)) ? "validate_message_user=" + validate_message_user + "\n" : "")
	              + ((!("".equals(case_restriction))&&(case_restriction!=null)) ? "case_restriction=" + case_restriction + "\n"  : "")
	              + ((!("".equals(break_line))&&(break_line!=null)) ? "break_line="+ break_line + "\n"  : "")
	              + ((!("".equals(lovObject))&&(lovObject!=null)) ? "lovObject=" + lovObject + "\n"  : "")
	              + ((!("".equals(lowest_value))&&(lowest_value!=null)) ? "lowest_value="+ lowest_value + "\n"  : "")
	              + ((!("".equals(highest_value))&&(highest_value!=null)) ? "highest_value=" + highest_value + "\n" : "")
	              + ((!("".equals(validate_value))&&(validate_value!=null)) ? "validate_value=" + validate_value + "\n"  : "")
	              + ((!("".equals(validate_type))&&(validate_type!=null)) ? "validate_type="+ validate_type + "\n"  : "")
	              + ((!("".equals(validate_group))&&(validate_group!=null)) ? "validate_group=" + validate_group + "\n" : "")
	              + ((!("".equals(validate_email))&&(validate_email!=null)) ? "validate_email=" + validate_email + "\n"  : "")
	              + ((!("".equals(validate_not_null))&&(validate_not_null!=null)) ? "validate_not_null="+ validate_not_null + "\n"  : "")
	              + ((!("".equals(validate_minlength))&&(validate_minlength!=null)) ? "validate_minlength="+ validate_minlength + "\n"  : "")
	              + ((!("".equals(validate_maxlength))&&(validate_maxlength!=null)) ? "validate_maxlength="+ validate_maxlength + "\n"  : "")
	              + ((!("".equals(validate_regex))&&(validate_regex!=null)) ? "validate_regex=" + validate_regex + "\n" : "")
	              + ((!("".equals(src))&&(src!=null)) ? "src=" + src + "\n"  : "")
	              + ((!("".equals(select_allowed))&&(select_allowed!=null)) ? "select_allowed=" + select_allowed + "\n" : "")
	              + ((!("".equals(update_allowed))&&(update_allowed!=null)) ? "update_allowed=" + update_allowed + "\n"  : "")
	              + ((!("".equals(insert_allowed))&&(insert_allowed!=null)) ? "insert_allowed="+ insert_allowed + "\n"  : "")
	              + ((!("".equals(isCustomized))&&(isCustomized!=null)) ? "isCustomized=" + isCustomized + "\n" : "")
	              + ((!("".equals(codeItem))&&(codeItem!=null)) ? "codeItem=" + codeItem + "\n"  : "")
	              + ((!("".equals(labelStyle))&&(labelStyle!=null)) ? "labelStyle=" + labelStyle + "\n" : "")
	              + ((!("".equals(labelTitle))&&(labelTitle!=null)) ? "labelTitle=" + labelTitle + "\n"  : "")
	              + ((!("".equals(labelTitleKey))&&(labelTitleKey!=null)) ? "labelTitleKey="+ labelTitleKey + "\n"  : "")
	              + ((!("".equals(fieldGridSize))&&(fieldGridSize!=null)) ? "fieldGridSize=" + fieldGridSize + "\n" : "")
	              + ((!("".equals(queryOperator))&&(queryOperator!=null)) ? "queryOperator=" + queryOperator + "\n"  : "")
	              + ((!("".equals(round_value))&&(round_value!=null)) ? "round_value="+ round_value + "\n"  : "")
	              + ((!("".equals(field_prefix))&&(field_prefix!=null)) ? "field_prefix=" + field_prefix + "\n" : "")
	              + ((!("".equals(field_sufix))&&(field_sufix!=null)) ? "field_sufix=" + field_sufix + "\n"  : "")
	              + ((!("".equals(write))&&(write!=null)) ? "writeIntoStage=" + write + "\n" : "")
	              + ((!("".equals(fieldSetProperty))&&(fieldSetProperty!=null)) ? "fieldSetProperty=" + fieldSetProperty + "\n"  : "")
	              + ((!("".equals(accesskey))&&(accesskey!=null)) ? "accesskey="+ accesskey + "\n"  : "")
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
	              + ((!("".equals(style))&&(style!=null)) ? "style=" + style + "\n"  : "")
	              + ((!("".equals(styleClass))&&(styleClass!=null)) ? "styleClass=" + styleClass + "\n" : "")
	              + ((!("".equals(styleId))&&(styleId!=null)) ? "styleId=" + styleId + "\n"  : "")
	              + ((!("".equals(tabindex))&&(tabindex!=null)) ? "tabindex=" + tabindex + "\n" : "")
	              + ((!("".equals(field_relation))&&(field_relation!=null)) ? "field_relation=" + field_relation + "\n"  : "")
	              + ((!("".equals(onmousemove))&&(onmousemove!=null)) ? "onmousemove="+ onmousemove + "\n"  : "")
	              + ((!("".equals(onmouseout))&&(onmouseout!=null)) ? "onmouseout=" + onmouseout + "\n"  : "")
	              + ((!("".equals(onmouseover))&&(onmouseover!=null)) ? "onmouseover="+ onmouseover + "\n"  : "")
	              + ((!("".equals(onmouseup))&&(onmouseup!=null)) ? "onmouseup=" + onmouseup + "\n"  : "")
	              + ((!("".equals(readonly))&&(readonly!=null)) ? "readonly="+ readonly + "\n"  : "")
	              + ((!("".equals(value))&&(value!=null)) ? "value=" + value + "\n"  : "")
	              + ((!("".equals(size))&&(size!=null)) ? "size=" + size + "\n" : "")
	              + ((!("".equals(maxlength))&&(maxlength!=null)) ? "maxlength=" + maxlength + "\n" : ""); 
	}
	
	
	
	

}
