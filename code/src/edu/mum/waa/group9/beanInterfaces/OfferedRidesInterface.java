package edu.mum.waa.group9.beanInterfaces;

import java.util.List;

import edu.mum.waa.group9.beanImpl.Person;
import edu.mum.waa.group9.beanImpl.Ride;

public interface OfferedRidesInterface {
	public List<Ride> getRideLists();
	public void setRideLists(List<Ride> rideLists);
}
