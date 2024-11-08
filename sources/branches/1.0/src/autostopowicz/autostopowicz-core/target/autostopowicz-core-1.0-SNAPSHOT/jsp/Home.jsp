<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include.jsp"%>

<f:view>
	<f:loadBundle basename="#{startPageController.localePath}"
		var="komunikat" />
	<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl"
		xmlns:acegi="http://sourceforge.net/projects/jsf-comp/acegijsf">
	<head>
	<link href="<%=request.getContextPath()%>/css/style.css"
		rel="stylesheet" type="text/css" />
	<meta name="description" content="Portal Autostopowicz" />
	<meta name="keywords"
		content="Autostop, Autostopowicz, Carpooling, Carpooler, Wakacje, Podróż, Podróżój wspólnie, Dojazdy do pracy" />
	<meta name="robots" content="all" />
	<meta name="robots" content="index,follow" />
	<meta name="author" content="Toms" />
	<link rel="Shortcut Icon" href="<%=request.getContextPath()%>/images/ferrari.ico" type="image/x-icon" />
	<title><h:outputText value="#{komunikat.home_welcome}" /></title>

	</head>
	<body>
	<div id="wrap">
	<div id="header" class="centered"></div>
	<%@ include file="/jsp/menu.jsp"%>
	<%@ include	file="/jsp/horizontal-loginbox.jsp"%>
	<div style="clear:both;"></div>

	<div id="content" class="centered">
	

		<h:form id="form1">
		<h:outputText>Dołącz do społeczności autostopowiczów na <strong>www.autostopowicz.com.pl</strong>
		</h:outputText> 
		<br/><br/>
		<h:outputText>Portal przeznaczony dla użytkowinków indywidualnych oraz dla Firm przyjaznych pracownikom.</h:outputText>
		<br/><br/>
		<h:outputText>Zarejestruj się i podróżuj wspólnie.</h:outputText>
		<br/><br/>
		<h:outputText>Płać mniej za paliwo</h:outputText>
		<br/><br/>
		<h:outputText>Podróżuj wspólnie na wakacje.</h:outputText>
		<br/><br/>
		<h:outputText>Jeśli nie jesteś jeszcze zarejestrowany </h:outputText>
		<t:commandLink style="text-decoration:blink;" id="registerController"
			action="#{registerController.next}" value="zarejestruj się" />
		</h:form>
	
	<div id="menu-login" class="centered" style="background-color:white;display:block;margin-left:auto;margin-right:auto;padding-left:auto;padding-right:auto;">
		
	<TABLE class="centered" >



<TR><TD><div class="wrap1">
		<h:form id="form2">
		<t:commandButton styleClass="pic-normal"
			style="overflow:hidden;width:120px;display:block;border:0px"
			image="/images/buttons_polish/addDrive_button.jpg" alt="Dodaj trasę" action="#{addDriveController.next}"></t:commandButton>
		</h:form>
		</div>
<TD><div class="wrap1">
		<h:form id="form3">
		<t:commandButton styleClass="pic-normal"
			style="overflow:hidden;width:120px;display:block;border:0px"
			image="/images/buttons_polish/checkDrive_button.jpg"  alt="Szukaj połączeń" action="#{checkDrivesController.next}"></t:commandButton>
		</h:form>
		</div>
		
<TD><div class="wrap1">
		<h:form id="form4">
		<t:commandButton styleClass="pic-normal"
			style="overflow:hidden;width:120px;display:block;border:0px"
			image="/images/buttons_polish/opinions_button.jpg"  alt="Komentarze/Artykuły" action="#{commentsArticlesController.next}"></t:commandButton>
			</h:form>
		</div>

	
	<TR><TD>
		<div class="wrap1">
		<h:form id="form5">
		<t:commandButton styleClass="pic-normal"
		style="overflow:hidden;width:120px;display:block;border:0px"
		image="/images/buttons_polish/register_button.jpg"  alt="Zarejestruj się" action="#{registerController.next}"></t:commandButton>
		</h:form>
		</div>
	
	<TD>	<div class="wrap1">
		<h:form id="form6">
		<t:commandButton styleClass="pic-normal"
		style="overflow:hidden;width:120px;display:block;border:0px"
		image="/images/buttons_polish/help_button.jpg"  alt="Pomoc" action="#{helpController.next}"></t:commandButton>
		</h:form>
		</div>
	
	<TD><div class="wrap1">
		<h:form id="form7">
		<t:commandButton styleClass="pic-normal"
		style="overflow:hidden;width:120px;display:block;border:0px"
		image="/images/buttons_polish/profile_button.jpg" alt="Profil" action="#{profileController.next}"></t:commandButton>
		</h:form>
		</div>
		
		</TABLE>
		
		
		<div id="clear" style="clear:left;">
		
		</div>	
	
	
	
	
			
	

	<rich:jQuery selector="#menu-login input" query="mouseover(function(){enlargePic(this)})" /> 
	<rich:jQuery selector="#menu-login input" query="mouseout(function(){normalPic(this)})" /> 
	<rich:jQuery name="enlargePic" timing="onJScall" query="stop().animate({width:'180px'})" /> 
	<rich:jQuery name="normalPic" timing="onJScall"	query="stop().animate({width:'120px'})" />

	
	</div>
	
	</div>
	</div>
	</body>

	</html>
</f:view>
