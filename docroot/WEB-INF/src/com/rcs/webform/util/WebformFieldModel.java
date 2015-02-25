package com.rcs.webform.util;

public class WebformFieldModel {
	
	/* String Tyoe */
	private String fieldLabelXml;
	private String fieldLabel;
	private String fieldType;
	private String fieldOptionslXml;
	private String fieldOptions;
	private String fieldValidationScript;
	private String fieldValidationErrorMessage;
	
	/* Integer Type */
	private Integer index;
	private Integer formFieldsIndex;
	
	/* Boolean Type */
	private Boolean fieldsEditingDisabled;
	private Boolean fieldOptional;
	private Boolean iqnoreRequestValue;
	
	public String getFieldLabelXml() {
		return fieldLabelXml;
	}
	public void setFieldLabelXml(String fieldLabelXml) {
		this.fieldLabelXml = fieldLabelXml;
	}
	public String getFieldLabel() {
		return fieldLabel;
	}
	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getFieldOptionslXml() {
		return fieldOptionslXml;
	}
	public void setFieldOptionslXml(String fieldOptionslXml) {
		this.fieldOptionslXml = fieldOptionslXml;
	}
	public String getFieldOptions() {
		return fieldOptions;
	}
	public void setFieldOptions(String fieldOptions) {
		this.fieldOptions = fieldOptions;
	}
	public String getFieldValidationScript() {
		return fieldValidationScript;
	}
	public void setFieldValidationScript(String fieldValidationScript) {
		this.fieldValidationScript = fieldValidationScript;
	}
	public String getFieldValidationErrorMessage() {
		return fieldValidationErrorMessage;
	}
	public void setFieldValidationErrorMessage(String fieldValidationErrorMessage) {
		this.fieldValidationErrorMessage = fieldValidationErrorMessage;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getFormFieldsIndex() {
		return formFieldsIndex;
	}
	public void setFormFieldsIndex(Integer formFieldsIndex) {
		this.formFieldsIndex = formFieldsIndex;
	}
	public Boolean getFieldsEditingDisabled() {
		return fieldsEditingDisabled;
	}
	public void setFieldsEditingDisabled(Boolean fieldsEditingDisabled) {
		this.fieldsEditingDisabled = fieldsEditingDisabled;
	}
	public Boolean getFieldOptional() {
		return fieldOptional;
	}
	public void setFieldOptional(Boolean fieldOptional) {
		this.fieldOptional = fieldOptional;
	}
	public Boolean getIqnoreRequestValue() {
		return iqnoreRequestValue;
	}
	public void setIqnoreRequestValue(Boolean iqnoreRequestValue) {
		this.iqnoreRequestValue = iqnoreRequestValue;
	}
	
	
}
