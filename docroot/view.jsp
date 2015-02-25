

<%@ include file="/init.jsp" %>

<portlet:actionURL var="saveDataURL">
	<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="saveData" />
</portlet:actionURL>

<aui:form action="<%= saveDataURL %>" method="post" name="fm">
	<c:if test="${formMoodel.validatorSuccessURL}">
		<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	</c:if>

	<aui:fieldset label="${formMoodel.title}">
		<c:if test="${formMoodel.validatorDescription}">
			<p class="description">${formMoodel.description}</p>
		</c:if>

		<liferay-ui:success key="success" message="the-form-information-was-sent-successfully" />

		<liferay-ui:error exception="<%= CaptchaMaxChallengesException.class %>" message="maximum-number-of-captcha-attempts-exceeded" />
		<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
		<liferay-ui:error key="error" message="an-error-occurred-while-sending-the-form-information" />

		<c:if test='${formMoodel.validateScriptEnable}'>
			<liferay-util:include page="/script_error.jsp" />
		</c:if>
		<table>
	
		
		<c:forEach items="${formMoodel.formComponentSet}" var="item">
		   <c:if test="${item.validationScriptEnabled}">
				<liferay-ui:error key='"error"${item.fieldLabel}' message="${item.fieldValidationErrorMessage}" />

				<c:if test="${item.fieldValidationScript}">
					<div class="hide" id="<portlet:namespace />validationError${item.fieldName}">
						<span class="alert alert-error">${item.fieldValidationErrorMessage}</span>
					</div>
				</c:if>
			</c:if>

			<c:choose>
				
					<c:when test="${item.fileType == 'text'}">
						<c:choose>
							<c:when test="${item.position == 'horizontal'}">
								<tr>
									<td valign="top">${item.fieldLabel}</td>
									<td valign="top"><aui:input label=""  name="${item.fieldName}" value="${item.fieldValue}" /></td> 
									<td valign="top">
										<c:if test="${! item.fieldOptional}">
											<div class="hide" id="<portlet:namespace />fieldOptionalError${item.fieldName}">
												<span class="alert alert-error"><liferay-ui:message key="this-field-is-mandatory" /></span>
											</div>
										</c:if>
									</td>
								</tr>
							</c:when>
							<c:when test="${item.position == 'vertical'}">
								<tr>
									<td valign="top">${item.fieldLabel}</td>
								</tr>
								<tr>
									<td valign="top" colspan="2">
										<aui:input label=""  name="${item.fieldName}" value="${item.fieldValue}" />
									</td>
									<td valign="top">
										<c:if test="${! item.fieldOptional}">
											<div class="hide" id="<portlet:namespace />fieldOptionalError${item.fieldName}">
												<span class="alert alert-error"><liferay-ui:message key="this-field-is-mandatory" /></span>
											</div>
										</c:if>
									</td>
								</tr>
							</c:when>
						</c:choose>
					</c:when>
					
					<c:when test="${item.fileType == 'textarea'}">
						<c:choose>
							<c:when test="${item.position == 'horizontal'}">
								<tr>
									<td valign="top">${item.fieldLabel}</td>
									<td><aui:input label="" name="${item.fieldName}" type="textarea" value="${item.fieldValue}" wrap="soft" wrapperCssClass="lfr-textarea-container" /></td> 
									<td>
										<c:if test="${! item.fieldOptional}">
											<div class="hide" id="<portlet:namespace />fieldOptionalError${item.fieldName}">
												<span class="alert alert-error"><liferay-ui:message key="this-field-is-mandatory" /></span>
											</div>
										</c:if>
									</td>
								</tr>
							</c:when>
							<c:when test="${item.position == 'vertical'}">
								<tr>
									<td valign="top">${item.fieldLabel}</td>
								</tr>
								<tr>
									<td colspan="2" valign="top">
										<aui:input label="" name="${item.fieldName}" type="textarea" value="${item.fieldValue}" wrap="soft" wrapperCssClass="lfr-textarea-container" />
									</td>
									<td valign="top">
										<c:if test="${! item.fieldOptional}">
											<div class="hide" id="<portlet:namespace />fieldOptionalError${item.fieldName}">
												<span class="alert alert-error"><liferay-ui:message key="this-field-is-mandatory" /></span>
											</div>
										</c:if>
									</td>
								</tr>
							</c:when>
						</c:choose>	
					</c:when>
					
					<c:when test="${item.fileType == 'options'}">
						<c:choose>
							<c:when test="${item.position == 'horizontal'}">
								<tr>
									<td valign="top">${item.fieldLabel}</td>
									<td>
										<aui:select label="" name="${item.fieldName}">
			
											<c:forEach items="${item.fieldOptionsSet}" var="itemChild">
					
												<aui:option  value="${itemChild.optionLabel}">${itemChild.optionLabel}</aui:option>
					
											</c:forEach>
					
										</aui:select>
									</td> 
									<td valign="top">
										<c:if test="${! item.fieldOptional}">
											<div class="hide" id="<portlet:namespace />fieldOptionalError${item.fieldName}">
												<span class="alert alert-error"><liferay-ui:message key="this-field-is-mandatory" /></span>
											</div>
										</c:if>
									</td>
								</tr>
							</c:when>
							<c:when test="${item.position == 'vertical'}">
								<tr>
									<td colspan="3">${item.fieldLabel}</td>
								</tr>
								<tr>
									<td colspan="2">
										
										<aui:select label="" name="${item.fieldName}">
			
											<c:forEach items="${item.fieldOptionsSet}" var="itemChild">
					
												<aui:option  value="${itemChild.optionLabel}">${itemChild.optionLabel}</aui:option>
					
											</c:forEach>
					
										</aui:select>
										
									</td>
									<td valign="top">
										<c:if test="${! item.fieldOptional}">
											<div class="hide" id="<portlet:namespace />fieldOptionalError${item.fieldName}">
												<span class="alert alert-error"><liferay-ui:message key="this-field-is-mandatory" /></span>
											</div>
										</c:if>
									</td>
								</tr>
							</c:when>
						</c:choose>		
					</c:when>
					<c:when test="${item.fileType == 'radio'}">
						<c:choose>
							<c:when test="${item.position == 'horizontal'}">
								<tr>
									<td valign="top">${item.fieldLabel}</td>
									<td>
										<aui:field-wrapper label="" name="${item.fieldName}">
			
											<c:forEach items="${item.fieldOptionsSet}" var="itemChild">
					
												<aui:input  label="${itemChild.optionLabel}" name="${item.fieldName}" type="radio" value="${itemChild.optionLabel}" />
					
											</c:forEach>
					
										</aui:field-wrapper>
									</td> 
									<td valign="top">
										<c:if test="${! item.fieldOptional}">
											<div class="hide" id="<portlet:namespace />fieldOptionalError${item.fieldName}">
												<span class="alert alert-error"><liferay-ui:message key="this-field-is-mandatory" /></span>
											</div>
										</c:if>
									</td>
								</tr>
							</c:when>
							<c:when test="${item.position == 'vertical'}">
								<tr>
									<td colspan="3">${item.fieldLabel}</td>
								</tr>
								<tr>
									<td colspan="2">
										
										<aui:field-wrapper label="" name="${item.fieldName}">
			
											<c:forEach items="${item.fieldOptionsSet}" var="itemChild">
					
												<aui:input  label="${itemChild.optionLabel}" name="${item.fieldName}" type="radio" value="${itemChild.optionLabel}" />
					
											</c:forEach>
					
										</aui:field-wrapper>
										
									</td>
									<td valign="top">
										<c:if test="${! item.fieldOptional}">
											<div class="hide" id="<portlet:namespace />fieldOptionalError${item.fieldName}">
												<span class="alert alert-error"><liferay-ui:message key="this-field-is-mandatory" /></span>
											</div>
										</c:if>
									</td>
								</tr>
							</c:when>
						</c:choose>		
					</c:when>
				
			</c:choose>
		</c:forEach> 
		</table>
		<c:if test="${formMoodel.requireCaptcha}">
			<portlet:resourceURL var="captchaURL">
				<portlet:param name="<%= Constants.CMD %>" value="captcha" />
			</portlet:resourceURL>

			<liferay-ui:captcha url="<%= captchaURL %>" />
		</c:if>

		<aui:button onClick="" type="submit" value="send" />
	</aui:fieldset>
</aui:form>

<aui:script use="aui-base,selector-css3">
	var form = A.one('#<portlet:namespace />fm');

	if (form) {
		form.on(
			'submit',
			function(event) {
				var keys = [];

				var fieldLabels = {};
				var fieldOptional = {};
				var fieldValidationErrorMessages = {};
				var fieldValidationFunctions = {};
				var fieldsMap = {};

				<%
				int i = 1;

				String fieldName = "field" + i;
				String fieldLabel = portletPreferences.getValue("fieldLabel" + i, StringPool.BLANK);

				while ((i == 1) || Validator.isNotNull(fieldLabel)) {
					boolean fieldOptional = PrefsParamUtil.getBoolean(portletPreferences, request, "fieldOptional" + i, false);
					String fieldType = portletPreferences.getValue("fieldType" + i, "text");
					String fieldValidationScript = portletPreferences.getValue("fieldValidationScript" + i, StringPool.BLANK);
					String fieldValidationErrorMessage = portletPreferences.getValue("fieldValidationErrorMessage" + i, StringPool.BLANK);
				%>

					var key = '<%= fieldName %>';

					keys[<%= i %>] = key;

					fieldLabels[key] = '<%= HtmlUtil.escape(fieldLabel) %>';
					fieldValidationErrorMessages[key] = '<%= fieldValidationErrorMessage %>';

					function fieldValidationFunction<%= i %>(currentFieldValue, fieldsMap) {
						<c:choose>
							<c:when test="<%= PortletPropsValues.VALIDATION_SCRIPT_ENABLED && Validator.isNotNull(fieldValidationScript) %>">
								<%= fieldValidationScript %>
							</c:when>
							<c:otherwise>
								return true;
							</c:otherwise>
						</c:choose>
					};

					fieldOptional[key] = <%= fieldOptional %>;
					fieldValidationFunctions[key] = fieldValidationFunction<%= i %>;

					<c:choose>
						<c:when test='<%= fieldType.equals("radio") %>'>
							var radioButton = A.one('input[name=<portlet:namespace />field<%= i %>]:checked');

							fieldsMap[key] = '';

							if (radioButton) {
								fieldsMap[key] = radioButton.val();
							}
						</c:when>
						<c:otherwise>
							var inputField = A.one('#<portlet:namespace />field<%= i %>');

							fieldsMap[key] = (inputField && inputField.val()) || '';
						</c:otherwise>
					</c:choose>

				<%
					i++;

					fieldName = "field" + i;
					fieldLabel = portletPreferences.getValue("fieldLabel" + i, "");
				}
				%>

				var validationErrors = false;

				for (var i = 1; i < keys.length; i++) {
					var key = keys [i];

					var currentFieldValue = fieldsMap[key];

					var optionalFieldError = A.one('#<portlet:namespace />fieldOptionalError' + key);
					var validationError = A.one('#<portlet:namespace />validationError' + key);

					if (!fieldOptional[key] && currentFieldValue.match(/^\s*$/)) {
						validationErrors = true;

						A.all('.alert-success').hide();

						if (optionalFieldError) {
							optionalFieldError.show();
						}
					}
					else if (!fieldValidationFunctions[key](currentFieldValue, fieldsMap)) {
						validationErrors = true;

						A.all('.alert-success').hide();

						if (optionalFieldError) {
							optionalFieldError.hide();
						}

						if (validationError) {
							validationError.show();
						}
					}
					else {
						if (optionalFieldError) {
							optionalFieldError.hide();
						}

						if (validationError) {
							validationError.hide();
						}
					}
				}

				if (validationErrors) {
					event.halt();
					event.stopImmediatePropagation();
				}
			}
		);
	}
</aui:script>