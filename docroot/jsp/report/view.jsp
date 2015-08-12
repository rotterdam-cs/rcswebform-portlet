<%@ include file="/jsp/init.jsp" %>

<c:choose>
	<c:when test="${data.success}">
		<aui:fieldset label="${data.data.formDto.title} Report">
			<div id="<portlet:namespace />rcsWebFormReport" class="rcsWebFormReport"></div>
		</aui:fieldset>
		
		<script>
		function replaceAll(find, replace, str) {
			return str.replace(new RegExp(find, 'g'), replace);
		}
		
		function buildTableColumn(data){
			var tableColumn = [];
			var formItems = data.data.formDto.formItems;
			
			for(var i = 0; i < formItems.length; i++){
				var tableHeader = {};
				tableHeader["key"] = replaceAll(' ', '_', formItems[i].label);
				tableHeader["sortable"] = true;
				tableColumn.push(tableHeader);
			}
			
			return tableColumn;
		}
		
		function buildTableData(data){
			var tableData = [];
			var formItems = data.data.formDto.formItems;
			var submittedData = data.data.dataDtoList;
			var tableRow;
			var j;
			
			for(var i = 0; i < submittedData.length; i++){
				if ((i % formItems.length)==0){
					j = 0;
					tableRow = {};
				}
				
				tableRow[""+replaceAll(' ', '_', formItems[j].label)+""] = submittedData[i].userInput;
				j++;
				
				if (((i+1) % formItems.length)==0){
					tableData.push(tableRow);
				}
			}
			
			return tableData;
		}
		
		AUI().use('aui-datatable','datatable-sort','datatable-paginator',function(A){
			var data = <%= renderRequest.getAttribute("data")%>;
			
			var tableColumn = buildTableColumn(data);
			var tableData = buildTableData(data);
			
			var datatable = new A.DataTable(
		      {
		        columns: tableColumn,
		        data: tableData,
		        rowsPerPage: 10
		      }
		    ).render("#<portlet:namespace />rcsWebFormReport");
		});
		</script>
	</c:when>
	<c:otherwise>
		<div class="noSelectedForm">
			Please select the form on the configuration page to view the form's report
		</div>
	</c:otherwise>
</c:choose>



