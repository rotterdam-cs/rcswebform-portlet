<%@ include file="/jsp/init.jsp" %>

<%
//Get values from the database
FormToPorletMap formToPortletMap = WebFormUtil.getFormToPortletMap(portletResource);
Form thisForm = WebFormUtil.getPortletForm(portletResource);
Long formToPortletId = GetterUtil.getLong(formToPortletMap.getFormToPorletMapId(), 0);
Long formId = GetterUtil.getLong(thisForm.getFormId(), 0);
String titleXml = GetterUtil.getString(thisForm.getTitle(), StringPool.BLANK);
String descriptionXml = GetterUtil.getString(thisForm.getDesc(), StringPool.BLANK);
boolean requireCaptcha = GetterUtil.getBoolean(""+ thisForm.getUseCaptcha() +"",false);
String submitSuccessMessage = GetterUtil.getString(thisForm.getSuccessMessage(), StringPool.BLANK);
boolean submitSuccessMessageRadio = !submitSuccessMessage.equals(StringPool.BLANK);
String successURL = GetterUtil.getString(thisForm.getSuccessURL(), StringPool.BLANK);
boolean successURLRadio = !successURL.equals(StringPool.BLANK);
String submitButtonLabel = GetterUtil.getString(thisForm.getSubmitLabel(), StringPool.BLANK);

//Get values from portlet preferences
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
				</aui:field-wrapper>
				
				<aui:field-wrapper label="Submit Button Label">
					<liferay-ui:input-localized name="submitBtnLabel" xml="<%= submitButtonLabel %>"></liferay-ui:input-localized>
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
				<c:if test="<%= fieldsEditingDisabled %>">
					<div class="alert">
						<liferay-ui:message key="there-is-existing-form-data-please-export-and-delete-it-before-making-changes-to-the-fields" />
					</div>

					<c:if test="<%= layoutTypePortlet.hasPortletId(portletResource) %>">
						<liferay-portlet:resourceURL portletName="<%= portletResource %>" var="exportURL">
							<portlet:param name="<%= Constants.CMD %>" value="export" />
						</liferay-portlet:resourceURL>

						<%
						String taglibExport = "submitForm(document.hrefFm, '" + exportURL + "', false);";
						%>

						<aui:button onClick="<%= taglibExport %>" value="export-data" />

						<liferay-portlet:actionURL portletName="<%= portletResource %>" var="deleteURL">
							<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="deleteData" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
						</liferay-portlet:actionURL>

						<%
						String taglibDelete = "submitForm(document." + renderResponse.getNamespace() + "fm, '" + deleteURL + "');";
						%>

						<aui:button onClick="<%= taglibDelete %>" value="delete-data" />
					</c:if>

					<br /><br />
				</c:if>

				<aui:input name="updateFields" type="hidden" value="<%= !fieldsEditingDisabled %>" />

				<%
				String formFieldsIndexesParam = ParamUtil.getString(renderRequest, "formFieldsIndexes") ;

				int[] formFieldsIndexes = null;

				if (Validator.isNotNull(formFieldsIndexesParam)) {
					formFieldsIndexes = StringUtil.split(formFieldsIndexesParam, 0);
				}
				else {
					formFieldsIndexes = new int[0];

					for (int i = 1; true; i++) {
						String fieldLabel = PrefsParamUtil.getString(portletPreferences, request, "fieldLabel" + i);

						if (Validator.isNull(fieldLabel)) {
							break;
						}

						formFieldsIndexes = ArrayUtil.append(formFieldsIndexes, i);
					}

					if (formFieldsIndexes.length == 0) {
						formFieldsIndexes = ArrayUtil.append(formFieldsIndexes, -1);
					}
				}

				int index = 1;

				for (int formFieldsIndex : formFieldsIndexes) {
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
			var value = select.val();

			var optionsDiv = formRow.one('.options');

			if ((value == 'options') || (value == 'radio')) {
				optionsDiv.all('label').show();
				optionsDiv.show();
			}
			else if (value == 'paragraph') {

				// Show just the text field and not the labels since there
				// are multiple choice inputs

				optionsDiv.all('label').hide();
				optionsDiv.show();
			}
			else {
				optionsDiv.hide();
			}

			var optionalControl = formRow.one('.optional-control').ancestor();
			var labelName = formRow.one('.label-name');

			if (value == 'paragraph') {
				var inputName = labelName.one('input.field');

				var formFieldsIndex = select.attr('id').match(/\d+$/);

				inputName.val('<liferay-ui:message key="paragraph" />' + formFieldsIndex);
				inputName.fire('change');

				labelName.hide();
				optionalControl.hide();

				optionalControl.all('input[type="checkbox"]').attr('checked', 'true');
				optionalControl.all('input[type="hidden"]').attr('value', 'true');
			}
			else {
				optionalControl.show();
				labelName.show();
			}
		};

		var webFields = A.one('.webFields');

		webFields.all('select').each(toggleOptions);

		webFields.delegate(['change', 'click', 'keydown'], toggleOptions, 'select');

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

		new Liferay.AutoFields(
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
			}
		).render();
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