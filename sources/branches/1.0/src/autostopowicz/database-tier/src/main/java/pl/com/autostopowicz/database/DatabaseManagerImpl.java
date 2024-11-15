package pl.com.autostopowicz.database;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import pl.com.autostopowicz.dao.AutostopowiczDAO;
import pl.com.autostopowicz.entities.City;
import pl.com.autostopowicz.entities.Country;
import pl.com.autostopowicz.entities.Drive;
import pl.com.autostopowicz.entities.User;
import pl.com.autostopowicz.entities.Userdrive;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * 
 * @author $Author: toms $
 * @version
 */
public class DatabaseManagerImpl implements DatabaseManager {
	// ~ Static fields/initializers
	// -------------------------------------------------------------------------------------

	/** Logger */
	private static Log log = LogFactory.getLog(DatabaseManagerImpl.class);

	// ~ Instance fields
	// ------------------------------------------------------------------------------------------------

	/** DataSource interface */
	private AutostopowiczDAO autostopowiczDao;

	ApplicationContext ctx;

	// ~ Methods
	// --------------------------------------------------------------------------------------------------------

	public DatabaseManagerImpl(boolean initCtx) {
		if (initCtx) {
			ApplicationContextFactory
					.init(DatabaseManagerImpl.class.getResource(
							"applicationContext-hibernate.xml").toString());
			ctx = ApplicationContextFactory.getApplicationContext();
			autostopowiczDao = (AutostopowiczDAO) ctx
					.getBean("autostopowiczDAO");
		}
	}

	public DatabaseManagerImpl() {

	}

	/**
	 * 
	 * 
	 * @return List of All users.
	 */
	public List<User> getUsers() {
		return autostopowiczDao.getUsers();
	}

	/**
	 * 
	 * 
	 * @param userId
	 * 
	 * 
	 * @return User form the given id.
	 */
	public User getUser(String userId) {

		return autostopowiczDao.getUser(userId);
	}

	/**
	 * Saves User.
	 * 
	 * @param user
	 * 
	 */
	public void saveUser(User user) {
		autostopowiczDao.saveUser(user);

	}

	/**
	 * @param userId
	 * @return User for the given id.
	 */
	public User getUser(int userId) {
		User user = autostopowiczDao.getUser(userId);

		if (user == null) {
			log.warn("UserId " + userId + " not found in database.");
		}

		return user;
	}

	/**
	 * 
	 * 
	 * @param userId
	 *            Removes user form database
	 * 
	 */
	public void removeUser(int userId) {
		autostopowiczDao.removeUser(userId);
	}

	/**
	 * 
	 * DAO
	 * 
	 * @param Dao
	 *            to set
	 */
	public void setDao(AutostopowiczDAO newDao) {
		this.autostopowiczDao = newDao;
	}

	public boolean uniqueLogin(String login) {
		return autostopowiczDao.uniqueLogin(login);

	}

	public boolean uniqueEmail(String email) {
		return autostopowiczDao.uniqueEmail(email);

	}

	public void activateUserAccount(int userId) {
		User activatedUser = autostopowiczDao.getUser(userId);
		if (activatedUser != null) {
			activatedUser.setStatus(1);

			autostopowiczDao.updateUser(activatedUser);
		}

	}

	public void saveDrive(Drive drive) {
		autostopowiczDao.saveDrive(drive);

	}

	public List<Drive> searchDrives(Drive drive, int daysAccuracy) {
		return (List<Drive>) autostopowiczDao.searchDrives(drive, daysAccuracy);
	}

	public List<String> getCityNames() {
		return (List<String>) autostopowiczDao.getCityNames();
	}

	public List<String> getCountryNames() {
		return (List<String>) autostopowiczDao.getCountryNames();
	}

	public HashMap<String, Integer> getCityMap() {

		return (HashMap<String, Integer>) autostopowiczDao.getCityMap();
	}

	public HashMap<String, Integer> getCountryMap() {
		return (HashMap<String, Integer>) autostopowiczDao.getCountryMap();
	}

	public List<Country> getCountries() {

		return (List<Country>) autostopowiczDao.getCountries();
	}

	public List<City> getCities() {
		return (List<City>) autostopowiczDao.getCities();
	}

	public boolean isActivated(String login) {
		return (Boolean) autostopowiczDao.isActivated(login);
	}

	public void updatePlaceNumber(Integer driveId, boolean increase) {
		autostopowiczDao.updatePlaceNumber(driveId, increase);
		
	}

	public List<Drive> getAddedDrives(String login) {
		
		return (List<Drive>)autostopowiczDao.getAddedDrives(login);
	}

	public List<Drive> getJoinedDrives(String login) {
		return (List<Drive>)autostopowiczDao.getJoinedDrives(login);
	}
	
	public void removeDrive(int driveId){
		autostopowiczDao.removeDrive(driveId);
	}

	public void updateUser(User user) {
		autostopowiczDao.updateUser(user);
		
	}

	public int unJoinFromDrive(int userId, int driveId) {
		
		return autostopowiczDao.unJoinFromDrive(userId, driveId);
		
	}

	public void updateDrive(Drive drive) {
	autostopowiczDao.updateDrive(drive);
		
	}

	public List<User> getUsersForDrive(Integer driveId) {
		return autostopowiczDao.getUsersForDrive(driveId);
	}

	public int removeDriveFromUserDrives(int driveId) {
		return autostopowiczDao.removeDriveFromUserDrives(driveId);
	}

	public void joinUserToDrive(int userId, int driveId) {
	    Userdrive userDrive = new Userdrive();
		userDrive.setIdUser(userId);
		userDrive.setIdDrive(driveId);
		autostopowiczDao.saveUserDrive(userDrive);
	}

	public Drive getDrive(int driveId) {
	
		return autostopowiczDao.getDrive(driveId);
	};
}
