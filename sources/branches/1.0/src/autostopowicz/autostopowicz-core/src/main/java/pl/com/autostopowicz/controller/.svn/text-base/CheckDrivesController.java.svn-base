package pl.com.autostopowicz.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
import pl.com.autostopowicz.model.CitiesBean;
import pl.com.autostopowicz.model.CountriesBean;
import pl.com.autostopowicz.model.DriveBean;

public class CheckDrivesController {
	// ~ Instance fields
	// ------------------------------------------------------------------------------------------------

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	/** TODO: DOCUMENT ME! */
	private DatabaseManager dataSource;
	private SimpleSelection selection = new SimpleSelection();
	private UIScrollableDataTable table;

	private ArrayList<Drive> selectedDrives = new ArrayList<Drive>();

	private int scrollerPage = 1;

	private static int DECIMALS = 1;
	private static int ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;

	private List<Drive> drives = new ArrayList<Drive>();

	private DriveBean drive;

	private CitiesBean cityBean;
	private CountriesBean countryBean;

	private MailSender mailSender;
	private SimpleMailMessage message;
	private AuthenticationController authenticationBean;

	private String joiningMessage;

	private boolean showMessage = false;

	// ~ Methods
	// --------------------------------------------------------------------------------------------------------
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setMessage(SimpleMailMessage message) {
		this.message = message;

	}

	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public String next() {
		return "check_drives";
	}

	public String next_en() {
		return "check_drives_en";
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

	public List<Drive> searchDrives() {
		drives.clear();
		Drive searchDrive = new Drive();
		searchDrive.setDate(drive.getDate());
		searchDrive.setPlaceNumber(drive.getPlaceNumber());
		searchDrive.setIdCountryFrom(countryBean.getCountriesIds().get(
				drive.getCountryFrom()));
		searchDrive.setIdCountryTo(countryBean.getCountriesIds().get(
				drive.getCountryTo()));
		searchDrive.setIdCityFrom(cityBean.getCitiesIds().get(
				drive.getCityFrom()));
		searchDrive.setIdCityTo(cityBean.getCitiesIds().get(drive.getCityTo()));
		searchDrive.setStreetFrom(drive.getStreetFrom());
		searchDrive.setStreetTo(drive.getStreetTo());
		if (drive != null
				&& drive.getSmoke() != null
				&& (drive.getSmoke().equals("T") || drive.getSmoke()
						.equals("Y"))) {
			searchDrive.setSmoke(true);
		} else {
			searchDrive.setSmoke(false);

		}

		String s = null;
		if (drive.getDate() != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy.MM.dd.HH.mm.ss");
			s = formatter.format(drive.getDate());

		}
		System.out.println("\nSmoke:" + drive.getSmoke() + "\nidCountryFrom:"
				+ countryBean.getCountriesIds().get(drive.getCountryFrom())
				+ "\nidCountryTo:"
				+ countryBean.getCountriesIds().get(drive.getCountryTo())
				+ "\nidCityFrom:"
				+ cityBean.getCitiesIds().get(drive.getCityFrom())
				+ "\nidCityTo:"
				+ cityBean.getCitiesIds().get(drive.getCityTo())
				+ "\nPlace Number:" + drive.getPlaceNumber() + "\nData:" + s
				+ "\nStreet from:" + drive.getStreetFrom() + "\nStreet to:"
				+ drive.getStreetTo() + "\nAccuracy" + drive.getDaysAccuracy());

		List<Drive> results = dataSource.searchDrives(searchDrive, drive
				.getDaysAccuracy());

		drives.addAll(results);

		return drives;

	}

	public List<Drive> getDrives() {
		return drives;
	}

	public void setDrives(List<Drive> drives) {
		this.drives = drives;
	}

	public SimpleSelection getSelection() {
		return selection;
	}

	public void setSelection(SimpleSelection selection) {
		this.selection = selection;
	}

	public String takeSelection() {
		getSelectedDrives().clear();
		Iterator<Object> iterator = getSelection().getKeys();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			table.setRowKey(key);
			if (table.isRowAvailable()) {
				getSelectedDrives().add((Drive) table.getRowData());
			}
		}
		if (getSelectedDrives().size() != 0) {
			return "details";
		}
		return null;
	}

	public String joinDrive() {

		if (authenticationBean != null
				&& authenticationBean.getLoggedInuser() != null) {

			User joiningUser = dataSource.getUser(authenticationBean
					.getLoggedInuser());

			if (dataSource.isActivated(authenticationBean.getLoggedInuser())) {

				setShowMessage(true);
				sendActeptationEmail(joiningUser);
			} else {
				FacesContext
						.getCurrentInstance()
						.addMessage(
								"login",
								new FacesMessage(
										FacesMessage.SEVERITY_ERROR,
										"U¿ytkownik musi byæ aktywny. Prosze aktywuj u¿ytkownika wedlug wskazówek z maila aktywacyjnego",
										null));

			}
		} else {

			FacesContext.getCurrentInstance().addMessage(
					"login",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Musisz byæ zalogowany", null));
		}

		return null;
	}

	private String sendActeptationEmail(User joiningUser) {
		String toReturn = "failure";
		SimpleMailMessage msg = new SimpleMailMessage(this.message);
		Drive drive = selectedDrives.get(0);
		String ownerEmail = drive.getUser().getEmail();
		System.out.println("Email" + ownerEmail);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		String s = formatter.format(drive.getDate());
		msg.setSubject("autostopowicz join acceptation");
		msg.setTo(ownerEmail);
		msg
				.setText("U¿ytkownik "
						+ joiningUser.getLogin()
						+ " chcia³by zabraæ siê Autostopem na Trasie:\n "
						+ "Data: "
						+ s
						+ "\nSk¹d: "
						+ "\nKraj:"
						+ drive.getCountryFrom().getName()
						+ "\nMiasto:"
						+ drive.getCityFrom().getName()
						+ "\nUlica: "
						+ drive.getStreetFrom()
						+ "\nGdzie: "
						+ "\nKraj:"
						+ drive.getCountryTo().getName()
						+ "\nMiasto:"
						+ drive.getCityTo().getName()
						+ "\nUlica: "
						+ drive.getStreetTo()
						+ "\nAby zaakceptowaæ naciœnij poni¿szy link:"
						+ "\nhttp://localhost:8080/Autostopowicz2/jsp/accept.jsf?acceptedUserId="
						+ joiningUser.getIdUser()
						+ "&driveId="
						+ drive.getIdDrive()
						+ "&accept=true"
						+ "\nAby odrzucic naciœnij:"
						+ "\nhttp://localhost:8080/Autostopowicz2/jsp/accept.jsf?acceptedUserId="
						+ joiningUser.getIdUser()
						+ "&driveId="
						+ drive.getIdDrive()
						+ "&accept=false"
						+ "\n\nIf the link above does not work then please\n"
						+ "copy the link and paste it into the location bar to accept the user."

				);

		try {
			mailSender.send(msg);
			toReturn = "success";

		} catch (MailException ex) {
			setJoiningMessage("<ul> "
					+ "<li>Wys³anie emaila akceptacyjnego nie powiod³o siê. Proszê spróbowaæ ponownie.</li> "
					+ "</ul> ");

		}

		return toReturn;
	}

	public String details() {
		return "details";

	}

	public ArrayList<Drive> getSelectedDrives() {
		return selectedDrives;
	}

	public void setSelectedDrives(ArrayList<Drive> selectedCars) {
		this.selectedDrives = selectedCars;
	}

	public UIScrollableDataTable getTable() {
		return table;
	}

	public void setTable(UIScrollableDataTable table) {
		this.table = table;
	}

	public DriveBean getDrive() {
		return drive;
	}

	public void setDrive(DriveBean drive) {
		this.drive = drive;
	}

	public DatabaseManager getDataSource() {
		return dataSource;
	}

	public CitiesBean getCityBean() {
		return cityBean;
	}

	public void setCityBean(CitiesBean cityBean) {
		this.cityBean = cityBean;
	}

	public CountriesBean getCountryBean() {
		return countryBean;
	}

	public void setCountryBean(CountriesBean countryBean) {
		this.countryBean = countryBean;
	}

	public String getJoiningMessage() {
		return joiningMessage;
	}

	public void setJoiningMessage(String joiningMessage) {
		this.joiningMessage = joiningMessage;
	}

	public AuthenticationController getAuthenticationBean() {
		return authenticationBean;
	}

	public void setAuthenticationBean(
			AuthenticationController authenticationBean) {
		this.authenticationBean = authenticationBean;
	}

	public boolean isShowMessage() {
		return showMessage;
	}

	public void setShowMessage(boolean showMessage) {
		this.showMessage = showMessage;
	}

}
