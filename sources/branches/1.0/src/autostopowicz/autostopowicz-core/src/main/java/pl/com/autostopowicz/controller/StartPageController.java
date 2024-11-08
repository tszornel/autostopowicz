package pl.com.autostopowicz.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.com.autostopowicz.database.DatabaseManager;



public class StartPageController{
	  //~ Instance fields ------------------------------------------------------------------------------------------------

    /** Logger for this class and subclasses */
    protected final static Log logger = LogFactory.getLog(StartPageController.class);

    /** TODO: DOCUMENT ME! */
    private DatabaseManager dataSource;
    
    //public String hello = "HELLO";
    
    private String language;
    
    private String localePath = "pl.com.autostopowicz.locale.Locale_pl";
    
    private static TreeMap<String, String> localePaths = new TreeMap<String, String>();

    
    public StartPageController(){
    	loadLocales();
    	
    }
    //~ Methods --------------------------------------------------------------------------------------------------------

    	
    
           
    public String next(){
    	return "home_page";
    }
    
    public static void loadLocales() {
//    	String localePathBase = "pl.com.autostopowicz.locale.";
//    	String localePathBase2 = "../locale/";
//    	File localeDir = new File(localePathBase2);
//    	
//    	if(logger.isDebugEnabled()){
//    		logger.debug("localeDir : " + localeDir);
//    	}
//    	System.out.println(localeDir.getAbsolutePath());
//    	String[] localeList = localeDir.list();
//    	if(logger.isDebugEnabled()){
//    		logger.debug("localeList : " + Arrays.toString(localeList));
//    	}
//    	
//    	for(int i=0; i < localeList.length; i++){
//    		String localeName = localeList[i];
//    		Properties props = new Properties();
//    		try {
//				props.load(new FileInputStream(localePathBase2 + localeName));
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//    		String languageName = props.getProperty("language");
//    		
//    		if(logger.isDebugEnabled()){
//    			logger.debug("Found language name is "+languageName);
//    		}
//    		
//    		localePaths.put(languageName, localePathBase + languageName);
//    	}
    	localePaths.put("Polski", "pl.com.autostopowicz.locale.Locale_pl");
    	localePaths.put("English", "pl.com.autostopowicz.locale.Locale_eng");
		
	}

	public String next_en(){
           	return "home_page_en";
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
    

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		System.out.println("Setting language to : "+language);
		this.language = language;
		localePath = localePaths.get(language);
	}

	/**
	 * @return the localePath
	 */
	public String getLocalePath() {
		return localePath;
	}

	/**
	 * @param localePath the localePath to set
	 */
	public void setLocalePath(String localePath) {
		this.localePath = localePath;
	}
	
	public List<SelectItem> getAvailableLocales(){
		List<SelectItem> tempList = new ArrayList<SelectItem>();
		
		Set<String> entrySet = localePaths.keySet();
		Iterator<String> it = entrySet.iterator();
		
		while(it.hasNext()){
			SelectItem si = new SelectItem();
			String value = it.next();
			si.setLabel(value);
			si.setValue(value);
			tempList.add(si);
		}
		return tempList;
	}
}
