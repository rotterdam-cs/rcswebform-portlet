package com.rcs.webform.util;

import java.util.HashSet;
import java.util.Set;

public class FormModel {
	/* String Value */
	private String title;
	private String description;
	private String emailFromName;
	private String emailFromAddress;
	private String emailAddress;
	private String subject;
	private String databaseTableName;
	private String fileName;

	/* Boolean Value */
	private Boolean validatorSuccessURL;
	private Boolean requireCaptcha;
	private Boolean validatorSuccesUrl;
	private Boolean validatorDescription;
	private Boolean validateScriptEnable;
	
	private Set<FormComponent> formComponentSet = new HashSet<FormComponent>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Boolean getValidatorSuccessURL() {
		return validatorSuccessURL;
	}

	public void setValidatorSuccessURL(Boolean validatorSuccessURL) {
		this.validatorSuccessURL = validatorSuccessURL;
	}

	public String getEmailFromName() {
		return emailFromName;
	}

	public void setEmailFromName(String emailFromName) {
		this.emailFromName = emailFromName;
	}

	public String getEmailFromAddress() {
		return emailFromAddress;
	}

	public void setEmailFromAddress(String emailFromAddress) {
		this.emailFromAddress = emailFromAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDatabaseTableName() {
		return databaseTableName;
	}

	public void setDatabaseTableName(String databaseTableName) {
		this.databaseTableName = databaseTableName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Boolean getRequireCaptcha() {
		return requireCaptcha;
	}

	public void setRequireCaptcha(Boolean requireCaptcha) {
		this.requireCaptcha = requireCaptcha;
	}

	public Boolean getValidatorSuccesUrl() {
		return validatorSuccesUrl;
	}

	public void setValidatorSuccesUrl(Boolean validatorSuccesUrl) {
		this.validatorSuccesUrl = validatorSuccesUrl;
	}

	public Boolean getValidatorDescription() {
		return validatorDescription;
	}

	public void setValidatorDescription(Boolean validatorDescription) {
		this.validatorDescription = validatorDescription;
	}

	public Boolean getValidateScriptEnable() {
		return validateScriptEnable;
	}

	public void setValidateScriptEnable(Boolean validateScriptEnable) {
		this.validateScriptEnable = validateScriptEnable;
	}

	public Set<FormComponent> getFormComponentSet() {
		return formComponentSet;
	}

	public void setFormComponentSet(Set<FormComponent> formComponentSet) {
		this.formComponentSet = formComponentSet;
	}

	
	
	
}
