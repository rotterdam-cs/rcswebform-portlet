package com.rcs.webform.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;


public class WebFormReportConfigurationImpl extends DefaultConfigurationAction {
	
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		if (!SessionErrors.isEmpty(actionRequest)) {
			return;
		}
		
		PortletPreferences preferences = actionRequest.getPreferences();
		
		Long selectedFormId = ParamUtil.getLong(actionRequest, "selectedRcsWebForm", -1);
		preferences.setValue("selectedForm", String.valueOf(selectedFormId));
		
		if (SessionErrors.isEmpty(actionRequest)) {
			preferences.store();
		}
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		return "/jsp/report/configuration.jsp";
	}
	
}
