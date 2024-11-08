package pl.com.autostopowicz.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.com.autostopowicz.database.DatabaseManager;

public class HelpController {
	  //~ Instance fields ------------------------------------------------------------------------------------------------

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    
    public String getPozdrowienia() {
        return "Pozdrowienia od ziarna ze Spring Framework";
    }

    /** TODO: DOCUMENT ME! */
    private DatabaseManager dataSource;

    //~ Methods --------------------------------------------------------------------------------------------------------


    public String next(){
       	return "help_page";
    }
        
    public String next_en(){
       return "help_page_en";
    }

    /**
     *  
    DOCUMENT ME!
     *
     *  @param dataSource the dataSource to set
     */
    public void setDataSource(DatabaseManager dataSource) {
        this.dataSource = dataSource;
    }                               
}
