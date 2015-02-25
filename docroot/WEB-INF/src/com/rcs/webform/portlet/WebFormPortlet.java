

package com.rcs.webform.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rcs.webform.util.FieldOptions;
import com.rcs.webform.util.FormComponent;
import com.rcs.webform.util.FormModel;
import com.rcs.webform.util.PortletPropsValues;
import com.rcs.webform.util.WebFormUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;


public class WebFormPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = null;
		try {
			preferences = PortletPreferencesFactoryUtil.getPortletSetup(request);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String renderPageName = ParamUtil.get(request, "renderPage", "view.jsp");
		String renderPagePath = getInitParameter(renderPageName);
		FormModel formMoodel=generateFormModel(preferences,themeDisplay,request);
		request.setAttribute("formMoodel", formMoodel);
		super.render(request, response);
	}
	
	public FormModel generateFormModel(PortletPreferences portletPreferences,ThemeDisplay themeDisplay,RenderRequest request){
		FormModel formMoodel=new FormModel();
		formMoodel.setTitle(LocalizationUtil.getPreferencesValue(portletPreferences, "title", themeDisplay.getLanguageId()));
		formMoodel.setDescription(HtmlUtil.escape(LocalizationUtil.getPreferencesValue(portletPreferences, "description", themeDisplay.getLanguageId())));
		formMoodel.setRequireCaptcha(GetterUtil.getBoolean(portletPreferences.getValue("requireCaptcha", StringPool.BLANK)));
		if(Validator.isNull(portletPreferences.getValue("successURL", StringPool.BLANK))){
			formMoodel.setValidatorSuccesUrl(true);
		}else{
			formMoodel.setValidatorSuccesUrl(false);
		}
		
		if(Validator.isNull(formMoodel.getDescription())){
			formMoodel.setValidatorDescription(true);
		}else{
			formMoodel.setValidatorDescription(false);
		}
		
		if(Validator.isNull(portletPreferences.getValue("successURL", StringPool.BLANK))){
			formMoodel.setValidatorSuccessURL(true);
		}else{
			formMoodel.setValidatorSuccessURL(false);
		}
		
		if(PortletPropsValues.VALIDATION_SCRIPT_ENABLED && SessionErrors.contains(request, "validationScriptError") ){
			formMoodel.setValidateScriptEnable(true);
		}else{
			formMoodel.setValidateScriptEnable(false);
		}
		
		int i = 1;

		String fieldName = "field" + i;
		String fieldLabel = LocalizationUtil.getPreferencesValue(portletPreferences, "fieldLabel" + i, themeDisplay.getLanguageId());
		boolean fieldOptional = PrefsParamUtil.getBoolean(portletPreferences, request, "fieldOptional" + i, false);
		String fieldValue = ParamUtil.getString(request, fieldName);
		List<FormComponent> formComponentSet = new ArrayList<FormComponent>();
		
		while ((i == 1) || Validator.isNotNull(fieldLabel)) {
			FormComponent formComponent=new FormComponent();
			formComponent.setFileType(portletPreferences.getValue("fieldType" + i, "text"));
			formComponent.setFieldOptions(LocalizationUtil.getPreferencesValue(portletPreferences, "fieldOptions" + i, themeDisplay.getLanguageId()));
			formComponent.setFieldValidationScript(portletPreferences.getValue("fieldValidationScript" + i, StringPool.BLANK));
			formComponent.setFieldValidationErrorMessage(portletPreferences.getValue("fieldValidationErrorMessage" + i, StringPool.BLANK));
			//formComponent.setPosition(portletPreferences.getValue("position" + i, StringPool.BLANK));
			formComponent.setPosition("horizontal");
			/*formComponent.setPlaceholder(portletPreferences.getValue("placeholder" + i, StringPool.BLANK));*/
			formComponent.setPlaceholder("Input Text Here");
			formComponent.setFieldOptional(fieldOptional);
			formComponent.setFieldValue(fieldValue);
			formComponent.setFieldLabel(fieldLabel);
			formComponent.setFieldName(fieldName);
			if(formComponent.getFileType().equalsIgnoreCase("options") || formComponent.getFileType().equalsIgnoreCase("radio")){
				List<FieldOptions> fieldOptionsSet = new ArrayList<FieldOptions>();
				for (String fieldOptionValue : WebFormUtil.split(formComponent.getFieldOptions())) {
					FieldOptions fieldOptions=new FieldOptions();
					fieldOptions.setOptionLabel(fieldOptionValue);
					fieldOptionsSet.add(fieldOptions);
				}
				formComponent.setFieldOptionsSet(fieldOptionsSet);
			}
			
			formComponentSet.add(formComponent);
			i++;
			
			fieldName = "field" + i;
			fieldLabel = LocalizationUtil.getPreferencesValue(portletPreferences, "fieldLabel" + i, themeDisplay.getLanguageId());
			fieldOptional = PrefsParamUtil.getBoolean(portletPreferences, request, "fieldOptional" + i, false);
			fieldValue = ParamUtil.getString(request, fieldName);
		}
		
		formMoodel.getFormComponentSet().addAll(formComponentSet);
		return formMoodel;
	}

}