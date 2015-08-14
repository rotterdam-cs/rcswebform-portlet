<%@ include file="/jsp/init.jsp" %>

<portlet:actionURL var="submitFormURL">
	<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="submitForm" />
</portlet:actionURL>

<aui:form action="<%= submitFormURL %>" method="POST" name="fm" autocomplete="off">

	<!-- fake fields are a workaround for chrome/firefox autofill getting the wrong fields -->
	<input style="display:none" type="text" name="fakeusernameremembered"/>
	<input style="display:none" type="password" name="fakepasswordremembered"/>
	
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
			<fieldset id="<portlet:namespace />rcsWebFormItem">
			<span id="<portlet:namespace />rcsWebFormItemLabel" >Form Item 1 label</span>
			<span id="<portlet:namespace />rcsWebFormItemInputWrapper" >
			
				<input type="text" name="<portlet:namespace />rcsWebFormItemInputText" id="<portlet:namespace />rcsWebFormItemInputText" autocomplete="off"/>
				<textarea name="<portlet:namespace />rcsWebFormItemInputTextArea" id="<portlet:namespace />rcsWebFormItemInputTextArea" autocomplete="off"></textarea>
				<select name="<portlet:namespace />rcsWebFormItemInputCombo" id="<portlet:namespace />rcsWebFormItemInputCombo">
					<option id="<portlet:namespace />rcsWebFormItemOption" value="">Please Select</option>
				</select>
				<span id="<portlet:namespace />rcsWebFormItemInputRadioWrapper">
					<input type="checkbox" name="<portlet:namespace />rcsWebFormItemInputRadio" id="<portlet:namespace />rcsWebFormItemInputRadio" />
					<span id="<portlet:namespace />rcsWebFormItemInputRadioLabel" ></span>
					<br/>
				</span>
			</span>
			</fieldset>
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
		var validator;
		var divForm = A.one('#<portlet:namespace />rcsWebForm');
		var divTemplateFormItem = A.one('#<portlet:namespace />rcsWebFormItem');
		divTemplateFormItem.hide();
		var rules = new Object();
		var fieldStrings = new Object();
		if(divForm || divTemplateFormItem) {
			for(formItemIdx in Data.data.formItems) { 
				var divFormItem =  divTemplateFormItem.cloneNode(true);
				if(divFormItem) {
					
					formItemLabel = divFormItem.one('#<portlet:namespace />rcsWebFormItemLabel');
					formItemInputWrapper = divFormItem.one('#<portlet:namespace />rcsWebFormItemInputWrapper');
					formItemInputCombo = divFormItem.one('#<portlet:namespace />rcsWebFormItemInputCombo');
					formItemInputText = divFormItem.one('#<portlet:namespace />rcsWebFormItemInputText');
					formItemInputTextArea = divFormItem.one('#<portlet:namespace />rcsWebFormItemInputTextArea');
					formItemInputRadioWrapper = divFormItem.one('#<portlet:namespace />rcsWebFormItemInputRadioWrapper');

					divFormItem.addClass(Data.data.formItems[formItemIdx].formItemAttrClass);
					formItemLabel.addClass(Data.data.formItems[formItemIdx].labelAttrClass);
					formItemLabel.set('text',Data.data.formItems[formItemIdx].label);

					switch(Data.data.formItems[formItemIdx].type) {
						case 'TEXT_FIELD' :
							initUserInputText(formItemInputWrapper, formItemInputText, formItemIdx);
							formItemInputText.set('type','text');
							formItemInputTextArea.remove();
							formItemInputRadioWrapper.remove();
							formItemInputCombo.remove();
							break;
						case 'TEXT_BOX' :
							initUserInputText(formItemInputWrapper, formItemInputTextArea, formItemIdx);
							formItemInputText.remove();
							formItemInputRadioWrapper.remove();
							formItemInputCombo.remove();
							break;
						case 'PASSWORD' :
							initUserInputText(formItemInputWrapper, formItemInputText, formItemIdx);
							formItemInputText.set('type','password');
							formItemInputTextArea.remove();
							formItemInputRadioWrapper.remove();
							formItemInputCombo.remove();
							break;
						case 'DATE' :
							initUserInputText(formItemInputWrapper, formItemInputText, formItemIdx);
							
							var datePicker = new A.DatePicker(
								      {
								    	  mask:'%d/%m/%Y',
								          trigger: '#'+formItemInputText.attr('id'),
								          setValue: true,
								          popover: {
									      	zIndex: 1
								          }
								      }
								    );
							
							datePicker.on('blur', function() {
								datePicker.close();
							})
							datePicker.getCalendar().on('dateClick', function(){
								if(validator) {
									validator.validate();
								} else {
									console.log('error validator not initialized');
								}
							});
							
							formItemInputTextArea.remove();
							formItemInputRadioWrapper.remove();
							formItemInputCombo.remove();
							break;
						case 'SECTION' :
							formItemInputWrapper.remove();
							break;
						case 'OPTIONS' :
							initUserInputCombo(formItemInputWrapper, formItemInputCombo, formItemIdx);
							formItemInputTextArea.remove();
							formItemInputRadioWrapper.remove();
							formItemInputText.remove();
							break;
						case 'RADIO_BUTTON' :
							initUserInputRadio(formItemInputWrapper, formItemInputRadioWrapper, formItemIdx);
							formItemInputTextArea.remove();
							formItemInputText.remove();
							formItemInputCombo.remove();
							break;
						case 'CHECKBOX' :
							initUserInputCheckbox(formItemInputWrapper, formItemInputRadioWrapper, formItemIdx);
							formItemInputTextArea.remove();
							formItemInputText.remove();
							formItemInputCombo.remove();
							break;
					}
				} else {
					console.log('fail cloning form item node');
				}
				divFormItem.show();
				divFormItem.appendTo(divForm);
			};
			
			console.log(JSON.stringify(rules));
			console.log(JSON.stringify(fieldStrings));
		 	validator = new A.FormValidator(
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

	function initUserInput(formItemInputWrapper, formItemInput, formItemIdx) {
		formItemInput.set('id', '<portlet:namespace />'+Data.data.formItems[formItemIdx].label.replace(/\ /g,'-'));
		formItemInput.set('name', '<portlet:namespace />'+Data.data.formItems[formItemIdx].label);
		formItemInput.setStyles({
			   height: '100%'
			});
		
		formItemInputWrapper.addClass(Data.data.formItems[formItemIdx].inputAttrClass);
		
		formItemInput.set('placeholder', Data.data.formItems[formItemIdx].hintMessage);
		
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
		
		rules[formItemInput.attr('id')] = rule;
		
		fieldString[Data.data.formItems[formItemIdx].validationType.toLowerCase()] = Data.data.formItems[formItemIdx].errorValidationMessage;
		fieldStrings[formItemInput.attr('id')] = fieldString;

	}
	
	function initUserInputText(formItemInputWrapper, formItemInput, formItemIdx) {
		initUserInput(formItemInputWrapper, formItemInput, formItemIdx);
		if(Data.data.formItems[formItemIdx].type === 'TEXT') {
			formItemInputText.set('value', Data.data.formItems[formItemIdx].defaultValue);
		}
	}
	
	function initUserInputCombo(formItemInputWrapper, formItemInput, formItemIdx, templateOptionItem) {
		initUserInput(formItemInputWrapper, formItemInput, formItemIdx);
		var optionKeys = JSON.parse(Data.data.formItems[formItemIdx].optionKeys);
		var optionValues = JSON.parse(Data.data.formItems[formItemIdx].optionValues);
		var templateOptionItem =  formItemInput.one('#<portlet:namespace />rcsWebFormItemOption');
		
		if(templateOptionItem){
			for(optionIdx in optionKeys) { 
				var optionItem =  templateOptionItem.cloneNode(true);
				if(optionItem) {
					optionItem.set('id', '<portlet:namespace />'+Data.data.formItems[formItemIdx].label);
					optionItem.set('value',optionKeys[optionIdx]);
					optionItem.set('text',optionValues[optionIdx]);
					optionItem.appendTo(formItemInput);
				} else {
					console.log('error cloning option');
				}
			}
// 			templateOptionItem.remove();
		} else {
			console.log('error getting template option');
		}
	}
	
	function initUserInputRadio(formItemInputWrapper, formItemInputRadioWrapper, formItemIdx) {
		initUserInputRadioCheckbox(formItemInputWrapper, formItemInputRadioWrapper, formItemIdx, 'radio');
	}
	function initUserInputCheckbox(formItemInputWrapper, formItemInputRadioWrapper, formItemIdx) {
		initUserInputRadioCheckbox(formItemInputWrapper, formItemInputRadioWrapper, formItemIdx, 'checkbox');
		
	}
	function initUserInputRadioCheckbox(formItemInputWrapper, formItemInputRadioWrapper, formItemIdx, type) {
		initUserInput(formItemInputWrapper, formItemInputRadioWrapper, formItemIdx);
		
		var optionKeys = JSON.parse(Data.data.formItems[formItemIdx].optionKeys);
		var optionValues = JSON.parse(Data.data.formItems[formItemIdx].optionValues);
		for(optionIdx in optionKeys) { 
			var radioWrapper = formItemInputRadioWrapper.cloneNode(true); 
			var radioButton =  radioWrapper.one('#<portlet:namespace />rcsWebFormItemInputRadio');
			var radioLabel = radioWrapper.one('#<portlet:namespace />rcsWebFormItemInputRadioLabel');
			if(radioButton && radioLabel) {
				radioButton.set('type',type);
				radioButton.set('name', '<portlet:namespace />'+Data.data.formItems[formItemIdx].label);
				radioButton.set('value',optionKeys[optionIdx]);
				radioLabel.set('text',optionValues[optionIdx]);
				
				if(optionKeys[optionIdx] == Data.data.formItems[formItemIdx].defaultValue) {
					radioButton.set('checked','true');
				}
				
				radioWrapper.appendTo(formItemInputWrapper);
			} else {
				console.log('error cloning option');
			}
			formItemInputRadioWrapper.remove();
		}
	}	
</aui:script>
