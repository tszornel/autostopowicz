package pl.com.autostopowicz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.com.autostopowicz.database.DatabaseManager;
import pl.com.autostopowicz.entities.City;
import pl.com.autostopowicz.entities.Country;
import pl.com.autostopowicz.entities.Drive;
import pl.com.autostopowicz.entities.User;
import pl.com.autostopowicz.entities.Userdrive;


/**
 * This class is the DAO implementation with all the queries needed in the
 * project.
 * 
 * @author $Author: toms $
 * @version 
 */
public class AutostopowiczDAOImpl extends HibernateDaoSupport implements
		AutostopowiczDAO {
	// ~ Static fields/initializers
	// -------------------------------------------------------------------------------------

	// ~ Instance fields
	// ------------------------------------------------------------------------------------------------

	/** Logger */
	Log log = LogFactory.getLog(AutostopowiczDAOImpl.class);

	// ~ Methods
	// --------------------------------------------------------------------------------------------------------

	/**
	 * Query taking out all records from Users table
	 * 
	 * @return List of all Users.
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getHibernateTemplate().find("from User");
	}

	/**
	 * Query taking out User with specified unique id.
	 * 
	 * @param id
	 *            PK of the Users table
	 * 
	 * @return Users user with <code>id</code>
	 */
	public User getUser(int id) {
		return (User) getHibernateTemplate().get(
				pl.com.autostopowicz.entities.User.class, new Integer(id));
	}

	/**
	 * Query that save record to the Users table
	 * 
	 * @param user
	 *            new User that is added to the table.
	 */
	public void saveUser(User user) {
		getHibernateTemplate().save(user);

		if (log.isDebugEnabled()) {
			log.debug("userId set to: " + user.getIdUser());
		}
	}

	public void updateUser(User user) {
		getHibernateTemplate().update(user);

		if (log.isDebugEnabled()) {
			log.debug("userId set to: " + user.getIdUser());
		}
	}

	/**
	 * Query that removes User with the specified unique id form the Users
	 * table.
	 * 
	 * @param id
	 *            PK unique ID of the Users table.
	 */
	public void removeUser(int id) {
		Object user = getHibernateTemplate().load(
				pl.com.autostopowicz.entities.User.class, new Integer(id));
		getHibernateTemplate().delete(user);
	}

	public User getUser(final String usrLogin) {
		return (User) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(User.class);

				User user = (User) criteria.add(
						Restrictions.like("login", usrLogin)).uniqueResult();
				return user;
			}
		});
	}

	public boolean uniqueEmail(final String email) {
		return ((Boolean) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(User.class);
				
				User user = (User)criteria.add(
						Restrictions.like("email", email)).uniqueResult();
			
				
				if (user != null){
					return Boolean.FALSE;
				}
				return Boolean.TRUE;
			}
		})).booleanValue();
	}

	public boolean uniqueLogin(final String login) {
		return ((Boolean) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(User.class);
				
				User user  = (User)criteria.add(
						Restrictions.like("login", login)).uniqueResult();
				if (user != null){
					return Boolean.FALSE;
				}
				return Boolean.TRUE;
					
				
				
			}
		})).booleanValue();
	}

	public void saveDrive(Drive drive) {
		getHibernateTemplate().save(drive);

		if (log.isDebugEnabled()) {
			log.debug("driveId set to: " + drive.getIdDrive());
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<Drive> searchDrives(final Drive drive, final int daysAccuracy) {
				
		return  (List<Drive>) getHibernateTemplate().execute(new HibernateCallback() {
			@SuppressWarnings("unchecked")
			public Object doInHibernate(final Session session)
					throws HibernateException, SQLException {
				int MILLIS_IN_DAY = daysAccuracy * 1000 * 60 * 60 * 24;
				System.out.println(drive);
				Criteria criteria = session.createCriteria(Drive.class);
				List<Drive> result =null;
				if (drive.getIdCountryTo() != null) {
					criteria.add(
						Restrictions.like("idCountryTo", drive.getIdCountryTo()));
				}
				
				if (drive.getIdCountryFrom() != null) {
					criteria.add(
						Restrictions.like("idCountryFrom", drive.getIdCountryFrom()));
				}
				
				if (drive.getIdCityFrom() != null) {
					criteria.add(
						Restrictions.like("idCityFrom", drive.getIdCityFrom()));
				}
				
				if (drive.getIdCityTo() != null) {
					criteria.add(
						Restrictions.like("idCityTo", drive.getIdCityTo()));
				}
				
				if (drive.getIdCountryTo() != null) {
					criteria.add(
						Restrictions.like("idCountryTo", drive.getIdCountryTo()));
				}
				
				if (drive.getIdCountryTo() != null) {
					criteria.add(
						Restrictions.like("idCountryTo", drive.getIdCountryTo()));
				}
				
				if (drive.getDate() != null) {
					
					 criteria.add(
							
							Restrictions.between("date", new Date(drive.getDate().getTime() - MILLIS_IN_DAY), new Date(drive.getDate().getTime() + MILLIS_IN_DAY)));
				}
				
				if (drive.getStreetFrom()!=null && !drive.getStreetFrom().equals("")) {
					criteria.add(
						Restrictions.like("streetFrom", drive.getStreetFrom()));
				}
				
				if ( drive.getStreetTo() !=null &&   !drive.getStreetTo().equals("")) {
					criteria.add(
						Restrictions.like("streetTo",drive.getStreetTo()));
				}
				
				
					criteria.add(
						Restrictions.ge("placeNumber", drive.getPlaceNumber()));
				
				
					criteria.add(
						Restrictions.like("smoke", drive.isSmoke()));
			
				
				result= (List<Drive>)criteria.list();
				return result;
				
			}
		});
		
		
		
	}
	@SuppressWarnings("unchecked")
	public List<String> getCityNames() {
		List<City> cities =  (List<City>)getHibernateTemplate().find("from City");
		List<String> result = null;
		for (City city :cities){
			 result.add(city.getName());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<String> getCountryNames() {
		List<Country> countries = (List<Country>) getHibernateTemplate().find("from Country");
		List<String> result = null;
		for (Country country :countries){
			 result.add(country.getName());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Integer> getCountryMap() {
		List<Country> countries = (List<Country>)getHibernateTemplate().find("from Country");
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		
		for (Country country :countries){
			result.put(country.getName(), country.getIdCountry());
			
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Integer> getCityMap() {
		List<City> cities =  (List<City>)getHibernateTemplate().find("from City");
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		for (City city :cities){
			result.put(city.getName(), city.getIdCountry());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<City> getCities() {
		List<City> result =  (List<City>)getHibernateTemplate().find("from City");
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Country> getCountries() {
		List<Country> result =  (List<Country>)getHibernateTemplate().find("from Country");
		return result;
	}

	public boolean isActivated(final String login) {
		return ((Boolean) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(User.class);
				
				User user  = (User)criteria.add(
						Restrictions.like("login", login)).uniqueResult();
				System.out.println("User status"+user.getStatus());
				if (user != null && user.getStatus() == DatabaseManager.USER_ACTIVATED){
					return Boolean.TRUE;
				}
				return Boolean.FALSE;
					
				
				
			}
		})).booleanValue();
	}

	public void updatePlaceNumber(Integer driveId, boolean increase) {
		Drive drive =  (Drive)getHibernateTemplate().get(
				pl.com.autostopowicz.entities.Drive.class, new Integer(driveId));
		if (increase){
			drive.setPlaceNumber(drive.getPlaceNumber()+1);
		} else {
			drive.setPlaceNumber(drive.getPlaceNumber()-1);
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<Drive> getAddedDrives(final String login) {
		
		return (List<Drive>) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List<Drive> result = new ArrayList();
				Criteria criteria = session.createCriteria(User.class);
				
				User user = (User) criteria.add(
						Restrictions.like("login", login)).uniqueResult();
				if (user!= null && user.getUserDrives()!= null){
					Set<Drive> userDrives = user.getUserDrives();
				
					for (Drive userDrive: userDrives){
						
						if(userDrive.getUser().getIdUser() == user.getIdUser()){
							result.add(userDrive);
						}
					}
				}
				return result;
			}
		});

}

	@SuppressWarnings("unchecked")
	public List<Drive> getJoinedDrives(final String login) {
		System.out.println("Taken login:"+login);
		return (List<Drive>) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List<Drive> result = new ArrayList();
				Criteria criteria = session.createCriteria(User.class);

				User user = (User) criteria.add(
						Restrictions.like("login", login)).uniqueResult();
				if (user!= null && user.getUserDrives()!= null){
					Set<Drive> userDrives = user.getUserDrives();
					for (Drive userDrive: userDrives){
			
						if(userDrive.getUser().getIdUser() != user.getIdUser()){
							result.add(userDrive);
						}
					}
				}
				return result;
			}
		});
	
	}

	public void removeDrive(int driveId) {
		Object drive = getHibernateTemplate().load(
				pl.com.autostopowicz.entities.Drive.class, new Integer(driveId));
		getHibernateTemplate().delete(drive);
		
	}

	public int unJoinFromDrive(final int userId, final int driveId) {
		 final String hql = "delete from Userdrive where idUser = :idUser and idDrive = :idDrive"  ;
	         
	       	
		 return ((Integer)getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				Query query = session.createQuery(hql);
				 query.setInteger("idUser",userId);
				 query.setInteger("idDrive",driveId);
				 
				 return query.executeUpdate();
				
				
			}
		})).intValue();
		 
		
	}

	public void updateDrive(Drive drive) {
		getHibernateTemplate().update(drive);

		if (log.isDebugEnabled()) {
			log.debug("driveId set to: " + drive.getIdDrive());
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsersForDrive(final Integer driveId) {
		System.out.println("Drive Id:"+driveId);
		return (List<User>) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List<User> result = new ArrayList();
				Criteria criteria = session.createCriteria(Drive.class);

				Drive drive = (Drive) criteria.add(
						Restrictions.like("idDrive", driveId)).uniqueResult();
				if (drive!= null && drive.getUsersForDrive()!= null){
					Set<User> usersForDrive = drive.getUsersForDrive();
					
					result.addAll(usersForDrive);
				
				}
				return result;
			}
		});
	
		

	}

	public int removeDriveFromUserDrives(final int driveId) {
		 final String hql = "delete from Userdrive where idDrive = :idDrive"  ;
         
	       	
		 return ((Integer)getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				Query query = session.createQuery(hql);
				
				 query.setInteger("idDrive",driveId);
				 
				 return query.executeUpdate();
				
				
			}
		})).intValue();
	}

	public void saveUserDrive(Userdrive userDrive) {
		getHibernateTemplate().save(userDrive);

		if (log.isDebugEnabled()) {
			log.debug("userdriveId set to: " + userDrive.getIdUserDrive());
		}
		
	}

	public Drive getDrive(int driveId) {
		return (Drive) getHibernateTemplate().get(
				pl.com.autostopowicz.entities.Drive.class, new Integer(driveId));
	}




}
