package pl.com.autostopowicz.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import pl.com.autostopowicz.database.DatabaseManager;
import pl.com.autostopowicz.entities.Country;

public class CountriesBean {
	private ArrayList<Country> countries = new ArrayList<Country>();

	private ArrayList<String> countriesNames = new ArrayList<String>();
	private SelectItem[] countriesNamesOptions;
	private ArrayList<SelectItem> countriesOptions = new ArrayList<SelectItem>();
	private HashMap<String,Integer> countriesIds = new HashMap<String,Integer>();
	
	
	
	private String countryName = "";
	private Country country;
	
	private DatabaseManager dataSource;

	public List<Country> autocomplete(Object suggest) {
		System.out.println("autocomplete");
		String pref = (String) suggest;
		ArrayList<Country> result = new ArrayList<Country>();

		Iterator<Country> iterator = getCountries().iterator();
		while (iterator.hasNext()) {
			Country elem = ((Country) iterator.next());
			if ((elem.getName() != null && elem.getName().toLowerCase()
					.indexOf(pref.toLowerCase()) == 0)
					|| "".equals(pref)) {
				result.add(elem);
			}
		}

		return result;

	}

	public CountriesBean(DatabaseManager dataSource) {
		this.dataSource = dataSource;
		countries.addAll(dataSource.getCountries());
		
		for (Country country :countries){
			
			countriesNames.add(country.getName());
			countriesIds.put(country.getName(), country.getIdCountry());
			
		}
			
	}

	public void addCountry(Country country) {

		System.out.println("Country added" + country.getName());
		countries.add(country);

	}

	public ArrayList<Country> getCountries() {
		return countries;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String country) {
		this.countryName = country;
	}

	public ArrayList<SelectItem> getCountriesOptions() {
		return countriesOptions;
	}

	public ArrayList<String> getCountriesNames() {
		return countriesNames;
	}

	public SelectItem[] getCountriesNamesOptions() {
		return countriesNamesOptions;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Country getCountry() {
		return country;
	}

	public DatabaseManager getDataSource() {
		return dataSource;
	}

	public void setDataSource(DatabaseManager dataSource) {
		this.dataSource = dataSource;
	}

	public HashMap<String, Integer> getCountriesIds() {
		return countriesIds;
	}

	public void setCountriesIds(HashMap<String, Integer> countriesIds) {
		this.countriesIds = countriesIds;
	}

}
