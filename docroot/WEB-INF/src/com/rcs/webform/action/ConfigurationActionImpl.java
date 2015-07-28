package com.rcs.webform.action;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.rcs.webform.model.FormItem;
import com.rcs.webform.service.FormItemLocalServiceUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		if (!SessionErrors.isEmpty(actionRequest)) {
			return;
		}

		Locale defaultLocale = LocaleUtil.getDefault();
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		String portletResource = ParamUtil.getString(actionRequest, "portletResource");

		PortletPreferences preferences = actionRequest.getPreferences();

		// Save title and description to portlet preferences
		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "title");
		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "description");

		boolean updateFields = ParamUtil.getBoolean(actionRequest, "updateFields");

		if (updateFields) {
			int i = 1;

			int[] formFieldsIndexes = StringUtil.split(ParamUtil.getString(actionRequest, "formFieldsIndexes"), 0);

			for (int formFieldsIndex : formFieldsIndexes) {
				Map<Locale, String> fieldLabelMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldLabel" + formFieldsIndex);

				if (Validator.isNull(fieldLabelMap.get(defaultLocale))) {
					continue;
				}

				String fieldType = ParamUtil.getString(actionRequest, "fieldType" + formFieldsIndex);
				boolean fieldOptional = ParamUtil.getBoolean(actionRequest, "fieldOptional" + formFieldsIndex);
				Map<Locale, String> fieldOptionsMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldOptions" + formFieldsIndex);
				String fieldValidationScript = ParamUtil.getString(actionRequest, "fieldValidationScript" + formFieldsIndex);
				String fieldValidationErrorMessage = ParamUtil.getString(actionRequest, "fieldValidationErrorMessage" + formFieldsIndex);

				if (Validator.isNotNull(fieldValidationScript) ^ Validator.isNotNull(fieldValidationErrorMessage)) {

					SessionErrors.add(actionRequest, "validationDefinitionInvalid" + i);
				}

				ServiceContext serviceContext = ServiceContextFactory.getInstance(FormItem.class.getName(), actionRequest);
				FormItemLocalServiceUtil.add(null, fieldLabelMap.values().toString(), fieldType, fieldOptionsMap.values().toString(), fieldOptional,
						fieldValidationScript, fieldValidationErrorMessage, serviceContext);

				i++;
			}

			if (!SessionErrors.isEmpty(actionRequest)) {
				return;
			}

		}

		if (SessionErrors.isEmpty(actionRequest)) {
			preferences.store();
		}

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		String cmd = ParamUtil.getString(renderRequest, Constants.CMD);

		if (cmd.equals(Constants.ADD)) {
			return "/jsp/edit_field.jsp";
		} else {
			return "/jsp/configuration.jsp";
		}
	}
}
