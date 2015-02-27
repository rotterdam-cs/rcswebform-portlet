<%@ include file="/init.jsp" %>

<liferay-ui:error key='fieldSizeInvalid${formFieldsIndex}' message="please-enter-no-more-than-75-characters" />
<c:set var="fieldModel" value="${configClass.generatingWebformFieldModelData(renderRequest,configurationFormFieldsIndex,configurationIndex)}" />

<div class="field-row field-row">
	<div class="field-title">
		<c:choose>
			<c:when test='${fieldModel.fieldType=="paragraph"}'>
				<span class="field-label"><liferay-ui:message key="paragraph" /></span>
			</c:when>
			<c:when test="${fieldModel.fieldLabel != null && !fieldModel.fieldLabel.equals('') }">
				<span class="field-label" >${fieldModel.fieldLabel}</span> 
			</c:when>
			<c:otherwise>
				<liferay-ui:message key="new-item" />
			</c:otherwise>
		</c:choose>
	</div>
	
	<c:choose>
		<c:when test="${configurationIsEditable}">
			<aui:input name="_field${fieldModel.index}" type="hidden" />
			<aui:field-wrapper cssClass="label-name" label="name">
				<liferay-ui:input-localized name="fieldLabel${fieldModel.index}" xml="${fieldModel.fieldLabelXml}" />
			</aui:field-wrapper>
			
			<!-- Field Type Section -->
			<aui:select name="fieldType${fieldModel.index}" label="type" ignoreRequestValue="${fieldModel.iqnoreRequestValue}">
				<aui:option selected='${fieldModel.fieldType=="text"}' value="text"><liferay-ui:message key="text" /></aui:option>
				<aui:option selected='${fieldModel.fieldType=="texarea"}' value="textarea"><liferay-ui:message key="textarea" /></aui:option>
				<aui:option selected='${fieldModel.fieldType=="options"}' value="options"><liferay-ui:message key="options" /></aui:option>
				<aui:option selected='${fieldModel.fieldType=="radio"}' value="radio"><liferay-ui:message key="radio-buttons" /></aui:option>
				<aui:option selected='${fieldModel.fieldType=="paragraph"}' value="paragraph"><liferay-ui:message key="paragraph" /></aui:option>
				<aui:option selected='${fieldModel.fieldType=="checkbox"}' value="checkbox"><liferay-ui:message key="check-box" /></aui:option>
			</aui:select>
			
			<aui:input cssClass="optional-control" ignoreRequestValue="${fieldModel.iqnoreRequestValue}" label="optional" name='fieldOptional${fieldModel.index}' type="checkbox" value="${fieldModel.fieldOptional}" />
			
			<!-- Field Type - Option Section -->
			<aui:field-wrapper cssClass='${fieldModel.fieldOptionsCss}' helpMessage="add-options-separated-by-commas" label="options">
				<liferay-ui:input-localized name="fieldOptions${fieldModel.index}" xml="${fieldModel.fieldOptionsXml}" />
			</aui:field-wrapper>
		</c:when>
	</c:choose>
	
	<c:if test="<%= PortletPropsValues.VALIDATION_SCRIPT_ENABLED %>">
		<c:choose>
			<c:when test="${configurationIsEditable}">
				<div class="validation">
					<liferay-ui:error key='validationDefinitionInvalid${fieldModel.index}' message="please-enter-both-the-validation-code-and-the-error-message" />
					<aui:a cssClass="validation-link" href="javascript:;"><liferay-ui:message key="validation" /> &raquo;</aui:a>
					<div class='validation-input ${fieldModel.fieldValidationScriptHide}'>
						<aui:column columnWidth="50">
							<aui:input cols="80" cssClass="validation-script" ignoreRequestValue="${fieldModel.iqnoreRequestValue}" label="validation-script" name='fieldValidationScript${fieldModel.index}' style="width: 95%" type="textarea" value="${fieldModel.fieldValidationScript}" wrap="off" />
							<aui:input cols="80" ignoreRequestValue="${fieldModel.iqnoreRequestValue}" label="validation-error-message" name='fieldValidationErrorMessage${fieldModel.index}' size="80" value="${fieldModel.fieldValidationErrorMessage}" wrapperCssClass="lfr-input-text-container" />
						</aui:column>
						<aui:column columnWidth="50">
							<div class="syntax-help">
								<liferay-util:include page="/script_help.jsp" servletContext="<%= application %>" />
							</div>
						</aui:column>
					</div>
				</div>
			</c:when>
		</c:choose>
	</c:if>
</div>
