<%@ include file="/jsp/init.jsp" %>

<portlet:actionURL var="submitFormURL">
	<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="submitForm" />
</portlet:actionURL>

<aui:form action="<%= submitFormURL %>" method="POST" name="fm" onSubmit="event.preventDefault();">
	<aui:fieldset label="${Data.data.title}">
		<div id="formDescription">
			${Data.data.desc}
		</div>
		
		<liferay-ui:success key="success" message="${Data.data.successMessage}" />
		
		<liferay-ui:error exception="<%= CaptchaMaxChallengesException.class %>" message="maximum-number-of-captcha-attempts-exceeded" />
		<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
		<liferay-ui:error key="error" message="An error occurred while sending the form information" />
		
		<!-- Hidden input -->
		<aui:input name="redirect" type="hidden" value="${Data.data.successURL}"></aui:input>
		<aui:input name="formId" type="hidden" value="${Data.data.formId}"></aui:input>
		
		<div id="<portlet:namespace />${Data.data.formAttrId}" class="${Data.data.formAttrClass}">
			<div id="<portlet:namespace />rcsWebForm">
				<!-- Form will be put here -->
				<div id="<portlet:namespace />rcsWebFormItem">
					<span id="<portlet:namespace />rcsWebFormItemLabel" >Form Item 1 label</span>
					<span id="<portlet:namespace />rcsWebFormItemInputWrapper" >
						<input type="text" name="<portlet:namespace />rcsWebFormItemInput" id="<portlet:namespace />rcsWebFormItemInput" />
					</span>
				</div>
			</div>
		</div>
		
		<c:if test="${Data.data.useCaptcha}">
			<div id="<portlet:namespace />rcsWebFormCaptcha">
				<portlet:resourceURL var="captchaURL">
					<portlet:param name="<%= Constants.CMD %>" value="captcha" />
				</portlet:resourceURL>
	
				<liferay-ui:captcha url="<%= captchaURL %>" />
			</div>
		</c:if>
		<input type="submit" value="${Data.data.submitLabel}" id="${Data.data.submitAttrId}" class="${Data.data.submitAttrClass}" />
	</aui:fieldset>
</aui:form>

<aui:script use="aui-base,node,aui-form-validator,aui-datepicker">
	var Data = <%= renderRequest.getAttribute("Data")%>;
	console.log(Data);
	if(Data) {
		console.log('t0');
		var divForm = A.one('#<portlet:namespace />rcsWebForm');
		console.log('t1');
		var divTemplateFormItem = A.one('#<portlet:namespace />rcsWebFormItem');
		divTemplateFormItem.hide();
		console.log('t2');
		var rules = new Object();
		var fieldStrings = new Object();
		if(divTemplateFormItem) {
			console.log('s1');
			for(formItemIdx in Data.data.formItems) { 
				console.log('formItem = '+formItemIdx);
				var divFormItem =  divTemplateFormItem.cloneNode(true);
				if(divFormItem) {
					console.log('s2');
					
					divFormItem.one('#<portlet:namespace />rcsWebFormItemLabel').set('text',Data.data.formItems[formItemIdx].label);
					divFormItemInput = divFormItem.one('#<portlet:namespace />rcsWebFormItemInput');
					divFormItemInput.set('id', divFormItemInput.attr('id')+formItemIdx);
					divFormItemInput.set('name', divFormItemInput.attr('name')+formItemIdx);
					console.log('formItem.type : '+Data.data.formItems[formItemIdx].type);
					
					var rule = new Object();
					rule.required = Data.data.formItems[formItemIdx].mandatory;
					if(Data.data.formItems[formItemIdx].validationType === 'REGEX'){
						console.log('regex');						
					} else {
						rule[Data.data.formItems[formItemIdx].validationType.toLowerCase()] = true;  
					}
					rules[divFormItemInput.attr('id')] = rule;
					
					var fieldString = new Object();
					fieldString.required = Data.data.formItems[formItemIdx].errorMandatoryMessage;
					fieldString[Data.data.formItems[formItemIdx].validationType.toLowerCase()] = Data.data.formItems[formItemIdx].errorValidationMessage;
					fieldStrings[divFormItemInput.attr('id')] = fieldString;

					switch(Data.data.formItems[formItemIdx].type) {
					case 'TEXT_FIELD' :
						divFormItemInput.set('type','text');					
						break;
					case 'TEXT_BOX' :
						divFormItemInput.set('type','textarea');					
						break;
					case 'PASSWORD' :
						divFormItemInput.set('type','password');
						break;
					case 'DATE' :
						divFormItemInput.set('type','date');
						console.log('[divFormItemInput.attr("id")] : '+[divFormItemInput.attr('id')])
						new A.DatePicker(
							      {
							    	  mask:'%d/%m/%y',
							        trigger: '#'+divFormItemInput.attr('id'),
							        popover: {
							          zIndex: 1
							        }
							      }
							    );
						rule.date = true;
						break;
					case 'SECTION' :
						divFormItemInput.hide();
						break;
					
					}
					
					
				} else {
					console.log('e2');
				}
				divFormItem.show();
				divFormItem.appendTo(divForm);
			};
			console.log('rules : '+JSON.stringify(rules));
			console.log('fieldStrings : '+JSON.stringify(fieldStrings));
			
		 	var validator = new A.FormValidator(
		 		{
					boundingBox:'#<portlet:namespace />fm',
					rules:rules,
					fieldStrings:fieldStrings,
					showAllMessages:true,
					on: {
						submitError: function(event) {
							console.log("submitError");
							return false;
						},
						submit: function(event) {
							console.log("Submit");
							return false;
						}
					}
				});
		 	
		} else { 
			console.log('form item not found');
		}
	} else{
		console.log('fail');
	}	
</aui:script>
