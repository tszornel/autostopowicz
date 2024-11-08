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
	<div id="header-subpage" class="header6" style="height: 140px;">
	<div id="logo"><span class="centered style1">Auto</span><span
		class="style2">Stop<span class="style3">owicz</span></span></div>
	</div>
	<%@ include file="/jsp/menu.jsp"%>
	<div style="clear: right;"></div>

	<div id="content" class="centered">
	<div id="profile" style="width: 100%; float: left;"><rich:panel
		bodyClass="inpanelBody">

		<f:facet name="header">

			<h2 style=""><h:outputText>Profil Użytkownika</h:outputText></h2>

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

				<h:panelGroup style="width:200px;vertical-align:top">
					<h:outputText value="Login:" />
					<br />

					<h:inputText label="Login" id="login" style="width:200px"
						value="#{profileController.user.login}">
					</h:inputText>
					<br />
					<h:outputText value="Email:" />
					<br />
					<h:inputText label="Email" id="email" style="width:200px"
						value="#{profileController.user.email}">
					</h:inputText>


					<br />
					<h:outputText value="Imię:" />
					<br />
					<h:inputText label="Name" id="Name" style="width:200px"
						value="#{profileController.user.name}">
					</h:inputText>

					<br />
					<h:outputText value="Nazwisko:" />
					<br />
					<h:inputText label="Surname" id="Surname" style="width:200px"
						value="#{profileController.user.surname}">
					</h:inputText>

					<br />
					<h:outputText value="Adres:" />
					<br />
					<h:inputText label="Address" id="Address" style="width:200px"
						value="#{profileController.user.address}">
					</h:inputText>

					<br />
					<h:outputText value="Telefon:" />
					<br />
					<h:inputText label="Phone" id="Phone" style="width:200px"
						value="#{profileController.user.phone}">
					</h:inputText>


					<br />
					<h:outputText value="Dodatkowy opis:" />
					<br />
					<h:inputText label="Description" id="Description"
						style="width:200px" value="#{profileController.user.description}">
					</h:inputText>

					<br />
					<br />
					<h:outputText value="Ranking: #{profileController.user.rank}" />
					<br />
					<br />
					<h:outputText value="Stare Hasło:" />
					<br />
					<h:inputSecret label="OldPasssword" id="oldpassword"
						style="width:200px" value="#{profileController.oldPassword}">

						<f:validateLength minimum="4" />
					</h:inputSecret>
					<br />
					<h:outputText value="Nowe Hasło" />
					<br />
					<h:inputSecret label="NewPassword" id="newpassword"
						style="width:200px" value="#{profileController.newPassword}">

					</h:inputSecret>
					<br />
					<h:outputText value="Potwierdz Nowe Hasło" />
					<br />
					<h:inputSecret label="Confirm" id="confirm" style="width:200px"
						value="#{profileController.confirm}">

					</h:inputSecret>
					<br />
					<br />
					<a4j:commandButton value="Modyfikuj Dane"
						action="#{profileController.verify}" />



				</h:panelGroup>

				<h:panelGroup>
					<a4j:form  id="formAddedDrives" >
					<rich:scrollableDataTable id="driveAdded" rowKeyVar="rkv"
						frozenColCount="8" height="141px;" width="723px" rows="20"
						value="#{profileController.addedUserDrives}" var="drive"
						sortMode="single" binding="#{profileController.addedDrivesTable}"
						selection="#{profileController.addedSelection}" rowClasses="row">
						<f:facet name="header">
							<h2 style=""><h:outputText styleClass="headerText"
								value="Trasy dodane przez użytkownika" /></h2>
						</f:facet>

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
					
					<span style="text-align:left;" id="cancelDrive">
					<a4j:commandButton value="Anuluj połączenie"
						action="#{profileController.cancelAddedDrive}"  reRender="driveAdded"/>
					</span>
					
					</a4j:form>
					<br/>
					<br/>
					<a4j:form id="formJoinedDrives">
					<rich:scrollableDataTable id="driveJoined" rowKeyVar="rkv"
						frozenColCount="8" height="141px;" width="723px" rows="20"
						value="#{profileController.joinedUserDrives}" var="drive"
						sortMode="single" binding="#{profileController.joinedDrivesTable}"
						selection="#{profileController.joinedSelection}" rowClasses="row">
						<f:facet name="header">
							<h2 style=""><h:outputText styleClass="headerText"
								value="Trasy do których użytkownik się zapisał" /></h2>
						</f:facet>
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
					<a4j:commandButton style="text-align:left" value="Anuluj udział"
						action="#{profileController.cancelJoinedDrive}" reRender="driveJoined"/>

					</a4j:form>
				</h:panelGroup>

			</h:panelGrid>

		</h:form>

	</rich:panel></div>
	<div style="clear: both;" /></div>
	</div>
	</div>
	</body>
	</html>
</f:view>