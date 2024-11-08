package pl.com.autostopowicz.authentication;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationManager;
import org.acegisecurity.context.HttpSessionContextIntegrationFilter;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.ui.WebAuthenticationDetails;
import org.acegisecurity.ui.webapp.AuthenticationProcessingFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.com.autostopowicz.controller.ProfileController;

public final class AuthenticationController {

 private static final Log LOG = LogFactory.getLog( AuthenticationController.class );

 private String _username;
 private String _password;
 private String loggedInuser;
 

 

 // injected properties
 private AuthenticationManager _authenticationManager;

 public String getPassword() {
     return _password;
 }

 public void setPassword( String password ) {
     _password = password;
 }

 public String getUsername() {
     return _username;
 }

 public void setUsername( String userName ) {
     _username = userName;
 }

 
 public String authenticate( ActionEvent e) {
     String outcome = "failure";
     
     try {
         final String userName = getUsername();
         final String password = getPassword();
       
         final UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
                 userName, password );

         final HttpServletRequest request = getRequest();
         authReq.setDetails( new WebAuthenticationDetails( request ) );

         final HttpSession session = request.getSession();
         session.setAttribute(AuthenticationProcessingFilter.ACEGI_SECURITY_LAST_USERNAME_KEY,userName );
         
         /* perform authentication
          */
         final Authentication auth = getAuthenticationManager().authenticate( authReq );
         
         /* initialize the security context.
          */
         final SecurityContext secCtx = SecurityContextHolder.getContext();
         secCtx.setAuthentication( auth );
         session.setAttribute( HttpSessionContextIntegrationFilter.ACEGI_SECURITY_CONTEXT_KEY, secCtx );
        
         
         
         outcome = "success";
        
        setLoggedInuser(userName);
        
   
     } catch ( Exception ex ) {
         outcome = "failure";
       
        
         FacesContext.getCurrentInstance().addMessage("login", new FacesMessage("B³¹d logowania"));
     }
  
     return outcome;
 }

 
 public String authenticateAfterActivation() {
     String outcome = null;
     setLoggedInuser(null);
     try {
         final String userName = getUsername();
         final String password = getPassword();
        
         final UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
                 userName, password );

         final HttpServletRequest request = getRequest();
         authReq.setDetails( new WebAuthenticationDetails( request ) );

         final HttpSession session = request.getSession();
         session.setAttribute(AuthenticationProcessingFilter.ACEGI_SECURITY_LAST_USERNAME_KEY,userName );
         
         /* perform authentication
          */
         final Authentication auth = getAuthenticationManager().authenticate( authReq );
         setLoggedInuser(userName);
         
         
         /* initialize the security context.
          */
         final SecurityContext secCtx = SecurityContextHolder.getContext();
         secCtx.setAuthentication( auth );
         session.setAttribute( HttpSessionContextIntegrationFilter.ACEGI_SECURITY_CONTEXT_KEY, secCtx );
         setLoggedInuser(userName);
      
        // outcome = "profile";
         session.setAttribute("login",userName);
        
       
       
     } catch ( Exception ex ) {
                 
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("B³¹d logowania"));
     }
  
     return outcome;
 }
 
 
 public void logout(ActionEvent e) {
	 setLoggedInuser(null);
     final HttpServletRequest request = getRequest();
     request.getSession( false ).removeAttribute( HttpSessionContextIntegrationFilter.ACEGI_SECURITY_CONTEXT_KEY );
  
     /* simulate the SecurityContextLogoutHandler
      */
     SecurityContextHolder.clearContext();
  
     request.getSession( false ).invalidate();
 }

 private HttpServletRequest getRequest() {
     return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
 }

 public AuthenticationManager getAuthenticationManager() {
     return _authenticationManager;
 }


 public void setAuthenticationManager(
         AuthenticationManager authenticationManager ) {
     _authenticationManager = authenticationManager;
 }

public String getLoggedInuser() {
	return loggedInuser;
}

public void setLoggedInuser(String loggedInuser) {
	this.loggedInuser = loggedInuser;
}



}
