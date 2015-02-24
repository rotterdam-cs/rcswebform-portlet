package com.rcs.webform.action;

import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

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
		
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(request);
		
		/* Portlet Preference Declaration */
		String titleXml 		= GetterUtil.getString(LocalizationUtil.getLocalizationXmlFromPreferences(preferences, request, "title"));
		String descriptionXml 	= GetterUtil.getString(LocalizationUtil.getLocalizationXmlFromPreferences(preferences, request, "description"));
		
		String returnPage = null;
		
		log.info("Title XML : "+titleXml);
		
		returnPage = "/configuration.jsp";
		
		request.setAttribute("titleXml", titleXml);
		
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
		
		boolean updateFields = ParamUtil.getBoolean(actionRequest, "updateFields");
		String portletResources = ParamUtil.getString(actionRequest, "portletResources");
		
		PortletPreferences preferences = actionRequest.getPreferences();
		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "title");
		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "description");
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
}
