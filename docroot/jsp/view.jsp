<%@ include file="/jsp/init.jsp" %>

<aui:form action="#" method="POST" name="fm">
	<aui:fieldset label="${Data.data.title}">
			<div id="formDescription">
				${Data.data.desc}
			</div>
<!-- 			<div id="formDescription"> -->
<%-- 				${Data} --%>
<!-- 			</div> -->
		
		<liferay-ui:success key="success" message="Form information was sent successfully" />
		<liferay-ui:error key="error" message="An error occurred while sending the form information" />
		
		<div id="<portlet:namespace />rcsWebForm" >
			<!-- Form will be put here -->
			<div id="<portlet:namespace />rcsWebFormItem">
			
			<span id="<portlet:namespace />rcsWebFormItemLabel" >Form Item 1 label</span>
			<span id="<portlet:namespace />rcsWebFormItemInputWrapper" >
				<aui:input name="" type="text" id="rcsWebFormItemInput" />
			</span>
			</div>

		</div>
		
	</aui:fieldset>
</aui:form>

<aui:script use="aui-base,node">
	var Data = <%= renderRequest.getAttribute("Data")%>;
	if(Data) {
		console.log('t0');
		var divForm = A.one('#<portlet:namespace />rcsWebForm');
		console.log('t1');
		var divTemplateFormItem = A.one('#<portlet:namespace />rcsWebFormItem');
		divTemplateFormItem.hide();
		console.log('t2');
		
		if(divTemplateFormItem) {
			console.log('s1');
			console.log('formItem.0.type = '+Data.data.formItems[0].type);
			for(formItemIdx in Data.data.formItems) { 
				console.log('formItem = '+formItemIdx);
				var divFormItem =  divTemplateFormItem.cloneNode(true);
				if(divFormItem) {
					divFormItem.one('#<portlet:namespace />rcsWebFormItemLabel').set('text',Data.data.formItems[formItemIdx].label);
					console.log('formItem.type : '+Data.data.formItems[formItemIdx].type);
					switch(Data.data.formItems[formItemIdx].type) {
					case 'TEXT_FIELD' :
						divFormItem.one('#<portlet:namespace />rcsWebFormItemInput').set('type','text');					
						break;
					case 'TEXT_BOX' :
						divFormItem.one('#<portlet:namespace />rcsWebFormItemInput').set('type','textarea');					
						break;
					case 'PASSWORD' :
						divFormItem.one('#<portlet:namespace />rcsWebFormItemInput').set('type','password');
						break;
					}
					console.log('s2');
				} else {
					console.log('e2');
				}
				divFormItem.show();
				divFormItem.appendTo(divForm);
			};
		} else { 
			console.log('form item not found');
		}
	} else{
		console.log('fail');
	}	
</aui:script>
