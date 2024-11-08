package pl.com.autostopowicz.dao;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.com.autostopowicz.database.DatabaseManager;
import pl.com.autostopowicz.entities.Drive;
import pl.com.autostopowicz.entities.User;
import pl.com.autostopowicz.entities.Userdrive;


public class BaseDAOTest extends TestCase {
	

	
	protected ApplicationContext ctx;

	protected AutostopowiczDAO dao = null;

	protected Log log;

	protected DatabaseManager db;

	protected void setUp() throws Exception {
		log = LogFactory.getLog(BaseDAOTest.class);
		String[] paths = { this.getClass().getResource("applicationContext-hibernate.xml").toString() };
		ctx = new ClassPathXmlApplicationContext(paths);
		dao = (AutostopowiczDAO) ctx.getBean("autostopowiczDAO");
		
	}

	protected void tearDown() throws Exception {
		db = null;
		dao = null;
		
	}
	
	
//	public void testUniqueLogin(){
//		//assertFalse(dao.uniqueLogin("__-1856152989"));
//	
//		assertTrue(dao.uniqueLogin("toms"));
//	
//		
//	}
//	
//	public void testUniqueEmail(){
//		//assertFalse(dao.uniqueLogin("__-1856152989"));
//	System.out.println(dao.uniqueEmail("__-1856152989"));
//		assertTrue(dao.uniqueEmail("__-1856152989"));
//	
//		
//	}
	
	
//	public void testSaveDrive(){
//		
//		Drive searchDrive = new Drive();
//		Date date = new Date();
//	    // Some examples
//	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
//	    String s = formatter.format(date);
//	    searchDrive.setIdUser(41);
//	    searchDrive.setDate(date);
//		searchDrive.setPlaceNumber(2);
//    	searchDrive.setPrice(10);
//    	searchDrive.setIdCountryFrom(1);
//    	searchDrive.setIdCountryTo(1);
//    	searchDrive.setIdCityFrom(1);
//    	searchDrive.setIdCityTo(2);
//    	searchDrive.setSmoke(false);
//    	searchDrive.setStreetFrom("Centralna");
//    	searchDrive.setStreetTo("Woloska");
//    	searchDrive.setIdCar(1);
//    	dao.saveDrive(searchDrive);
//		
//	}
	
//	public void testSearchDrives(){
//		
//		Drive searchDrive = new Drive();
//		Date date = new Date();
//	    // Some examples
////	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
////	    String s = formatter.format(date);
//	    searchDrive.setDate(date);
//		searchDrive.setPlaceNumber(1);
//     	searchDrive.setIdCountryFrom(1);
//    	searchDrive.setIdCountryTo(1);
//    	searchDrive.setIdCityFrom(1);
//    	searchDrive.setIdCityTo(2);
//    	searchDrive.setSmoke(false);
//    	searchDrive.setStreetFrom("Centralna");
//       	List<Drive> result  = dao.searchDrives(searchDrive, 10);
//		
//       	System.out.println("size"+result.size());
//       	for (Drive drive : result){
//			System.out.println(drive);
//			
//		}
//	}

//	public void testAddNewUser(){
//		
//		String value = "__"+new Random().nextInt();
//		
//		User user = new User();
//		user.setName(value);
//		user.setLogin(value);
//		user.setPassword(value);
//		user.setEmail(value);
//		user.setRole((byte) 2);
//		user.setRank(1);
//		
//		
//		//log.fatal("##### login="+value+", ########USERID1="+user.getIdUser());
//		
//		
//		dao.saveUser(user);
//		log.info("##### login="+value+", ########USERID2="+user.getIdUser());
//		
//		User newUser = dao.getUser(value);
//		log.debug("saved with different id"+user.getIdUser()+" new user id"+newUser.getIdUser());
//		assertEquals("saved with different id",user.getIdUser(),newUser.getIdUser());
//	}


//	public void testGetUser() {
//
//		User user = dao.getUser(41);
//		assertTrue(user.getName() != null);
//		
//	}
	
	
//	public void testUnjoiFromDrive(){
//		
//		dao.unJoinFromDrive(41, 3);
//		
//	}
//	public void testGetUserDrives() {
//	
//			List<Drive> userDrives = dao.getAddedDrives("toms");
//			
//			for (Drive userDrive: userDrives){
//				 if (userDrive != null)
//				 System.out.println("User drive "+userDrive);
//			 }
//			
//		}
	
//	public void testGetUsersForDrives(){
//		List<User> usersForDrive = dao.getUsersForDrive(1);
//		for (User userForDrive: usersForDrive){
//			 System.out.println("User "+userForDrive);
//		 }
//		
//	}
	
	
	public void testSaveUserDrive(){
		Userdrive userDrive =  new Userdrive();
		userDrive.setIdDrive(1);
		userDrive.setIdUser(65);
		dao.saveUserDrive(userDrive);
		
	}



	public static void main(String[] args) {
		junit.textui.TestRunner.run(BaseDAOTest.class);
	}

}
