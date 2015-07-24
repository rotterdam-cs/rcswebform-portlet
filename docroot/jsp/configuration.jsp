<%@ include file="/jsp/init.jsp" %>

<aui:form action="#" method="POST" name="fmConfig">
	<aui:input name="formId" type="hidden" value="0"/>
	
	<liferay-ui:panel-container extended="true" id="webFormConfiguration">
		<liferay-ui:panel collapsible="true" extended="true" id="webFormGeneral" title="Form Information">
			<aui:fieldset>
				<aui:field-wrapper label="Title">
					<liferay-ui:input-localized name="title" xml=""></liferay-ui:input-localized>
				</aui:field-wrapper>
				
				<aui:field-wrapper label="Description">
					<liferay-ui:input-localized name="description" xml="" type="editor"></liferay-ui:input-localized>
				</aui:field-wrapper>
			</aui:fieldset>
		</liferay-ui:panel>
		
		<liferay-ui:panel collapsible="true" extended="true" id="webFormData" title="Submitted Data to be Stored">
			<aui:fieldset label="Email">
				<liferay-ui:error key="emailAddressInvalid" message="please-enter-a-valid-email-address" />
				<liferay-ui:error key="emailAddressRequired" message="please-enter-an-email-address" />
				<liferay-ui:error key="fileNameInvalid" message="please-enter-a-valid-path-and-file-name" />
				<liferay-ui:error key="handlingRequired" message="please-select-an-action-for-the-handling-of-form-data" />
				<liferay-ui:error key="subjectRequired" message="please-enter-a-subject" />
				
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
		
		<liferay-ui:panel collapsible="true" extended="true" id="webFormFields" title="Form Fields">
			<aui:fieldset>
				Form fields to be put here
			</aui:fieldset>
		</liferay-ui:panel>
		
	</liferay-ui:panel-container>
	
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
	
</aui:form>