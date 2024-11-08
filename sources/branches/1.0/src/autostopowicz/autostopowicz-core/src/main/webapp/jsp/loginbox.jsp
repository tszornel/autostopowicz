<%@ page contentType="text/html; charset=UTF-8"%>
 <f:subview id="loginbox">
<div id="loginbox">
	
	<acegijsf:authorize ifAnyGranted="ROLE_USER">
 	 <h:form id="logout">
 		<t:commandLink	style="font-size: small;text-decoration:none;" id="logout" actionListener="#{authenticationController.logout}" value="Wyloguj" />
 	</h:form>
	 
	</acegijsf:authorize>
	<acegijsf:authorize ifNotGranted="ROLE_USER">
	    <p>
	    <h:form id="authenticate">
	    <h:messages style="color: black"/><br/>
	    Login<br />
	    <h:inputText size="10" maxlength="15" value="#{authenticationController.username}"/>
	    </p>
	    <p>Hasło<br />
	    <h:inputText size="10" maxlength="15" value="#{authenticationController.password}"/>
	    </p>
	 	
	 	 <p>	 
	  	 <t:commandLink	styleClass="submit-button" style="padding:2px 12px;font-size: small;text-decoration:none;" id="authentication" actionListener="#{authenticationController.authenticate}" value="Zaloguj" />
	 	 </p>
	 	</h:form>
	 
		<br/>
	<h:form id="Register">
	 <t:commandLink	style="font-size: small;text-decoration:none;" 
	 id="registerController" action="#{registerController.next}" value="Zarejestruj się" />
	</h:form>
	</acegijsf:authorize>

	
	<h:form id="selection" style="align:center;">
	<h:selectOneMenu id="Lang"
 		value="#{startPageController.language}" onchange="pulldownChanged()" immediate="true">
 	<f:selectItem
    	itemValue="Polski" itemLabel="Polski"/>
  	<f:selectItem 
   	 itemValue="Angielski" itemLabel="Angielski"/>
	</h:selectOneMenu> <br />
	<span style="align:center;"><strong>Język</strong></span><br/>
	<t:commandButton style="visibility:hidden;"
            id="changeLanguageButton"
            value="Submit"
            action="#{startPageController.next_en}"/>
			
	</h:form>	
</div>
</f:subview>
