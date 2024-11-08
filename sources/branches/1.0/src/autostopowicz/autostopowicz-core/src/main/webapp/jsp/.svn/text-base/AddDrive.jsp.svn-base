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

	<div id="content"><h:panelGrid columns="2" columnClasses="col">

		<h:panelGroup style="width:25%">
			<rich:gmap mapType="G_NORMAL_MAP" gmapVar="map" zoom="#{gmBean.zoom}"
				style="width:350px;height:400px" gmapKey="#{gmBean.gmapkey}"
				id="gmap" />
		</h:panelGroup>
		<h:panelGroup style="width:25%">
			
			<rich:tabPanel switchType="ajax" width="350" height="400">

				<rich:tab label="Wyznacz Trasę">
						<rich:panel bodyClass="inpanelBody">

				<f:facet name="header">

					<h:outputText>
						<h2 align="center"><h:outputText value="Dodawanie Połączeń" /></h2>
					</h:outputText>

				</f:facet>

				<ul>

					<li>Wprowadz dane do formularza i naciśnij przycisk "Dodaj
					Połączenie".</li>

					<li>Trasa zostanie automatycznie wyznaczona na mapce.</li>

					<li>Na niej również można modyfikować punkty pośrednie.</li>
				</ul>

			</rich:panel>
					<h:form id="addDrive">
						<rich:dataGrid var="place" value="#{gmBean.point}" columns="1">
							<h:outputText value="Miejsce początkowe:" />
							<rich:comboBox suggestionValues="#{countriesBean.countriesNames}"
								directInputSuggestions="true" defaultLabel="Kraj" value="#{driveBean.countryFrom}" />
							<rich:comboBox suggestionValues="#{citiesBean.citiesNames}"
								directInputSuggestions="true" defaultLabel="Miejscowość" value="#{driveBean.cityFrom}"/>
						
							<h:inputText size="15" maxlength="20"
								value="#{driveBean.streetFrom}" title="Ulica" label="Ulica"
								id="streetFrom" />	<h:outputText value=" Ulica" />
							<br/>
							<h:outputText value="Data" />
							<br/>
							<rich:calendar 
								value="#{driveBean.date}"
								locale="#{calendarBean.locale}" 
								popup="#{calendarBean.popup}"
								datePattern="#{calendarBean.pattern}"
								showApplyButton="#{calendarBean.showApply}" 
								style="width:200px" />
							<br />
							<h:outputText value="Miejsce docelowe:" />
							<rich:comboBox suggestionValues="#{countriesBean.countriesNames}"
								directInputSuggestions="true" defaultLabel="Kraj" value="#{driveBean.countryTo}"/>
							<rich:comboBox suggestionValues="#{citiesBean.citiesNames}"
								directInputSuggestions="true" defaultLabel="Miejscowość" value="#{driveBean.cityTo}"/>
							
							<h:inputText size="15" maxlength="20"
								value="#{driveBean.streetTo}" title="Ulica" label="Ulica"
								id="streetTo" /> <h:outputText value=" Ulica" />
							<br />
							<h:outputText>Ilość miejsc:</h:outputText>
							<rich:inputNumberSpinner value="#{driveBean.placeNumber}"/>
							<br/>
							<h:outputText>Miejsca Palące:</h:outputText>
							<h:selectBooleanCheckbox id="smokePlaces" value="#{driveBean.smoking}" />
							<br />
							<h:commandButton onclick="showPlace('#{place.id}')"
								style="cursor:pointer" value="Wyznacz na mapie"></h:commandButton>
								
							<h:commandButton disabled="#{gmBean.localized}" action="#{addDriveController.validateAndAddDrive}"
								style="cursor:pointer" value="Zapisz Połączenie"></h:commandButton>
					
						</rich:dataGrid>
					</h:form>
				</rich:tab>

				<rich:tab label="Ostatnie Trasy">
				
					<rich:dataGrid var="place" value="#{gmBean.point}" columns="2">
						<rich:panel bodyClass="inpanelBody">

				<f:facet name="header">

					<h:outputText>
						<h2 align="center"><h:outputText value="Ostatnie Trasy" /></h2>
					</h:outputText>

				</f:facet>

				<ul>
					
					<li>W liscie znajduje się 10 ostatnio dodanych Tras.</li>
					
					<li>W celu szybkiego dodania tras kliknij na wybrany link.</li>

					<li>Po naciśnięciu linku Trasa automatycznie zaznaczy się na mapce.</li>

					<li>Aby dodać  Trasę dla innych autostopowiczów naciśnić "Dodaj trasę".</li>
				
				</ul>

			</rich:panel>	
						
						
						<h:graphicImage onclick="showPlace('#{place.id}')"
							style="cursor:pointer" value="resource://#{place.pic}" />
					</rich:dataGrid>

				</rich:tab>


			</rich:tabPanel>
		</h:panelGroup>

		





	</h:panelGrid> <h:form>
		<a4j:jsFunction name="showPlace" data="#{gmBean.currentPlace}"
			reRender=":zoom"
			oncomplete="map.setCenter(new GLatLng(data.lat, data.lng),data.zoom)">
			<a4j:actionparam name="id" assignTo="#{gmBean.currentId}"></a4j:actionparam>
		</a4j:jsFunction>
	</h:form></div>
	</body>
	</html>
</f:view>
