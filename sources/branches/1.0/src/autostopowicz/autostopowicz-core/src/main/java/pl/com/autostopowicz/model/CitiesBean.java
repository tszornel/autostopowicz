package pl.com.autostopowicz.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import pl.com.autostopowicz.database.DatabaseManager;
import pl.com.autostopowicz.entities.City;

public class CitiesBean {
	private List<City> cities = new ArrayList<City>();
    private String city = ""; 
    
    private ArrayList<String> citiesNames = new ArrayList<String>();
    private HashMap<String,Integer> citiesIds = new HashMap<String,Integer>();
    
    private DatabaseManager dataSource;
	
	public List<City> autocomplete(Object suggest) {
        String pref = (String)suggest;
        ArrayList<City> result = new ArrayList<City>();

        Iterator<City> iterator = getCities().iterator();
        while (iterator.hasNext()) {
        	City elem = ((City) iterator.next());
            if ((elem.getName() != null && elem.getName().toLowerCase().indexOf(pref.toLowerCase()) == 0) || "".equals(pref))
            {
                result.add(elem);
            }
        }
        return result;
    }
    
	public CitiesBean(DatabaseManager dataSource) {
		this.dataSource = dataSource;
		
		
		if(dataSource != null){
		List<City> newCities = dataSource.getCities();
		
		if (newCities!=null && newCities.size()!= 0){
		for (City cityNew :newCities){
				System.out.println(cityNew);
		}
		
		cities.addAll(newCities);
		for (City city :cities){
			citiesNames.add(city.getName());
			citiesIds.put(city.getName(), city.getIdCity());
			
		}
		}
		
		}
		
	}
	
	public String addCity(City city) {
		cities.add(city);
		return null;
	}
	
	public List<City> getCities() {
		System.out.println(cities.size());
		return cities;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public DatabaseManager getDataSource() {
		return dataSource;
	}

	public void setDataSource(DatabaseManager dataSource) {
		this.dataSource = dataSource;
	}

	public ArrayList<String> getCitiesNames() {
		return citiesNames;
	}

	public void setCitiesNames(ArrayList<String> citiesNames) {
		this.citiesNames = citiesNames;
	}

	public HashMap<String, Integer> getCitiesIds() {
		return citiesIds;
	}

	public void setCitiesIds(HashMap<String, Integer> citiesIds) {
		this.citiesIds = citiesIds;
	}
	
}

