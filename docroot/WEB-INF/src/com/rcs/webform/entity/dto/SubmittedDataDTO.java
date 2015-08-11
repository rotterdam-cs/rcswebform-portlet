package com.rcs.webform.entity.dto;

import java.util.Date;


public class SubmittedDataDTO {
	
	private long submittedDataId;
	private long groupId;
	private long companyId;
	private boolean active;
	private Date creationDate;
	private Date modificationDate;
	private String modificationUser;
	private long formId;
	private String portletId;
	private long formItemId;
	private String userInput;
	
	public long getSubmittedDataId() {
		return submittedDataId;
	}
	
	public void setSubmittedDataId(long submittedDataId) {
		this.submittedDataId = submittedDataId;
	}
	
	public long getGroupId() {
		return groupId;
	}
	
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	
	public long getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
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
	
	public String getPortletId() {
		return portletId;
	}
	
	public void setPortletId(String portletId) {
		this.portletId = portletId;
	}
	
	public long getFormItemId() {
		return formItemId;
	}
	
	public void setFormItemId(long formItemId) {
		this.formItemId = formItemId;
	}
	
	public String getUserInput() {
		return userInput;
	}
	
	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}
	
}
