<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="java.util.List"%>
<%@page import="com.rcs.webform.model.FormItem"%>
<%@page import="com.rcs.webform.model.FormItemSoap"%>
<%@ include file="/jsp/init.jsp" %>

<%
int index = ParamUtil.getInteger(renderRequest, "index", GetterUtil.getInteger((String)request.getAttribute("configuration.jsp-index")));
int formFieldsIndex = GetterUtil.getInteger((String)request.getAttribute("configuration.jsp-formFieldsIndex"));
boolean fieldsEditingDisabled = GetterUtil.getBoolean((String)request.getAttribute("configuration.jsp-fieldsEditingDisabled"));
List<FormItem> formItems = (List<FormItem>) GetterUtil.getObject(request.getAttribute("formItems"));
Long formItemId = null;
String fieldLabelXml = "";
String fieldLabel = "";
String fieldType = "TEXT_FIELD";
boolean fieldOptional = false;
String fieldOptionsXml = "";
String fieldOptions = "";
String fieldValidationScript = "";
String fieldValidationErrorMessage = "";
String fieldTextFieldInputType = "ALPHA";
String fieldHintMessageXml = "";
int inputMaxLength = 0;

if(formItems != null && !formItems.isEmpty()){
	formItemId = formItems.get(formFieldsIndex).getFormItemId();
	fieldLabelXml = formItems.get(formFieldsIndex).getLabel();
	fieldLabel = LocalizationUtil.getLocalization(fieldLabelXml, themeDisplay.getLanguageId());
	fieldType = formItems.get(formFieldsIndex).getType();
	fieldOptional = !formItems.get(formFieldsIndex).getMandatory();
	fieldOptionsXml = formItems.get(formFieldsIndex).getOptions();
	fieldOptions = LocalizationUtil.getLocalization(fieldOptionsXml, themeDisplay.getLanguageId());
	fieldTextFieldInputType = formItems.get(formFieldsIndex).getValidationType();
	inputMaxLength = formItems.get(formFieldsIndex).getMaxLength();
	fieldValidationScript = PrefsParamUtil.getString(portletPreferences, request, "fieldValidationScript" + formFieldsIndex);
	fieldValidationErrorMessage = PrefsParamUtil.getString(portletPreferences, request, "fieldValidationErrorMessage" + formFieldsIndex);
	fieldHintMessageXml = formItems.get(formFieldsIndex).getHintMessage();
}

boolean ignoreRequestValue = (index != formFieldsIndex);
%>

<liferay-ui:error key='<%= "fieldSizeInvalid" + formFieldsIndex %>' message="please-enter-no-more-than-75-characters" />

<div class="field-row field-row">
	<div class="field-title">
		<c:choose>
			<c:when test='<%= fieldType.equals("paragraph") %>'>
				<span class="field-label"><liferay-ui:message key="paragraph" /></span>
			</c:when>
			<c:when test="<%= Validator.isNotNull(fieldLabel) %>">
				<span class="field-label"><%= fieldLabel %></span>
			</c:when>
			<c:otherwise>
				<liferay-ui:message key="new-item" />
			</c:otherwise>
		</c:choose>
	</div>

	<c:choose>
		<c:when test="<%= !fieldsEditingDisabled %>">
			<aui:input name='<%= "_field" + index %>' type="hidden" />
			<aui:input cssClass="formItemId" name='<%= "formItemId" + index %>' type="hidden" value='<%=formItemId%>'/>

			<aui:field-wrapper cssClass="label-name" label="name">
				<liferay-ui:input-localized ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "fieldLabel" + index %>' xml="<%= fieldLabelXml %>" />
			</aui:field-wrapper>
		</c:when>
		<c:otherwise>
			<dl class="editing-disabled">
				<dt>
					<liferay-ui:message key="name" />
				</dt>
				<dd>
					<%= fieldLabel %>
				</dd>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="<%= !fieldsEditingDisabled %>">
			<aui:select cssClass='field-type' ignoreRequestValue="<%= ignoreRequestValue %>" label="type" name='<%= "fieldType" + index %>' >
				<aui:option selected='<%= fieldType.equals("TEXT_FIELD") %>' value="TEXT_FIELD"><liferay-ui:message key="text" /></aui:option>
				<aui:option selected='<%= fieldType.equals("TEXT_BOX") %>' value="TEXT_BOX"><liferay-ui:message key="text-box" /></aui:option>
				<aui:option selected='<%= fieldType.equals("PASSWORD") %>' value="PASSWORD"><liferay-ui:message key="password" /></aui:option>
				<aui:option selected='<%= fieldType.equals("OPTIONS") %>' value="OPTIONS"><liferay-ui:message key="options" /></aui:option>
				<aui:option selected='<%= fieldType.equals("RADIO_BUTTON") %>' value="RADIO_BUTTON"><liferay-ui:message key="radio-buttons" /></aui:option>
				<aui:option selected='<%= fieldType.equals("CHECKBOX") %>' value="CHECKBOX"><liferay-ui:message key="check-box" /></aui:option>
				<aui:option selected='<%= fieldType.equals("DATE") %>' value="DATE"><liferay-ui:message key="date" /></aui:option>
				<aui:option selected='<%= fieldType.equals("SECTION") %>' value="SECTION"><liferay-ui:message key="Section" /></aui:option>
			</aui:select>
		</c:when>
		<c:otherwise>
				<dt>
					<liferay-ui:message key="type" />
				</dt>
				<dd>
					<liferay-ui:message key="<%= fieldType %>" />
				</dd>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="<%= !fieldsEditingDisabled %>">
			<aui:input cssClass="optional-control" ignoreRequestValue="<%= ignoreRequestValue %>" label="optional" name='<%= "fieldOptional" + index %>' type="checkbox" value="<%= fieldOptional %>" />
		</c:when>
		<c:otherwise>
				<dt>
					<liferay-ui:message key="optional" />
				</dt>
				<dd>
					<liferay-ui:message key='<%= fieldOptional ? "yes" : "no" %>' />
				</dd>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="<%= !fieldsEditingDisabled %>">
			<aui:field-wrapper cssClass='<%= "options" + ((Validator.isNull(fieldType) || (!fieldType.equals("OPTIONS") && !fieldType.equals("RADIO_BUTTON"))) ? " hide" : StringPool.BLANK) %>' helpMessage="add-options-separated-by-commas" label="options">
				<liferay-ui:input-localized ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "fieldOptions" + index %>' xml="<%= fieldOptionsXml %>" />
			</aui:field-wrapper>
		</c:when>
		<c:when test="<%= Validator.isNotNull(fieldOptions) %>">
				<dt>
					<liferay-ui:message key="options" />
				</dt>
				<dd>
					<%= fieldOptions %>
				</dd>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test="<%= !fieldsEditingDisabled %>">
				<aui:field-wrapper cssClass='<%= "input-hint-message" + ((Validator.isNull(fieldType) || (!fieldType.equals("TEXT_FIELD"))) ? " hide" : StringPool.BLANK) %>' label="Hint Message" helpMessage='Set Field Hint Message / Placeholder'>
					<liferay-ui:input-localized ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "fieldHintMessage" + index %>' xml="<%= fieldHintMessageXml %>" />
				</aui:field-wrapper>
		</c:when>
	</c:choose>

	<c:choose>
		<c:when test="<%= !fieldsEditingDisabled %>">
			<aui:field-wrapper cssClass='<%= "text-field-input-type" + ((Validator.isNull(fieldType) || (!fieldType.equals("TEXT_FIELD"))) ? " hide" : StringPool.BLANK) %>' >
				<aui:select cssClass="text-field-input-type" ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "fieldInputType" + index %>' helpMessage='Set Text Field Input Type' label="Input Type">
					<aui:option selected='<%= fieldTextFieldInputType.equals("ALPHA") %>' value="ALPHA"><liferay-ui:message key="text" /></aui:option>
					<aui:option selected='<%= fieldTextFieldInputType.equals("NUMBER") %>' value="NUMBER"><liferay-ui:message key="number" /></aui:option>
					<aui:option selected='<%= fieldTextFieldInputType.equals("PHONE_NUMBER") %>' value="PHONE_NUMBER"><liferay-ui:message key="phone-number" /></aui:option>
					<aui:option selected='<%= fieldTextFieldInputType.equals("EMAIL") %>' value="EMAIL"><liferay-ui:message key="email" /></aui:option>
				</aui:select>
				
				<aui:field-wrapper cssClass='<%= "input-max-length" + ((Validator.isNull(fieldTextFieldInputType) || (!fieldTextFieldInputType.equals("ALPHA") && !fieldTextFieldInputType.equals("NUMBER"))) ? " hide" : StringPool.BLANK) %>' >
					<aui:input ignoreRequestValue="<%= ignoreRequestValue %>" label="Max Length" name='<%= "inputMaxLength" + index %>' helpMessage="Set max number of allowed characters" type="text" value="<%= inputMaxLength %>" />
				</aui:field-wrapper>
			</aui:field-wrapper>
		</c:when>
	</c:choose>

	<c:if test="false">
		<c:choose>
			<c:when test="<%= !fieldsEditingDisabled %>">
				<div class="validation">
					<liferay-ui:error key='<%= "validationDefinitionInvalid" + index %>' message="please-enter-both-the-validation-code-and-the-error-message" />

					<aui:a cssClass="validation-link" href="javascript:;"><liferay-ui:message key="validation" /> &raquo;</aui:a>

					<div class='validation-input <%= Validator.isNull(fieldValidationScript) ? "hide" : "" %>'>
						<aui:column columnWidth="50">
							<aui:input cols="80" cssClass="validation-script" ignoreRequestValue="<%= ignoreRequestValue %>" label="validation-script" name='<%= "fieldValidationScript" + index %>' style="width: 95%" type="textarea" value="<%= fieldValidationScript %>" wrap="off" />

							<aui:input cols="80" cssClass="lfr-input-text-container" ignoreRequestValue="<%= ignoreRequestValue %>" label="validation-error-message" name='<%= "fieldValidationErrorMessage" + index %>' size="80" value="<%= fieldValidationErrorMessage %>" />
						</aui:column>
						<aui:column columnWidth="50">
							<div class="syntax-help">
								<liferay-util:include page="/script_help.jsp" servletContext="<%= application %>" />
							</div>
						</aui:column>
					</div>
				</div>
			</c:when>
			<c:when test="<%=Validator.isNotNull(fieldValidationScript) %>">
					<dt class="optional">
						<liferay-ui:message key="validation" />
					</dt>
					<dd>
						<pre><%= fieldValidationScript %></pre>
					</dd>
					<dt class="optional">
						<liferay-ui:message key="validation-error-message" />
					</dt>
					<dd>
						<%= fieldValidationErrorMessage %>
					</dd>
			</c:when>
			<c:otherwise>
					<dt class="optional">
						<liferay-ui:message key="validation" />
					</dt>
					<dd>
						<liferay-ui:message key="this-field-does-not-have-any-specific-validation" />
					</dd>
			</c:otherwise>
		</c:choose>
	</c:if>

	<c:if test="<%=fieldsEditingDisabled %>">
		</dl>
	</c:if>
</div>