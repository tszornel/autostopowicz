package pl.com.autostopowicz.model;

import java.util.Date;
import java.util.Locale;

import javax.faces.event.ValueChangeEvent;

public class CalendarBean {

	private Locale locale;
	private boolean popup;
	private String pattern;
	private Date selectedDate;
	private boolean showApply;

	private boolean useCustomDayLabels;

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public boolean isPopup() {
		return popup;
	}

	public void setPopup(boolean popup) {
		this.popup = popup;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public CalendarBean() {

		locale = Locale.US;
		popup = true;
		pattern = "d/M/yy HH:mm";
		showApply = true;
	}
	
	public static void addDaysToDate(Date oldDate,int daysNumber) {
		System.out.println("1. Add to a Date Operation\n");
		

	
		System.out.println("-------------------------------------");
	}
	
	

	public static void subDayToDate(Date oldDate,int daysNumber) {
		System.out.println("1. Substract a days to a Date Operation\n");
		

		
		System.out.println("-------------------------------------");
	}
	
	
	public void selectLocale(ValueChangeEvent event) {

		String tLocale = (String) event.getNewValue();
		if (tLocale != null) {
			String lang = tLocale.substring(0, 2);
			String country = tLocale.substring(3);
			locale = new Locale(lang, country, "");
		}
	}

	public boolean isUseCustomDayLabels() {
		return useCustomDayLabels;
	}

	public void setUseCustomDayLabels(boolean useCustomDayLabels) {
		this.useCustomDayLabels = useCustomDayLabels;
	}

	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}

	public boolean isShowApply() {
		return showApply;
	}

	public void setShowApply(boolean showApply) {
		this.showApply = showApply;
	}
}