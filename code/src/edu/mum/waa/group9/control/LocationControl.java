package edu.mum.waa.group9.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import edu.mum.waa.group9.DaoImp.LocationDaoImpl;
import edu.mum.waa.group9.daoFacade.LocationDaoFacade;

@Named("locationControl")
@SessionScoped
public class LocationControl implements Serializable {

	private static final long serialVersionUID = -4116319637005914985L;

	private List<String> location;
	private String selectedLocation;

	public LocationControl() {
		location = new ArrayList<String>();
	}

	public List<String> filterLocation(String s) {
		LocationDaoFacade locationDao = new LocationDaoImpl();
		return locationDao.getLocation(s);
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
