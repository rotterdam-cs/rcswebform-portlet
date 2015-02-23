package com.rcs.webform.action;

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

/**
 * @author rikad.ramadhan
 *
 */
public class ConfigurationActionImpl extends DefaultConfigurationAction {

	@Override
	public String render(PortletConfig portletConfig, RenderRequest request, RenderResponse response)
			throws Exception{
		
		String returnPage = null;
		
		returnPage = "/configuration.jsp";
		
		return returnPage;
	}
}
