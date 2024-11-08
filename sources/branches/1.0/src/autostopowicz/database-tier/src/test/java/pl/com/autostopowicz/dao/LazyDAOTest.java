package pl.com.autostopowicz.dao;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import pl.com.autostopowicz.entities.Drive;
import pl.com.autostopowicz.entities.User;


public class LazyDAOTest extends BaseDAOTest {

	protected SessionFactory sessionFactory;
	protected Session session;


	
	

	protected void setUp() throws Exception {
		super.setUp();
        sessionFactory = (SessionFactory)ctx.getBean("sessionFactory");
        session = sessionFactory.openSession();
        TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));

	}

	protected void tearDown() throws Exception {
		super.tearDown();
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager
				.getResource(sessionFactory);
		Session s = holder.getSession();
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
		SessionFactoryUtils.closeSession(s);
	

	}

	
	public void testGetUserDrives() {

		User user = dao.getUser(41);
		assertTrue(user.getName() != null);

		Set<Drive> userDrives =  user.getUserDrives();
		//		log.debug(" User with id " + user);
		System.out.println(userDrives.size()); 
		
		for (Drive userDrive: userDrives){
			 if (userDrive != null)
			 System.out.println("User drive "+userDrive);
		 }
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(LazyDAOTest.class);
	}

}
