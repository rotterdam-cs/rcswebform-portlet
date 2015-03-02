package com.rcs.webform.util;

import java.util.List;

public class ConfigurationModel {
	
	/* String Value */
	private String titleXml;
	private String descriptionXml;
	private String successURL;
	private String emailFromName;
	private String emailFromAddress;
	private String emailAddress;
	private String subject;
	private String databaseTableName;
	private String fileName;
	private String submitLabelXml;
	
	/* Boolean Value */
	private Boolean requireCaptcha;
	private Boolean sendAsEmail;
	private Boolean saveToDatabase;
	private Boolean saveToFile;
	private Boolean isEditable;
	
	/* Integer Value */
	private Integer totalField;
	

	public String getTitleXml() {
		return titleXml;
	}

	public void setTitleXml(String titleXml) {
		this.titleXml = titleXml;
	}

	public String getDescriptionXml() {
		return descriptionXml;
	}

	public void setDescriptionXml(String descriptionXml) {
		this.descriptionXml = descriptionXml;
	}

	public String getSuccessURL() {
		return successURL;
	}

	public void setSuccessURL(String successURL) {
		this.successURL = successURL;
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

	public Boolean getSendAsEmail() {
		return sendAsEmail;
	}

	public void setSendAsEmail(Boolean sendAsEmail) {
		this.sendAsEmail = sendAsEmail;
	}

	public Boolean getSaveToDatabase() {
		return saveToDatabase;
	}

	public void setSaveToDatabase(Boolean saveToDatabase) {
		this.saveToDatabase = saveToDatabase;
	}

	public Boolean getSaveToFile() {
		return saveToFile;
	}

	public void setSaveToFile(Boolean saveToFile) {
		this.saveToFile = saveToFile;
	}

	public Boolean getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(Boolean isEditable) {
		this.isEditable = isEditable;
	}

	public Integer getTotalField() {
		return totalField;
	}

	public void setTotalField(Integer totalField) {
		this.totalField = totalField;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getSubmitLabelXml() {
		return submitLabelXml;
	}

	public void setSubmitLabelXml(String submitLabelXml) {
		this.submitLabelXml = submitLabelXml;
	}

	
	

}
