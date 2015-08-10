package com.rcs.webform.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;


public class WebFormReportConfigurationImpl extends DefaultConfigurationAction {

	private static Log log = LogFactoryUtil.getLog(WebFormReportConfigurationImpl.class);
	
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		if (!SessionErrors.isEmpty(actionRequest)) {
			return;
		}
		
		log.info("Action");
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		return "/jsp/report/configuration.jsp";
	}
	
}
