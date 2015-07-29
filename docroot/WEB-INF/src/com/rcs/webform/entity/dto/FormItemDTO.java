package com.rcs.webform.entity.dto;

import java.util.Date;

import com.rcs.webform.common.dto.GenericEntityDTO;
import com.rcs.webform.common.enums.FormItemType;
import com.rcs.webform.common.enums.ValidationType;

public class FormItemDTO extends GenericEntityDTO {

	private long formItemId;
	private boolean active;
    private Date creationDate;
    private Date modificationDate;
    private String modificationUser;
    private long formId;
	private String formItemAttrId;
	private String formItemAttrClass;
	private String label;
	private String labelAttrId;
	private String labelAttrClass;
	private String inputAttrId;
	private String inputAttrClass;
	private FormItemType type;
	private String options;
	private boolean mandatory;
	private String defaultValue;
	private int order;
	private ValidationType validationType;
	private String validationRegexValueString;
	private String errorValidationMessage;
	private String errorMandatoryMessage;
	private String hintMessage;
    
    public long getFormItemId() {
        return formItemId;
    }
    
    public void setFormItemId(long formItemId) {
        this.formItemId = formItemId;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    
    public Date getCreationDate() {
        return creationDate;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    public Date getModificationDate() {
        return modificationDate;
    }
    
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
    
    public String getModificationUser() {
        return modificationUser;
    }
    
    public void setModificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
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
    
    public FormItemType getType() {
        return type;
    }
    
    public void setType(FormItemType type) {
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
    
    public String getHintMessage() {
        return hintMessage;
    }
    
    public void setHintMessage(String hintMessage) {
        this.hintMessage = hintMessage;
    }
}
