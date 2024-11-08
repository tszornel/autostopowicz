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
	<div id="header-subpage" class="header3" style="height:140px;">
	<div id="logo"><span class="centered style1">Auto</span><span
		class="style2">Stop<span class="style3">owicz</span></span>
	</div>
	</div>
	<%@ include file="/jsp/menu.jsp"%>
	<%@ include file="/jsp/horizontal-loginbox.jsp"%>
	<div style="clear: right;"></div>

	<div id="content">

	

	</div>
	<div style="clear: right;" />
	</div>
	</body>
	</html>
</f:view>
