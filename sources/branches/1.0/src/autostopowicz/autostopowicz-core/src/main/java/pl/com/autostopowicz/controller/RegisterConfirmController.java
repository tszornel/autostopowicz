package pl.com.autostopowicz.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.com.autostopowicz.database.DatabaseManager;

public class RegisterConfirmController {
	// ~ Instance fields
	// ------------------------------------------------------------------------------------------------

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	/** DataSource Bean */
	private DatabaseManager dataSource;

	private String activationCode;
	
	private String userId;
	
	private String userLogin;

	private boolean activate = false;
	
	private int counter=0;



	// ~ Methods
	// --------------------------------------------------------------------------------------------------------
	/**
	 * 
	 */
	public String next() {
		return "register";
	}

	/**
	 * 
	 * @return
	 */
	public String next_en() {
		return "register_en";
	}

	/**
	 * 
	 * DataSource Bean setter.
	 * 
	 * @param dataSource
	 *            the dataSource to set
	 */
	public void setDataSource(DatabaseManager dataSource) {
		this.dataSource = dataSource;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isActivate() {
			
		
		counter++;
		if (activationCode != null && userId !=null && userLogin != null && counter==1) {
				
			String code = RegisterController.getActivationCode(userLogin);
		    if(code.equals(activationCode) && userId!= null){
		    	dataSource.activateUserAccount(Integer.parseInt(userId));
		    	return true;
		    }else{
		    	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Aktywacja przebieg³a niepoprawnie"));
		    	return false;
		    }
			

		}
		return false;
	}




	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	



}
