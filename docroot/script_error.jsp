

<%@ include file="/init.jsp" %>

<%
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
%>

<div>
	<c:choose>
		<c:when test="<%= permissionChecker.hasPermission(scopeGroupId, name, primKey, ActionKeys.CONFIGURATION) %>">
			<span class="alert alert-error"><liferay-ui:message key="an-error-occurred-while-executing-the-validation.-please-review-the-following-errors" /></span>

			<pre><%= SessionErrors.get(renderRequest, "validationScriptError") %></pre>
		</c:when>
		<c:otherwise>
			<span class="alert alert-error"><liferay-ui:message key="an-error-occurred-while-executing-the-validation.-please-contact-an-administrator" /></span>
		</c:otherwise>
	</c:choose>
</div>