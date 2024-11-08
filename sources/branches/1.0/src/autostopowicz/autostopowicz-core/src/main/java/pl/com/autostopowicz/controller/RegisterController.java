package pl.com.autostopowicz.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import pl.com.autostopowicz.database.DatabaseManager;
import pl.com.autostopowicz.entities.User;

public class RegisterController {
	// ~ Instance fields
	// ------------------------------------------------------------------------------------------------

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	/** DataSource Bean */
	private DatabaseManager dataSource;

	private String login;
	/**
	 * Password confirmation
	 */
	private String password;
	private String confirm;
	
	private boolean notConfirmedRegistration=true;

	private String email;

	private boolean validEmail = false;
	private boolean validLogin = false;

	private boolean verified = false;

	private MailSender mailSender;
	private SimpleMailMessage message;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setMessage(SimpleMailMessage message) {
		this.message = message;
	}

	// ~ Methods
	// --------------------------------------------------------------------------------------------------------
	
	
	
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isValidEmail() {
		return validEmail;
	}

	public void setValidEmail(boolean validEmail) {
		this.validEmail = validEmail;
	}

	public boolean isValidLogin() {
		return validLogin;
	}

	public void setValidLogin(boolean validLogin) {
		this.validLogin = validLogin;
	}

	/**
	 * Registration validation
	 */
	public String verify() {

		boolean validPass = validPassword();

		boolean validLog = validateLogin();

		boolean validEm = validateEmail();
		System.out.println(validLog);
		System.out.println(validEm);

		verified = validPass && validEm && validLog;

		if (verified) {
			return "verified";
		}

		return "notveryfied";
	}

	public static boolean isEmail(String inputEmail)
	{
	   inputEmail  = inputEmail.trim();
	   String strRegex = "^([\\w]+)(([-\\.][\\w]+)?)*@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	  
	//   Pattern email = Pattern.compile("^\\S+@\\S+$");
	   Pattern email = Pattern.compile(strRegex);
       Matcher fit = email.matcher(inputEmail);
               if (fit.matches()) {
                      return true;
               } else {
                     return false;
               }
	}
	
	public boolean validateEmail() {
		
		if (isEmail(email)){
			
			if (!dataSource.uniqueEmail(email)) {

				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(
										FacesMessage.SEVERITY_ERROR,
										"Wybrany email jest ju¿ zarejestrowany w systemie. Proszê wybraæ inny.",
										null));
				return false;
			}
			return true;
		}
		
		FacesContext
		.getCurrentInstance()
		.addMessage(
				null,
				new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Niepoprawny adres email. Poprawna form: name@domain.name.",
						null));
		return false;
		
		
	}

	/**
	 * 
	 * @param memberName
	 * @return
	 */
	public static String getActivationCode(String memberName) {
		String raw = "TrueRunes".concat(memberName);
		return DigestUtils.md5Hex(raw);
	}

	/**
	 * 
	 * @return
	 */
	public boolean validPassword() {

		if (password != null && confirm != null && password.equals(confirm)) {
			// newMember.setPasswordHash(DigestUtils.shaHex(password));

			return true;
		}
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Has³o nie jest zgodne z potwierdzeniem", null));
		return false;
	}

	public boolean validateLogin() {

	
		if (!dataSource.uniqueLogin(login)) {

			
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Wybrany login jest ju¿ zarejestrowany w systemie. Proszê wybraæ inny.",
							null));

			return false;

		}

		return true;
	}

	public String confirmAction() {
		setNotConfirmedRegistration(false);
		return "register";
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String register(ActionEvent e) throws Exception {
		String toReturn = "failure";
		
		User newUser = createNewUser();
		if (newUser.getIdUser() != 0){
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Nowy u¿ytkownik zosta³ utworzony.", null));
			toReturn = sendRegistrationEmail(newUser);
			
		}else{
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"B³¹d podczas tworzenia urzytkownika. Prosze spróbuj ponownie.", null));
			
		}
		if (toReturn.equals("success")){
			setNotConfirmedRegistration(false);
			
		}	
				
		return toReturn;
	}

	private User createNewUser() {
		User newUser = new User();
		newUser.setLogin(login);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setRank(1);
		newUser.setRole(DatabaseManager.ROLE_USER);
		
		
			dataSource.saveUser(newUser);
			
		
		return newUser;
	}

	private String sendRegistrationEmail(User newUser) {
		String toReturn = "failure";
		SimpleMailMessage msg = new SimpleMailMessage(this.message);

		msg.setTo(email);
		msg
				.setText("Please click the following link to activate your account:\n"
						+ "http://localhost:8080/Autostopowicz2/jsp/activate.jsf?userLogin="
						+ newUser.getLogin()
						+ "&activationCode="
						+ getActivationCode(newUser.getLogin())
						+ "&userId="
						+ newUser.getIdUser()
						+ "\nIf the link above does not work then please\n"
						+ "copy the activate link and paste it into the location bar to activate your account:"

				);

		try {
			mailSender.send(msg);
			toReturn = "success";
			FacesContext.getCurrentInstance().addMessage(
					"registerForm",
					new FacesMessage("Email rejestracyjny zosta³ wys³any."));
			
			FacesContext.getCurrentInstance().addMessage(
					"registerForm",
					new FacesMessage("Aktywuj nowego u¿ytkownika i ciesz siê jazd¹ Autostopem."));
		} catch (MailException ex) {
			System.out.println("Register failure");
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Wys³anie emaila rejestracyjnego nie powiod³o siê. Proszê spróbowaæ ponownie.",
									null));

		}
		
		
		return toReturn;

	}

	
	public boolean isNotConfirmedRegistration() {
		return notConfirmedRegistration;
	}

	public void setNotConfirmedRegistration(boolean notConfirmedRegistration) {
		this.notConfirmedRegistration = notConfirmedRegistration;
	}

}
