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
	<div id="header-subpage" class="header5" style="height: 140px;">
	<div id="logo"><span class="centered style1">Auto</span><span
		class="style2">Stop<span class="style3">owicz</span></span></div>
	</div>
	<%@ include file="/jsp/menu.jsp"%>

	<div style="clear: right;"></div>

	<div id="content" class="centered">
	<div id="register" style="width: 100%; float: left;"><!-- <a4j:loadStyle src="resource:///css/rspanel.xcss" />-->
	<rich:spacer height="20" /> <rich:panel style="font-size:large;font-family: Georgia, 'Times New Roman', Times, serif;">

		<f:facet name="header">

			<h:outputText value="Formularz rejestracyjny" />

		</f:facet>
		<h:form>

			<rich:messages passedLabel="Data is allowed to be stored."
				layout="list">
				<f:facet name="header">

					<h:outputText value="Entered Data Status:"></h:outputText>

				</f:facet>

				<f:facet name="passedMarker">

					<h:graphicImage value="/images/passed.gif" />

				</f:facet>

				<f:facet name="errorMarker">

					<h:graphicImage value="/images/error.gif" />

				</f:facet>
			</rich:messages>
			<h:panelGrid columns="2" style="width: 100%">

				<h:panelGroup>
					<h:outputText value="Login:" />
					<br />
					<h:inputText label="Login" id="name" required="true"
						value="#{registerController.login}">
					</h:inputText>
					<br />
					<h:outputText value="Email:" />
					<br />
					<h:inputText label="Email" id="email" required="true"
						value="#{registerController.email}">
					</h:inputText>
					<br />
					<h:outputText value="Hasło:" />
					<br />
					<h:inputSecret label="Passsword" id="password" required="true"
						value="#{registerController.password}">

						<f:validateLength minimum="4" />
					</h:inputSecret>
					<br />
					<h:outputText value="Potwierdzenie Hasła:" />
					<br />
					<h:inputSecret label="Confirm" id="confirm" required="true"
						value="#{registerController.confirm}">

					</h:inputSecret>
					<br />

					<a4j:commandButton value="Rejestruj"
						action="#{registerController.verify}" />



				</h:panelGroup>

				<h:panelGroup styleClass="centered">
					
					<rich:panel bodyClass="inpanelBody" style="height:235px;">

					<f:facet name="header">

						<h:outputText>
							<h2 align="center"><h:outputText value="Rejetrowanie Autostopowicza" /></h2>
						</h:outputText>

					</f:facet>

					<ul>

						<li>Aby się zarejestrować wypełnij formularz.</li>

						<li>Login oraz Email <strong>muszą być unikatowe</strong>.</li>
						<li>Po udanej validacji na podany adres email zostanie wysłany emial z linkiem aktywującym konto.</li>

						<li>Po aktywacji użytkownik ma pełny dostęp do serwisu Autostopowicz.</li>

						<li>Po aktywacji mozesz uzupełnić swój profil w dane potrzebne do dodawania oraz jeżdżenia autostopem.</li>

					</ul>

				</rich:panel>
					
					

				</h:panelGroup>
			</h:panelGrid>

		</h:form>

	</rich:panel></div>
	</div>
	<div style="clear: right;" /></div>
	</body>
	</html>
</f:view>