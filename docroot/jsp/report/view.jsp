<%@ include file="/jsp/init.jsp" %>

<portlet:actionURL var="deleteRowURL">
	<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="deleteRow" />
</portlet:actionURL>
<portlet:actionURL var="getRowURL">
	<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="getRow" />
</portlet:actionURL>



<c:choose>
	<c:when test="${data.success}">
		<div style="overflow:scroll; width:100%">
				<aui:fieldset label="${data.data.formDto.title} Report">
						<div id="<portlet:namespace />rcsWebFormReport" class="rcsWebFormReport"></div>
				</aui:fieldset>
		</div>
		<aui:form action="<%= deleteRowURL %>" method="POST" name="deleteRowForm" autocomplete="off" cssClass="hidden" >
			<input type="hidden" name="<portlet:namespace />submitId" id="<portlet:namespace />submitId" />
			<button class="btn icon-remove" id="<portlet:namespace />deleteRow" type="submit"></button>			
		</aui:form>
		
		<aui:script use="aui-node,aui-datatype,aui-datatable,datatable-sort,datatable-paginator">
		
			function buildTableData(submittedData, formItems){
				var tableData = [];
				var isSubmittedDataActive = true; 
				for(submittedDataId in submittedData){
					tableRow = {};
					isSubmittedDataActive = true;
					for(formItemId in submittedData[submittedDataId]) {
						if(submittedData[submittedDataId][formItemId].active == 'false') {
							isSubmittedDataActive = false;
							continue;
						}
						tableRow[""+replaceAll(' ', '_', formItems[formItemId].label)+""] = submittedData[submittedDataId][formItemId].userInput;	
					}
					if(isSubmittedDataActive) {
						submittedData[submittedDataId]['table_row_index'] = tableData.length;
						creationDate = new Date(submittedData[submittedDataId][formItemId].creationDate);
						tableRow["submit_date"] = A.Date.format(creationDate, {format : "%c"});
						tableRow[" "] = submittedDataId;
						tableData.push(tableRow);
					}
				}
				return tableData;
			}

		
			var data = <%= renderRequest.getAttribute("data")%>;
			var formItems = fixFormItemData(data.data.formDto.formItems);
			var submittedData = fixSubmittedData(data.data.dataDtoList);
			var tableRow;
			var tableColumn = buildTableColumn(data);
			var tableData = buildTableData(submittedData, formItems);
			
			var datatable = new A.DataTable(
		      {
		        columns: tableColumn,
		        data: tableData,
		        rowsPerPage: 10,
		        
		      }
		    ).render("#<portlet:namespace />rcsWebFormReport");
			
			if(tableData.length == 0) {
				A.one('.table-data').getDOMNode().innerHTML = '<tr  class="table-even"><td style="text-align:center;" colspan="'+tableColumn.length+'" class="table-cell " >No Data</td></tr>';
			}
			
			</aui:script>
			
			<aui:script>
			var deleteRow = function (event) {
				document.getElementById('<portlet:namespace />submitId').value = event.currentTarget.value;
				document.getElementById('<portlet:namespace />deleteRow').click();
			}
			
			function replaceAll(find, replace, str) {
				return str.replace(new RegExp(find, 'g'), replace);
			}
			
			function buildTableColumn(data){
				var tableColumn = [];
				var formItems = data.data.formDto.formItems;
				var tableHeader;

				for(var i = 0; i < formItems.length; i++){
					tableHeader = {};
					if(formItems[i].type != 'SECTION') {
						tableHeader["key"] = replaceAll(' ', '_', formItems[i].label);
						tableHeader["sortable"] = true;
						tableColumn.push(tableHeader);
					}
				}
				
				tableHeader = {};
				tableHeader["key"] = "submit_date";
				tableHeader["sortable"] = true;
				tableColumn.push(tableHeader);
				
				tableHeader = {};
				tableHeader["key"] = " ";
				tableHeader["sortable"] = false;
				tableHeader["alllowHTML"] = true;
				tableHeader["formatter"] = '<button class="btn icon-remove" id="<portlet:namespace />deleteRow{value}" type="submit" value="{value}" onclick="deleteRow(event)""></button>';
				tableColumn.push(tableHeader);
				
				return tableColumn;
			}
			
			function fixFormItemData(data) {
				var fixedFormItem = {};
				for (idx in data) {
					fixedFormItem[data[idx].formItemId] = data[idx];
				}
				return fixedFormItem;
			}
			
			function fixSubmittedData(data) {
				var fixedSubmittedData = {};
				for (idx in data) {
				    if (!fixedSubmittedData[data[idx].submittedDataId]) {
				    	fixedSubmittedData[data[idx].submittedDataId] = {};
				    } 
				    fixedSubmittedData[data[idx].submittedDataId][data[idx].formItemId] = data[idx];
				}
				return fixedSubmittedData;
			}

			</aui:script>
	</c:when>
	<c:otherwise>
		<div class="noSelectedForm">
			Please select the form on the configuration page to view the form's report
		</div>
	</c:otherwise>
</c:choose>



