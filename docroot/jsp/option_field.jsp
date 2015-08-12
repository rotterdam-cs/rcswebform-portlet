<%@page import="com.rcs.webform.model.FormItemOption"%>
<%@page import="java.util.List"%>
<%@ include file="/jsp/init.jsp" %>

<%
int fieldOptionsIndex = GetterUtil.getInteger(request.getAttribute("fieldOptionsIndex"));
int index = GetterUtil.getInteger(request.getAttribute("formItemIndex"));
boolean ignoreRequestValue = GetterUtil.getBoolean(request.getAttribute("ignoreRequestValue"));
String formItemOptionLabelMap = "";
String formItemOptionValueMap = "";
Long formItemOptionId = null;
List<FormItemOption> formItemOptions = (List<FormItemOption>) GetterUtil.getObject(request.getAttribute("formItemOptions"));
if(formItemOptions != null && !formItemOptions.isEmpty()){
	formItemOptionId = formItemOptions.get(fieldOptionsIndex).getFormitemoptionId();
	formItemOptionLabelMap = formItemOptions.get(fieldOptionsIndex).getOptionKey();
	formItemOptionValueMap = formItemOptions.get(fieldOptionsIndex).getOptionValue();
}
%>

<div class='added-option-field'>
	<aui:input cssClass='formItemOptionId' name='<%= "formItemOptionId" + fieldOptionsIndex + "_" + index %>' ignoreRequestValue="<%= ignoreRequestValue %>" type="hidden" value='<%=formItemOptionId%>'/>
	<aui:field-wrapper cssClass='left-row-clear-left options'>
		<liferay-ui:input-localized ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "fieldOptionsLabel" + fieldOptionsIndex + "_" + index %>' xml="<%= formItemOptionLabelMap %>" />
	</aui:field-wrapper>
	<aui:field-wrapper cssClass='left-row options'>
		<liferay-ui:input-localized ignoreRequestValue="<%= ignoreRequestValue %>" name='<%= "fieldOptionsValue" + fieldOptionsIndex  + "_" + index %>' xml="<%= formItemOptionValueMap %>" />
	</aui:field-wrapper>
	<aui:field-wrapper cssClass='left-row-clear-right options'>
	<!-- 	<button type="button" class="btn-add-option btn btn-primary btn-content btn btn-icon-only " title="Add option"><span class="btn-icon icon icon-plus"></span></button> -->
		<button type="button" id='<%= "btn-remove-option" + fieldOptionsIndex  + "_" + index %>' class="btn-remove-option btn btn-primary btn-content btn btn-icon-only " title="Remove option"><span class="btn-icon icon icon-minus"></span></button>
	</aui:field-wrapper>
</div>

<aui:script use="aui-base,aui-node">
A.one('<%= "#btn-remove-option" + fieldOptionsIndex  + "_" + index %>').on('click', function(event){
   	var rowFormItemOptionId = event.currentTarget.ancestorsByClassName('added-option-field').getDOM()[0].getElementsByClassName('formItemOptionId')[0].value;
   	
   	var rowFormItemOptionIds = A.one('#<portlet:namespace />deletedFormItemOptionIds').val();
   	
   	if(rowFormItemOptionIds != ""){
   		rowFormItemOptionIds += "," + rowFormItemOptionId;
   	}else{
   		rowFormItemOptionIds += rowFormItemOptionId;
   	}
   	
   	A.one('#<portlet:namespace />deletedFormItemOptionIds').val(rowFormItemOptionIds);

	event.currentTarget.ancestorsByClassName('added-option-field').remove();
});
</aui:script>