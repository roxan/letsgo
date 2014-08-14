package edu.mum.waa.group9.beanInterfaces;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

public interface RideInterface {
	
	public String getSource();
	public String getDestination();
	public Date getDepartDate();
	public Time getDepartTime();
	public Date getReturnDate();
	public Time getReturnTime();
	public BigDecimal getExpectedExpense();
	public int getCapacity();
	public String getDescription();
	public String getVehicleDescription();
	public String getRideType();
	public PersonInterface getPerson();
	public int getHitCounter();
	
	public void setId(int Id);
	public void setSource(String source);
	public void setDestination(String destination);
	public void setDepartDate(Date departDate);
	public void setDepartTime(Time departTime);
	public void setReturnDate(Date returnDate);
	public void setReturnTime(Time returnTime);
	public void setExpectedExpense(BigDecimal expectedExpense);
	public void setCapacity(int capacity);
	public void setDescription(String description);
	public void setVehicleDescription(String vehicleDescription);
	public void setRideType(String rideType);
	public void setPerson(PersonInterface person);
	public void setHitCounter(int hitCounter);
}
