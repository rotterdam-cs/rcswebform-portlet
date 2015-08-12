package com.rcs.webform.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.rcs.webform.common.enums.FormItemType;
import com.rcs.webform.common.enums.ValidationType;
import com.rcs.webform.entity.dto.FormDTO;
import com.rcs.webform.entity.dto.FormItemDTO;
import com.rcs.webform.entity.dto.SubmittedDataDTO;
import com.rcs.webform.model.Form;
import com.rcs.webform.model.FormItem;
import com.rcs.webform.model.FormItemOption;
import com.rcs.webform.model.SubmittedData;
import com.rcs.webform.service.FormItemOptionLocalServiceUtil;
import com.sun.corba.se.spi.orb.StringPair;

public class EntityDtoConverter {
    
    private static final String NONE = "NONE";
    private static final String KEY = "KEY";
    private static final String VALUE = "VALUE";

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
        formItemDto.setType(formItem.getType().isEmpty() ? FormItemType.valueOf(NONE) : FormItemType.valueOf(formItem.getType()));
        Map<String, String> optionKeyValueMap = getOptionKeyValueMap(formItem, locale);
        formItemDto.setOptionKeys(optionKeyValueMap.get(KEY));
        formItemDto.setOptionValues(optionKeyValueMap.get(VALUE));
        formItemDto.setMandatory(formItem.getMandatory());
        formItemDto.setDefaultValue(formItem.getDefaultValue(locale));
        formItemDto.setOrder(formItem.getOrder());
        formItemDto.setValidationType(formItem.getValidationType().isEmpty() ? ValidationType.valueOf(NONE) : ValidationType
                .valueOf(formItem.getValidationType()));
        formItemDto.setMinLength(formItem.getMinLength());
        formItemDto.setMaxLength(formItem.getMaxLength());
        formItemDto.setValidationRegexValue(formItem.getValidationRegexValue());
        formItemDto.setErrorValidationMessage(formItem.getErrorValidationMessage(locale));
        formItemDto.setErrorMandatoryMessage(formItem.getErrorMandatoryMessage(locale));
        formItemDto.setErrorLengthMessage(formItem.getErrorLengthMessage(locale));
        formItemDto.setHintMessage(formItem.getHintMessage(locale));
        return formItemDto;
    }
    
    private static final Map<String, String> getOptionKeyValueMap(final FormItem formItem, final Locale locale){
        HashMap<String, String> optionKeyValueMap = new HashMap<String, String>();
        List<FormItemOption> formItemOptions = FormItemOptionLocalServiceUtil.getFormItemOptionsByFormItemId(formItem.getFormItemId());
        JSONArray optionKeyArray = JSONFactoryUtil.createJSONArray();
        JSONArray optionValueArray = JSONFactoryUtil.createJSONArray();
        for(FormItemOption formItemOption : formItemOptions) {
            optionKeyArray.put(formItemOption.getOptionKey(locale));
            optionValueArray.put(formItemOption.getOptionValue(locale));
        }
        optionKeyValueMap.put(KEY, optionKeyArray.toString());
        optionKeyValueMap.put(VALUE, optionValueArray.toString());
        return optionKeyValueMap;
    }
    
    public static final SubmittedDataDTO submittedDataEntityToDTO(final SubmittedData submittedData){
    	SubmittedDataDTO submittedDataDTO = new SubmittedDataDTO();
    	submittedDataDTO.setActive(submittedData.getActive());
    	submittedDataDTO.setCompanyId(submittedData.getCompanyId());
    	submittedDataDTO.setCreationDate(submittedData.getCreationDate());
    	submittedDataDTO.setFormId(submittedData.getFormId());
    	submittedDataDTO.setFormItemId(submittedData.getFormItemId());
    	submittedDataDTO.setGroupId(submittedData.getGroupId());
    	submittedDataDTO.setModificationDate(submittedData.getModificationDate());
    	submittedDataDTO.setModificationUser(submittedData.getModificationUser());
    	submittedDataDTO.setPortletId(submittedData.getPortletId());
    	submittedDataDTO.setSubmittedDataId(submittedData.getSubmittedDataId());
    	submittedDataDTO.setUserInput(submittedData.getUserInput());
    	return submittedDataDTO;
    }

}