<%@ include file="/jsp/init.jsp" %>

<c:choose>
	<c:when test="${data.success}">
		<aui:fieldset label="${data.data.formDto.title} Report">
			<div id="<portlet:namespace />rcsWebFormReport" class="rcsWebFormReport">
				<table id="<portlet:namespace />rcsWebFormReportTable" style="width:100%; border: 1px solid black;">
				</table>
			</div>
		</aui:fieldset>
		
		<script>
		AUI().use('aui-base',function(A){
			var data = <%= renderRequest.getAttribute("data")%>;
			
			var tableContent = "<thead><tr>";
			for(var i = 0; i < data.data.formDto.formItems.length; i++){
				tableContent += "<th>"+data.data.formDto.formItems[i].label+"</th>";
			}
			tableContent += "</tr></thead><tbody>";
			
			var formItemsLength = data.data.formDto.formItems.length;
			var submittedData = data.data.dataDtoList;
			for(var i = 0; i < submittedData.length; i++){
				if ((i % formItemsLength)==0){
					tableContent += "<tr>";
				}
				tableContent += "<td>"+submittedData[i].userInput+"</td>";
				if (((i+1) / formItemsLength)==0){
					tableContent += "</tr>";
				}
			}
			
			tableContent += "</tbody>";
			document.getElementById("<portlet:namespace />rcsWebFormReportTable").innerHTML = tableContent;
		});
		</script>
	</c:when>
	<c:otherwise>
		<div class="noSelectedForm">
			Please select the form on the configuration page to view the form's report
		</div>
	</c:otherwise>
</c:choose>



