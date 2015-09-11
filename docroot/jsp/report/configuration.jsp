<%@page import="java.text.SimpleDateFormat"%>
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
<%-- 		<aui:field-wrapper label="Select Form"> --%>
			<%
			if (formList.isEmpty()){
				out.println("List of form is empty");
			} else {
			%>
			<aui:select name="selectedRcsWebForm" label="Select Form">
				<%
				for (Form form : formList){
				%>
						<aui:option value="<%= form.getFormId() %>"  selected="<%= form.getFormId()==selectedFormId %>">
						<%= form.getTitle(locale) %>  - created on <%= new SimpleDateFormat("YYYY-MM-dd HH:mm").format(form.getCreationDate()) %>
					</aui:option>
				<%
				}
				%>
			</aui:select>
			<%
			}
			%>
<%-- 		</aui:field-wrapper> --%>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>