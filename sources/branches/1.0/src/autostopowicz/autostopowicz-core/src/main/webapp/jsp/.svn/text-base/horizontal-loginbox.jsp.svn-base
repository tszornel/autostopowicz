<%@ page contentType="text/html; charset=UTF-8"%>

<div id="loginbox_subpage"
	style="text-align: right; padding: 1% 1%; margin: 0% 1%; border-right: 1px solid black; border-left: 1px solid black; border-bottom: 1px solid black;">

<h:form id="selection">
<TABLE style="padding-top:6px;" style="width:80%">

<TR>
<acegijsf:authorize ifNotGranted="ROLE_USER">

<TD><h:outputText
				value="Login" /> 

<TD><h:inputText size="10" maxlength="15"
				value="#{authenticationController.username}" id="login" />
<TD><h:outputText value="Hasło" />
<TD><h:inputText size="10"
				maxlength="15" value="#{authenticationController.password}" />
<TD><t:commandLink styleClass="submit-button"
				style="width:30px;padding:2px 12px;font-size: small;text-decoration:none;"
				id="authentication"
				actionListener="#{authenticationController.authenticate}"
				value="Zaloguj" />
<TD> <t:commandLink
				style="font-size: small;text-decoration:none;width: 20px;"
				id="registerController" action="#{registerController.next}"
				value="Zarejestruj się" />
</acegijsf:authorize>

<acegijsf:authorize ifAnyGranted="ROLE_USER">
<TD>	<t:commandLink
				style="width:20px;font-size: small;text-decoration:none;"
				id="logout" actionListener="#{authenticationController.logout}"
				value="Wyloguj" />
			<h:graphicImage value="/images/link.jpg"/>
			<t:commandLink 
				style="width:150px;margin:0px 2px;padding:2px 12px;font-size: small;text-decoration:none;color:black;" id="profileButton"
			value="Profil Użytkownika" action="#{profileController.next}" immediate="true" />
				
</acegijsf:authorize>
</TABLE>
<div style="float:right">
<h:messages style="color:red" layout="table"/>
</div>
</h:form>

</div>

