<%@ include file="/jsp/init.jsp" %>

<%-- <aui:form action="#" method="POST" name="fm"> --%>
<aui:form action="#" method="POST" name="fm" onSubmit="event.preventDefault();">
	<aui:fieldset label="${Data.data.title}">
			<div id="formDescription">
				${Data.data.desc}
			</div>
		
		<liferay-ui:success key="success" message="Form information was sent successfully" />
		<liferay-ui:error key="error" message="An error occurred while sending the form information" />
		
		<div id="<portlet:namespace />rcsWebForm" >
			<!-- Form will be put here -->
			<div id="<portlet:namespace />rcsWebFormItem">
			<span id="<portlet:namespace />rcsWebFormItemLabel" >Form Item 1 label</span>
			<span id="<portlet:namespace />rcsWebFormItemInputWrapper" >
				<input type="text" name="<portlet:namespace />rcsWebFormItemInput" id="<portlet:namespace />rcsWebFormItemInput" />
			</span>
			</div>
		</div>
	<input type="submit" value="${Data.data.submitLabel}" />
	</aui:fieldset>
</aui:form>

<aui:script use="aui-base,node,aui-form-validator,aui-datepicker">
	var Data = <%= renderRequest.getAttribute("Data")%>;
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
