package edu.mum.group9.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import edu.mum.group9.db.DataAccess;

@Named("control")
@SessionScoped
public class Control implements Serializable {

	private static final long serialVersionUID = -4116319637005914985L;

	private Date date;
	private List<String> location;
	private String selectedLocation;

	public Control() {
		location = new ArrayList<String>();
	}

	public String showValue() {
		System.out.println(date);
		return null;
	}

	public List<String> filterLocation(String s) {
		DataAccess da = new DataAccess();
		return da.getLocation(s);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSelectedLocation() {
		return selectedLocation;
	}

	public void setSelectedLocation(String selectedLocation) {
		this.selectedLocation = selectedLocation;
	}

	public List<String> getLocation() {
		return location;
	}

	public void setLocation(List<String> location) {
		this.location = location;
	}
}
