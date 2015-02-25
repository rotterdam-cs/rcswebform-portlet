<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="true" var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	
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
	</liferay-ui:panel-container>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>