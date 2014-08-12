package edu.mum.waa.group9.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import edu.mum.waa.group9.DaoImp.SearchDaoImpl;
import edu.mum.waa.group9.beanImpl.Person;
import edu.mum.waa.group9.beanImpl.Ride;
import edu.mum.waa.group9.beanImpl.Search;
import edu.mum.waa.group9.beanInterfaces.PersonInterface;
import edu.mum.waa.group9.beanInterfaces.RideInterface;
import edu.mum.waa.group9.beanInterfaces.SearchInterface;
import edu.mum.waa.group9.daoFacade.SearchDaoFacade;

public class SearchService {
	List<Ride> rideList = new ArrayList<>();
	CachedRowSet searchResult;

	public void search(Search searchBean) {
		SearchDaoFacade searchDao = new SearchDaoImpl();
		searchResult = searchDao.search(searchBean);
		try {
			while (searchResult.next()) {

				Ride tempRide = new Ride();
				Person tempPerson = new Person();

				tempPerson.setId(searchResult.getInt("PERSON_ID"));

				tempRide.setId(searchResult.getInt("ID"));
				tempRide.setSource(searchResult.getString("SOURCE"));
				tempRide.setDestination(searchResult.getString("DESTINATION"));
				tempRide.setDepartDate(searchResult.getDate("DEPART_DATE"));
				tempRide.setDepartTime(searchResult.getTime("DEPART_TIME"));
				tempRide.setReturnDate(searchResult.getDate("RETURN_DATE"));
				tempRide.setReturnTime(searchResult.getTime("RETURN_TIME"));
				tempRide.setDescription(searchResult.getString("DESCRIPTION"));
				tempRide.setCapacity(searchResult.getInt("CAPACITY"));
				tempRide.setVehicleDescription(searchResult
						.getString("VEHICLE_DESCRIPTION"));
				tempRide.setExpectedExpense(searchResult
						.getBigDecimal("EXPECTED_EXPENSE"));
				tempRide.setRideType(searchResult.getString("RIDE_TYPE"));
				tempRide.setPerson(tempPerson);

				searchBean.getRideList().add(tempRide);
			}
		} catch (SQLException e) {

		}
	}
}
