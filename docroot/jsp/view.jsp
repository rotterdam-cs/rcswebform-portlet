<%@ include file="/jsp/init.jsp" %>

<portlet:actionURL var="submitFormURL">
	<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="submitForm" />
</portlet:actionURL>

<aui:form action="<%= submitFormURL %>" method="POST" name="fm">
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

		<div id="<portlet:namespace />rcsWebForm" class="${Data.data.formAttrClass}">
			<!-- Form will be put here -->
			<div id="<portlet:namespace />rcsWebFormItem">
			<span id="<portlet:namespace />rcsWebFormItemLabel" >Form Item 1 label</span>
			<span id="<portlet:namespace />rcsWebFormItemInputWrapper" >
				<input type="text" name="<portlet:namespace />rcsWebFormItemInputText" id="<portlet:namespace />rcsWebFormItemInputText" />
				<select name="<portlet:namespace />rcsWebFormItemInputCombo" id="<portlet:namespace />rcsWebFormItemInputCombo">
					<option id="<portlet:namespace />rcsWebFormItemOption" value="">Please Select</option>
				</select>
				<input type="checkbox" name="<portlet:namespace />rcsWebFormItemInputRadio" id="<portlet:namespace />rcsWebFormItemInputRadio" />
				<span id="<portlet:namespace />rcsWebFormItemInputRadioLabel" ></span>
				
			</span>
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
		<aui:button-row>
			<aui:button type="submit" cssClass="${Data.data.submitAttrClass}" value="${Data.data.submitLabel}"></aui:button>
		</aui:button-row>
	</aui:fieldset>
</aui:form>

<aui:script use="aui-base,aui-node,aui-form-validator,aui-datepicker">
	var DEFAULTS_FORM_VALIDATOR = A.config.FormValidator;

	var phone = function(val, node, ruleValue) {
	    if(node.attr('value') == node.attr('placeholder') ){
	        return false;
	    }   
	
	 	// valid phone number match
	    var phoneRegExp = /^((\+)?[1-9]{1,2})?([-\s\.])?((\(\d{1,4}\))|\d{1,4})(([-\s\.])?[0-9]{1,12}){1,2}$/;

	    if (phoneRegExp.test(val)) {
	        return true;
	    }
	    return false;
	}
	
	var regex = function(val, node, ruleValue) {
	    if(node.attr('value') == node.attr('placeholder') ){
	        return false;
	    }   
	
	    var regExp = new RegExp(ruleValue);
	    
	    return regExp.test(val);
	}
	
	var custom_date = function(val, node, ruleValue) {
	    if(node.attr('value') == node.attr('placeholder') ){
	        return false;
	    }   
	
		return isValidDate(val);
	}
 
	function isValidDate(str) {
	    var parts = str.split('/');
	    if (parts.length < 3)
	        return false;
	    else {
	        var day = parseInt(parts[0]);
	        var month = parseInt(parts[1]);
	        var year = parseInt(parts[2]);
	        if (isNaN(day) || isNaN(month) || isNaN(year)) {
	            return false;
	        }
	        if (day < 1 || year < 1)
	            return false;
	        if(month>12||month<1)
	            return false;
	        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31)
	            return false;
	        if ((month == 4 || month == 6 || month == 9 || month == 11 ) && day > 30)
	            return false;
	        if (month == 2) {
	            if (((year % 4) == 0 && (year % 100) != 0) || ((year % 400) == 0 && (year % 100) == 0)) {
	                if (day > 29)
	                    return false;
	            } else {
	                if (day > 28)
	                    return false;
	            }      
	        }
	        return true;
	    }
	}
	
	A.mix(
	    DEFAULTS_FORM_VALIDATOR.RULES,
	    {
	        phone_number    : phone,
	        regex    : regex,
	        custom_date : custom_date
	    },
	    true
	);      
	
	A.mix(
	    DEFAULTS_FORM_VALIDATOR.STRINGS,
	    {
	        phone    : 'Please enter valid phone number',
	        regex    : 'Please enter valid input',
	        custom_date : 'Please enter valid date'
	    },
	    true
	);

	var Data = <%= renderRequest.getAttribute("Data")%>;
	if(Data) {
		var divForm = A.one('#<portlet:namespace />rcsWebForm');
		var divTemplateFormItem = A.one('#<portlet:namespace />rcsWebFormItem');
		divTemplateFormItem.hide();
		var rules = new Object();
		var fieldStrings = new Object();
		if(divForm || divTemplateFormItem) {
			for(formItemIdx in Data.data.formItems) { 
				console.log('formItem = '+formItemIdx);
				var divFormItem =  divTemplateFormItem.cloneNode(true);
				if(divFormItem) {
					
					divFormItemLabel = divFormItem.one('#<portlet:namespace />rcsWebFormItemLabel');
					divFormItemInputWrapper = divFormItem.one('#<portlet:namespace />rcsWebFormItemInputWrapper');
					divFormItemInputCombo = divFormItem.one('#<portlet:namespace />rcsWebFormItemInputCombo');
					divFormItemInputText = divFormItem.one('#<portlet:namespace />rcsWebFormItemInputText');
					divFormItemInputRadio = divFormItem.one('#<portlet:namespace />rcsWebFormItemInputRadio');
					divFormItemInputRadioLabel = divFormItem.one('#<portlet:namespace />rcsWebFormItemInputRadioLabel');

					divFormItem.addClass(Data.data.formItems[formItemIdx].formItemAttrClass);
					divFormItemLabel.addClass(Data.data.formItems[formItemIdx].labelAttrClass);
					divFormItemLabel.set('text',Data.data.formItems[formItemIdx].label);

					switch(Data.data.formItems[formItemIdx].type) {
						case 'TEXT_FIELD' :
							initUserInputText(divFormItemInputWrapper, divFormItemInputText, formItemIdx);
							divFormItemInputText.set('type','text');
							divFormItemInputRadio.remove();
							divFormItemInputRadioLabel.remove();
							divFormItemInputCombo.remove();
							break;
						case 'TEXT_BOX' :
							initUserInputText(divFormItemInputWrapper, divFormItemInputText, formItemIdx);
							divFormItemInputText.set('type','textarea');					
							divFormItemInputRadio.remove();
							divFormItemInputRadioLabel.remove();
							divFormItemInputCombo.remove();
							break;
						case 'PASSWORD' :
							initUserInputText(divFormItemInputWrapper, divFormItemInputText, formItemIdx);
							divFormItemInputText.set('type','password');
							divFormItemInputRadio.remove();
							divFormItemInputRadioLabel.remove();
							divFormItemInputCombo.remove();
							break;
						case 'DATE' :
							initUserInputText(divFormItemInputWrapper, divFormItemInputText, formItemIdx);
							new A.DatePicker(
								      {
								    	  mask:'%d/%m/%Y',
								          trigger: '#'+divFormItemInputText.attr('id'),
								          popover: {
									      	zIndex: 1
								        }
								      }
								    );
							divFormItemInputRadio.remove();
							divFormItemInputRadioLabel.remove();
							divFormItemInputCombo.remove();
							break;
						case 'SECTION' :
							console.log('section called');
							divFormItemInputWrapper.remove();
							break;
						case 'OPTIONS' :
							initUserInputCombo(divFormItemInputWrapper, divFormItemInputCombo, formItemIdx);
							divFormItemInputRadio.remove();
							divFormItemInputRadioLabel.remove();
							divFormItemInputText.remove();
							break;
						case 'RADIO_BUTTON' :
							divFormItemInputRadio.set('type','radio');
							initUserInputRadioCheckbox(divFormItemInputWrapper, divFormItemInputRadio, formItemIdx, divFormItemInputRadioLabel);
							divFormItemInputText.remove();
							divFormItemInputCombo.remove();
							break;
						case 'CHECKBOX' :
							divFormItemInputRadio.set('type','checkbox');
							initUserInputRadioCheckbox(divFormItemInputWrapper, divFormItemInputRadio, formItemIdx, divFormItemInputRadioLabel);
							divFormItemInputText.remove();
							divFormItemInputCombo.remove();
							break;

					}
					
					
				} else {
					console.log('fail cloning form item node');
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
					fieldContainer:'span',
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
			console.log('form or form item not found');
		}
	} else{
		console.log('empty Data');
	}	

	function initUserInput(divFormItemInputWrapper, divFormItemInput, formItemIdx) {
		divFormItemInput.set('id', '<portlet:namespace />'+Data.data.formItems[formItemIdx].label);
		divFormItemInput.set('name', '<portlet:namespace />'+Data.data.formItems[formItemIdx].label);
		
		divFormItemInputWrapper.addClass(Data.data.formItems[formItemIdx].inputAttrClass);
		divFormItemInput.set('placeholder', Data.data.formItems[formItemIdx].hintMessage);
		
		var rule = new Object();
		var fieldString = new Object();
		
		rule.required = Data.data.formItems[formItemIdx].mandatory;
		fieldString.required = Data.data.formItems[formItemIdx].errorMandatoryMessage;

		if(Data.data.formItems[formItemIdx].validationType === 'REGEX'){
			rule[Data.data.formItems[formItemIdx].validationType.toLowerCase()] = Data.data.formItems[formItemIdx].validationRegexValue;
		} else {
			rule[Data.data.formItems[formItemIdx].validationType.toLowerCase()] = true;  
		}
		
		if(Data.data.formItems[formItemIdx].minLength) {
			rule.minLength = Data.data.formItems[formItemIdx].minLength;
			fieldString.minLength = Data.data.formItems[formItemIdx].errorLengthMessage;
		}
		
		if(Data.data.formItems[formItemIdx].maxLength) {
			rule.maxLength = Data.data.formItems[formItemIdx].maxLength;
			fieldString.maxLength = Data.data.formItems[formItemIdx].errorLengthMessage;
		}
		
		if(Data.data.formItems[formItemIdx].type === 'DATE') {
			rule.custom_date = true;
		}
		
		rules[divFormItemInput.attr('id')] = rule;
		
		fieldString[Data.data.formItems[formItemIdx].validationType.toLowerCase()] = Data.data.formItems[formItemIdx].errorValidationMessage;
		fieldStrings[divFormItemInput.attr('id')] = fieldString;

	}
	
	function initUserInputText(divFormItemInputWrapper, divFormItemInput, formItemIdx) {
		initUserInput(divFormItemInputWrapper, divFormItemInput, formItemIdx);
		divFormItemInputText.set('value', Data.data.formItems[formItemIdx].defaultValue);
	}
	
	function initUserInputCombo(divFormItemInputWrapper, divFormItemInput, formItemIdx, templateOptionItem) {
		initUserInput(divFormItemInputWrapper, divFormItemInput, formItemIdx);
		<!-- var options = Data.data.formItems[formItemIdx].options.split(','); -->
		var options= "";
		var templateOptionItem =  divFormItemInput.one('#<portlet:namespace />rcsWebFormItemOption');
		
		if(templateOptionItem){
			for(optionIdx in options) { 
				var optionItem =  templateOptionItem.cloneNode(true);
				if(optionItem) {
					optionItem.set('id', '<portlet:namespace />'+Data.data.formItems[formItemIdx].label);
					optionItem.set('value',options[optionIdx]);
					optionItem.set('text',options[optionIdx]);
					optionItem.appendTo(divFormItemInput);
				} else {
					console.log('error cloning option');
				}
			}
// 			templateOptionItem.remove();
		} else {
			console.log('error getting template option');
		}
	}
	

	function initUserInputRadioCheckbox(divFormItemInputWrapper, divFormItemInput, formItemIdx, divFormItemInputLabel) {
		initUserInput(divFormItemInputWrapper, divFormItemInput, formItemIdx);
<!-- 		var options = Data.data.formItems[formItemIdx].options.split(','); -->
		var options= "";
		for(optionIdx in options) { 
			var radioButton =  divFormItemInput.cloneNode(true);
			var radioLabel = divFormItemInputLabel.cloneNode(true);
			if(radioButton && radioLabel) {
				radioButton.set('name', '<portlet:namespace />'+Data.data.formItems[formItemIdx].label);
				radioButton.set('value',options[optionIdx]);
				radioLabel.set('text',options[optionIdx]);
				
				if(options[optionIdx] == Data.data.formItems[formItemIdx].defaultValue) {
					radioButton.set('checked','true');
				}
				
				radioButton.appendTo(divFormItemInputWrapper);
				radioLabel.appendTo(divFormItemInputWrapper);
			} else {
				console.log('error cloning option');
			}
			divFormItemInput.remove();
			divFormItemInputLabel.remove();
		}
	}	
</aui:script>
