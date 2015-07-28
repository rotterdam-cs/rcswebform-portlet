/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the FormItem service. Represents a row in the &quot;rcswebform_FormItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rcs.webform.model.impl.FormItemModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rcs.webform.model.impl.FormItemImpl}.
 * </p>
 *
 * @author ryusuf
 * @see FormItem
 * @see com.rcs.webform.model.impl.FormItemImpl
 * @see com.rcs.webform.model.impl.FormItemModelImpl
 * @generated
 */
public interface FormItemModel extends BaseModel<FormItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a form item model instance should use the {@link FormItem} interface instead.
	 */

	/**
	 * Returns the primary key of this form item.
	 *
	 * @return the primary key of this form item
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this form item.
	 *
	 * @param primaryKey the primary key of this form item
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the form item ID of this form item.
	 *
	 * @return the form item ID of this form item
	 */
	public long getFormItemId();

	/**
	 * Sets the form item ID of this form item.
	 *
	 * @param formItemId the form item ID of this form item
	 */
	public void setFormItemId(long formItemId);

	/**
	 * Returns the active of this form item.
	 *
	 * @return the active of this form item
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this form item is active.
	 *
	 * @return <code>true</code> if this form item is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this form item is active.
	 *
	 * @param active the active of this form item
	 */
	public void setActive(boolean active);

	/**
	 * Returns the creation date of this form item.
	 *
	 * @return the creation date of this form item
	 */
	public Date getCreationDate();

	/**
	 * Sets the creation date of this form item.
	 *
	 * @param creationDate the creation date of this form item
	 */
	public void setCreationDate(Date creationDate);

	/**
	 * Returns the modification date of this form item.
	 *
	 * @return the modification date of this form item
	 */
	public Date getModificationDate();

	/**
	 * Sets the modification date of this form item.
	 *
	 * @param modificationDate the modification date of this form item
	 */
	public void setModificationDate(Date modificationDate);

	/**
	 * Returns the modification user of this form item.
	 *
	 * @return the modification user of this form item
	 */
	@AutoEscape
	public String getModificationUser();

	/**
	 * Sets the modification user of this form item.
	 *
	 * @param modificationUser the modification user of this form item
	 */
	public void setModificationUser(String modificationUser);

	/**
	 * Returns the form ID of this form item.
	 *
	 * @return the form ID of this form item
	 */
	public long getFormId();

	/**
	 * Sets the form ID of this form item.
	 *
	 * @param formId the form ID of this form item
	 */
	public void setFormId(long formId);

	/**
	 * Returns the form item attr ID of this form item.
	 *
	 * @return the form item attr ID of this form item
	 */
	@AutoEscape
	public String getFormItemAttrId();

	/**
	 * Sets the form item attr ID of this form item.
	 *
	 * @param formItemAttrId the form item attr ID of this form item
	 */
	public void setFormItemAttrId(String formItemAttrId);

	/**
	 * Returns the form item attr class of this form item.
	 *
	 * @return the form item attr class of this form item
	 */
	@AutoEscape
	public String getFormItemAttrClass();

	/**
	 * Sets the form item attr class of this form item.
	 *
	 * @param formItemAttrClass the form item attr class of this form item
	 */
	public void setFormItemAttrClass(String formItemAttrClass);

	/**
	 * Returns the label of this form item.
	 *
	 * @return the label of this form item
	 */
	@AutoEscape
	public String getLabel();

	/**
	 * Sets the label of this form item.
	 *
	 * @param label the label of this form item
	 */
	public void setLabel(String label);

	/**
	 * Returns the label attr ID of this form item.
	 *
	 * @return the label attr ID of this form item
	 */
	@AutoEscape
	public String getLabelAttrId();

	/**
	 * Sets the label attr ID of this form item.
	 *
	 * @param labelAttrId the label attr ID of this form item
	 */
	public void setLabelAttrId(String labelAttrId);

	/**
	 * Returns the label attr class of this form item.
	 *
	 * @return the label attr class of this form item
	 */
	@AutoEscape
	public String getLabelAttrClass();

	/**
	 * Sets the label attr class of this form item.
	 *
	 * @param labelAttrClass the label attr class of this form item
	 */
	public void setLabelAttrClass(String labelAttrClass);

	/**
	 * Returns the input attr ID of this form item.
	 *
	 * @return the input attr ID of this form item
	 */
	@AutoEscape
	public String getInputAttrId();

	/**
	 * Sets the input attr ID of this form item.
	 *
	 * @param inputAttrId the input attr ID of this form item
	 */
	public void setInputAttrId(String inputAttrId);

	/**
	 * Returns the input attr class of this form item.
	 *
	 * @return the input attr class of this form item
	 */
	@AutoEscape
	public String getInputAttrClass();

	/**
	 * Sets the input attr class of this form item.
	 *
	 * @param inputAttrClass the input attr class of this form item
	 */
	public void setInputAttrClass(String inputAttrClass);

	/**
	 * Returns the type of this form item.
	 *
	 * @return the type of this form item
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this form item.
	 *
	 * @param type the type of this form item
	 */
	public void setType(String type);

	/**
	 * Returns the options of this form item.
	 *
	 * @return the options of this form item
	 */
	@AutoEscape
	public String getOptions();

	/**
	 * Sets the options of this form item.
	 *
	 * @param options the options of this form item
	 */
	public void setOptions(String options);

	/**
	 * Returns the mandatory of this form item.
	 *
	 * @return the mandatory of this form item
	 */
	public boolean getMandatory();

	/**
	 * Returns <code>true</code> if this form item is mandatory.
	 *
	 * @return <code>true</code> if this form item is mandatory; <code>false</code> otherwise
	 */
	public boolean isMandatory();

	/**
	 * Sets whether this form item is mandatory.
	 *
	 * @param mandatory the mandatory of this form item
	 */
	public void setMandatory(boolean mandatory);

	/**
	 * Returns the default value of this form item.
	 *
	 * @return the default value of this form item
	 */
	@AutoEscape
	public String getDefaultValue();

	/**
	 * Sets the default value of this form item.
	 *
	 * @param defaultValue the default value of this form item
	 */
	public void setDefaultValue(String defaultValue);

	/**
	 * Returns the order of this form item.
	 *
	 * @return the order of this form item
	 */
	public int getOrder();

	/**
	 * Sets the order of this form item.
	 *
	 * @param order the order of this form item
	 */
	public void setOrder(int order);

	/**
	 * Returns the validation type of this form item.
	 *
	 * @return the validation type of this form item
	 */
	@AutoEscape
	public String getValidationType();

	/**
	 * Sets the validation type of this form item.
	 *
	 * @param validationType the validation type of this form item
	 */
	public void setValidationType(String validationType);

	/**
	 * Returns the validation regex value of this form item.
	 *
	 * @return the validation regex value of this form item
	 */
	@AutoEscape
	public String getValidationRegexValue();

	/**
	 * Sets the validation regex value of this form item.
	 *
	 * @param validationRegexValue the validation regex value of this form item
	 */
	public void setValidationRegexValue(String validationRegexValue);

	/**
	 * Returns the error validation message of this form item.
	 *
	 * @return the error validation message of this form item
	 */
	@AutoEscape
	public String getErrorValidationMessage();

	/**
	 * Sets the error validation message of this form item.
	 *
	 * @param errorValidationMessage the error validation message of this form item
	 */
	public void setErrorValidationMessage(String errorValidationMessage);

	/**
	 * Returns the error mandatory message of this form item.
	 *
	 * @return the error mandatory message of this form item
	 */
	@AutoEscape
	public String getErrorMandatoryMessage();

	/**
	 * Sets the error mandatory message of this form item.
	 *
	 * @param errorMandatoryMessage the error mandatory message of this form item
	 */
	public void setErrorMandatoryMessage(String errorMandatoryMessage);

	/**
	 * Returns the hint message of this form item.
	 *
	 * @return the hint message of this form item
	 */
	@AutoEscape
	public String getHintMessage();

	/**
	 * Sets the hint message of this form item.
	 *
	 * @param hintMessage the hint message of this form item
	 */
	public void setHintMessage(String hintMessage);

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
	public int compareTo(FormItem formItem);

	@Override
	public int hashCode();

	@Override
	public CacheModel<FormItem> toCacheModel();

	@Override
	public FormItem toEscapedModel();

	@Override
	public FormItem toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}