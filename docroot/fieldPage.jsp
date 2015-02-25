<%@ include file="/init.jsp" %>

<liferay-ui:error key='fieldSizeInvalid${formFieldsIndex}' message="please-enter-no-more-than-75-characters" />

<div class="field-row field-row">
	<div class="field-title">
		<c:choose>
			<c:when test='${fieldModel.fieldType=="paragraph"}'>
				<span class="field-label"><liferay-ui:message key="paragraph" /></span>
			</c:when>
			<c:when test="${fieldModel.fieldLabel!=null}">
				<span class="field-label" >${fieldLabel}</span> 
			</c:when>
			<c:otherwise>
				<liferay-ui:message key="new-item" />
			</c:otherwise>
		</c:choose>
	</div>
	
	<c:choose>
		<c:when test="${isEditable}">
			<aui:input name="_field${fieldModel.index}" type="hidden" />
			<aui:field-wrapper cssClass="label-name" label="name">
				<liferay-ui:input-localized name="fieldLabel${fieldModel.index}" xml="${fieldModel.fieldLabelXml" />
			</aui:field-wrapper>
		</c:when>
	</c:choose>
</div>
