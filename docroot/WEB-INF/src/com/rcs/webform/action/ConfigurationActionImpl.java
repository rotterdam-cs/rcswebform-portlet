package com.rcs.webform.action;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.expando.service.ExpandoRowLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;
import com.rcs.webform.util.ConfigurationModel;
import com.rcs.webform.util.GeneralUtil;
import com.rcs.webform.util.WebFormUtil;
import com.rcs.webform.util.WebformFieldModel;

/**
 * @author rikad.ramadhan
 *
 */
public class ConfigurationActionImpl extends DefaultConfigurationAction {

	private static Log log = LogFactoryUtil.getLog(ConfigurationActionImpl.class);
	
	@Override
	public String render(PortletConfig portletConfig, RenderRequest request, RenderResponse response)
			throws Exception{
		
		ThemeDisplay themeDisplay 		= (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences 	= PortletPreferencesFactoryUtil.getPortletSetup(request);
		String portletResources 		= ParamUtil.getString(request, "portletResource");
		String formFieldsIndexesParam 	= ParamUtil.getString(request, "formFieldsIndexes");
		String cmd 						= ParamUtil.getString(request, Constants.CMD);
		String returnPage 				= null;
		
		if(cmd.equals(Constants.ADD)) {
			log.info("###--- Add Field Action ---###");
			
			returnPage = "/fieldPage.jsp";
			String configurationIndex = request.getParameter("index");
			log.info("configurationIndex : "+configurationIndex);
			
			request.setAttribute("configClass", this);
			request.setAttribute("configurationIndex", configurationIndex);
			request.setAttribute("configurationFormFieldsIndex", null);
			
		}else{
			log.info("###--- Entering Render Action ---###");
			
			/* Generating Configuration Model */
			ConfigurationModel configModel = generateConfigurationModelData(preferences, request);

			
			boolean dataFilePathChangeable = GetterUtil.getBoolean(PortletProps.get(GeneralUtil.DATA_FILE_PATH_CHANGEABLE));
			log.info("Data File Path Changeable : "+dataFilePathChangeable);
			
			returnPage = "/configuration.jsp";
			
			/* Setting Attribute */
			request.setAttribute("configModel", configModel);
			request.setAttribute("isEditable", configModel.getIsEditable());
			request.setAttribute("dataFilePathChangeable", dataFilePathChangeable);
			request.setAttribute("formFieldsIndexesParam", formFieldsIndexesParam);
			request.setAttribute("configClass", this);
			
			if(!dataFilePathChangeable){
				request.setAttribute("fileName", HtmlUtil.escape(GeneralUtil.getFileName(themeDisplay, portletResources)));
			}
		}
		
		return returnPage;
	}
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception{
		
		log.info("###--- Entering Process Action ---###");
		
		if(!SessionErrors.isEmpty(actionRequest)){
			return;
		}
		
		Locale defaultLocale 		= LocaleUtil.getDefault();
		String defaultLanguageId 	= LocaleUtil.toLanguageId(defaultLocale);
		String portletId 			= PortalUtil.getPortletId(actionRequest);
		String portletResources 	= ParamUtil.getString(actionRequest, "portletResource");
		boolean updateFields 		= ParamUtil.getBoolean(actionRequest, "updateFields");
		
		
		PortletPreferences preferences = actionRequest.getPreferences();
		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "title");
		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "description");
		
		preferences.setValue("requireCaptcha", ParamUtil.getString(actionRequest, "requireCaptcha"));
		
		log.info("PortletId : "+portletId);
		log.info("Portlet Resources : "+portletResources);
		
		/* Saving Dynamic Field To PortletPreference */
		if(updateFields){
			int i = 1;
			
			String databaseTableName = GeneralUtil.getNewDatabaseTableName(portletResources);
			preferences.setValue("databaseTableName", databaseTableName);
			
			int[] formFieldsIndexes = StringUtil.split(ParamUtil.getString(actionRequest, "formFieldsIndexes"), 0);
			log.info("FormFieldsIndexes Length : "+formFieldsIndexes.length);
			
			for(int formFieldIndex : formFieldsIndexes){
				Map<Locale, String> fieldLabelMap 		= LocalizationUtil.getLocalizationMap(actionRequest, "fieldLabel"+formFieldIndex);
				Map<Locale, String> fieldOptionsMap 	= LocalizationUtil.getLocalizationMap(actionRequest, "fieldOptions"+formFieldIndex);
				Map<Locale, String> fieldPlaceHolderMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldPlaceHolder"+formFieldIndex);
				
				if (Validator.isNull(fieldLabelMap.get(defaultLocale))) {
					continue;
				}
				
				String fieldType 					= ParamUtil.getString(actionRequest, "fieldType" + formFieldIndex);
				String fieldValidationScript 		= ParamUtil.getString(actionRequest, "fieldValidationScript" + formFieldIndex);
				String fieldValidationErrorMessage 	= ParamUtil.getString(actionRequest,"fieldValidationErrorMessage" + formFieldIndex);
				String fieldPosition				= ParamUtil.getString(actionRequest,"fieldPosition" + formFieldIndex);
				boolean fieldOptional 				= ParamUtil.getBoolean(actionRequest, "fieldOptional" + formFieldIndex);
				
				if (Validator.isNotNull(fieldValidationScript) ^ Validator.isNotNull(fieldValidationErrorMessage)) {
					SessionErrors.add(actionRequest, "validationDefinitionInvalid" + i);
				}
				
				updateModifiedLocales("fieldLabel" + i, fieldLabelMap, preferences);
				updateModifiedLocales("fieldOptions" + i, fieldOptionsMap, preferences);
				updateModifiedLocales("fieldPlaceHolder" + i, fieldPlaceHolderMap, preferences);
				
				preferences.setValue("fieldType" + i, fieldType);
				preferences.setValue("fieldOptional" + i, String.valueOf(fieldOptional));
				preferences.setValue("fieldValidationScript" + i, fieldValidationScript);
				preferences.setValue("fieldValidationErrorMessage" + i,fieldValidationErrorMessage);
				preferences.setValue("fieldPosition", fieldPosition);
				
				i++;
			}
			
			String fieldLabel = LocalizationUtil.getPreferencesValue(preferences, "fieldLabel" + i, defaultLanguageId);
			

			while (Validator.isNotNull(fieldLabel)) {
				Map<Locale, String> fieldLabelMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldLabel" + i);

				for (Locale locale : fieldLabelMap.keySet()) {
					String languageId = LocaleUtil.toLanguageId(locale);

					LocalizationUtil.setPreferencesValue(preferences, "fieldLabel" + i, languageId,StringPool.BLANK);

					LocalizationUtil.setPreferencesValue(preferences, "fieldOptions" + i, languageId,StringPool.BLANK);
					LocalizationUtil.setPreferencesValue(preferences, "fieldPlaceHolder" + i, languageId,StringPool.BLANK);
				}

				preferences.setValue("fieldType" + i, StringPool.BLANK);
				preferences.setValue("fieldOptional" + i, StringPool.BLANK);
				preferences.setValue("fieldValidationScript" + i, StringPool.BLANK);
				preferences.setValue("fieldValidationErrorMessage" + i, StringPool.BLANK);
				preferences.setValue("fieldPosition" + i, StringPool.BLANK);

				i++;

				fieldLabel = LocalizationUtil.getPreferencesValue(preferences, "fieldLabel" + i, defaultLanguageId);
			}
		}
		
		if(SessionErrors.isEmpty(actionRequest)){
			preferences.store();
		}
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	/**
	 * For Generating ConfigurationModel class so can be use to frontPage
	 * @param preferences
	 * @param request
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 * @author rikad.ramadhan
	 */
	public ConfigurationModel generateConfigurationModelData(PortletPreferences preferences,PortletRequest request ) throws SystemException, PortalException{
		
		log.info("###--- Begin Generating Configuration Model ---###");
		
		ConfigurationModel configModel = new ConfigurationModel();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String titleXml 		= GetterUtil.getString(LocalizationUtil.getLocalizationXmlFromPreferences(preferences, request, "title"));
		String descriptionXml 	= GetterUtil.getString(LocalizationUtil.getLocalizationXmlFromPreferences(preferences, request, "description"));
		String emailFromName	= PortalUtil.getEmailFromName(preferences, themeDisplay.getCompanyId(), "");
		String emailFromAddr	= PortalUtil.getEmailFromAddress(preferences, themeDisplay.getCompanyId(), "");
		String emailAddress 	= preferences.getValue("emailAddress", StringPool.BLANK);
		String subject 			= preferences.getValue("subject", StringPool.BLANK);
		String databaseTableName= preferences.getValue("databaseTableName", StringPool.BLANK);
		String successURL		= preferences.getValue("successURL", StringPool.BLANK);
		String fileName 		= preferences.getValue("fileName", StringPool.BLANK);
		Integer totalField		= GetterUtil.getInteger(preferences.getValue("totalField", String.valueOf(1)));
		boolean requireCaptcha	= GetterUtil.getBoolean(preferences.getValue("requireCaptcha", StringPool.BLANK));
		boolean sendAsEmail 	= GetterUtil.getBoolean(preferences.getValue("sendAsEmail", StringPool.BLANK));
		boolean saveToDatabase 	= GetterUtil.getBoolean(preferences.getValue("saveToDatabase", StringPool.BLANK));
		boolean saveToFile 		= GetterUtil.getBoolean(preferences.getValue("saveToFile", StringPool.BLANK));
		boolean isEditable 		= true;
		
		Integer databaseRowsCount = ExpandoRowLocalServiceUtil.getRowsCount(themeDisplay.getCompanyId(), WebFormUtil.class.getName(),databaseTableName);
		log.info(databaseTableName+" || Rows Count : "+databaseRowsCount.toString());
		if(databaseRowsCount > 0 ) {
			isEditable = false;
		}
		
		configModel.setTitleXml(titleXml);
		configModel.setDescriptionXml(descriptionXml);
		configModel.setSuccessURL(successURL);
		configModel.setRequireCaptcha(requireCaptcha);
		configModel.setEmailFromAddress(emailFromAddr);
		configModel.setEmailFromName(emailFromName);
		configModel.setEmailAddress(emailAddress);
		configModel.setSubject(subject);
		configModel.setFileName(fileName);
		configModel.setIsEditable(isEditable);
		configModel.setDatabaseTableName(databaseTableName);
		configModel.setTotalField(totalField);
		configModel.setSendAsEmail(sendAsEmail);
		configModel.setSaveToDatabase(saveToDatabase);
		configModel.setSaveToFile(saveToFile);
		
		return configModel;
	}
	
	protected void updateModifiedLocales(String parameter, Map<Locale, String> newLocalizationMap, PortletPreferences preferences)
		throws Exception{
		
		Map<Locale, String> oldLocalizationMap = LocalizationUtil.getLocalizationMap(preferences, parameter);
		List<Locale> modifiedLocales = LocalizationUtil.getModifiedLocales(oldLocalizationMap, newLocalizationMap);
		
		for(Locale locale : modifiedLocales){
			String languageId = LocaleUtil.toLanguageId(locale);
			String value = newLocalizationMap.get(locale);
			
			LocalizationUtil.setPreferencesValue(preferences, parameter, languageId, value);
		}
		
	}
	
	
	
	public int[] generateFormFieldsIndexes(String formFieldsIndexesParam,PortletRequest request) throws PortalException, SystemException{
		log.info("###--- Generating FormFieldsIndexes ---###");
		
		int[] formFieldsIndexes = null;
		PortletPreferences preferences 	= PortletPreferencesFactoryUtil.getPortletSetup(request);
		
		if(Validator.isNotNull(formFieldsIndexesParam)){
			formFieldsIndexes = StringUtil.split(formFieldsIndexesParam,0);
		}else{
			formFieldsIndexes = new int[0];
			
			for(int i=1; true; i++){
				String fieldLabel = GetterUtil.getString(preferences.getValue("fieldLabel"+i, null));
				
				if(Validator.isNull(fieldLabel)){
					break;
				}
				
				formFieldsIndexes = ArrayUtil.append(formFieldsIndexes, i);
			}
			
			if(formFieldsIndexes.length == 0){
				formFieldsIndexes = ArrayUtil.append(formFieldsIndexes, -1);
			}
		}
		log.info("Form Field Indexes : "+formFieldsIndexes.length);
		return formFieldsIndexes;
	}
	
	public WebformFieldModel generatingWebformFieldModelData(PortletRequest request,int formFieldsIndex, int index ) throws PortalException, SystemException{
		
		log.info("###--- Generating WebformFieldModel Data ---###");
		log.info("FormFieldIndex : "+formFieldsIndex+"|| Index Value : "+index);
		
		PortletPreferences preferences 	= PortletPreferencesFactoryUtil.getPortletSetup(request);
		
		WebformFieldModel fieldModel = new WebformFieldModel();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		String fieldLabelXml 				= GetterUtil.getString(LocalizationUtil.getLocalizationXmlFromPreferences(preferences, request, "fieldLabel"+formFieldsIndex),StringPool.BLANK);
		String fieldLabel 					= LocalizationUtil.getLocalization(fieldLabelXml, themeDisplay.getLanguageId());
		String fieldType 					= PrefsParamUtil.getString(preferences, request, "fieldType"+formFieldsIndex);
		String fieldOptionsXml 				= GetterUtil.getString(LocalizationUtil.getLocalizationXmlFromPreferences(preferences, request, "fieldOptions"+formFieldsIndex),StringPool.BLANK);
		String fieldOptions 				= LocalizationUtil.getLocalization(fieldOptionsXml, themeDisplay.getLanguageId());
		String fieldValidationScript 		= PrefsParamUtil.getString(preferences, request, "fieldValidationScript" + formFieldsIndex);
		String fieldValidationErrorMessage 	= PrefsParamUtil.getString(preferences, request, "fieldValidationErrorMessage" + formFieldsIndex);
		String fieldPlaceHolderXml			= GetterUtil.getString(LocalizationUtil.getLocalizationXmlFromPreferences(preferences, request, "fieldPlaceHolder"+formFieldsIndex),StringPool.BLANK);
		String fieldPlaceHolder				= LocalizationUtil.getLocalization(fieldPlaceHolderXml, themeDisplay.getLanguageId());;
		String fieldPosition				= PrefsParamUtil.getString(preferences, request, "fieldPosition"+formFieldsIndex);
		int formFieldsIndexParam 			= formFieldsIndex;
		boolean fieldOptional 				= PrefsParamUtil.getBoolean(preferences, request, "fieldOptional" + formFieldsIndex);
		boolean ignoreRequestValue 			= (index != formFieldsIndex);
		
		log.info("fieldLabelXml : "+fieldLabelXml);
		log.info("fieldValidationScript : "+fieldValidationScript);
		
		fieldModel.setFieldLabelXml(fieldLabelXml);
		fieldModel.setFieldLabel(fieldLabel);
		fieldModel.setFieldType(fieldType);
		fieldModel.setFieldOptionsXml(fieldOptionsXml);
		fieldModel.setFieldOptions(fieldOptions);
		fieldModel.setFieldValidationErrorMessage(fieldValidationErrorMessage);
		fieldModel.setFieldValidationScript(fieldValidationScript);
		fieldModel.setIndex(index);
		fieldModel.setFormFieldsIndex(formFieldsIndexParam);
		fieldModel.setFieldOptional(fieldOptional);
		fieldModel.setIqnoreRequestValue(ignoreRequestValue);
		fieldModel.setFieldValidationScriptHide(Validator.isNull(fieldValidationScript) ? "hide" : "");
		fieldModel.setFieldOptionsCss("options"+ ((Validator.isNull(fieldType) || (!fieldType.equals("options") && !fieldType.equals("radio"))) ? " hide" : StringPool.BLANK));
		fieldModel.setFieldPlaceHolder(fieldPlaceHolder);
		fieldModel.setFieldPlaceHolderXml(fieldPlaceHolderXml);
		fieldModel.setFieldPosition(fieldPosition);
		
		log.info("FieldOptionsCss : "+fieldModel.getFieldOptionsCss());
		
		return fieldModel;
	}
	
}
