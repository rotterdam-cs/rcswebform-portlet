<%@ include file="/init.jsp" %>
Testing Page

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="true" var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	
	<liferay-ui:error exception="<%= DuplicateColumnNameException.class %>" message="please-enter-unique-field-names" />
	
	<liferay-ui:panel-container extended="true" id="rcsWebformConfiguration" persistState="true">
		<liferay-ui:panel title="form-information" collapsible="true" extended="true" id="rcsWebformGeneral" persistState="true">
			<aui:fieldset>
				<aui:field-wrapper>
					<liferay-ui:input-localized name="title" xml="${titleXml}" />
				</aui:field-wrapper>
			</aui:fieldset>
		</liferay-ui:panel>
	</liferay-ui:panel-container>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>