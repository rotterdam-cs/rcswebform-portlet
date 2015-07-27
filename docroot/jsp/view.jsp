<%@ include file="/jsp/init.jsp" %>

<%
String title = LocalizationUtil.getPreferencesValue(portletPreferences, "title", themeDisplay.getLanguageId());
String description = LocalizationUtil.getPreferencesValue(portletPreferences, "description", themeDisplay.getLanguageId());
%>

<aui:form action="#" method="POST" name="fm">
	<aui:fieldset label="<%= HtmlUtil.escape(title) %>">
		<c:if test="<%= Validator.isNotNull(description) %>">
			<div id="formDescription">
				<%= description %>
			</div>
		</c:if>
		
		<liferay-ui:success key="success" message="Form information was sent successfully" />
		<liferay-ui:error key="error" message="An error occurred while sending the form information" />
		
		<div id="rcsWebForm">
			<!-- Form will be put here -->
		</div>
		
	</aui:fieldset>
</aui:form>
