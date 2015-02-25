package com.rcs.webform.util;

import java.util.HashSet;
import java.util.Set;

public class FormComponent {

	/*String*/
	private String fileType;
	private String fieldName;
	private String fieldLabel;
	private String fieldValue;
	private String fieldOptions; 
	private String fieldValidationScript; 
	private String fieldValidationErrorMessage; 
	private String position; 
	private String placeholder; 
	
	
	/*Boolean*/
	private Boolean fieldOptional;
	private Boolean validationScriptEnabled;
	private Boolean fvalidatorFieldValidationErrorMessage;
	
	private Set<FieldOptions> fieldOptionsSet = new HashSet<FieldOptions>();
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldLabel() {
		return fieldLabel;
	}
	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	public Boolean getFieldOptional() {
		return fieldOptional;
	}
	public void setFieldOptional(Boolean fieldOptional) {
		this.fieldOptional = fieldOptional;
	}
	public Boolean getValidationScriptEnabled() {
		return validationScriptEnabled;
	}
	public void setValidationScriptEnabled(Boolean validationScriptEnabled) {
		this.validationScriptEnabled = validationScriptEnabled;
	}
	public Boolean getFvalidatorFieldValidationErrorMessage() {
		return fvalidatorFieldValidationErrorMessage;
	}
	public void setFvalidatorFieldValidationErrorMessage(
			Boolean fvalidatorFieldValidationErrorMessage) {
		this.fvalidatorFieldValidationErrorMessage = fvalidatorFieldValidationErrorMessage;
	}
	public Set<FieldOptions> getFieldOptionsSet() {
		return fieldOptionsSet;
	}
	public void setFieldOptionsSet(Set<FieldOptions> fieldOptionsSet) {
		this.fieldOptionsSet = fieldOptionsSet;
	}
	
	
	
	
}
