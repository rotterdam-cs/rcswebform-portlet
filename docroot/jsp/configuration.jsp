<%@ include file="/jsp/init.jsp" %>

<%
String titleXml = GetterUtil.getString(LocalizationUtil.getLocalizationXmlFromPreferences(portletPreferences, renderRequest, "title"), StringPool.BLANK);
String descriptionXml = GetterUtil.getString(LocalizationUtil.getLocalizationXmlFromPreferences(portletPreferences, renderRequest, "description"), StringPool.BLANK);
boolean sendAsEmail = GetterUtil.getBoolean(portletPreferences.getValue("sendAsEmail", StringPool.BLANK));
String emailFromName = portletPreferences.getValue("emailFromName", StringPool.BLANK);
String emailFromAddress = portletPreferences.getValue("emailFromAddress", StringPool.BLANK);
String emailAddress = portletPreferences.getValue("emailAddress", StringPool.BLANK);
String subject = portletPreferences.getValue("subject", StringPool.BLANK);
boolean saveToDatabase = GetterUtil.getBoolean(portletPreferences.getValue("saveToDatabase", StringPool.BLANK));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="true" var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="POST" name="fmConfig">
	<aui:input name="formId" type="hidden" value="0"/>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<input type="hidden" name="<portlet:namespace/>portletNamespace" value="<portlet:namespace/>"/>
	
	<liferay-ui:panel-container extended="true" id="webFormConfiguration">
		<liferay-ui:panel collapsible="true" extended="true" id="webFormGeneral" persistState="true" title="Form Information">
			<aui:fieldset>
				<aui:field-wrapper label="Title">
					<liferay-ui:input-localized name="title" xml="<%= titleXml %>"></liferay-ui:input-localized>
				</aui:field-wrapper>
				
				<aui:field-wrapper label="Description">
					<liferay-ui:input-localized name="description" xml="<%= descriptionXml %>" type="editor"></liferay-ui:input-localized>
				</aui:field-wrapper>
				
				<aui:field-wrapper label="On Valid Submitted Data">
					<aui:input name="onSubmitData" type="radio" id="submitSuccessRadio" label="Show Success Message"></aui:input>
					Success message: <liferay-ui:input-localized name="submitSuccessMsg" xml=""></liferay-ui:input-localized>
					<aui:input name="onSubmitData" type="radio" id="submitURLRadio" label="Redirect URL on success"></aui:input>
					URL redirect: <aui:input name="submitSuccessURL" type="text" label=""></aui:input>
				</aui:field-wrapper>
				
				<aui:field-wrapper label="Submit Button Label">
					<liferay-ui:input-localized name="submitBtnLabel" xml=""></liferay-ui:input-localized>
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
			<aui:fieldset>
				Form fields to be put here
			</aui:fieldset>
		</liferay-ui:panel>
		
	</liferay-ui:panel-container>
	
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
	
</aui:form>