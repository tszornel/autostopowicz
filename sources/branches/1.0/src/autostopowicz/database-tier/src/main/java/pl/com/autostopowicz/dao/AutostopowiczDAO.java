package pl.com.autostopowicz.dao;

import java.util.HashMap;
import java.util.List;

import pl.com.autostopowicz.entities.City;
import pl.com.autostopowicz.entities.Country;
import pl.com.autostopowicz.entities.Drive;
import pl.com.autostopowicz.entities.User;
import pl.com.autostopowicz.entities.Userdrive;

public interface AutostopowiczDAO {
	
	public List<User> getUsers();

	public User getUser(int userId);

	public User getUser(String usrLogin);

	public void saveUser(User user);

	public void updateUser(User user);

	public void removeUser(int userId);

	public boolean uniqueLogin(String login);
	
	public boolean uniqueEmail(String email);
	
	public void saveDrive(Drive drive);
	
	public List<Drive> searchDrives(Drive drive,int daysAccuracy);
	
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
	
	public int unJoinFromDrive(int userId, int driveId);
	
	public void updateDrive(Drive drive);
	
	public  List<User> getUsersForDrive(Integer driveId);
	
	public int removeDriveFromUserDrives(int driveId);
	
	public void saveUserDrive(Userdrive userDrive);
	
	public Drive getDrive(int driveId);
	
}
