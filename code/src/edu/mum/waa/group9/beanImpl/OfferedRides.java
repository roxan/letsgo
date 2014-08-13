package edu.mum.waa.group9.beanImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import edu.mum.waa.group9.beanInterfaces.OfferedRidesInterface;

@Named("offeredRides")
@SessionScoped
public class OfferedRides implements OfferedRidesInterface, Serializable {
	private List<Ride> rideLists;

	public OfferedRides() {
		rideLists = new ArrayList<>();
	}

	private static final long serialVersionUID = 1L;

	public List<Ride> getRideLists() {
		return rideLists;
	}

	public void setRideLists(List<Ride> rideLists) {
		this.rideLists = rideLists;
	}
}
