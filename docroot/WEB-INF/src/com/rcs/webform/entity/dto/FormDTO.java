package com.rcs.webform.entity.dto;

import java.util.Date;
import java.util.List;

public class FormDTO{

	private long formId;
	private boolean active;
	private Date creationDate;
    private Date modificationDate;
    private String modificationUser;
    private long groupId;
	private long companyId;
	private long userId;
	private String userName;
	private String formAttrId;
	private String formAttrClass;
	private String title;
	private String desc;
	private boolean useCaptcha;
	private String successMessage;
	private String successURL;
	private String submitLabel;
	private String submitAttrId;
	private String submitAttrClass;
	private List<FormItemDTO> formItems;
    
    public long getFormId() {
        return formId;
    }
    
    public void setFormId(long formId) {
        this.formId = formId;
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
    
    public long getUserId() {
        return userId;
    }
    
    public void setUserId(long userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getFormAttrId() {
        return formAttrId;
    }
    
    public void setFormAttrId(String formAttrId) {
        this.formAttrId = formAttrId;
    }
    
    public String getFormAttrClass() {
        return formAttrClass;
    }
    
    public void setFormAttrClass(String formAttrClass) {
        this.formAttrClass = formAttrClass;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public boolean isUseCaptcha() {
        return useCaptcha;
    }
    
    public void setUseCaptcha(boolean useCaptcha) {
        this.useCaptcha = useCaptcha;
    }
    
    public String getSuccessMessage() {
        return successMessage;
    }
    
    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
    
    public String getSuccessURL() {
        return successURL;
    }
    
    public void setSuccessURL(String successURL) {
        this.successURL = successURL;
    }
    
    public String getSubmitLabel() {
        return submitLabel;
    }
    
    public void setSubmitLabel(String submitLabel) {
        this.submitLabel = submitLabel;
    }
    
    public String getSubmitAttrId() {
        return submitAttrId;
    }
    
    public void setSubmitAttrId(String submitAttrId) {
        this.submitAttrId = submitAttrId;
    }
    
    public String getSubmitAttrClass() {
        return submitAttrClass;
    }
    
    public void setSubmitAttrClass(String submitAttrClass) {
        this.submitAttrClass = submitAttrClass;
    }
    
    public List<FormItemDTO> getFormItems() {
        return formItems;
    }
    
    public void setFormItems(List<FormItemDTO> formItems) {
        this.formItems = formItems;
    }
}
