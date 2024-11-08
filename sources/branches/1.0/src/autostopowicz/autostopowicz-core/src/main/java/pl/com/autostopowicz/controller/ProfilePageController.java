package pl.com.autostopowicz.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import pl.com.autostopowicz.authentication.AuthenticationController;
import pl.com.autostopowicz.database.DatabaseManager;

public class ProfilePageController{
	  //~ Instance fields ------------------------------------------------------------------------------------------------

    /** Logger for this class and subclasses */
    protected final static Log logger = LogFactory.getLog(ProfilePageController.class);

    /** TODO: DOCUMENT ME! */
    private DatabaseManager dataSource;
    
	private MailSender mailSender;
	private SimpleMailMessage message;
	private AuthenticationController authenticationBean;
    
    //public String hello = "HELLO";
    

    
    private String localePath = "pl.com.autostopowicz.locale.Locale_pl";
    
    private static TreeMap<String, String> localePaths = new TreeMap<String, String>();

    //~ Methods --------------------------------------------------------------------------------------------------------
 
           
    public String next(){
    	return "home_page";
    }
    
  

	public String next_en(){
           	return "home_page_en";
    }
    
  
    /**
     *  
    DOCUMENT ME!
     *
     *  @param dataSource the dataSource to set
     */
    public void setDataSource(DatabaseManager dataSource) {
        this.dataSource = dataSource;
    }



	public SimpleMailMessage getMessage() {
		return message;
	}



	public void setMessage(SimpleMailMessage message) {
		this.message = message;
	}



	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}



	public void setLocalePath(String localePath) {
		this.localePath = localePath;
	}   
    

	
}
