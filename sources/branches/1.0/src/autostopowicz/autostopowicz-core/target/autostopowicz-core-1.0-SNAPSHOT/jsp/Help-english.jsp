<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/include.jsp"%>

<f:view>
<f:loadBundle basename="pl.com.autostopowicz.locale.Locale_eng"
		var="komunikat" />
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>

<meta http-equiv="Content-Type"
	content="application/xhtml+xml; charset=UTF-8" />
	
	<link href="<%=request.getContextPath()%>/css/style.css"
		rel="stylesheet" type="text/css" />
<title>Autostopowicz</title>

</head>

<body>
<div id="wrap"> 
<div id="header-subpage" class="header4" style="height:140px;">
<div id="logo">
<span class="style1">The </span><span class="style2">Hitch</span><span class="style3">-hiker</span>
</div>
</div>
<%@ include file="/jsp/menu-english.jsp"%>
<%@ include	file="/jsp/horizontal-loginbox.jsp"%>
<div style="clear: right;"></div>
<div id="content" class="centered">



</div>
<div style="clear: right;" />
</body>
</html>
</f:view>