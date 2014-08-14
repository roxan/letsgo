package edu.mum.waa.group9.services;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import org.primefaces.model.DefaultStreamedContent;

import edu.mum.waa.group9.DaoImp.SearchDaoImpl;
import edu.mum.waa.group9.beanImpl.Person;
import edu.mum.waa.group9.beanImpl.PersonAddress;
import edu.mum.waa.group9.beanImpl.Ride;
import edu.mum.waa.group9.beanImpl.Search;
import edu.mum.waa.group9.daoFacade.SearchDaoFacade;
import edu.mum.waa.group9.utils.DateUtil;

public class SearchService {
	List<Ride> rideList = new ArrayList<>();
	CachedRowSet searchResult;

	public void search(Search searchBean) {
		SearchDaoFacade searchDao = new SearchDaoImpl();
		searchResult = searchDao.search(searchBean);
		try {
			searchBean.getRideList().clear();
			while (searchResult.next()) {

				Ride tempRide = new Ride();
				Person tempPerson = new Person();
				PersonAddress tempAddress = new PersonAddress();

				tempAddress.setId(searchResult.getInt("ADDRESS_ID"));
				tempAddress.setStreet(searchResult.getString("STREET"));
				tempAddress.setCity(searchResult.getString("CITY"));
				tempAddress.setState(searchResult.getString("STATE"));
				tempAddress.setCountry(searchResult.getString("COUNTRY"));
				tempAddress.setZip(searchResult.getString("ZIP"));

				tempPerson.setId(searchResult.getInt("PERSON_ID"));
				tempPerson.setFirstName(searchResult.getString("FIRST_NAME"));
				tempPerson.setLastName(searchResult.getString("LAST_NAME"));
				tempPerson.setSex(searchResult.getString("SEX"));
				tempPerson.setPhone(searchResult.getString("PHONE"));
				tempPerson.setEmail(searchResult.getString("EMAIL"));
				tempPerson.setPassword(searchResult.getString("PASSWORD"));
				if (null != searchResult.getBlob("AVATAR")) {
					InputStream bs = searchResult.getBlob("AVATAR")
							.getBinaryStream();
					DefaultStreamedContent dsc = new DefaultStreamedContent(bs);
					tempPerson.setPhoto(dsc);
				}
				tempPerson.setAddress(tempAddress);

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
				tempRide.setPerson(tempPerson);
				searchBean.getRideList().add(tempRide);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
