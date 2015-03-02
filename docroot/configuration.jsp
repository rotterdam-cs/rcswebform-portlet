<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="true" var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />
	
	<liferay-ui:error exception="<%= DuplicateColumnNameException.class %>" message="please-enter-unique-field-names" />
	
	<liferay-ui:panel-container extended="true" id="rcsWebformConfiguration" persistState="true">
		<liferay-ui:panel title="form-information" collapsible="true" extended="true" id="rcsWebformGeneral" persistState="true">
			<aui:fieldset>
				<aui:field-wrapper cssClass="lfr-input-text-container" label="title">
					<liferay-ui:input-localized name="title" xml="${configModel.titleXml}" />
				</aui:field-wrapper>
				
				<aui:field-wrapper cssClass="lfr-input-text-container" label="description">
					<liferay-ui:input-localized name="description" xml="${configModel.descriptionXml}" type="textarea">
					</liferay-ui:input-localized>
				</aui:field-wrapper>
				
				<aui:input name="requireCaptcha" type="checkbox" value="${configModel.requireCaptcha}" />
				<aui:input label="redirect-url-on-success" name="preferences--successURL--" value="${configModel.successURL}" wrapperCssClass="lfr-input-text-container" />
				
				<aui:field-wrapper cssClass="lfr-input-text-container" label="submit-label">
					<liferay-ui:input-localized name="submitLabel" xml="${configModel.submitLabelXml }" />
				</aui:field-wrapper>
			</aui:fieldset>
		</liferay-ui:panel>
		
		<liferay-ui:panel collapsible="true" extended="true" id="rcsWebformData" persistState="true" title="handling-of-form-data">
			<aui:fieldset cssClass="handle-data" label="email">
				<liferay-ui:error key="emailAddressInvalid" message="please-enter-a-valid-email-address" />
				<liferay-ui:error key="emailAddressRequired" message="please-enter-an-email-address" />
				<liferay-ui:error key="fileNameInvalid" message="please-enter-a-valid-path-and-file-name" />
				<liferay-ui:error key="handlingRequired" message="please-select-an-action-for-the-handling-of-form-data" />
				<liferay-ui:error key="subjectRequired" message="please-enter-a-subject" />
				
				<aui:input name="preferences--sendAsEmail--" type="checkbox" label="send-as-email" value="${configModel.sendAsEmail}" />
				
				<aui:fieldset>
					<aui:input name="preferences--emailFromName--" label="name-from" value="${configModel.emailFromName}" wrapperCssClass="lfr-input-text-container" />
					<aui:input label="address-from" name="preferences--emailFromAddress--" value="${configModel.emailFromAddress}" wrapperCssClass="lfr-input-text-container" />
				</aui:fieldset>
				
				<aui:input name="preferences--emailAddress--" label="addresses-to" helpMessage="add-email-addresses-separated-by-commas" value="${configModel.emailAddress}" />
				<aui:input name="preferences--subject--" label="email-subject" value="${configModel.subject}" wrapperCssClass="lfr-input-text-container" />
			</aui:fieldset>
			
			<aui:fieldset cssClass="handle-data" label="database">
				<aui:input name="saveToDatabase" type="checkbox" value="${configModel.saveToDatabase}" />
			</aui:fieldset>
			
			<aui:fieldset cssClass="handle-data" label="file">
				<aui:input name="saveToFile" type="checkbox" value="${configModel.saveToFile}" />
				<c:choose>
					<c:when test="${dataFilePathChangeable}">
						<aui:input label="path-and-file-name" name="preferences--fileName--" value="${configModel.fileName }" wrapperCssClass="lfr-input-text-container" />
					</c:when>
					<c:otherwise>
						<liferay-ui:message arguments="${fileName}" key="form-data-will-be-saved-to-x" />
					</c:otherwise>
				</c:choose>
				
			</aui:fieldset>
			
		</liferay-ui:panel>
		
		<liferay-ui:panel collapsible="true" extended="true" id="webFormFields" persistState="true" title="form-fields">
			<aui:fieldset cssClass="rows-container webFields">
				<c:if test="${isEditable==false}">
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
				
				<aui:input name="updateFields" type="hidden" value="${configModel.isEditable}" />
				<c:set var="index" value="1" scope="request" />
				<c:set var="formFieldsIndexes" value="${configClass.generateFormFieldsIndexes(formFieldsIndexesParam,renderRequest)}" />
				
				<c:forEach items="${formFieldsIndexes}" var="formFieldsIndex" varStatus="counter">
					<c:set var="configurationIndex" value="${index}" scope="application"/>
					<c:set var="configurationFormFieldsIndex" value="${formFieldsIndex}" scope="request" />
					<c:set var="configurationIsEditable" value="${isEditable}" scope="application" />
					
					<div class="lfr-form-row" id="<portlet:namespace />fieldset${formFieldsIndex}">
						<div class="row-fields">
							<liferay-util:include page="/fieldPage.jsp" servletContext="<%= application %>" />
						</div>
					</div>
					<c:set var="index" value="${index+1}" scope="request" />
				</c:forEach>
					
			</aui:fieldset>
		</liferay-ui:panel>
		
	</liferay-ui:panel-container>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<c:if test="${configModel.isEditable}">
	<aui:script use="aui-base,liferay-auto-fields">
		var toggleOptions = function(event) {
			var select = this;

			var formRow = select.ancestor('.lfr-form-row');
			var value = select.val();

			var optionsDiv = formRow.one('.options');
			
			var placeHolderDiv = formRow.one('.label-placeHolder');

			if ((value == 'options') || (value == 'radio')) {
				optionsDiv.all('label').show();
				optionsDiv.show();
				placeHolderDiv.hide();
			}
			else if (value == 'paragraph') {

				// Show just the text field and not the labels since there
				// are multiple choice inputs

				optionsDiv.all('label').hide();
				optionsDiv.show();
			}
			else {
				optionsDiv.hide();
				placeHolderDiv.show();
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

		<c:if test="<%= PortletPropsValues.VALIDATION_SCRIPT_ENABLED %>">
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
					<portlet:param name="configurationIsEditable" value="${isEditable}" />
					<portlet:param name="configurationIndex" value="${index}" />
				</liferay-portlet:renderURL>

				url: '<%= editFieldURL %>'
			}
		).render();
	</aui:script>
</c:if>