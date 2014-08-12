package edu.mum.waa.group9.beanImpl;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import edu.mum.waa.group9.beanInterfaces.SearchInterface;


@Named("search")
@SessionScoped
public class Search implements SearchInterface, Serializable{
	private String fromLocation;
	private String toLocation;
	private Date fromDate;
	private Date toDate;
	private List<Ride> rideList;
	
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public List<Ride> getRideList() {
		return rideList;
	}
	public void setRideList(List<Ride> rideList) {
		this.rideList = rideList;
	}
}
