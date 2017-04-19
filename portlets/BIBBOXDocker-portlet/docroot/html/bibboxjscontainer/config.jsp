<%@ include file="/html/init_config.jsp" %>

<%
String firstparameter_cfg = GetterUtil.getString(portletPreferences.getValue("firstparameter", "%"));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
   		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
		<!-- Record Name -->
		<aui:input name="preferences--firstparameter--" label="First Parameter (% will only use url parameters)" type="text" value ="<%= firstparameter_cfg %>" />
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>