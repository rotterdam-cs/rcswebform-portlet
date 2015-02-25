package com.rcs.webform.action;

import java.util.Locale;

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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.portlet.PortletProps;
import com.rcs.dbService.service.WebformRowLocalServiceUtil;
import com.rcs.webform.util.ConfigurationModel;
import com.rcs.webform.util.GeneralUtil;

/**
 * @author rikad.ramadhan
 *
 */
public class ConfigurationActionImpl extends DefaultConfigurationAction {

	private static Log log = LogFactoryUtil.getLog(ConfigurationActionImpl.class);
	
	@Override
	public String render(PortletConfig portletConfig, RenderRequest request, RenderResponse response)
			throws Exception{
		
		log.info("###--- Entering Render Action ---###");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(request);
		String portletResources = ParamUtil.getString(request, "portletResource");
		
		/* Generating Configuration Model */
		ConfigurationModel configModel = generateConfigurationModelData(preferences, request);
		
		boolean dataFilePathChangeable = GetterUtil.getBoolean(PortletProps.get(GeneralUtil.DATA_FILE_PATH_CHANGEABLE));
		
		
		
		log.info("Data File Path Changeable : "+dataFilePathChangeable);
		
		String returnPage = null;
		String formFieldsIndexesParam = ParamUtil.getString(request, "formFieldsIndexes");
		
		log.info("Indexes Param : "+formFieldsIndexesParam);
		
		returnPage = "/configuration.jsp";
		
		/* Setting Attribute */
		request.setAttribute("configModel", configModel);
		request.setAttribute("dataFilePathChangeable", dataFilePathChangeable);
		
		if(!dataFilePathChangeable){
			request.setAttribute("fileName", HtmlUtil.escape(GeneralUtil.getFileName(themeDisplay, portletResources)));
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
		
		//boolean updateFields = ParamUtil.getBoolean(actionRequest, "updateFields");
		String portletResources = ParamUtil.getString(actionRequest, "portletResource");
		
		PortletPreferences preferences = actionRequest.getPreferences();
		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "title");
		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "description");
		
		preferences.setValue("requireCaptcha", ParamUtil.getString(actionRequest, "requireCaptcha"));
		
		//log.info("PortletId : "+portletId);
		log.info("Portlet Resources : "+portletResources);
		
		if(SessionErrors.isEmpty(actionRequest)){
			preferences.store();
		}
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
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
		
		
		if(WebformRowLocalServiceUtil.getRowsCount(databaseTableName) > 0 ) {
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
}
