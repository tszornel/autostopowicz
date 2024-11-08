package pl.com.autostopowicz.database;

import java.util.HashMap;
import java.util.List;

import pl.com.autostopowicz.entities.City;
import pl.com.autostopowicz.entities.Country;
import pl.com.autostopowicz.entities.Drive;
import pl.com.autostopowicz.entities.User;

public interface DatabaseManager {

	public static final int ROLE_ADMIN = 1;

	public static final int ROLE_USER = 2;

	public static final int USER_INACTIVATED = 0;

	public static final int USER_ACTIVATED = 1;

	public List<User> getUsers();

	public User getUser(int userId);

	public void saveUser(User user);

	public void removeUser(int userId);

	public User getUser(String login);

	public boolean uniqueLogin(String login);

	public boolean uniqueEmail(String email);

	public void activateUserAccount(int userId);

	public void saveDrive(Drive drive);

	public List<Drive> searchDrives(Drive drive, int daysAccuracy);

	public List<String> getCountryNames();

	public List<String> getCityNames();

	public HashMap<String, Integer> getCityMap();

	public HashMap<String, Integer> getCountryMap();
	
public List<Country> getCountries();
	
	public List<City> getCities();
	
public boolean isActivated(String login);
	
	public void updatePlaceNumber(Integer driveId, boolean increase);
	
	public List<Drive> getAddedDrives(String login);
	
	public List<Drive> getJoinedDrives(String login);
	
	public void removeDrive(int driveId);
	
	public void updateUser(User user);
	
	public int unJoinFromDrive(int userId, int driveId);
	
	public void updateDrive(Drive drive);	
	
	public  List<User> getUsersForDrive(Integer driveId);
	
	public int removeDriveFromUserDrives(int driveId);
	
	public void joinUserToDrive(int userId, int driveId);

	public Drive getDrive(int driveId);
	
}
