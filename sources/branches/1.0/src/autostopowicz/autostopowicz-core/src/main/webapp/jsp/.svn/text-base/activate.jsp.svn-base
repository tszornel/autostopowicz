 <%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/include.jsp"%>

<f:view>
	<f:loadBundle basename="pl.com.autostopowicz.locale.Locale_pl"
		var="komunikat" />
	<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl">
	<head>

	 <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>
<link rel="Shortcut Icon" href="<%=request.getContextPath()%>/images/ferrari.ico" type="image/x-icon" />
	<title>Autostopowicz</title>

	</head>

	<body>
	<div id="wrap"> 
	<div id="header-subpage" style="height:140px;">
	<div id="logo"><span class="centered style1">Auto</span><span
		class="style2">Stop<span class="style3">owicz</span></span>
	</div>
	</div>
	<%@ include file="/jsp/menu.jsp"%>
	
	<div style="clear: right;"></div>

	<div id="content" class="centered">
 <span class="error"> 

 </span>
	<h:panelGrid rendered="#{registerConfirmController.activate}" styleClass="centered">
			<h:outputText value="Witaj #{registerConfirmController.userLogin}. Twoje konto zostało aktywowane. Prosze zaloguj się i uzupełnij swój profil użytkownika. "></h:outputText>

	</h:panelGrid>
		<div id="loginbox" class="centered">
		
	<acegijsf:authorize ifNotGranted="ROLE_USER">
	    <h:form id="authenticate">
	     <h:messages id="activateMessage" globalOnly="true"/>
	    Login<br />
	    <h:inputText size="10" maxlength="15" value="#{authenticationController.username}"/>
	    </p>
	    <p>Hasło<br />
	    <h:inputText size="10" maxlength="15" value="#{authenticationController.password}"/>
	    </p>
	  	 <p>	 
	  	 <h:commandLink	styleClass="submit-button" style="padding:2px 12px;font-size: small;text-decoration:none;" id="authentication" action="#{profileController.nextAfterRegistration}"  value="Zaloguj" />
	 	 </p>
	 	</h:form>
	 </acegijsf:authorize>
		
	</div>
	</div>
	<div style="clear: both" />
	</div>
	</body>
	</html>
</f:view>
 
 
