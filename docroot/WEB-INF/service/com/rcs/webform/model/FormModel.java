/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rcs.webform.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Form service. Represents a row in the &quot;rcswebform_Form&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rcs.webform.model.impl.FormModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rcs.webform.model.impl.FormImpl}.
 * </p>
 *
 * @author ryusuf
 * @see Form
 * @see com.rcs.webform.model.impl.FormImpl
 * @see com.rcs.webform.model.impl.FormModelImpl
 * @generated
 */
public interface FormModel extends BaseModel<Form>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a form model instance should use the {@link Form} interface instead.
	 */

	/**
	 * Returns the primary key of this form.
	 *
	 * @return the primary key of this form
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this form.
	 *
	 * @param primaryKey the primary key of this form
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the form ID of this form.
	 *
	 * @return the form ID of this form
	 */
	public long getFormId();

	/**
	 * Sets the form ID of this form.
	 *
	 * @param formId the form ID of this form
	 */
	public void setFormId(long formId);

	/**
	 * Returns the group ID of this form.
	 *
	 * @return the group ID of this form
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this form.
	 *
	 * @param groupId the group ID of this form
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this form.
	 *
	 * @return the company ID of this form
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this form.
	 *
	 * @param companyId the company ID of this form
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this form.
	 *
	 * @return the user ID of this form
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this form.
	 *
	 * @param userId the user ID of this form
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this form.
	 *
	 * @return the user uuid of this form
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this form.
	 *
	 * @param userUuid the user uuid of this form
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this form.
	 *
	 * @return the user name of this form
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this form.
	 *
	 * @param userName the user name of this form
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this form.
	 *
	 * @return the create date of this form
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this form.
	 *
	 * @param createDate the create date of this form
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this form.
	 *
	 * @return the modified date of this form
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this form.
	 *
	 * @param modifiedDate the modified date of this form
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the form attr ID of this form.
	 *
	 * @return the form attr ID of this form
	 */
	@AutoEscape
	public String getFormAttrId();

	/**
	 * Sets the form attr ID of this form.
	 *
	 * @param formAttrId the form attr ID of this form
	 */
	public void setFormAttrId(String formAttrId);

	/**
	 * Returns the form attr class of this form.
	 *
	 * @return the form attr class of this form
	 */
	@AutoEscape
	public String getFormAttrClass();

	/**
	 * Sets the form attr class of this form.
	 *
	 * @param formAttrClass the form attr class of this form
	 */
	public void setFormAttrClass(String formAttrClass);

	/**
	 * Returns the title of this form.
	 *
	 * @return the title of this form
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this form.
	 *
	 * @param title the title of this form
	 */
	public void setTitle(String title);

	/**
	 * Returns the desc of this form.
	 *
	 * @return the desc of this form
	 */
	@AutoEscape
	public String getDesc();

	/**
	 * Sets the desc of this form.
	 *
	 * @param desc the desc of this form
	 */
	public void setDesc(String desc);

	/**
	 * Returns the use captcha of this form.
	 *
	 * @return the use captcha of this form
	 */
	public boolean getUseCaptcha();

	/**
	 * Returns <code>true</code> if this form is use captcha.
	 *
	 * @return <code>true</code> if this form is use captcha; <code>false</code> otherwise
	 */
	public boolean isUseCaptcha();

	/**
	 * Sets whether this form is use captcha.
	 *
	 * @param useCaptcha the use captcha of this form
	 */
	public void setUseCaptcha(boolean useCaptcha);

	/**
	 * Returns the success message of this form.
	 *
	 * @return the success message of this form
	 */
	@AutoEscape
	public String getSuccessMessage();

	/**
	 * Sets the success message of this form.
	 *
	 * @param successMessage the success message of this form
	 */
	public void setSuccessMessage(String successMessage);

	/**
	 * Returns the success u r l of this form.
	 *
	 * @return the success u r l of this form
	 */
	@AutoEscape
	public String getSuccessURL();

	/**
	 * Sets the success u r l of this form.
	 *
	 * @param successURL the success u r l of this form
	 */
	public void setSuccessURL(String successURL);

	/**
	 * Returns the submit label of this form.
	 *
	 * @return the submit label of this form
	 */
	@AutoEscape
	public String getSubmitLabel();

	/**
	 * Sets the submit label of this form.
	 *
	 * @param submitLabel the submit label of this form
	 */
	public void setSubmitLabel(String submitLabel);

	/**
	 * Returns the submit attr ID of this form.
	 *
	 * @return the submit attr ID of this form
	 */
	@AutoEscape
	public String getSubmitAttrId();

	/**
	 * Sets the submit attr ID of this form.
	 *
	 * @param submitAttrId the submit attr ID of this form
	 */
	public void setSubmitAttrId(String submitAttrId);

	/**
	 * Returns the submit attr class of this form.
	 *
	 * @return the submit attr class of this form
	 */
	@AutoEscape
	public String getSubmitAttrClass();

	/**
	 * Sets the submit attr class of this form.
	 *
	 * @param submitAttrClass the submit attr class of this form
	 */
	public void setSubmitAttrClass(String submitAttrClass);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Form form);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Form> toCacheModel();

	@Override
	public Form toEscapedModel();

	@Override
	public Form toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}