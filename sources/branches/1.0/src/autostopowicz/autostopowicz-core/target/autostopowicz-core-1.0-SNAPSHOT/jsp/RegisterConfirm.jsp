<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/include.jsp"%>
<f:view>
	<f:loadBundle basename="pl.com.autostopowicz.locale.Locale_pl"
		var="komunikat" />
	<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl">
	<head>

	<link href="<%=request.getContextPath()%>/css/style.css"
		rel="stylesheet" type="text/css" />
<link rel="Shortcut Icon" href="<%=request.getContextPath()%>/images/ferrari.ico" type="image/x-icon" />
	<title>Autostopowicz</title>

	</head>

	<body>
	<div id="wrap">
	<div id="header-subpage" style="height: 140px;">
	<div id="logo"><span class="centered style1">Auto</span><span
		class="style2">Stop<span class="style3">owicz</span></span></div>
	</div>
	<%@ include file="/jsp/menu.jsp"%>

	<div style="clear: right;"></div>

	<div id="content" class="centered">
	<div id="registerConfirmForm" class="centered" style="width: 50%;"><!-- <a4j:loadStyle src="resource:///css/rspanel.xcss" />-->
	<rich:spacer height="20" /> <rich:panel style="font-size:x-large;">

		<f:facet name="header">

			<h2 style="font-size:xx-large;"><h:outputText value="Wprowadzone dane" /></h2>

		</f:facet>
		<h:form id="registerForm">
			<h:messages style="font-size:large;color: black" />
		
			<center><h:outputText style="font-size:x-large;"
					value="Login: #{registerController.login}" rendered="#{registerController.notConfirmedRegistration}"/> <br />
				<h:outputText  style="font-size:x-large;" value="Email: #{registerController.email}" rendered="#{registerController.notConfirmedRegistration}" /> <br />
				</center>
				<br/>
			<h:panelGrid columns="2" styleClass="Centered" rendered="#{registerController.notConfirmedRegistration}">
				
				<h:panelGroup>
					<t:commandButton style="width:75px" value="Potwierdź"
						actionListener="#{registerController.register}" />
				</h:panelGroup> 
				
				<h:panelGroup>
					<t:commandButton style="width:75px" value="Edytuj" action="#{registerController.next}" />
				</h:panelGroup>


			</h:panelGrid>

		</h:form>

	</rich:panel></div>
	</div>
	<div style="clear: right;" /></div>
	</body>
	</html>
</f:view>