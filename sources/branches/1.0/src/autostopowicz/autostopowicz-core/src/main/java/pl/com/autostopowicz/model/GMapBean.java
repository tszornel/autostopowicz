package pl.com.autostopowicz.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


public class GMapBean {

	private ArrayList<Place> point;
	private String currentId;
	private int zoom;
	private String gmapkey;
	private boolean localized = false;
	
	
	
	
	
	public String getCurrentId() {
		return currentId;
	}



	public void setCurrentId(String currentId) {
		this.currentId = currentId;
	}



	public ArrayList<Place> getPoint() {
		if (point == null)
			initData();
		return point;
	}



	public void setPoint(ArrayList<Place> point) {
		this.point = point;
	}


	public Place getCurrentPlace() {
		Iterator<Place> it = point.iterator();
		while (it.hasNext()) {
			 Place pl = (Place)it.next();
			 if (currentId.equals(pl.getId())) {
				 zoom = pl.getZoom(); //sync with zoom of new place
				 return pl;
			 }
		}
		return (Place)point.get(0);	
	}

	private void initData() {
		point = new ArrayList<Place>();
		point.add(new Place ("goldengate", "/images/logo.jpg", "37.81765", "-122.477603" , 14,
				"Golden Gate  Bridge, San Francisco"));
	
		currentId = "goldengate";
	}



	public int getZoom() {
		return zoom;
	}



	public void setZoom(int zoom) {
		this.zoom = zoom;
	}



	public String getGmapkey() {
		if (gmapkey == null) {
			gmapkey = createKey();
		}
		return gmapkey;
	}

	private String createKey() {
		
		HashMap<String, String> hosts = new HashMap<String, String>();
		hosts.put("localhost:8080", "ABQIAAAAU5IDceLqYFSp4k84FYLxyRTwM0brOpm-All5BF6PoaKBxRWWERSDiAIGyx-hbmMfA3v7tHF4Tvwfaw");
		
//		hosts.put("localhost", "ABQIAAAAxU6W9QEhFLMNdc3ATIu-VxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxRkrpOGzxH8_ud3inE9pG1845-FCA");
//		hosts.put("localhost:8080", "ABQIAAAAxU6W9QEhFLMNdc3ATIu-VxTwM0brOpm-All5BF6PoaKBxRWWERTHxF5cK19oAMu3MP89kWdchuCH6w");
//		hosts.put("www.autostopowicz.com.pl", "ABQIAAAAxU6W9QEhFLMNdc3ATIu-VxRl-RYVoXwacweAQq3rWvtlmS78MhRst9EH2cahrIp0_HHi_U1Zn7o1Fg");
		
//		ABQIAAAAU5IDceLqYFSp4k84FYLxyRTwM0brOpm-All5BF6PoaKBxRWWERSDiAIGyx-hbmMfA3v7tHF4Tvwfaw
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String host = (String)ec.getRequestHeaderMap().get("host");
		String key = (String)hosts.get(host);
		if (key != null) 
			return key;
		else
			return "get the key for your domain at http://www.google.com/apis/maps/signup.html";
		
	}


	public GMapBean() {
	
		
	}



	public void setGmapkey(String gmapkey) {
		this.gmapkey = gmapkey;
	}



	public boolean isLocalized() {
		return localized;
	}



	public void setLocalized(boolean localized) {
		this.localized = localized;
	}




}
