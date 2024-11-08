package pl.com.autostopowicz.authentication;

import org.acegisecurity.providers.dao.DaoAuthenticationProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.com.autostopowicz.database.DatabaseManager;

public class AutoDaoAuthenticationProvider extends DaoAuthenticationProvider{

	DatabaseManager dataSource;

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	
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
