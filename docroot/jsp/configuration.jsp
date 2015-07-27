<%@ include file="/jsp/init.jsp" %>

<%
String titleXml = GetterUtil.getString(LocalizationUtil.getLocalizationXmlFromPreferences(portletPreferences, renderRequest, "title"), StringPool.BLANK);
String descriptionXml = GetterUtil.getString(LocalizationUtil.getLocalizationXmlFromPreferences(portletPreferences, renderRequest, "description"), StringPool.BLANK);
boolean requireCaptcha = GetterUtil.getBoolean(portletPreferences.getValue("requireCaptcha", StringPool.BLANK));
String successURL = portletPreferences.getValue("successURL", StringPool.BLANK);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="true" var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="POST" name="fmConfig">
	<aui:input name="formId" type="hidden" value="0"/>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	
	<liferay-ui:panel-container extended="true" id="webFormConfiguration">
		<liferay-ui:panel collapsible="true" extended="true" id="webFormGeneral" persistState="true" title="Form Information">
			<aui:fieldset>
				<aui:field-wrapper label="Title">
					<liferay-ui:input-localized name="title" xml="<%= titleXml %>"></liferay-ui:input-localized>
				</aui:field-wrapper>
				
				<aui:field-wrapper label="Description">
					<liferay-ui:input-localized name="description" xml="<%= descriptionXml %>" type="editor"></liferay-ui:input-localized>
				</aui:field-wrapper>
				
				<aui:input name="preferences--requireCaptcha--" type="checkbox" value="<%= requireCaptcha %>" />

				<aui:input label="redirect-url-on-success" name="preferences--successURL--" value="<%= HtmlUtil.toInputSafe(successURL) %>" wrapperCssClass="lfr-input-text-container" />
				
			</aui:fieldset>
		</liferay-ui:panel>
		
		<liferay-ui:panel collapsible="true" extended="true" id="webFormData" persistState="true" title="Submitted Data to be Stored">
			<aui:fieldset label="Email">
				<liferay-ui:error key="emailAddressInvalid" message="Please enter a valid email address" />
				<liferay-ui:error key="emailAddressRequired" message="Please enter an email address" />
				<liferay-ui:error key="fileNameInvalid" message="Please enter a valid path and file name" />
				<liferay-ui:error key="handlingRequired" message="Please select an action for the handling of form data" />
				<liferay-ui:error key="subjectRequired" message="Please enter a subject" />
				
				<aui:input name="sendAsEmail" label="Send data as email" type="checkbox" value="false"></aui:input>
				
				<aui:fieldset>
					<aui:input name="emailFromName" label="Name From"></aui:input>
					<aui:input name="emailFromAddress" label="Address From"></aui:input>
				</aui:fieldset>
				
				<aui:input name="emailToAddress" label="Adresses To" helpMessage="Add email addresses separated by commas"></aui:input>
				
				<aui:input name="emailSubject" label="Subject"></aui:input>
			</aui:fieldset>
			
			<aui:fieldset label="Database">
				<aui:input name="saveToDatabase" label="Save data to database" type="checkbox" value="false"></aui:input>
			</aui:fieldset>
		</liferay-ui:panel>
		
		<liferay-ui:panel collapsible="true" extended="true" id="webFormFields" persistState="true" title="Form Fields">
			<aui:fieldset>
				Form fields to be put here
			</aui:fieldset>
		</liferay-ui:panel>
		
	</liferay-ui:panel-container>
	
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
	
</aui:form>