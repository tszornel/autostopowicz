<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/include.jsp"%>

<f:view>
	<f:loadBundle basename="pl.com.autostopowicz.locale.Locale_pl"
		var="komunikat" />
	<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl">
	<head>
	<link href="<%=request.getContextPath()%>/css/style.css"
		rel="stylesheet" type="text/css" />
	<link rel="Shortcut Icon"
		href="<%=request.getContextPath()%>/images/ferrari.ico"
		type="image/x-icon" />
	<title>Autostopowicz</title>
	</head>
	<body>
	<div id="wrap">
	<div id="header-subpage" class="header1" style="height: 140px;">
	<div id="logo"><span class="centered style1">Auto</span><span
		class="style2">Stop<span class="style3">owicz</span></span></div>
	</div>
	<%@ include file="/jsp/menu.jsp"%> <%@ include
		file="/jsp/horizontal-loginbox.jsp"%>
	<div style="clear: both;"></div>
	<div id="content">
	<div id="driveDetails"><h:form>
		<rich:panel bodyClass="inpanelBody" style="width:850px;">
			<f:facet name="header">
				<h:outputText>
					<h2 align="center"><h:outputText value="Szczegóły Połączenia" /></h2>
				</h:outputText>
			</f:facet>
			<h:panelGrid columns="2" columnClasses="col">
				<h:panelGroup style="width:25%">

					<rich:dataGrid value="#{checkDrivesController.selectedDrives}"
						var="drive" columns="1" elements="1" id="table">
						<rich:panel style="width:300px">
							<f:facet name="header">
								<h:outputText value="Szczegóły Trasy"></h:outputText>
							</f:facet>
							<h:panelGrid columns="1">
								<h:panelGroup style="width:300px">
									<center><h:commandButton value="Powrót do Listy"
										action="#{checkDrivesController.next}" styleClass="button">
									</h:commandButton></center>
									<br />
									<h:outputText value="Skąd" styleClass="label"></h:outputText>
									<br />
									<h:outputText value="Kraj: #{drive.countryFrom.name}" />
									<br />
									<h:outputText value="Miasto: #{drive.cityFrom.name}" />
									<br />
									<h:outputText value="Ulica: #{drive.streetFrom}" />
									<br />
									<br />
									<h:outputText value="Gdzie" styleClass="label"></h:outputText>
									<br />
									<h:outputText value="Kraj: #{drive.countryTo.name}" />
									<br />
									<h:outputText value="Miasto: #{drive.cityTo.name}" />
									<br />
									<h:outputText value="Ulica: #{drive.streetTo}" />
									<br />
									<h:outputText value="Ilość miejsc: #{drive.placeNumber}"></h:outputText>
									<br />
									<h:outputText value="Miejsca palące: #{driveBean.smoke}"></h:outputText>
									<br />
									<h:outputText value="Ilość miejsc: #{drive.placeNumber}"></h:outputText>
									<br />
									<h:outputText value="Cena za kilometr: #{drive.price}"></h:outputText>
									<br />
									<br />
									<h:outputText value="Dane Samochodu" styleClass="label"></h:outputText>
									<br />
									<h:outputText
										value="Marka/Model: #{drive.car.make} / #{drive.car.model}"></h:outputText>
									<br />
									<h:outputText value="Dane kierowcy" styleClass="label"></h:outputText>
									<br />
									<h:outputText value="Login: #{drive.user.login}"></h:outputText>
									<br />
									<h:outputText value="Ranking: #{drive.user.rank}"></h:outputText>
									<br />
									<br />

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
									<center><a4j:commandButton styleClass="button"
										value="Zapisz się na połączenie"
										action="#{checkDrivesController.joinDrive}"
										data="#{checkDrivesController.showMessage}"
										ignoreDupResponses="true"
										oncomplete="javascript:if(data){Richfaces.showModalPanel('panel');}" />
									</center>

								</h:panelGroup>
							</h:panelGrid>
						</rich:panel>

					</rich:dataGrid>

				</h:panelGroup>
				<h:panelGroup style="width:25%">

					<rich:gmap showGMapTypeControl="false" showGLargeMapControl="false"
						mapType="G_NORMAL_MAP" gmapVar="map" zoom="#{gmBean.zoom}"
						style="width:520px;height:323px" gmapKey="#{gmBean.gmapkey}"
						id="gmap" />

				</h:panelGroup>
			</h:panelGrid>
		</rich:panel>
		<rich:modalPanel id="panel" autosized="true" width="300"
			styleClass="inpanelBody">


			<f:facet name="controls">

				<span style="cursor: pointer"
					onclick="javascript:Richfaces.hideModalPanel('panel')">X</span>

			</f:facet>

			<ul>
				<li>Zostałeś zapisany na wybrane połączenie.</li>


				<li>Kierowca automatycznie dostanie email z Twoimi danymi.</li>


				<li>Zostaniesz poinformowany emailem o akceptacji bądź
				odrzuceniu przez niego Twojego zgłoszenia.</li>


				<li>Aby zapisać się na połączenie wybierz konkretną trase
				poprzez klikniecie myszki i naciśnij przycisk 'pokaż szczegóły'</li>


				<li>Jeżeli <strong>zostaniesz zaakceptowany</strong>
				automatycznie dostaniesz emaila ze szczegółowymi danymi kierowcy,
				numerem telefonu, emailem oraz numerem rejestracyjnym samochodu.</li>

			</ul>

		</rich:modalPanel>

	</h:form></div>
	<div style="clear: both" /></div>
	</body>
	</html>
</f:view>
