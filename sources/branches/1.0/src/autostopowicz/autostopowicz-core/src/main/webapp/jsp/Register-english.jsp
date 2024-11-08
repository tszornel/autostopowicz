<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/include.jsp"%>
<f:view>
	<f:loadBundle basename="pl.com.autostopowicz.locale.Locale_eng"
		var="komunikat" />
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>

<meta http-equiv="Content-Type"
	content="application/xhtml+xml; charset=iso-8859-2" />
		<link href="<%=request.getContextPath()%>/css/style.css"
		rel="stylesheet" type="text/css" />
<title>Autostopowicz</title>

</head>

<body>
<div id="wrap"> 
<div id="header-subpage" style="height:140px;">
<div id="logo">
<span class="style1">The </span><span class="style2">Hitch</span><span class="style3">-hiker</span>
</div>
</div>
<%@ include file="/jsp/menu-english.jsp"%>
<div style="clear: right;"></div>
<div style="clear: right;"></div>
<div id="content" class="centered">

<%@ include file="/jsp/loginbox_en.jsp"%>

</div>
<div style="clear: right;" />
</div>
</body>
</html>
</f:view>