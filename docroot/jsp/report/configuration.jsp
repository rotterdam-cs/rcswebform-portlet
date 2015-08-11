<%@page import="java.util.List"%>
<%@ include file="/jsp/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="true" var="configurationRenderURL" />

<%
List<Form> formList = WebFormUtil.getAllForms();
long selectedFormId = GetterUtil.getLong(portletPreferences.getValue("selectedForm", "-1"));
%>

<aui:form action="<%= configurationActionURL %>" method="POST" name="reportFmConfig">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	
	<aui:fieldset>
		<aui:field-wrapper label="Select Form">
			<%
			if (formList.isEmpty()){
				out.println("List of form is empty");
			} else {
			%>
			<select name="<portlet:namespace />selectedRcsWebForm" id="<portlet:namespace />selectedRcsWebForm">
				<%
				for (Form form : formList){
				%>
					<option value="<%= form.getFormId() %>" <%if(form.getFormId()==selectedFormId){%>selected<%}%>>
						<%= form.getTitle(locale) %>
					</option>
				<%
				}
				%>
			</select>
			<%
			}
			%>
		</aui:field-wrapper>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>