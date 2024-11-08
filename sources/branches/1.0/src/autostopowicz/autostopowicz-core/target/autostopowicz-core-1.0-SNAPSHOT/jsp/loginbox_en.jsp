<%@ page contentType="text/html; charset=UTF-8"%>
 <f:subview id="loginbox_en">
<div id="loginbox">
	
	<acegijsf:authorize ifAnyGranted="ROLE_USER">
 	 <h:form id="logout">
 		<t:commandLink	style="font-size: small;text-decoration:none;" id="logout" actionListener="#{authenticationController.logout}" value="Logout" />
 		</h:form>
	 
	</acegijsf:authorize>
	<acegijsf:authorize ifNotGranted="ROLE_USER">
	 
	    <p>
	    <h:form id="authenticate">
	    Login<br />
	    <h:inputText size="10" maxlength="15" value="#{authenticationController.username}"/>
	    </p>
	    <p>Password<br />
	    <h:inputText size="10" maxlength="15" value="#{authenticationController.password}"/>
	    </p>
	 	
	 	 <p>	 
	  	 <t:commandLink	 styleClass="submit-button" style="font-size: small;text-decoration:none;" id="authentication" actionListener="#{authenticationController.authenticate}" value="Login" />
	 	</h:form>
	 	</p>
		
	<p>
	<h:form id="Register">
	 <t:commandLink	style="font-size: small;text-decoration:none;" 
	 id="registerController" action="#{registerController.next}" value="Register" />
	</h:form>
	</acegijsf:authorize>
	</p>
	
	<h:form id="selection" style="align:center;">
	<h:selectOneMenu id="Lang"
 		value="#{startPageController.language}" onchange="pulldownChanged()" immediate="true">
 	
  	<f:selectItem 
   	 itemValue="Angielski" itemLabel="English"/>
   	 <f:selectItem
    	itemValue="Polski" itemLabel="Polish"/>
	</h:selectOneMenu> <br />
	<span style="align:center;"><strong>Language</strong></span><br/>
	<h:commandButton style="visibility:hidden;"
            id="changeLanguageButton"
            value="Submit"
            action="#{startPageController.next}"/>
	
	</h:form>	
</div>
</f:subview>
