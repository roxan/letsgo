package edu.mum.waa.group9.services;

import javax.sql.rowset.CachedRowSet;

import edu.mum.waa.group9.DaoImp.RideDaoImpl;
import edu.mum.waa.group9.beanImpl.Ride;
import edu.mum.waa.group9.daoFacade.RideDaoFacade;

public class RideService {
	CachedRowSet searchResult;
	
	public boolean createRide(Ride rideBean){
		System.out.println("Inside RideService--createRide");
		RideDaoFacade rideDao = new RideDaoImpl();
		return rideDao.createRide(rideBean);
		
	}

}
