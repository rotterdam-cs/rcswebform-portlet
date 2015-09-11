<%@page import="com.rcs.webform.model.FormItem"%>
<%@page import="java.util.List"%>
<%@ include file="/jsp/init.jsp" %>

<%
String tabValues = ParamUtil.getString(request, "tabsValue", "Form Information");

//Get values from the database
List<FormItem> formItems = WebFormUtil.getPortletFormItems(portletResource);
FormToPorletMap formToPortletMap = WebFormUtil.getFormToPortletMap(portletResource);
Form thisForm = WebFormUtil.getPortletForm(portletResource);
Long formToPortletId = 0L;
Long formId = 0L;
String titleXml = "";
String descriptionXml = "";
boolean requireCaptcha = false;
String submitSuccessMessage = "";
boolean submitSuccessMessageRadio = true;
String successURL = "";
boolean successURLRadio = false;
String submitButtonLabel = "Submit";
String formCssClass = "form";
String submitBtnCssClass = "btn btn-primary";

String oneColumnLabelCssClass = "rcs control-label single";
String oneColumnInputCssClass = "rcs field single";
String twoColumnLabelCssClass = "rcs control-label dual";
String twoColumnInputCssClass = "rcs field dual";

try{
	formToPortletId = GetterUtil.getLong(formToPortletMap.getFormToPorletMapId(), 0);
	formId = GetterUtil.getLong(thisForm.getFormId(), 0);
	titleXml = GetterUtil.getString(thisForm.getTitle(), StringPool.BLANK);
	descriptionXml = GetterUtil.getString(thisForm.getDesc(), StringPool.BLANK);
	requireCaptcha = GetterUtil.getBoolean(""+ thisForm.getUseCaptcha() +"",false);
	submitSuccessMessage = GetterUtil.getString(thisForm.getSuccessMessage(), StringPool.BLANK);
	submitSuccessMessageRadio = !submitSuccessMessage.equals(StringPool.BLANK);
	successURL = GetterUtil.getString(thisForm.getSuccessURL(), StringPool.BLANK);
	successURLRadio = !successURL.equals(StringPool.BLANK);
	submitButtonLabel = GetterUtil.getString(thisForm.getSubmitLabel(), StringPool.BLANK);
	formCssClass = GetterUtil.getString(thisForm.getFormAttrClass(), StringPool.BLANK);
	submitBtnCssClass = GetterUtil.getString(thisForm.getSubmitAttrClass(), StringPool.BLANK);
} catch(Exception ignored){
}

//Get values from portlet preferences
int onSubmitValue = GetterUtil.getInteger(portletPreferences.getValue("onSubmitValue", "1"));
boolean sendAsEmail = GetterUtil.getBoolean(portletPreferences.getValue("sendAsEmail", StringPool.BLANK));
String emailFromName = WebFormUtil.getEmailFromName(portletPreferences, company.getCompanyId());
String emailFromAddress = WebFormUtil.getEmailFromAddress(portletPreferences, company.getCompanyId());
String emailAddress = portletPreferences.getValue("emailAddress", StringPool.BLANK);
String subject = portletPreferences.getValue("subject", StringPool.BLANK);
boolean saveToDatabase = GetterUtil.getBoolean(portletPreferences.getValue("saveToDatabase", StringPool.TRUE));

boolean fieldsEditingDisabled = false;
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="true" var="configurationRenderURL" />

<liferay-portlet:renderURL portletConfiguration="true" var="formItemURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="type" value="formItem" />
</liferay-portlet:renderURL>

<aui:form action="<%= configurationActionURL %>" method="POST" name="fmConfig">
	<aui:input name="formId" type="hidden" value="<%= formId %>"/>
	<aui:input name="formToPortletMapId" type="hidden" value="<%= formToPortletId %>"/>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />
	<aui:input name="tabsValue" type="hidden" value="<%= tabValues %>"></aui:input>

	<liferay-ui:error exception="<%= DuplicateColumnNameException.class %>" message="please-enter-unique-field-names" />
	<liferay-ui:error key="error-storage-not-choosen" message="Please choose at least one storage for submitted data" />
	
	<liferay-ui:tabs names="Form Information,Form Submit Handling,Form Fields,Extra Settings" onClick="onClickTabs(this)" refresh="false" value="<%= tabValues %>">
		<liferay-ui:section>
			<aui:fieldset>
				<aui:field-wrapper label="Title">
					<liferay-ui:input-localized name="title" xml="<%= titleXml %>"></liferay-ui:input-localized>
				</aui:field-wrapper>
				
				<aui:field-wrapper label="Description">
					<liferay-ui:input-localized name="description" xml="<%= descriptionXml %>" type="editor"></liferay-ui:input-localized>
				</aui:field-wrapper>
				
			</aui:fieldset>
		</liferay-ui:section>
		<liferay-ui:section>
				<aui:field-wrapper label="How submitted data handled">
					<aui:input name="preferences--saveToDatabase--" label="Save data to database" type="checkbox" value="<%= saveToDatabase %>"></aui:input>
					
					<aui:input name="preferences--sendAsEmail--" cssClass="sendAsEmailChkBox" label="Send data as email" type="checkbox" value="<%= sendAsEmail %>"></aui:input>
					
					<div id='<%= "email"%>' class=' <%="email-form" + (sendAsEmail ? StringPool.BLANK : " hide") %>'>
					
						<liferay-ui:error key="emailAddressInvalid" message="Please enter a valid email address" />
						<liferay-ui:error key="emailAddressRequired" message="Please enter an email address" />
						<liferay-ui:error key="fileNameInvalid" message="Please enter a valid path and file name" />
						<liferay-ui:error key="handlingRequired" message="Please select an action for the handling of form data" />
						<liferay-ui:error key="subjectRequired" message="Please enter a subject" />
						
						<aui:fieldset>
							<aui:input name="preferences--emailFromName--" label="Name From" value="<%= emailFromName %>"></aui:input>
							<aui:input name="preferences--emailFromAddress--" label="Address From" value="<%= emailFromAddress %>"></aui:input>
						</aui:fieldset>
						
						<aui:input name="preferences--emailAddress--" label="Adresses To" helpMessage="Add email addresses separated by commas" value="<%= emailAddress %>"></aui:input>
						
						<aui:input name="preferences--subject--" label="Subject" value="<%= subject %>"></aui:input>
					</div>
				</aui:field-wrapper>
				
				<aui:field-wrapper label="What to do after data submitted">
					<aui:input name="onSubmitData" type="radio" id="submitSuccessRadio" label="Show Success Message" value="1" checked="<%= submitSuccessMessageRadio %>" ></aui:input>
					<aui:field-wrapper cssClass='<%= "rcs submit-success-msg-wrapper" + ( onSubmitValue == 1 ? StringPool.BLANK:" hide")%>' label="Success message:"> 
						<liferay-ui:input-localized name="submitSuccessMsg" cssClass='rcs.control-group' xml="<%= submitSuccessMessage %>"></liferay-ui:input-localized>
					</aui:field-wrapper>
					<aui:input name="onSubmitData" type="radio" id="submitURLRadio" label="Redirect to" value="2" checked="<%= successURLRadio %>"></aui:input>
					<aui:field-wrapper cssClass='<%= "submit-success-url-wrapper" + (onSubmitValue == 2 ? StringPool.BLANK:" hide")%>' label="URL : "> 
						<aui:input name="submitSuccessURL" type="text" label="" value="<%= successURL %>"></aui:input>
					</aui:field-wrapper>
					<aui:input name="preferences--onSubmit--" type="hidden" id="onSubmitHiddenValue" value="<%= onSubmitValue %>"></aui:input>
				</aui:field-wrapper>
				
		</liferay-ui:section>
		<liferay-ui:section>
			<aui:fieldset cssClass="rows-container webFields">

				<aui:input name="updateFields" type="hidden" value="<%= !fieldsEditingDisabled %>" />
				<aui:input id="deletedFormItemIds" name="deletedFormItemIds" type="hidden" value="" />
				<aui:input id="deletedFormItemOptionIds" name="deletedFormItemOptionIds" type="hidden" value="" />

				<%
				
				int formItemsSize = 1;
				if(formItems != null && !formItems.isEmpty()){
					formItemsSize = formItems.size();
				}

				int index = 1;
				
				request.setAttribute("formItems", formItems);

				for (int formFieldsIndex = 0; formFieldsIndex < formItemsSize; formFieldsIndex++) {
					request.setAttribute("configuration.jsp-index", String.valueOf(index));
					request.setAttribute("configuration.jsp-formFieldsIndex", String.valueOf(formFieldsIndex));
					request.setAttribute("configuration.jsp-fieldsEditingDisabled", String.valueOf(fieldsEditingDisabled));
				%>

					<div class="lfr-form-row" id="<portlet:namespace />fieldset<%= formFieldsIndex %>">
						<div class="row-fields">
							<liferay-util:include page="/jsp/edit_field.jsp" servletContext="<%= application %>" />
						</div>
					</div>

				<%
					index++;
				}
				%>

			</aui:fieldset>
		</liferay-ui:section>
		<liferay-ui:section>
			<aui:field-wrapper>
				<aui:input name="requireCaptcha" type="checkbox" label="Use Captcha" value="<%= requireCaptcha %>"></aui:input>
			</aui:field-wrapper>
			<aui:field-wrapper>
				<aui:input name="formCssClass" type="text" label="Form Class" value="<%= formCssClass %>"></aui:input>
			</aui:field-wrapper>
			<aui:field-wrapper label="Submit Button Label">
				<liferay-ui:input-localized name="submitBtnLabel" xml="<%= submitButtonLabel %>"></liferay-ui:input-localized>
			</aui:field-wrapper>
			<aui:field-wrapper>
				<aui:input name="submitCssClass" type="text" label="Submit Button Class" value="<%= submitBtnCssClass %>"></aui:input>
			</aui:field-wrapper>
		</liferay-ui:section>
		
	</liferay-ui:tabs>
	
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
	
</aui:form>

<c:if test="<%= !fieldsEditingDisabled %>">
	<aui:script use="aui-base,liferay-auto-fields, aui-node,liferay-portlet-url,aui-io-request">
		var toggleOptions = function(event) {
			var select = this;

			var formRow = select.ancestor('.lfr-form-row');
			var value = select.val();

			var optionsDiv = formRow.one('.options-field');

			if ((value == 'OPTIONS') || (value == 'RADIO_BUTTON') || (value == 'CHECKBOX')) {
				optionsDiv.all('label').show();
				optionsDiv.show();
			}
			else {
				optionsDiv.hide();
			}
			
			var optionalDiv = formRow.one('.optionalChk');
			
			if (!(value == 'SECTION')) {
				optionalDiv.all('label').show();
				optionalDiv.show();
			}
			else {
				optionalDiv.hide();
			}
			
			var textFieldInputTypeDiv = formRow.one('.text-field-input-type');
			var textFieldHintDiv = formRow.one('.input-hint-message');
			var textFieldDefaultValueDiv = formRow.one('.input-default-value');
			

			if (value == 'TEXT_FIELD') {
				textFieldInputTypeDiv.all('label').show();
				textFieldHintDiv.all('label').show();
				textFieldInputTypeDiv.show();
				textFieldHintDiv.show();
				textFieldDefaultValueDiv.show();
			}
			else {
				textFieldInputTypeDiv.hide();
				textFieldHintDiv.hide();
				textFieldDefaultValueDiv.hide();
			}
			
			var dateFormatDiv = formRow.one('.date-format');
			if (value == 'DATE') {
				dateFormatDiv.show();
			}
			else {
				dateFormatDiv.hide();
			}
			
			var optionalControl = formRow.one('.optional-control').ancestor();
			var labelName = formRow.one('.label-name');
			optionalControl.show();
			labelName.show();
			
			var optionalInput = optionalDiv.one('input').val();
			var mandatoryErrorMessageDiv = formRow.one('.mandatory-error-message');
			mandatoryChanged(value, optionalInput, mandatoryErrorMessageDiv);
			
			var maxLengthInput = formRow.one('.input-max-length').one('input').val();
			var maxLengthErrorMessageDiv = formRow.one('.max-length-error-message');
			maxLengthChanged(value, maxLengthInput, maxLengthErrorMessageDiv);

			var inputType = textFieldInputTypeDiv.one('select').val().split(":")[0];
			var validationErrorMessageDiv = formRow.one('.validation-error-message');
			validationChanged(value, inputType, validationErrorMessageDiv);
		};
		
		
		var inputTypeToggleOptions = function(event) {
			var select = this;

			var formRow = select.ancestor('.lfr-form-row');
			var value = select.val().split(":")[0];
			
			var inputMaxLengthDiv = formRow.one('.input-max-length');
	
			if ( (value == 'NONE') || (value == 'ALPHANUM') || (value == 'ALPHA') || (value == 'NUMBER') || (value == '')) {
				inputMaxLengthDiv.all('label').show();
				inputMaxLengthDiv.show();
			}
			else {
				inputMaxLengthDiv.hide();
			}
			
			var fieldType = formRow.one('select.field-type').val().split(":")[0];
			var validationErrorMessageDiv = formRow.one('.validation-error-message');
			validationChanged(fieldType, value, validationErrorMessageDiv);
			
			var validationRegexDiv = formRow.one('.field-validation-regex');
			if (value == 'REGEX') {
				 validationRegexDiv.show();
			} else {
				 validationRegexDiv.hide();
			}
			
		};

		var webFields = A.one('.webFields');

		webFields.all('select.field-type').each(toggleOptions);

		webFields.delegate(['change', 'click', 'keydown'], toggleOptions, 'select.field-type');
		
		webFields.all('select.text-field-input-type').each(inputTypeToggleOptions);

		webFields.delegate(['change', 'click', 'keydown'], inputTypeToggleOptions, 'select.text-field-input-type');

		<c:if test="false">
			var toggleValidationOptions = function(event) {
				this.next().toggle();
			};

			webFields.delegate('click', toggleValidationOptions, '.validation-link');
		</c:if>

		webFields.delegate(
			'change',
			function(event) {
				var input = event.currentTarget;
				var row = input.ancestor('.field-row');
				var label = row.one('.field-title');

				if (label) {
					label.html(input.get('value'));
				}
			},
			'.label-name input'
		);

		var autoFields = new Liferay.AutoFields(
			{
				contentBox: webFields,
				fieldIndexes: '<portlet:namespace />formFieldsIndexes',
				namespace: '<portlet:namespace />',
				sortable: true,
				sortableHandle: '.field-label',
				url: '<%= formItemURL %>'
			});
			
		// delete row event
		autoFields.on("delete", function(event) {
        	var deletedRow = event.deletedRow;
        	var rowFormItemId = deletedRow.getDOM().getElementsByClassName('formItemId')[0].value;
        	
        	var rowFormItemIds = A.one('#<portlet:namespace />deletedFormItemIds').val();
        	
        	if(rowFormItemIds != ""){
        		rowFormItemIds += "," + rowFormItemId;
        	}else{
        		rowFormItemIds += rowFormItemId;
        	}
        	
        	A.one('#<portlet:namespace />deletedFormItemIds').val(rowFormItemIds);
        });

  		autoFields.render();
	</aui:script>
</c:if>

<aui:script>
function onClickTabs(_this){
	document.getElementById("<portlet:namespace />tabsValue").value = _this.innerHTML.trim();
}

AUI().use('aui-base',function(A){
	
	<c:if test="<%= !sendAsEmail %>">
		A.one('#<portlet:namespace />emailFromName').set('disabled',true);
		A.one('#<portlet:namespace />emailFromAddress').set('disabled',true);
		A.one('#<portlet:namespace />emailAddress').set('disabled',true);
		A.one('#<portlet:namespace />subject').set('disabled',true);
	</c:if>
	
	
	var onSubmitHiddenValueNode = A.one('#<portlet:namespace />onSubmitHiddenValue');
	function onValidSubmitActionToggle() {
		var submitSuccessMsgWrapper = A.one('.submit-success-msg-wrapper');
		var submitSuccessURLWrapper = A.one('.submit-success-url-wrapper');
		if(onSubmitHiddenValueNode.val() == '1') {
			submitSuccessMsgWrapper.show();
			submitSuccessURLWrapper.hide();
		} else if (onSubmitHiddenValueNode.val() == '2') {
			submitSuccessMsgWrapper.hide();
			submitSuccessURLWrapper.show();
		}
	};

	A.one('#<portlet:namespace />submitSuccessRadio').on('click', function(event){
		onSubmitHiddenValueNode.set('value',this.val());
		onValidSubmitActionToggle();
	});
	
	A.one('#<portlet:namespace />submitURLRadio').on('click', function(event){
		onSubmitHiddenValueNode.set('value',this.val());
		onValidSubmitActionToggle();
	});
	
	A.one('.sendAsEmailChkBox').on('click', function(event){
		if(this.attr('checked')){
			A.one('.email-form').show();
			A.one('#<portlet:namespace />emailFromName').set('disabled',false);
			A.one('#<portlet:namespace />emailFromAddress').set('disabled',false);
			A.one('#<portlet:namespace />emailAddress').set('disabled',false);
			A.one('#<portlet:namespace />subject').set('disabled',false);
		} else {
			A.one('.email-form').hide();	
			A.one('#<portlet:namespace />emailFromName').set('disabled',true);
			A.one('#<portlet:namespace />emailFromAddress').set('disabled',true);
			A.one('#<portlet:namespace />emailAddress').set('disabled',true);
			A.one('#<portlet:namespace />subject').set('disabled',true);
		}
	});
	
});

var autoFillOptionKeyValue = function(fieldOptionValue, fieldOptionLabel, fieldOptionLabelDefaultLocale) {
	if( fieldOptionLabel && fieldOptionLabel && fieldOptionLabelDefaultLocale) {
		if(fieldOptionLabel.val().length === 0) {
			fieldOptionLabel.set('value', fieldOptionValue.val());
			fieldOptionLabelDefaultLocale.set('value', fieldOptionValue.val());
		}
		if(fieldOptionValue.val().length === 0) {
			fieldOptionValue.set('value', fieldOptionLabel.val());
		}
	}
};

var mandatoryChanged = function(fieldType, optional, mandatoryErrorMessageDiv) {
	if(fieldType !== 'SECTION' && optional ==='false') {
		mandatoryErrorMessageDiv.show();
	} else {
		mandatoryErrorMessageDiv.hide();
	}
}

var maxLengthChanged = function(fieldType, maxLength, maxLengthErrorMessageDiv) {
	if(fieldType === 'TEXT_FIELD' && maxLength > 0) {
		maxLengthErrorMessageDiv.show();
	} else {
		maxLengthErrorMessageDiv.hide();
	}
}

var validationChanged = function(fieldType, inputType, validationErrorMessageDiv) {
	if(fieldType === 'TEXT_FIELD' && inputType !== 'NONE') {
		validationErrorMessageDiv.show();
	} else {
		validationErrorMessageDiv.hide();
	}
}

var formLayoutChanged = function(formLayout, label, input) {
	if(label && input) {
		if(formLayout==='TWO_COLUMN') {
			input.set('value','<%= twoColumnInputCssClass %>');
			label.set('value','<%= twoColumnLabelCssClass %>');
		} else if(formLayout==='ONE_COLUMN') {
			input.set('value','<%= oneColumnInputCssClass %>');
			label.set('value','<%= oneColumnLabelCssClass %>');
		}
	}

}
</aui:script>
