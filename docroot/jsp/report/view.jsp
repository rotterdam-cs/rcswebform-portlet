<%@ include file="/jsp/init.jsp" %>

RCS Web Form Report View

<aui:script use="aui-base">
var data = <%= renderRequest.getAttribute("data")%>;
console.log(data);
</aui:script>