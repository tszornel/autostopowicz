package pl.com.autostopowicz.authentication;


import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import pl.com.autostopowicz.database.DatabaseManager;
import pl.com.autostopowicz.entities.User;

public class AutoListUserDetailsService implements UserDetailsService {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	
	DatabaseManager dataSource;
	
	
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException, DataAccessException {
		if(logger.isDebugEnabled()){
	        logger.debug("%%%%%%%%%%%%%%%% loadUserByUsername login="+login);
		}


		User user = dataSource.getUser(login);

		if(logger.isDebugEnabled()){
	        logger.debug("%%%%%%%%%%%%%%%% loadUserByUsername login="+login + ", user="+user);
		}
		
		if(user == null){
			throw new UsernameNotFoundException("no such user");
		}
		
		return (UserDetails)(new AutoUserDetails(user));
	 
	}


	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DatabaseManager dataSource) {

		if(logger.isDebugEnabled()){
	        logger.debug("%%%%%%%%%%%%%%%% setDataSource");
		}

		this.dataSource = dataSource;
	}

}
