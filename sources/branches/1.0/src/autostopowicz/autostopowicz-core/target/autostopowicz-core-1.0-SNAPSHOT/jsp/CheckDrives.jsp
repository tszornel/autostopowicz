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
	<div id="header-subpage" class="header3" style="height: 140px;">
	<div id="logo"><span class="centered style1">Auto</span><span
		class="style2">Stop<span class="style3">owicz</span></span></div>
	</div>
	<%@ include file="/jsp/menu.jsp"%> <%@ include
		file="/jsp/horizontal-loginbox.jsp"%>
	<div style="clear: both;"></div>

	<div id="content">


		<div id="searchTable">
		<a4j:form ajaxSubmit="true"	reRender="dataTable">
		<h:panelGrid columns="7"
			columnClasses="optionList">

			<h:panelGroup>
				<h:outputText value="Miejsce początkowe:" />
				<rich:comboBox suggestionValues="#{countriesBean.countriesNames}"
					directInputSuggestions="true" defaultLabel="Kraj"
					value="#{driveBean.countryFrom}" />

				<rich:comboBox suggestionValues="#{citiesBean.citiesNames}"
					directInputSuggestions="true" defaultLabel="Miejscowość"
					value="#{driveBean.cityFrom}" />
				<h:outputText value="Ulica:" />
				<h:inputText size="10" maxlength="15"
					value="#{driveBean.streetFrom}" title="Ulica" label="Ulica"
					id="streetFrom" />


			</h:panelGroup>

			<h:panelGroup>
				<h:outputText value="Miejsce docelowe:" />
				<rich:comboBox suggestionValues="#{countriesBean.countriesNames}"
					directInputSuggestions="true" defaultLabel="Kraj"
					value="#{driveBean.countryTo}" />
				<rich:comboBox suggestionValues="#{citiesBean.citiesNames}"
					directInputSuggestions="true" defaultLabel="Miejscowość"
					value="#{driveBean.cityTo}" />
				<h:outputText value="Ulica:" />
				<h:inputText size="10" maxlength="15" value="#{driveBean.streetTo}"
					label="Ulica" id="streetTo" />

			</h:panelGroup>

			<h:panelGroup style="width:240px">
				<h:outputText value="Data" />
				<br />
				<rich:calendar value="#{driveBean.date}"
					locale="#{calendarBean.locale}" popup="#{calendarBean.popup}"
					datePattern="#{calendarBean.pattern}"
					showApplyButton="#{calendarBean.showApply}" style="width:200px" />
			</h:panelGroup>
			<h:panelGroup>
				<h:outputText>Dokładność:</h:outputText>
				<rich:inputNumberSpinner inputSize="1" label="Dni"
					value="#{driveBean.daysAccuracy}" />

			</h:panelGroup>
			<h:panelGroup>
				<h:outputText>Pora Dnia:</h:outputText>
				<rich:comboBox defaultLabel="Pora dnia" width="100"
					value="#{driveBean.dayHours}">
					<f:selectItem itemValue="6-12" />
					<f:selectItem itemValue="12-18" />
					<f:selectItem itemValue="18-24" />
					<f:selectItem itemValue="24-6" />
				</rich:comboBox>

			</h:panelGroup>
			<h:panelGroup>
				<h:outputText>Ilość miejsc:</h:outputText>
				<rich:inputNumberSpinner inputSize="4"
					value="#{driveBean.placeNumber}" />
			</h:panelGroup>
			<h:panelGroup>
				<h:outputText>Miejsca Palące:</h:outputText>
				<h:selectOneRadio  value="#{driveBean.smoke}">
					<f:selectItem  itemValue="T" itemLabel="tak" />
					<f:selectItem itemValue="N" itemLabel="nie" />
				</h:selectOneRadio>
			</h:panelGroup>
		</h:panelGrid> 
		
	
		<a4j:commandButton value="Szukaj Połączeń"
					action="#{checkDrivesController.searchDrives}">
		</a4j:commandButton>
	
		<br/>
		<br/>
		<br/>
		<a4j:commandButton id="link" value="Pokaż szczegóły"
					action="#{checkDrivesController.takeSelection}">
		</a4j:commandButton>
		<h:panelGrid columns="2" columnClasses="optionList">
			<h:panelGroup>
		    	<rich:scrollableDataTable id="dataTable" rowKeyVar="rkv"
						frozenColCount="8" height="435px;" width="724px" rows="20"
						value="#{checkDrivesController.drives}" var="drive"
						sortMode="single" binding="#{checkDrivesController.table}"
						selection="#{checkDrivesController.selection}" rowClasses="row">
						<rich:column id="fromCountry" width="90px">
							<f:facet name="header">
								<h:outputText styleClass="headerText" value="Skąd" />
							</f:facet>

							<h:outputText value="#{drive.countryFrom.name}" />

						</rich:column>
						<rich:column id="fromCity" width="90px">
							<f:facet name="header">
								<h:outputText styleClass="headerText" value="" />
							</f:facet>

							<h:outputText value="#{drive.cityFrom.name}" />

						</rich:column>
						<rich:column id="fromUlica" width="90px">
							<f:facet name="header">
								<h:outputText styleClass="headerText" value="" />
							</f:facet>


							<h:outputText value="#{drive.streetFrom}" />

						</rich:column>
						<rich:column id="toCountry" width="90px">
							<f:facet name="header">
								<h:outputText styleClass="headerText" value="Gdzie" />
							</f:facet>
							<h:outputText value="#{drive.countryTo.name}" />

						</rich:column>
						<rich:column id="toCity" width="90px">
							<f:facet name="header">
								<h:outputText styleClass="headerText" value="" />
							</f:facet>


							<h:outputText value="#{drive.cityTo.name}" />


						</rich:column>
						<rich:column id="toStreet" width="90px">
							<f:facet name="header">
								<h:outputText styleClass="headerText" value="" />
							</f:facet>
							<h:outputText value="#{drive.streetTo}" />
						</rich:column>
						<rich:column id="date" width="100px">
							<f:facet name="header">
								<h:outputText styleClass="headerText" value="Data" />
							</f:facet>
							<h:outputText value="#{drive.date}" />
						</rich:column>

						<rich:column id="placeNumber" width="80px">
							<f:facet name="header">
								<h:outputText styleClass="headerText" value="Ilość Miejsc" />
							</f:facet>
							<h:outputText value="#{drive.placeNumber}" />
						</rich:column>

					</rich:scrollableDataTable>
					
				
				


			</h:panelGroup>

			<h:panelGroup>

				<rich:panel bodyClass="inpanelBody" style="height:435px;">

					<f:facet name="header">

						<h:outputText>
							<h2 align="center"><h:outputText value="Wyszukiwanie Połączeń" /></h2>
						</h:outputText>

					</f:facet>

					<ul>

						<li>Aby zobaczyć wszystkie połączenia naciśnij przycisk "szukaj połączeń".</li>

						<li>Aby wyszukać konkretne połączenia wprowadź potrzebne dane i ponownie naciśnij przycisk "szukaj połączeń".</li>

						<li>Tabela zawiera wyniki wyszukiwania ułożone po 10 połączeń na każdej stronie tabeli.</li>

						<li>Aby zapisać się na połączenie wybierz konkretną trase poprzez klikniecie myszki i naciśnij przycisk "pokaż szczegóły"</li>

						<li>Otworzy się strona ze szczegółami wybranego połączenia na której można się do niego zapisać</li>

						<li>Tabela ma również możliwośc filtrowania wyszukanych już wyników</li>

					</ul>

				</rich:panel>

			</h:panelGroup>
		</h:panelGrid>
		
			</a4j:form>
		</div>
		<div style="clear: both" />
	</div>


	</div>
	</body>
	</html>
</f:view>
