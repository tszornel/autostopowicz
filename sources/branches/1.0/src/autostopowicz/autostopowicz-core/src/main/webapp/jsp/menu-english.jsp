<%@ page contentType="text/html; charset=UTF-8"%>

<div id="menu" >
<h:form style="display:inline;text-align:center;">

<h:graphicImage value="/images/link.jpg"/>

 <t:commandLink	styleClass="nounderline" id="startPageController" action="#{startPageController.next}" value="Strona Domowa" />
<h:graphicImage value="/images/link.jpg"/>
<t:commandLink styleClass="nounderline" id="checkDrivesController" action="#{checkDrivesController.next}" value="Szukaj Tras" />  
<h:graphicImage value="/images/link.jpg"/> 
<t:commandLink styleClass="nounderline" id="addDriveController" action="#{addDriveController.next}"	value="Dodaj Połączenie" /> 
<h:graphicImage value="/images/link.jpg"/>
<t:commandLink styleClass="nounderline" id="commentsArticlesController" action="#{commentsArticlesController.next}"	value="Opinie/Artykuły" /> 
<h:graphicImage value="/images/link.jpg"/>	 
<t:commandLink styleClass="nounderline" id="helpController" action="#{helpController.next}" value="Pomoc" />
</h:form>
</div>
