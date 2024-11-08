package pl.com.autostopowicz.controller;

import java.text.SimpleDateFormat;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.com.autostopowicz.authentication.AuthenticationController;
import pl.com.autostopowicz.database.DatabaseManager;
import pl.com.autostopowicz.entities.Drive;
import pl.com.autostopowicz.entities.User;
import pl.com.autostopowicz.model.CitiesBean;
import pl.com.autostopowicz.model.CountriesBean;
import pl.com.autostopowicz.model.DriveBean;
import pl.com.autostopowicz.model.GMapBean;

public class AddDriveController {
	// ~ Instance fields
	// ------------------------------------------------------------------------------------------------

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	/** TODO: DOCUMENT ME! */
	private DatabaseManager dataSource;

	private GMapBean gmBean;

	private CitiesBean cityBean;
	private CountriesBean countryBean;

	private AuthenticationController authenticationBean;

	private DriveBean drive;

	// ~ Methods
	// --------------------------------------------------------------------------------------------------------

	public String next() {
		return "add_drive";
	}

	public String next_en() {
		return "add_drive_en";
	}

	/**
	 * 
	 * 
	 * @param dataSource
	 *            the dataSource to set
	 */
	public void setDataSource(DatabaseManager dataSource) {
		this.dataSource = dataSource;
	}

	public GMapBean getGmBean() {
		return gmBean;
	}

	public void setGmBean(GMapBean gmBean) {
		this.gmBean = gmBean;
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

	public AuthenticationController getAuthenticationBean() {
		return authenticationBean;
	}

	public void setAuthenticationBean(
			AuthenticationController authenticationBean) {
		this.authenticationBean = authenticationBean;
	}

	public void validateAndAddDrive() {
		if (authenticationBean != null
				&& authenticationBean.getLoggedInuser() != null) {

			User loggedUser = dataSource.getUser(authenticationBean
					.getLoggedInuser());

			if (dataSource.isActivated(authenticationBean.getLoggedInuser())) {

				addDrive();
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

	}

	private void addDrive() {

		// dodawanie po³¹czenia
		Drive addDrive = new Drive();

		addDrive.setDate(drive.getDate());
		addDrive.setPlaceNumber(drive.getPlaceNumber());
		addDrive.setIdCountryFrom(countryBean.getCountriesIds().get(
				addDrive.getCountryFrom()));
		addDrive.setIdCountryTo(countryBean.getCountriesIds().get(
				drive.getCountryTo()));
		addDrive
				.setIdCityFrom(cityBean.getCitiesIds().get(drive.getCityFrom()));
		addDrive.setIdCityTo(cityBean.getCitiesIds().get(drive.getCityTo()));
		addDrive.setStreetFrom(drive.getStreetFrom());
		addDrive.setStreetTo(drive.getStreetTo());
		if (drive != null
				&& drive.getSmoke() != null
				&& (drive.getSmoke().equals("T") || drive.getSmoke()
						.equals("Y"))) {
			addDrive.setSmoke(true);
		} else {
			addDrive.setSmoke(false);

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

		dataSource.saveDrive(addDrive);

	}

	public DriveBean getDrive() {
		return drive;
	}

	public void setDrive(DriveBean drive) {
		this.drive = drive;
	}

}
