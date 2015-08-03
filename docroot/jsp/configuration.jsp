<%@page import="com.rcs.webform.model.FormItem"%>
<%@page import="java.util.List"%>
<%@ include file="/jsp/init.jsp" %>

<%
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
String submitButtonLabel = "";
String formCssId = "";
String formCssClass = "";
String submitBtnCssId = "";
String submitBtnCssClass = "";

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
	formCssId = GetterUtil.getString(thisForm.getFormAttrId(), StringPool.BLANK);
	formCssClass = GetterUtil.getString(thisForm.getFormAttrClass(), StringPool.BLANK);
	submitBtnCssId = GetterUtil.getString(thisForm.getSubmitAttrId(), StringPool.BLANK);
	submitBtnCssClass = GetterUtil.getString(thisForm.getSubmitAttrClass(), StringPool.BLANK);
} catch(Exception ignored){
}

//Get values from portlet preferences
int onSubmitValue = GetterUtil.getInteger(portletPreferences.getValue("onSubmitValue", "1"));
boolean sendAsEmail = GetterUtil.getBoolean(portletPreferences.getValue("sendAsEmail", StringPool.BLANK));
String emailFromName = portletPreferences.getValue("emailFromName", StringPool.BLANK);
String emailFromAddress = portletPreferences.getValue("emailFromAddress", StringPool.BLANK);
String emailAddress = portletPreferences.getValue("emailAddress", StringPool.BLANK);
String subject = portletPreferences.getValue("subject", StringPool.BLANK);
boolean saveToDatabase = GetterUtil.getBoolean(portletPreferences.getValue("saveToDatabase", StringPool.BLANK));

boolean fieldsEditingDisabled = false;
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="true" var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="POST" name="fmConfig">
	<aui:input name="formId" type="hidden" value="<%= formId %>"/>
	<aui:input name="formToPortletMapId" type="hidden" value="<%= formToPortletId %>"/>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />

	<liferay-ui:error exception="<%= DuplicateColumnNameException.class %>" message="please-enter-unique-field-names" />
	
	<liferay-ui:panel-container extended="true" id="webFormConfiguration">
		<liferay-ui:panel collapsible="true" extended="true" id="webFormGeneral" persistState="true" title="Form Information">
			<aui:fieldset>
				<aui:field-wrapper label="Title">
					<liferay-ui:input-localized name="title" xml="<%= titleXml %>"></liferay-ui:input-localized>
				</aui:field-wrapper>
				
				<aui:field-wrapper label="Description">
					<liferay-ui:input-localized name="description" xml="<%= descriptionXml %>" type="editor"></liferay-ui:input-localized>
				</aui:field-wrapper>
				
				<aui:field-wrapper>
					<aui:input name="requireCaptcha" type="checkbox" label="Require Captcha" value="<%= requireCaptcha %>"></aui:input>
				</aui:field-wrapper>
				
				<aui:field-wrapper label="On Valid Submitted Data">
					<aui:input name="onSubmitData" type="radio" id="submitSuccessRadio" label="Show Success Message" value="1" checked="<%= submitSuccessMessageRadio %>" ></aui:input>
					Success message: <liferay-ui:input-localized name="submitSuccessMsg" xml="<%= submitSuccessMessage %>"></liferay-ui:input-localized>
					<aui:input name="onSubmitData" type="radio" id="submitURLRadio" label="Redirect URL on success" value="2" checked="<%= successURLRadio %>"></aui:input>
					URL redirect: <aui:input name="submitSuccessURL" type="text" label="" value="<%= successURL %>"></aui:input>
					<aui:input name="preferences--onSubmit--" type="hidden" id="onSubmitHiddenValue" value="<%= onSubmitValue %>"></aui:input>
				</aui:field-wrapper>
				
				<aui:field-wrapper label="Submit Button Label">
					<liferay-ui:input-localized name="submitBtnLabel" xml="<%= submitButtonLabel %>"></liferay-ui:input-localized>
				</aui:field-wrapper>
				
				<aui:field-wrapper label="Form CSS Styling">
					<aui:input name="formCssId" type="text" label="Form Id" value="<%= formCssId %>"></aui:input>
					<aui:input name="formCssClass" type="text" label="Form Class" value="<%= formCssClass %>"></aui:input>
					<aui:input name="submitCssId" type="text" label="Submit Button Id" value="<%= submitBtnCssId %>"></aui:input>
					<aui:input name="submitCssClass" type="text" label="Submit Button Class" value="<%= submitBtnCssClass %>"></aui:input>
				</aui:field-wrapper>
				
			</aui:fieldset>
		</liferay-ui:panel>
		
		<liferay-ui:panel collapsible="true" extended="true" id="webFormData" persistState="true" title="Submitted Data to be Stored">
			<aui:fieldset label="Email">
				<liferay-ui:error key="emailAddressInvalid" message="Please enter a valid email address" />
				<liferay-ui:error key="emailAddressRequired" message="Please enter an email address" />
				<liferay-ui:error key="fileNameInvalid" message="Please enter a valid path and file name" />
				<liferay-ui:error key="handlingRequired" message="Please select an action for the handling of form data" />
				<liferay-ui:error key="subjectRequired" message="Please enter a subject" />
				
				<aui:input name="preferences--sendAsEmail--" cssClass="sendAsEmailChkBox" label="Send data as email" type="checkbox" value="<%= sendAsEmail %>"></aui:input>
				
				<aui:fieldset>
					<aui:input name="preferences--emailFromName--" label="Name From" value="<%= emailFromName %>"></aui:input>
					<aui:input name="preferences--emailFromAddress--" label="Address From" value="<%= emailFromAddress %>"></aui:input>
				</aui:fieldset>
				
				<aui:input name="preferences--emailAddress--" label="Adresses To" helpMessage="Add email addresses separated by commas" value="<%= emailAddress %>"></aui:input>
				
				<aui:input name="preferences--subject--" label="Subject" value="<%= subject %>"></aui:input>
			</aui:fieldset>
			
			<aui:fieldset label="Database">
				<aui:input name="preferences--saveToDatabase--" label="Save data to database" type="checkbox" value="<%= saveToDatabase %>"></aui:input>
			</aui:fieldset>
		</liferay-ui:panel>
		
		<liferay-ui:panel collapsible="true" extended="true" id="webFormFields" persistState="true" title="Form Fields">
			<aui:fieldset cssClass="rows-container webFields">

				<aui:input name="updateFields" type="hidden" value="<%= !fieldsEditingDisabled %>" />
				<aui:input id="deletedFormItemIds" name="deletedFormItemIds" type="hidden" value="" />

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
		</liferay-ui:panel>
		
	</liferay-ui:panel-container>
	
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
	
</aui:form>

<c:if test="<%= !fieldsEditingDisabled %>">
	<aui:script use="aui-base,liferay-auto-fields">
		var toggleOptions = function(event) {
			var select = this;

			var formRow = select.ancestor('.lfr-form-row');
			var value = select.val().split(":")[0];

			var optionsDiv = formRow.one('.options');

			if ((value == 'OPTIONS') || (value == 'RADIO_BUTTON')) {
				optionsDiv.all('label').show();
				optionsDiv.show();
			}
			else {
				optionsDiv.hide();
			}
			
			var textFieldInputTypeDiv = formRow.one('.text-field-input-type');
	
			if (value == 'TEXT_FIELD') {
				textFieldInputTypeDiv.all('label').show();
				textFieldInputTypeDiv.show();
			}
			else {
				textFieldInputTypeDiv.hide();
			}

			var optionalControl = formRow.one('.optional-control').ancestor();
			var labelName = formRow.one('.label-name');
			optionalControl.show();
			labelName.show();
			
		};
		
		var inputTypeToggleOptions = function(event) {
			var select = this;

			var formRow = select.ancestor('.lfr-form-row');
			var value = select.val().split(":")[0];
			
			var inputMaxLengthDiv = formRow.one('.input-max-length');
	
			if ((value == 'ALPHA') || (value == 'NUMBER')) {
				inputMaxLengthDiv.all('label').show();
				inputMaxLengthDiv.show();
			}
			else {
				inputMaxLengthDiv.hide();
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

				<liferay-portlet:renderURL portletConfiguration="true" var="editFieldURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
					<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
				</liferay-portlet:renderURL>

				url: '<%= editFieldURL %>'
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
AUI().use('aui-base',function(A){
	
	<c:if test="<%= !sendAsEmail %>">
		A.one('#<portlet:namespace />emailFromName').set('disabled',true);
		A.one('#<portlet:namespace />emailFromAddress').set('disabled',true);
		A.one('#<portlet:namespace />emailAddress').set('disabled',true);
		A.one('#<portlet:namespace />subject').set('disabled',true);
	</c:if>
	
	A.one('#<portlet:namespace />submitSuccessRadio').on('click', function(event){
		A.one('#<portlet:namespace />onSubmitHiddenValue').set('value',this.val());
	});
	
	A.one('#<portlet:namespace />submitURLRadio').on('click', function(event){
		A.one('#<portlet:namespace />onSubmitHiddenValue').set('value',this.val());
	});
	
	A.one('.sendAsEmailChkBox').on('click', function(event){
		if(this.attr('checked')){
			A.one('#<portlet:namespace />emailFromName').set('disabled',false);
			A.one('#<portlet:namespace />emailFromAddress').set('disabled',false);
			A.one('#<portlet:namespace />emailAddress').set('disabled',false);
			A.one('#<portlet:namespace />subject').set('disabled',false);
		} else {
			A.one('#<portlet:namespace />emailFromName').set('disabled',true);
			A.one('#<portlet:namespace />emailFromAddress').set('disabled',true);
			A.one('#<portlet:namespace />emailAddress').set('disabled',true);
			A.one('#<portlet:namespace />subject').set('disabled',true);
		}
	});
	
});
</aui:script>
