package edu.mum.waa.group9.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import org.primefaces.model.UploadedFile;

import edu.mum.waa.group9.DaoImp.PersonDaoImpl;
import edu.mum.waa.group9.beanImpl.Person;
import edu.mum.waa.group9.beanImpl.Ride;
import edu.mum.waa.group9.daoFacade.PersonDaoFacade;
import edu.mum.waa.group9.utils.DateUtil;

public class PersonService {

	List<Ride> rideList = new ArrayList<>();
	CachedRowSet searchResult;

	public boolean register(Person personBean) {
		PersonDaoFacade registerDao = new PersonDaoImpl();
		return registerDao.registerPerson(personBean);
	}

	public void handleFileUpload(UploadedFile file, int pid) {
		PersonDaoFacade personDao = new PersonDaoImpl();
		personDao.saveImage(file, pid);
	}

	public void getOfferedRides(Person person) {

		PersonDaoFacade getOfferedRidesDao = new PersonDaoImpl();

		searchResult = getOfferedRidesDao.getOfferedRides(person);

		try {
			while (searchResult.next()) {

				Ride tempRide = new Ride();

				tempRide.setId(searchResult.getInt("ID"));

				tempRide.setSource(searchResult.getString("SOURCE"));
				tempRide.setDestination(searchResult.getString("DESTINATION"));
				tempRide.setDepartDate(DateUtil.utilDate(searchResult
						.getDate("DEPART_DATE")));
				tempRide.setDepartTime(searchResult.getTime("DEPART_TIME"));
				tempRide.setReturnDate(DateUtil.utilDate(searchResult
						.getDate("RETURN_DATE")));
				tempRide.setReturnTime(searchResult.getTime("RETURN_TIME"));
				tempRide.setDescription(searchResult.getString("DESCRIPTION"));
				tempRide.setCapacity(searchResult.getInt("CAPACITY"));
				tempRide.setVehicleDescription(searchResult
						.getString("VEHICLE_DESCRIPTION"));
				tempRide.setExpectedExpense(searchResult
						.getBigDecimal("EXPECTED_EXPENSE"));
				tempRide.setRideType(searchResult.getString("RIDE_TYPE"));
				person.getOfferredRidesList().add(tempRide);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}