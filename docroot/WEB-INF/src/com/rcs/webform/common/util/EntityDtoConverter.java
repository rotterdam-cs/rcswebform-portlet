package com.rcs.webform.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.rcs.webform.common.enums.FormItemType;
import com.rcs.webform.common.enums.ValidationType;
import com.rcs.webform.entity.dto.FormDTO;
import com.rcs.webform.entity.dto.FormItemDTO;
import com.rcs.webform.model.Form;
import com.rcs.webform.model.FormItem;

public class EntityDtoConverter {

    public static final FormDTO formEntityToDto(final Form form, final List<FormItem> formItems, final Locale locale) {

        FormDTO formDto = new FormDTO();
        formDto.setFormId(form.getFormId());
        formDto.setActive(form.getActive());
        formDto.setCreationDate(form.getCreationDate());
        formDto.setModificationDate(form.getModificationDate());
        formDto.setModificationUser(form.getModificationUser());
        formDto.setCompanyId(form.getCompanyId());
        formDto.setGroupId(form.getGroupId());
        formDto.setUserId(form.getUserId());
        formDto.setUserName(form.getUserName());
        formDto.setFormAttrId(form.getFormAttrId());
        formDto.setFormAttrClass(form.getFormAttrClass());
        formDto.setTitle(HtmlUtil.escape(form.getTitle(locale)));
        formDto.setDesc(form.getDesc(locale));
        formDto.setUseCaptcha(form.getUseCaptcha());
        formDto.setSuccessMessage(form.getSuccessMessage(locale));
        formDto.setSuccessURL(form.getSuccessURL());
        formDto.setSubmitLabel(form.getSubmitLabel(locale));
        formDto.setSubmitAttrId(form.getSubmitAttrId());
        formDto.setSubmitAttrClass(form.getSubmitAttrClass());
        formDto.setFormItems(formItemListEntityToDto(formItems, locale));
        return formDto;
    }

    public static final List<FormItemDTO> formItemListEntityToDto(final List<FormItem> formItems, final Locale locale) {
        List<FormItemDTO> formItemDTOs = new ArrayList<FormItemDTO>();
        for (FormItem formItem : formItems) {
            formItemDTOs.add(formItemEntityToDto(formItem, locale));
        }
        return formItemDTOs;
    }

    public static final FormItemDTO formItemEntityToDto(final FormItem formItem, final Locale locale) {
        FormItemDTO formItemDto = new FormItemDTO();
        formItemDto.setFormItemId(formItem.getFormItemId());
        formItemDto.setActive(formItem.getActive());
        formItemDto.setCreationDate(formItem.getCreationDate());
        formItemDto.setModificationDate(formItem.getModificationDate());
        formItemDto.setModificationUser(formItem.getModificationUser());
        formItemDto.setFormId(formItem.getFormId());
        formItemDto.setFormItemAttrId(formItem.getFormItemAttrId());
        formItemDto.setFormItemAttrClass(formItem.getFormItemAttrClass());
        formItemDto.setLabel(formItem.getLabel(locale));
        formItemDto.setLabelAttrId(formItem.getLabelAttrId());
        formItemDto.setLabelAttrClass(formItem.getLabelAttrClass());
        formItemDto.setInputAttrId(formItem.getInputAttrId());
        formItemDto.setInputAttrClass(formItem.getInputAttrClass());
        formItemDto.setType(formItem.getType().isEmpty() ? FormItemType.valueOf("NONE") : FormItemType.valueOf(formItem.getType()));
        formItemDto.setOptions(formItem.getOptions(locale));
        formItemDto.setMandatory(formItem.getMandatory());
        formItemDto.setDefaultValue(formItem.getDefaultValue(locale));
        formItemDto.setOrder(formItem.getOrder());
        formItemDto.setValidationType(formItem.getValidationType().isEmpty() ? ValidationType.valueOf("NONE") : ValidationType
                .valueOf(formItem.getValidationType()));
        formItemDto.setValidationRegexValueString(formItem.getValidationRegexValue());
        formItemDto.setErrorValidationMessage(formItem.getErrorValidationMessage(locale));
        formItemDto.setErrorMandatoryMessage(formItem.getErrorMandatoryMessage(locale));
        return formItemDto;
    }

}