<%@ include file="/jsp/init.jsp" %>

<aui:form action="#" method="POST" name="fm">
	<aui:fieldset label="${Data.data.title}">
			<div id="formDescription">
				${Data.data.desc}
			</div>
		
		<liferay-ui:success key="success" message="Form information was sent successfully" />
		<liferay-ui:error key="error" message="An error occurred while sending the form information" />
		
		<div id="rcsWebForm">
			<!-- Form will be put here -->
		</div>
		
	</aui:fieldset>
</aui:form>
