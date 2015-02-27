

package com.rcs.webform.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
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
import com.liferay.portlet.expando.model.ExpandoRow;
import com.liferay.portlet.expando.service.ExpandoRowLocalServiceUtil;
import com.rcs.dbservice.model.WebformRow;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rcs.webform.util.FieldOptions;
import com.rcs.webform.util.FormComponent;
import com.rcs.webform.util.FormModel;
import com.rcs.webform.util.PortletPropsValues;
import com.rcs.webform.util.WebFormUtil;



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
		/*formMoodel.setRequireCaptcha(GetterUtil.getBoolean(portletPreferences.getValue("requireCaptcha", StringPool.BLANK)));*/
		formMoodel.setRequireCaptcha(false);
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
			formComponent.setPlaceholder(portletPreferences.getValue("fieldPlaceHolder" + i, StringPool.BLANK));
			formComponent.setFieldOptional(fieldOptional);
			formComponent.setFieldValue(fieldValue);
			formComponent.setFieldLabel(fieldLabel);
			formComponent.setFieldName(fieldName);
			if(Validator.isNotNull(fieldValue)){
				formComponent.setFieldValueBoolean(GetterUtil.getBoolean(fieldValue));
			}
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
	
	@Override
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

		try {
			if (cmd.equals("captcha")) {
				serveCaptcha(resourceRequest, resourceResponse);
			}
			else if (cmd.equals("export")) {
				exportData(resourceRequest, resourceResponse);
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}
	
	protected void serveCaptcha(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		CaptchaUtil.serveImage(resourceRequest, resourceResponse);
	}
	
	protected void exportData(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletId = PortalUtil.getPortletId(resourceRequest);

		PortletPermissionUtil.check(
			themeDisplay.getPermissionChecker(), themeDisplay.getPlid(),
			portletId, ActionKeys.CONFIGURATION);

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(resourceRequest);

		String databaseTableName = preferences.getValue(
			"databaseTableName", StringPool.BLANK);
		String title = preferences.getValue("title", "no-title");

		StringBundler sb = new StringBundler();

		List<String> fieldLabels = new ArrayList<String>();

		for (int i = 1; true; i++) {
			String fieldLabel = preferences.getValue(
				"fieldLabel" + i, StringPool.BLANK);

			String localizedfieldLabel = LocalizationUtil.getPreferencesValue(
				preferences, "fieldLabel" + i, themeDisplay.getLanguageId());

			if (Validator.isNull(fieldLabel)) {
				break;
			}

			fieldLabels.add(fieldLabel);

			sb.append(getCSVFormattedValue(localizedfieldLabel));
			sb.append(PortletPropsValues.CSV_SEPARATOR);
		}

		sb.setIndex(sb.index() - 1);

		sb.append(CharPool.NEW_LINE);

		if (Validator.isNotNull(databaseTableName)) {
			List<ExpandoRow> rows = ExpandoRowLocalServiceUtil.getRows(themeDisplay.getCompanyId(), WebFormUtil.class.getName(),databaseTableName, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			for (ExpandoRow row : rows) {
				for (String fieldName : fieldLabels) {
					String data = ExpandoValueLocalServiceUtil.getData(
						themeDisplay.getCompanyId(),
						WebFormUtil.class.getName(), databaseTableName,
						fieldName, row.getClassPK(), StringPool.BLANK);

					sb.append(getCSVFormattedValue(data));
					sb.append(PortletPropsValues.CSV_SEPARATOR);
				}

				sb.setIndex(sb.index() - 1);

				sb.append(CharPool.NEW_LINE);
			}
		}

		String fileName = title + ".csv";
		byte[] bytes = sb.toString().getBytes();
		String contentType = ContentTypes.APPLICATION_TEXT;

		PortletResponseUtil.sendFile(
			resourceRequest, resourceResponse, fileName, bytes, contentType);
	}
	
	protected String getCSVFormattedValue(String value) {
		StringBundler sb = new StringBundler(3);

		sb.append(CharPool.QUOTE);
		sb.append(
			StringUtil.replace(value, CharPool.QUOTE, StringPool.DOUBLE_QUOTE));
		sb.append(CharPool.QUOTE);

		return sb.toString();
	}

	
	public void saveData(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletId = PortalUtil.getPortletId(actionRequest);

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portletId);

		boolean requireCaptcha = GetterUtil.getBoolean(
			preferences.getValue("requireCaptcha", StringPool.BLANK));
		String successURL = GetterUtil.getString(
			preferences.getValue("successURL", StringPool.BLANK));
		boolean sendAsEmail = GetterUtil.getBoolean(
			preferences.getValue("sendAsEmail", StringPool.BLANK));
		boolean saveToDatabase = GetterUtil.getBoolean(
			preferences.getValue("saveToDatabase", StringPool.BLANK));
		String databaseTableName = GetterUtil.getString(
			preferences.getValue("databaseTableName", StringPool.BLANK));
		boolean saveToFile = GetterUtil.getBoolean(preferences.getValue("saveToFile", StringPool.BLANK));
		String fileName = GetterUtil.getString(
			preferences.getValue("fileName", StringPool.BLANK));

		if (requireCaptcha) {
			try {
				CaptchaUtil.check(actionRequest);
			}
			catch (CaptchaTextException cte) {
				SessionErrors.add(
					actionRequest, CaptchaTextException.class.getName());

				return;
			}
		}

		Map<String, String> fieldsMap = new LinkedHashMap<String, String>();

		for (int i = 1; true; i++) {
			String fieldLabel = preferences.getValue(
				"fieldLabel" + i, StringPool.BLANK);

			String fieldType = preferences.getValue(
				"fieldType" + i, StringPool.BLANK);

			if (Validator.isNull(fieldLabel)) {
				break;
			}

			if (StringUtil.equalsIgnoreCase(fieldType, "paragraph")) {
				continue;
			}

			fieldsMap.put(fieldLabel, actionRequest.getParameter("field" + i));
		}

		Set<String> validationErrors = null;

		try {
			validationErrors = validate(fieldsMap, preferences);
		}
		catch (Exception e) {
			SessionErrors.add(
				actionRequest, "validationScriptError", e.getMessage().trim());

			return;
		}

		if (validationErrors.isEmpty()) {
			boolean databaseSuccess = true;

		

			if (saveToDatabase) {
				if (Validator.isNull(databaseTableName)) {
					databaseTableName = WebFormUtil.getNewDatabaseTableName(
						portletId);

					preferences.setValue("databaseTableName", databaseTableName);

					preferences.store();
				}

				databaseSuccess = saveDatabase(themeDisplay.getCompanyId(), fieldsMap, preferences,databaseTableName);
			}

	

			if (databaseSuccess) {
				if (Validator.isNull(successURL)) {
					SessionMessages.add(actionRequest, "success");
				}
				else {
					SessionMessages.add(
						actionRequest,
						portletId +
							SessionMessages.
								KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
				}
			}
			else {
				SessionErrors.add(actionRequest, "error");
			}
		}
		else {
			for (String badField : validationErrors) {
				SessionErrors.add(actionRequest, "error" + badField);
			}
		}

		if (SessionErrors.isEmpty(actionRequest) &&
			Validator.isNotNull(successURL)) {

			actionResponse.sendRedirect(successURL);
		}
	}
	
	protected Set<String> validate(
			Map<String, String> fieldsMap, PortletPreferences preferences)
		throws Exception {

		Set<String> validationErrors = new HashSet<String>();

		for (int i = 0; i < fieldsMap.size(); i++) {
			String fieldType = preferences.getValue(
				"fieldType" + (i + 1), StringPool.BLANK);
			String fieldLabel = preferences.getValue(
				"fieldLabel" + (i + 1), StringPool.BLANK);
			String fieldValue = fieldsMap.get(fieldLabel);

			boolean fieldOptional = GetterUtil.getBoolean(
				preferences.getValue(
					"fieldOptional" + (i + 1), StringPool.BLANK));

			if (Validator.equals(fieldType, "paragraph")) {
				continue;
			}

			if (!fieldOptional && Validator.isNotNull(fieldLabel) &&
				Validator.isNull(fieldValue)) {

				validationErrors.add(fieldLabel);

				continue;
			}

			if (!PortletPropsValues.VALIDATION_SCRIPT_ENABLED) {
				continue;
			}

			String validationScript = GetterUtil.getString(
				preferences.getValue(
					"fieldValidationScript" + (i + 1), StringPool.BLANK));

			if (Validator.isNotNull(validationScript) &&
				!WebFormUtil.validate(
					fieldValue, fieldsMap, validationScript)) {

				validationErrors.add(fieldLabel);

				continue;
			}
		}

		return validationErrors;
	}
	
	protected boolean saveDatabase(long companyId, Map<String, String> fieldsMap,PortletPreferences preferences, String databaseTableName)
		throws Exception {

		WebFormUtil.checkTable(companyId, databaseTableName, preferences);

		long classPK = CounterLocalServiceUtil.increment(
			WebFormUtil.class.getName());

		try {
			for (String fieldLabel : fieldsMap.keySet()) {
				String fieldValue = fieldsMap.get(fieldLabel);
				ExpandoValueLocalServiceUtil.addValue(companyId, WebFormUtil.class.getName(), databaseTableName,fieldLabel, classPK, fieldValue);
			}

			return true;
		}
		catch (Exception e) {
			_log.error(
				"The web form data could not be saved to the database", e);

			return false;
		}
	}

	
	private static Log _log = LogFactoryUtil.getLog(WebFormPortlet.class);


}