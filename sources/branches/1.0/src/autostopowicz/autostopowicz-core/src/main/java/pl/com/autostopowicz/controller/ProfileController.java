package pl.com.autostopowicz.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.richfaces.component.UIScrollableDataTable;
import org.richfaces.model.selection.SimpleSelection;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import pl.com.autostopowicz.authentication.AuthenticationController;
import pl.com.autostopowicz.database.DatabaseManager;
import pl.com.autostopowicz.entities.Drive;
import pl.com.autostopowicz.entities.User;

public class ProfileController {
	// ~ Instance fields
	// ------------------------------------------------------------------------------------------------

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private String authorizedUser;

	private AuthenticationController authenticationBean;

	private int scrollerPage = 1;

	private List<Drive> addedUserDrives;
	private List<Drive> joinedUserDrives;

	private String confirm = "";
	private String oldPassword = "";
	private String newPassword = "";

	private String currentLogin;
	private String currentEmail;

	private boolean validEmail = false;
	private boolean validLogin = false;
	private boolean verified = false;

	private User user;

	private DatabaseManager dataSource;

	private MailSender mailSender;

	private SimpleMailMessage message;

	private SimpleSelection addedSelection = new SimpleSelection();

	private SimpleSelection joinedSelection = new SimpleSelection();

	private UIScrollableDataTable addedDrivesTable;

	private UIScrollableDataTable joinedDrivesTable;

	private ArrayList<Drive> selectedAddedDrives = new ArrayList<Drive>();

	private ArrayList<Drive> selectedJoinedDrives = new ArrayList<Drive>();

	// ~ Methods
	// --------------------------------------------------------------------------------------------------------

	public String next() {
		 final HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		final HttpSession session = request.getSession(false);
		if (authenticationBean.getLoggedInuser() != null) {
			
			String loginFromSession = (String)session.getAttribute("login");
			
			System.out.println("User login form session"+loginFromSession);
			System.out.println("User login ");
			user = dataSource.getUser(authenticationBean.getLoggedInuser());
			this.currentLogin = user.getLogin();
			this.currentEmail = user.getEmail();
			return "profile";
		}
		FacesContext
				.getCurrentInstance()
				.addMessage(
						"login",
						new FacesMessage(
								"Musisz byæ zalogowanym u¿ytkownikiem ¿eby obejrzeæ swój Profil"));
		return null;

	}
	
	public String nextAfterRegistration() {
	
		authenticationBean.authenticateAfterActivation();
		
		if (authenticationBean.getLoggedInuser() != null) {
			
						
			
			System.out.println("User login "+authenticationBean.getLoggedInuser());
			user = dataSource.getUser(authenticationBean.getLoggedInuser());
			this.currentLogin = user.getLogin();
			this.currentEmail = user.getEmail();
			return "profile";
		}
		FacesContext
				.getCurrentInstance()
				.addMessage(
						"login",
						new FacesMessage(
								"Musisz byæ zalogowanym u¿ytkownikiem ¿eby obejrzeæ swój Profil"));
		return null;

	}

	public String cancelAddedDrive() {

		getSelectedAddedDrives().clear();
		Iterator<Object> iterator = getAddedSelection().getKeys();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			addedDrivesTable.setRowKey(key);
			if (addedDrivesTable.isRowAvailable()) {
				getSelectedAddedDrives().add(
						(Drive) addedDrivesTable.getRowData());
			}
		}
		if (getSelectedAddedDrives().size() != 0) {

			for (Drive drive : getSelectedAddedDrives()) {

				List<User> users =  dataSource.getUsersForDrive(drive.getIdDrive());
				
			
				for (User user : users) {

					sendResignationEmail(user);
				}

				dataSource.removeDriveFromUserDrives(drive.getIdDrive());
				dataSource.removeDrive(drive.getIdDrive());

			}

		}
		return null;

	}

	private String sendResignationEmail(User newUser) {
		String toReturn = "failure";
		SimpleMailMessage msg = new SimpleMailMessage(this.message);
		msg.setSubject("Autostopowicz. Anulowana Trasa.");
		msg.setTo(newUser.getEmail());
		msg
				.setText("U¿ytkownik "
						+ authenticationBean.getLoggedInuser()
						+ " anulowa³ po³¹cznie."
						+ "\nAby wyszukaæ inne po³¹czenie kliknij poni¿szy link"
						+ "\nhttp://localhost:8080/Autostopowicz2/jsp/CheckDrives.jsf"
						+ "\nIf the link above does not work then please\n"
						+ "copy the activate link and paste it into the location bar to activate your account:"

				);

		try {
			mailSender.send(msg);
			toReturn = "success";
			FacesContext
					.getCurrentInstance()
					.addMessage(
							"registerForm",
							new FacesMessage(
									"Email informacyjny zosta³ wys³any do osób które zapisa³y sie na po³¹czenie."));
		} catch (MailException ex) {
			System.out.println("Register failure");
			//FacesContext ctx = FacesContext.getCurrentInstance();
			//ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Wys³anie emaila informacyjnego nie powiod³o siê.", null));

		}

		return toReturn;

	}

	public String cancelJoinedDrive() {

		getJoinedUserDrives().clear();
		Iterator<Object> iterator = getJoinedSelection().getKeys();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			joinedDrivesTable.setRowKey(key);
			if (joinedDrivesTable.isRowAvailable()) {
				getSelectedJoinedDrives().add(
						(Drive) joinedDrivesTable.getRowData());
			}
		}
		if (getSelectedJoinedDrives().size() != 0) {
			// cancel join drive and send email to the owner and update drive places

			for (Drive drive : getSelectedJoinedDrives()) {

				dataSource.unJoinFromDrive(this.user.getIdUser(), drive
						.getIdDrive());
				drive.setPlaceNumber(drive.getPlaceNumber()+1);
				dataSource.updateDrive(drive);
				sendUnJoinEmail(drive.getUser(), drive);
			}

		}
		FacesContext
		.getCurrentInstance()
		.addMessage(
				"registerForm",
				new FacesMessage(
						"Zrezygnowa³eœ z podró¿y. Email informacyjny zosta³ wys³any do Kierowcy."));
		return null;
	}

	private String sendUnJoinEmail(User newUser, Drive drive) {
		String toReturn = "failure";
		SimpleMailMessage msg = new SimpleMailMessage(this.message);
		msg.setSubject("Autostopowicz. Anulowanie uczestnictwa. ");
		msg.setTo(newUser.getEmail());
		msg.setText("U¿ytkownik" + authenticationBean.getLoggedInuser()
				+ "zrezygnowa³ z utworzonej przez Ciebie trasy." + "Skad:"
				+ "\nKraj:" + drive.getCountryFrom() + " Miasto: "
				+ drive.getCityFrom() + " Ulica: " + drive.getStreetFrom()
				+ "\nGdzie:" + "\n" + "\nKraj:" + drive.getCountryTo()
				+ " Miasto: " + drive.getCityTo() + " Ulica: "
				+ drive.getStreetTo()

		);

		try {
			mailSender.send(msg);
			toReturn = "success";
			FacesContext.getCurrentInstance().addMessage(
					"registerForm",
					new FacesMessage(
							"Email informacyjny zosta³ wys³any do kierowcy."));
		} catch (MailException ex) {
			System.out.println("Register failure");
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Wys³anie emaila informacyjnego nie powiod³o siê.", null));

		}

		return toReturn;

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

			dataSource.updateUser(user);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Dane zosta³y uaktualnione.", null));
		}

		return "notveryfied";
	}

	public static boolean isEmail(String inputEmail) {
		inputEmail = inputEmail.trim();
		String strRegex = "^([\\w]+)(([-\\.][\\w]+)?)*@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

		// Pattern email = Pattern.compile("^\\S+@\\S+$");
		Pattern email = Pattern.compile(strRegex);
		Matcher fit = email.matcher(inputEmail);
		if (fit.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateEmail() {

		if (isEmail(user.getEmail())) {

			if (!user.getEmail().equals(currentEmail)
					&& !dataSource.uniqueEmail(user.getEmail())) {

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

	public boolean validPassword() {

		if (newPassword != null && !newPassword.equals("")) {

			if (oldPassword.equals(user.getPassword())) {
				if (newPassword.equals(confirm)) {

					return true;
				}
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(
										FacesMessage.SEVERITY_ERROR,
										"Has³o nie jest zgodne z potwierdzeniem",
										null));
				return false;

			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Niepoprawne stare has³o", null));
				return false;

			}

		}
		return true;
	}

	public boolean validateLogin() {

		if (!user.getLogin().equals(currentLogin)
				&& !dataSource.uniqueLogin(user.getLogin())) {

			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Wybrany logi jest ju¿ zarejestrowany w systemie. Proszê wybraæ inny.",
									null));
			return false;
		}
		return true;
	}

	/**
	 * 
	 * DOCUMENT ME!
	 * 
	 * @param dataSource
	 *            the dataSource to set
	 */
	public void setDataSource(DatabaseManager dataSource) {
		this.dataSource = dataSource;
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

	public DatabaseManager getDataSource() {
		return dataSource;
	}

	public List<Drive> getAddedUserDrives() {

		if (dataSource.getAddedDrives(getAuthorizedUser()) != null) {
			addedUserDrives = dataSource.getAddedDrives(getAuthorizedUser());
		}
		return addedUserDrives;
	}

	public void setAddedUserDrives(List<Drive> addedUserDrives) {
		this.addedUserDrives = addedUserDrives;
	}

	public List<Drive> getJoinedUserDrives() {
		if (dataSource.getAddedDrives(getAuthorizedUser()) != null) {
			joinedUserDrives = dataSource.getJoinedDrives(getAuthorizedUser());
		}
		return joinedUserDrives;
	}

	public void setJoinedUserDrives(List<Drive> joinedUserDrives) {
		this.joinedUserDrives = joinedUserDrives;
	}

	public String getAuthorizedUser() {
		return authenticationBean.getLoggedInuser();
	}

	public AuthenticationController getAuthenticationBean() {
		return authenticationBean;
	}

	public void setAuthenticationBean(
			AuthenticationController authenticationBean) {
		this.authenticationBean = authenticationBean;
	}

	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getCurrentLogin() {
		return currentLogin;
	}

	public void setCurrentLogin(String currentLogin) {
		this.currentLogin = currentLogin;
	}

	public String getCurrentEmail() {
		return currentEmail;
	}

	public void setCurrentEmail(String currentEmail) {
		this.currentEmail = currentEmail;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public SimpleSelection getAddedSelection() {
		return addedSelection;
	}

	public void setAddedSelection(SimpleSelection addedSelection) {
		this.addedSelection = addedSelection;
	}

	public SimpleSelection getJoinedSelection() {
		return joinedSelection;
	}

	public void setJoinedSelection(SimpleSelection joinedSelection) {
		this.joinedSelection = joinedSelection;
	}

	public UIScrollableDataTable getAddedDrivesTable() {
		return addedDrivesTable;
	}

	public void setAddedDrivesTable(UIScrollableDataTable addedDrivesTable) {
		this.addedDrivesTable = addedDrivesTable;
	}

	public UIScrollableDataTable getJoinedDrivesTable() {
		return joinedDrivesTable;
	}

	public void setJoinedDrivesTable(UIScrollableDataTable joinedDrivesTable) {
		this.joinedDrivesTable = joinedDrivesTable;
	}

	public ArrayList<Drive> getSelectedAddedDrives() {
		return selectedAddedDrives;
	}

	public void setSelectedAddedDrives(ArrayList<Drive> selectedAddedDrives) {
		this.selectedAddedDrives = selectedAddedDrives;
	}

	public ArrayList<Drive> getSelectedJoinedDrives() {
		return selectedJoinedDrives;
	}

	public void setSelectedJoinedDrives(ArrayList<Drive> selectedJoinedDrives) {
		this.selectedJoinedDrives = selectedJoinedDrives;
	}

	public void setAuthorizedUser(String authorizedUser) {
		this.authorizedUser = authorizedUser;
	}

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public SimpleMailMessage getMessage() {
		return message;
	}

	public void setMessage(SimpleMailMessage message) {
		this.message = message;
	}

}
