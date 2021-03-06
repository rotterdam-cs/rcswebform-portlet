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
	private String optionKeys;
	private String optionValues;
    private boolean mandatory;
	private String defaultValue;
	private int order;
	private ValidationType validationType;
	private String validationRegexValue;
	private int minLength;
	private int maxLength;
    private String errorValidationMessage;
	private String errorMandatoryMessage;
	private String errorLengthMessage;
    private String hintMessage;
    private String dateFormat;
    
    
    public int getMinLength() {
        return minLength;
    }

    
    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    
    public int getMaxLength() {
        return maxLength;
    }

    
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    
    public String getErrorLengthMessage() {
        return errorLengthMessage;
    }

    
    public void setErrorLengthMessage(String errorLengthMessage) {
        this.errorLengthMessage = errorLengthMessage;
    }

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
        
    public String getOptionKeys() {
        return optionKeys;
    }

    public void setOptionKeys(String optionKeys) {
        this.optionKeys = optionKeys;
    }
    
    public String getOptionValues() {
        return optionValues;
    }
    
    public void setOptionValues(String optionValues) {
        this.optionValues = optionValues;
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
    
    public String getValidationRegexValue() {
        return validationRegexValue;
    }
    
    public void setValidationRegexValue(String validationRegexValue) {
        this.validationRegexValue = validationRegexValue;
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


    public String getDateFormat() {
        return dateFormat;
    }


    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}
