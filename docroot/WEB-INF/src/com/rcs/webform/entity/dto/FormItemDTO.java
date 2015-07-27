package com.rcs.webform.entity.dto;

import com.rcs.webform.common.dto.GenericEntityDTO;
import com.rcs.webform.common.enums.ValidationType;

public class FormItemDTO extends GenericEntityDTO {

	private long formItemId;
	private long formId;
	private String formItemAttrId;
	private String formItemAttrClass;
	private String label;
	private String labelAttrId;
	private String labelAttrClass;
	private String inputAttrId;
	private String inputAttrClass;
	private String type;
	private String options;
	private boolean mandatory;
	private String defaultValue;
	private int order;
	private ValidationType validationType;
	private String validationRegexValueString;
	private String errorValidationMessage;
	private String errorMandatoryMessage;
	
	public long getFormItemId() {
		return formItemId;
	}
	
	public void setFormItemId(long formItemId) {
		this.formItemId = formItemId;
	}
	
	public long getFormId() {
		return formId;
	}
	
	public void setFormId(long formId) {
		this.formId = formId;
	}
	
	public String getFormItemAttrId() {
		return formItemAttrId;
	}
	
	public void setFormItemAttrId(String formItemAttrId) {
		this.formItemAttrId = formItemAttrId;
	}
	
	public String getFormItemAttrClass() {
		return formItemAttrClass;
	}
	
	public void setFormItemAttrClass(String formItemAttrClass) {
		this.formItemAttrClass = formItemAttrClass;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getLabelAttrId() {
		return labelAttrId;
	}
	
	public void setLabelAttrId(String labelAttrId) {
		this.labelAttrId = labelAttrId;
	}
	
	public String getLabelAttrClass() {
		return labelAttrClass;
	}
	
	public void setLabelAttrClass(String labelAttrClass) {
		this.labelAttrClass = labelAttrClass;
	}
	
	public String getInputAttrId() {
		return inputAttrId;
	}
	
	public void setInputAttrId(String inputAttrId) {
		this.inputAttrId = inputAttrId;
	}
	
	public String getInputAttrClass() {
		return inputAttrClass;
	}
	
	public void setInputAttrClass(String inputAttrClass) {
		this.inputAttrClass = inputAttrClass;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getOptions() {
		return options;
	}
	
	public void setOptions(String options) {
		this.options = options;
	}
	
	public boolean isMandatory() {
		return mandatory;
	}
	
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}
	
	public String getDefaultValue() {
		return defaultValue;
	}
	
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public ValidationType getValidationType() {
		return validationType;
	}
	
	public void setValidationType(ValidationType validationType) {
		this.validationType = validationType;
	}
	
	public String getValidationRegexValueString() {
		return validationRegexValueString;
	}
	
	public void setValidationRegexValueString(String validationRegexValueString) {
		this.validationRegexValueString = validationRegexValueString;
	}
	
	public String getErrorValidationMessage() {
		return errorValidationMessage;
	}
	
	public void setErrorValidationMessage(String errorValidationMessage) {
		this.errorValidationMessage = errorValidationMessage;
	}
	
	public String getErrorMandatoryMessage() {
		return errorMandatoryMessage;
	}
	
	public void setErrorMandatoryMessage(String errorMandatoryMessage) {
		this.errorMandatoryMessage = errorMandatoryMessage;
	}
	
}
