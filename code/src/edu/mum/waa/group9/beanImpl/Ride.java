package edu.mum.waa.group9.beanImpl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import edu.mum.waa.group9.beanInterfaces.PersonInterface;
import edu.mum.waa.group9.beanInterfaces.RideInterface;

@Named
@SessionScoped
public class Ride implements RideInterface, Serializable {
	private int id;
	private String source;
	private String destination;
	private Date departDate;
	private Time departTime;
	private Date returnDate;
	private Time returnTime;
	private String description;
	private int capacity;
	private String vehicleDescription;
	private BigDecimal expectedExpense;
	private String rideType;
	private PersonInterface person;
	private int hitCounter;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDepartDate() {
		return departDate;
	}

	public void setDepartDate(Date departDate) {
		this.departDate = departDate;
	}

	public Time getDepartTime() {
		return departTime;
	}

	public void setDepartTime(Time departTime) {
		this.departTime = departTime;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Time getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Time returnTime) {
		this.returnTime = returnTime;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getVehicleDescription() {
		return vehicleDescription;
	}

	public void setVehicleDescription(String vehicleDescription) {
		this.vehicleDescription = vehicleDescription;
	}

	public BigDecimal getExpectedExpense() {
		return expectedExpense;
	}

	public void setExpectedExpense(BigDecimal expectedExpense) {
		this.expectedExpense = expectedExpense;
	}

	public String getRideType() {
		return rideType;
	}

	public void setRideType(String rideType) {
		this.rideType = rideType;
	}

	public int getHitCounter() {
		return hitCounter;
	}

	public String getDescription() {
		return description;
	}

	public PersonInterface getPerson() {
		return person;
	}

	public void setPerson(PersonInterface person) {
		this.person = person;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHitCounter(int hitCounter) {
		this.hitCounter = hitCounter;
	}

}
