package com.rcs.webform.action;

import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		if(!SessionErrors.isEmpty(actionRequest)){
			return;
		}
		
		Locale defaultLocale = LocaleUtil.getDefault();
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);
		
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		
		PortletPreferences preferences = actionRequest.getPreferences();
		
		//Save title and description to portlet preferences
		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "title");
		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "description");
		
		if(SessionErrors.isEmpty(actionRequest)){
			preferences.store();
		}
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		return "/jsp/configuration.jsp";
	}
}
