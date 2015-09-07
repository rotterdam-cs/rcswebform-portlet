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

<%@page import="com.rcs.webform.model.FormItemOption"%>
<%@page import="java.util.List"%>
<%@page import="com.rcs.webform.model.FormItem"%>
<%@page import="com.rcs.webform.model.FormItemSoap"%>
<%@ include file="/jsp/init.jsp" %>

<%
String defaultLocale = themeDisplay.getLocale().toString();
int index = ParamUtil.getInteger(renderRequest, "index", GetterUtil.getInteger((String)request.getAttribute("configuration.jsp-index")));
int formFieldsIndex = GetterUtil.getInteger((String)request.getAttribute("configuration.jsp-formFieldsIndex"));
boolean fieldsEditingDisabled = GetterUtil.getBoolean((String)request.getAttribute("configuration.jsp-fieldsEditingDisabled"));
List<FormItem> formItems = (List<FormItem>) GetterUtil.getObject(request.getAttribute("formItems"));
String portletId = PortalUtil.getPortletId(request);
int fieldOptionsIndex = 0;
Long formItemId = null;
String fieldLabelXml = "";
String fieldLabel = "";
String fieldType = "TEXT_FIELD";
boolean fieldOptional = true;
String fieldOptionsXml = "";
String formItemOptionLabelMap = "";
String formItemOptionValue = "";
Long formItemOptionId = null;
String fieldOptions = "";
String fieldValidationScript = "";
String fieldValidationErrorMessage = "";
String fieldTextFieldInputType = "NONE";
String fieldHintMessageXml = "";
String fieldDefaultValueXml = "";
int inputMaxLength = 0;

String sectionCssClass = "rcs section";
String sectionLabelCssClass = "rcs section-label";
String formItemCssClass = "rcs control-group";
String labelCssClass = "rcs control-label dual";
String inputCssClass = "rcs field dual";

String oneColumnLabelCssClass = "rcs control-label single";
String oneColumnInputCssClass = "rcs field single";
String twoColumnLabelCssClass = "rcs control-label dual";
String twoColumnInputCssClass = "rcs field dual";

String mandatoryErrorMessageXml = "";
String validationErrorMessageXml = "";
String maxLengthErrorMessageXml = "";
String fieldValidationRegex = "";
String formLayout = "";
String dateFormat = "%d/%m/%Y";

if(formItems != null && !formItems.isEmpty()){
	formItemId = formItems.get(formFieldsIndex).getFormItemId();
	fieldLabelXml = formItems.get(formFieldsIndex).getLabel();
	fieldLabel = LocalizationUtil.getLocalization(fieldLabelXml, themeDisplay.getLanguageId());
	fieldType = formItems.get(formFieldsIndex).getType();
	fieldOptional = !formItems.get(formFieldsIndex).getMandatory();
	fieldTextFieldInputType = formItems.get(formFieldsIndex).getValidationType();
	inputMaxLength = formItems.get(formFieldsIndex).getMaxLength();
	fieldValidationScript = PrefsParamUtil.getString(portletPreferences, request, "fieldValidationScript" + formFieldsIndex);
	fieldValidationErrorMessage = PrefsParamUtil.getString(portletPreferences, request, "fieldValidationErrorMessage" + formFieldsIndex);
	fieldHintMessageXml = formItems.get(formFieldsIndex).getHintMessage();
	fieldDefaultValueXml = formItems.get(formFieldsIndex).getDefaultValue();
	formItemCssClass = formItems.get(formFieldsIndex).getFormItemAttrClass();
	labelCssClass = formItems.get(formFieldsIndex).getLabelAttrClass();
	inputCssClass = formItems.get(formFieldsIndex).getInputAttrClass();
	mandatoryErrorMessageXml = formItems.get(formFieldsIndex).getErrorMandatoryMessage();
	validationErrorMessageXml = formItems.get(formFieldsIndex).getErrorValidationMessage();
	maxLengthErrorMessageXml = formItems.get(formFieldsIndex).getErrorLengthMessage();
	fieldValidationRegex = formItems.get(formFieldsIndex).getValidationRegexValue();
	formLayout = formItems.get(formFieldsIndex).getFormLayout();
	dateFormat = formItems.get(formFieldsIndex).getDateFormat();
}

List<FormItemOption> formItemOptions = null;
if(fieldType.equals("OPTIONS") || fieldType.equals("RADIO_BUTTON") || fieldType.equals("CHECKBOX")){
	formItemOptions = WebFormUtil.getFormItemOptions(formItemId);
	if(formItemOptions != null && !formItemOptions.isEmpty()){
		fieldOptionsIndex = formItemOptions.size();
		formItemOptionId = formItemOptions.get(0).getFormItemOptionId();
		formItemOptionValue = formItemOptions.get(0).getOptionKey();
		formItemOptionLabelMap = formItemOptions.get(0).getOptionValue();
	}
}

if(fieldOptionsIndex == 0){
	fieldOptionsIndex = 1;
}

boolean ignoreRequestValue = (index != formFieldsIndex);
%>

<liferay-portlet:renderURL portletConfiguration="true"  var="optionFieldURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="type" value="optionField" />
	<portlet:param name="fieldOptionsIndex" value='<%= "fieldOptionsIndex0" %>' />
	<portlet:param name="formItemIndex" value='<%= String.valueOf(index) %>' />
	<portlet:param name="ignoreRequestValue" value='<%= String.valueOf(ignoreRequestValue) %>' />
</liferay-portlet:renderURL> 

<liferay-ui:error key='<%= "fieldSizeInvalid" + formFieldsIndex %>' message="please-enter-no-more-than-75-characters" />

<div class="field-row form-items-row">
	<div class="field-title">
		<c:choose>
			<c:when test='<%= fieldType.equals("paragraph") %>'>
				<span class="field-label"><liferay-ui:message key="paragraph" /></span>
			</c:when>
			<c:when test="<%= Validator.isNotNull(fieldLabel) %>">
			<aui:field-wrapper cssClass="field-label" label="<%= fieldLabel %>" helpMessage='Drag to arrange item'>
			</aui:field-wrapper>
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

			<aui:field-wrapper cssClass="label-name left-row" label="name">
				<liferay-ui:input-localized ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "fieldLabel" + index %>' xml="<%= fieldLabelXml %>"/>
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
			<aui:field-wrapper cssClass="left-row">
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
			</aui:field-wrapper>
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
				<aui:field-wrapper cssClass='<%= "left-row input-hint-message" + ((Validator.isNull(fieldType) || (!fieldType.equals("TEXT_FIELD"))) ? " hide" : StringPool.BLANK) %>' label="Hint Message" helpMessage='Set Field Hint Message / Placeholder'>
					<liferay-ui:input-localized ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "fieldHintMessage" + index %>' xml="<%= fieldHintMessageXml %>" />
				</aui:field-wrapper>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test="<%= !fieldsEditingDisabled %>">
				<aui:field-wrapper cssClass='<%= "left-row input-default-value" + ((Validator.isNull(fieldType) || (!fieldType.equals("TEXT_FIELD"))) ? " hide" : StringPool.BLANK) %>' label="Default Value" helpMessage='Set Field Default Value'>
					<liferay-ui:input-localized ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "fieldDefaultValue" + index %>' xml="<%= fieldDefaultValueXml %>" />
				</aui:field-wrapper>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test="<%= !fieldsEditingDisabled %>">
			<aui:field-wrapper cssClass='<%= "optionalChk left-row-clear-right" + ((Validator.isNull(fieldType) || (fieldType.equals("SECTION"))) ? " hide" : StringPool.BLANK) %>'>
				<aui:input cssClass='optional-control' ignoreRequestValue="<%= ignoreRequestValue %>" label="optional" name='<%= "fieldOptional" + index %>' type="checkbox" value="<%= fieldOptional %>" />
			</aui:field-wrapper>
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
		<aui:input cssClass="fieldOptionsIndex" name='<%= "fieldOptionsIndex" + index %>' type="hidden" value='<%=fieldOptionsIndex%>'/>
		<div class="options-field">
			<aui:input name='<%= "formItemOptionId0_" + index %>' type="hidden" value='<%=formItemOptionId%>'/>
			<aui:field-wrapper cssClass='<%= "left-row-clear-left options" + ((Validator.isNull(fieldType) || (!fieldType.equals("OPTIONS") && !fieldType.equals("RADIO_BUTTON") && !fieldType.equals("CHECKBOX"))) ? " hide" : StringPool.BLANK) %>'>
				<aui:input name='<%= "fieldOptionsValue0_" + index %>' type="text" ignoreRequestValue="<%= ignoreRequestValue %>" label="Options Value" value="<%= formItemOptionValue %>"></aui:input>
			</aui:field-wrapper>
			<aui:field-wrapper cssClass='<%= "left-row options" + ((Validator.isNull(fieldType) || (!fieldType.equals("OPTIONS") && !fieldType.equals("RADIO_BUTTON") && !fieldType.equals("CHECKBOX"))) ? " hide" : StringPool.BLANK) %>' label="Options Label">
				<liferay-ui:input-localized ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "fieldOptionsLabel0_" + index %>' xml="<%= formItemOptionLabelMap %>" />
			</aui:field-wrapper>
			<aui:field-wrapper cssClass='<%= "left-row-clear-right options" + ((Validator.isNull(fieldType) || (!fieldType.equals("OPTIONS") && !fieldType.equals("RADIO_BUTTON") && !fieldType.equals("CHECKBOX"))) ? " hide" : StringPool.BLANK) %>' helpMessage="" label="Action">
				<button type="button" id='<%= "btn-add-option" + index %>' class="btn-add-option btn btn-primary btn-content btn btn-icon-only " title="Add option"><span class="btn-icon icon icon-plus"></span></button>
<!-- 				<button type="button" class="btn-remove-option btn btn-primary btn-content btn btn-icon-only " title="Remove option"><span class="btn-icon icon icon-minus"></span></button> -->
			</aui:field-wrapper>
			
			<%
				
				request.setAttribute("formItemOptions", formItemOptions);

				for (int optionIndex = 1; optionIndex < fieldOptionsIndex; optionIndex++) {
					request.setAttribute("fieldOptionsIndex", String.valueOf(optionIndex));
					request.setAttribute("formItemIndex", String.valueOf(index));
				%>
				
				<liferay-util:include page="/jsp/option_field.jsp" servletContext="<%= application %>" />

				<%
				}
			%>
		</div>
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
			<aui:field-wrapper cssClass='<%= "text-field-input-type" + ((Validator.isNull(fieldType) || (!fieldType.equals("TEXT_FIELD"))) ? " hide" : StringPool.BLANK) %>' >
				<aui:field-wrapper cssClass="left-row-clear-left">
					<aui:select cssClass="text-field-input-type" ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "fieldInputType" + index %>' helpMessage='Set Text Field Input Type' label="Input Type">
						<aui:option selected='<%= fieldTextFieldInputType.equals("NONE") %>' value="NONE"><liferay-ui:message key="any" /></aui:option>
						<aui:option selected='<%= fieldTextFieldInputType.equals("ALPHANUM") %>' value="ALPHANUM"><liferay-ui:message key="com.rcs.rcswebform.validation.alphanumeric" /></aui:option>
						<aui:option selected='<%= fieldTextFieldInputType.equals("ALPHA") %>' value="ALPHA"><liferay-ui:message key="com.rcs.rcswebform.validation.alphabet" /></aui:option>
						<aui:option selected='<%= fieldTextFieldInputType.equals("NUMBER") %>' value="NUMBER"><liferay-ui:message key="number" /></aui:option>
						<aui:option selected='<%= fieldTextFieldInputType.equals("PHONE_NUMBER") %>' value="PHONE_NUMBER"><liferay-ui:message key="phone-number" /></aui:option>
						<aui:option selected='<%= fieldTextFieldInputType.equals("EMAIL") %>' value="EMAIL"><liferay-ui:message key="email" /></aui:option>
						<aui:option selected='<%= fieldTextFieldInputType.equals("REGEX") %>' value="REGEX"><liferay-ui:message key="com.rcs.rcswebform.validation.regex" /></aui:option>
					</aui:select>
				</aui:field-wrapper>
				<aui:field-wrapper cssClass='<%= "field-validation-regex left-row" + (( Validator.isNull(fieldTextFieldInputType) || !fieldTextFieldInputType.equals("REGEX")) ? " hide" : StringPool.BLANK) %>' > 
					<aui:input ignoreRequestValue="<%= ignoreRequestValue %>" label="Regex Pattern" name='<%= "fieldValidationRegex" + index %>' helpMessage="Set regex pattern to validate input. Example ^[a-zA-Z0-9]*$ for alphanumeric" type="text" value="<%= fieldValidationRegex %>" ></aui:input>
				</aui:field-wrapper>
				<aui:field-wrapper cssClass='<%= "input-max-length left-row-clear-right" + (( Validator.isNull(fieldTextFieldInputType) || (!fieldTextFieldInputType.equals("NONE") && !fieldTextFieldInputType.equals("ALPHANUM") && !fieldTextFieldInputType.equals("ALPHA") && !fieldTextFieldInputType.equals("NUMBER"))) ? " hide" : StringPool.BLANK) %>' > 
					<aui:input ignoreRequestValue="<%= ignoreRequestValue %>" label="Max Length" name='<%= "inputMaxLength" + index %>' helpMessage="Set max number of allowed characters" type="text" value="<%= inputMaxLength %>" >
						<aui:validator name="number"></aui:validator>
					</aui:input>
				</aui:field-wrapper>
			</aui:field-wrapper>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test="<%= !fieldsEditingDisabled %>">
			<aui:field-wrapper cssClass='<%= "left-row-clear-left form-layout"+ ((fieldType.equals("SECTION")) ? " hide" : StringPool.BLANK) %>'>
				<aui:select cssClass='form-layout' name='<%= "formLayout" + index %>' label="Form Layout">
					<aui:option selected='<%= formLayout.equals("TWO_COLUMN") %>' value="TWO_COLUMN"><liferay-ui:message key="com.rcs.rcswebform.layout.twoColumn" /></aui:option>
					<aui:option selected='<%= formLayout.equals("ONE_COLUMN") %>' value="ONE_COLUMN"><liferay-ui:message key="com.rcs.rcswebform.layout.oneColumn" /></aui:option>
				</aui:select>
			</aui:field-wrapper>
		</c:when>
	</c:choose>
					
	
	
	<!-- Advance settings toggle  -->
	<c:choose>
		<c:when test="<%= !fieldsEditingDisabled %>">
			<aui:field-wrapper cssClass="left-row-clear-left">
				<liferay-ui:toggle id='<%= "advanceSettings" + index %>' showMessage="Show Advanced Settings" hideMessage="Hide Advanced Settings" 
 				 	defaultShowContent="true" stateVar='<%= "advanceSettings" + index %>'></liferay-ui:toggle> 
				<div id='<%= "advanceSettings" + index %>' style="display: <liferay-ui:toggle-value id='<%= "advanceSettings" + index %>' />; padding-top: 10px;">
					<aui:field-wrapper cssClass="left-row-clear-left form-item-css-class">
						<aui:input name='<%= "formItemCssClass" + index %>' type="text" ignoreRequestValue="<%= ignoreRequestValue %>" label="Form Item CSS Class" value="<%= formItemCssClass %>"></aui:input>
					</aui:field-wrapper>
					<aui:field-wrapper cssClass="left-row form-label-css-class">
						<aui:input name='<%= "formLabelCssClass" + index %>' type="text" ignoreRequestValue="<%= ignoreRequestValue %>" label="Label CSS Class" value="<%= labelCssClass %>"></aui:input>
					</aui:field-wrapper>
					<aui:field-wrapper cssClass="left-row-clear-right form-input-css-class">
						<aui:input name='<%= "formInputCssClass" + index %>' type="text" ignoreRequestValue="<%= ignoreRequestValue %>" label="Input CSS Class" value="<%= inputCssClass %>"></aui:input>
					</aui:field-wrapper>
					<br/>
					<aui:field-wrapper cssClass='<%= "mandatory-error-message left-row"+ ( (fieldOptional) || (fieldType.equals("SECTION")) ? " hide" : StringPool.BLANK) %>' label="Mandatory field error message">
						<liferay-ui:input-localized ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "mandatoryErrorMessage" + index %>' xml="<%= mandatoryErrorMessageXml %>" />
					</aui:field-wrapper>
					<aui:field-wrapper cssClass='<%= "validation-error-message left-row"+ (!(fieldType.equals("TEXT_FIELD") && !fieldTextFieldInputType.equals("NONE")) ? " hide" : StringPool.BLANK) %>'  label="Validation error message">
						<liferay-ui:input-localized ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "validationErrorMessage" + index %>' xml="<%= validationErrorMessageXml %>" />
					</aui:field-wrapper>
					<aui:field-wrapper cssClass='<%= "max-length-error-message left-row" + (inputMaxLength == 0 ? " hide" : StringPool.BLANK) %>' label="More than max length error message">
						<liferay-ui:input-localized ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "maxLengthErrorMessage" + index %>' xml="<%= maxLengthErrorMessageXml %>" />
					</aui:field-wrapper>
					<br/>
					<aui:field-wrapper cssClass='<%= "date-format left-row"+ ( (!fieldType.equals("DATE")) ? " hide" : StringPool.BLANK) %>' >
						<aui:input  name='<%= "dateFormat" + index %>' label="Date Format" ignoreRequestValue="<%= ignoreRequestValue %>" value="<%= dateFormat %>" helpMessage="Set date format for this input." />
					</aui:field-wrapper>
			</div>
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

<aui:script use="aui-base,liferay-auto-fields, aui-node,liferay-portlet-url,aui-io-request,aui-tooltip" >
var index = '<%= index %>';
if(A.one('#advanceSettings' + index).getStyle('display')==='block') {
	<%= "advanceSettings" + index + "Toggle"%>();
}

A.one('<%= "#btn-add-option" + index %>').on('click', function(event){
	var responseText='';
	var fieldOptionsIndex = Number(A.one('#<portlet:namespace />fieldOptionsIndex' + index).val());
		
	var optionFieldURL = '<%= optionFieldURL %>';
	var targetString = "fieldOptionsIndex0";
	var replacedString = "fieldOptionsIndex" + fieldOptionsIndex;

	optionFieldURL = optionFieldURL.replace(targetString, replacedString);
	
	 A.io.request(optionFieldURL, {
  		on: {
   			success: function() {
    	 		responseText=this.get('responseData');
    	 		A.Node.create(responseText).appendTo(event.currentTarget.ancestorsByClassName("options-field").getDOM()[0]);
				var node = document.createElement("div");
				node.innerHTML = responseText;
				var scripts = node.getElementsByTagName("script");
				webFormCustomFunction.evalScript(scripts);
    	 		A.all('.btn-remove-option').on('click', function(event){
    	 			event.currentTarget.ancestorsByClassName('added-option-field').remove();
    	 		});
    	 		fieldOptionsIndex++; 
    	 		A.one('#<portlet:namespace />fieldOptionsIndex' + index).set('value',fieldOptionsIndex);

   			}
  		}
	}); 
});

A.all('.btn-remove-option').on('click', function(event){
	event.currentTarget.ancestorsByClassName('added-option-field').remove();
});

var fieldType = A.one('#<portlet:namespace />fieldType'+index);
var formLayout = A.one('#<portlet:namespace />formLayout'+index);
if(fieldType && formLayout) {
	var formItemClass = A.one('#<portlet:namespace />formItemCssClass<%= index %>');
	var labelClass = A.one('#<portlet:namespace />formLabelCssClass<%= index %>');
	var inputClass = A.one('#<portlet:namespace />formInputCssClass<%= index %>');

	if(fieldType.val()==='SECTION') {
		inputClass.get('parentNode').hide();
	}
	
	fieldType.on('change', function(event) {
		if(event.currentTarget.val()==='SECTION') {
			if(formItemClass && labelClass && inputClass) {
				formItemClass.set('value','<%= sectionCssClass %>');
				labelClass.set('value','<%= sectionLabelCssClass %>');
				inputClass.get('parentNode').hide();
				formLayout.ancestorsByClassName('control-group').hide();
			}
		} else {
			if(formItemClass && labelClass && inputClass) {
				formItemClass.set('value','<%= formItemCssClass %>');
				labelClass.set('value','<%= labelCssClass %>');
				inputClass.get('parentNode').show();
				formLayout.ancestorsByClassName('control-group').show();
			}
		}
	});
	
	formLayout.on('change', function(event) {
		formLayoutChanged(event.currentTarget.val(), labelClass, inputClass);
	});

}

var optionalCheckbox = A.one('#<portlet:namespace />fieldOptional' + index + 'Checkbox');
optionalCheckbox.on('click', function(event) {
	var optionalInput = A.one('#<portlet:namespace />fieldOptional' + index);
	var select = this;

	var formRow = select.ancestor('.lfr-form-row');
	var optionalCheckbox = A.one('#<portlet:namespace />fieldOptional' + index + 'Checkbox');

	var value = optionalInput.val();

	var fieldType = formRow.one('select.field-type').val().split(":")[0];
	var mandatoryErrorMessageDiv = formRow.one('.mandatory-error-message');
	mandatoryChanged(fieldType, value, mandatoryErrorMessageDiv);
});

var fieldOptionValue = A.one('input#<portlet:namespace />fieldOptionsValue0_' + index + '.field');
var fieldOptionLabel = A.one('input#<portlet:namespace />fieldOptionsLabel0__' + index + '.language-value');
var fieldOptionLabelDefaultLocale = A.one('input#<portlet:namespace /><%= "fieldOptionsLabel0__" + index + "_" + defaultLocale%>.field');

fieldOptionValue.on('change', function (event) {
	autoFillOptionKeyValue(fieldOptionValue, fieldOptionLabel, fieldOptionLabelDefaultLocale);
});

fieldOptionLabel.on('change', function (event) {
	autoFillOptionKeyValue(fieldOptionValue, fieldOptionLabel, fieldOptionLabelDefaultLocale);
});

var maxLengthInput = A.one('input#<portlet:namespace />inputMaxLength' + index + '.field');
maxLengthInput.on('change', function(event) {
	var select = this;

	var formRow = select.ancestor('.lfr-form-row');
	var value = select.val();

	var fieldType = formRow.one('select.field-type').val().split(":")[0];
	var maxLengthErrorMessageDiv = formRow.one('.max-length-error-message');
	maxLengthChanged(fieldType, value, maxLengthErrorMessageDiv);
});

</aui:script>