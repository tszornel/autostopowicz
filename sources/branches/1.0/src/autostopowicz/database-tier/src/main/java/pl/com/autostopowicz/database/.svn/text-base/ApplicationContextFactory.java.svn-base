package pl.com.autostopowicz.database;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class ApplicationContextFactory {
	private static Log log = LogFactory.getLog(ApplicationContextFactory.class);

	private static String initObj = null;
	private static int count = 0;
	
	
	public static void init(String s){
		
		if (count > 0){
			log.error("Can't initialize the application context twice: THIS SHOULD ONLY HAPPEN DURING TESTING");
		}
		initObj=s;
		count++;
	}
	
	public static ApplicationContext getApplicationContext(){
		if (initObj == null){
			throw new IllegalStateException("Application context not initialized");
		} else {
			return new ClassPathXmlApplicationContext(initObj);
		} 
	}

}


