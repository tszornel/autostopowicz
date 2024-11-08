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
	<title><h:outputText value="#{komunikat.home_welcome}" /></title>
	</head>

	<body>
	<div id="wrap">
	<div id="header-subpage" class="header4" style="height:140px;">
	<div id="logo"><span class="centered style1">Auto</span><span
		class="style2">Stop</span><span class="style3">owicz</span>
	</div>
	</div>
	<%@ include file="/jsp/menu.jsp"%>
	<%@ include file="/jsp/horizontal-loginbox.jsp"%>


	<div style="clear: right;"></div>

	<div id="content" class="centered">


	<div id="helpForm" style="width: 75%; float: left;">
	<rich:tabPanel
		switchType="ajax" style="font-size:large;">

		<rich:tab label="#{komunikat.tab1_label}">     
            <jsp:include page="HelpResources/pl/tab1.html"/>		
        </rich:tab>
        
		<rich:tab label="#{komunikat.tab2_label}">
			<jsp:include page="HelpResources/pl/tab2.html"/>
        </rich:tab>
        
		<rich:tab label="#{komunikat.tab3_label}">
			<jsp:include page="HelpResources/pl/tab3.html"/>
        </rich:tab>
        
		<rich:tab label="#{komunikat.tab4_label}">
			<jsp:include page="HelpResources/pl/tab4.html"/>
        </rich:tab>
        
		<rich:tab label="#{komunikat.tab5_label}">
			<jsp:include page="HelpResources/pl/tab5.html"/>
        </rich:tab>
        
		<rich:tab label="#{komunikat.tab6_label}">
			<jsp:include page="HelpResources/pl/tab6.html"/>
        </rich:tab>

		<rich:tab label="FAQ">
            Here is tab #7
        </rich:tab>

	</rich:tabPanel>
	</div>
	<div style="clear: both;" />
	</div>
	</div>
	</body>
	</html>
</f:view>
