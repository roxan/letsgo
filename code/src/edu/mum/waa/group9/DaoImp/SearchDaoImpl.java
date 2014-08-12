package edu.mum.waa.group9.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.rowset.CachedRowSet;

import edu.mum.waa.group9.beanImpl.Person;
import edu.mum.waa.group9.beanImpl.Ride;
import edu.mum.waa.group9.beanInterfaces.PersonInterface;
import edu.mum.waa.group9.beanInterfaces.RideInterface;
import edu.mum.waa.group9.beanInterfaces.SearchInterface;
import edu.mum.waa.group9.daoFacade.SearchDaoFacade;
import edu.mum.waa.group9.utils.ConnectionManager;

public class SearchDaoImpl implements SearchDaoFacade {
	private final String QUERY = "SELECT * FROM RIDE WHERE RIDE.SOURCE=? AND RIDE.DESTINATION=? "
			+ "AND RIDE.DEPART_DATE=? AND RIDE.RETURN_DATE=?";
	
	CachedRowSet searchResult;

	public CachedRowSet search(SearchInterface searchBean) {
		
		PreparedStatement ps;
		Connection con;
		try {
			con = ConnectionManager.getConnection();
			try {
				ps = con.prepareStatement(QUERY);
				ps.setString(1,searchBean.getFromLocation());
				ps.setString(2,searchBean.getToLocation());
				ps.setDate(3, searchBean.getFromDate());
				ps.setDate(4, searchBean.getToDate());
				
				ResultSet rs = ps.executeQuery();
				
				searchResult = new com.sun.rowset.CachedRowSetImpl();
				searchResult.populate(rs);
				
				//RideInterface tempRide = new Ride();
				//PersonInterface tempPerson = new Person();
				
			/*	while (rs.next()) {
					
					RideInterface tempRide = new Ride();
					PersonInterface tempPerson = new Person();
					
					tempPerson.setId(rs.getInt("PERSON_ID"));
					
					tempRide.setId(rs.getInt("ID"));
					tempRide.setSource(rs.getString("SOURCE"));
					tempRide.setDestination(rs.getString("DESTINATION"));
					tempRide.setDepartDate(rs.getDate("DEPART_DATE"));
					tempRide.setDepartTime(rs.getTime("DEPART_TIME"));
					tempRide.setReturnDate(rs.getDate("RETURN_DATE"));
					tempRide.setReturnTime(rs.getTime("RETURN_TIME"));
					tempRide.setDescription(rs.getString("DESCRIPTION"));
					tempRide.setCapacity(rs.getInt("CAPACITY"));
					tempRide.setVehicleDescription(rs.getString("VEHICLE_DESCRIPTION"));
					tempRide.setExpectedExpense(rs.getBigDecimal("EXPECTED_EXPENSE"));
					tempRide.setRideType(rs.getString("RIDE_TYPE"));
					tempRide.setPerson(tempPerson);
					
					output.add(tempRide);
				}*/
				ps.close();
			} finally {
				ConnectionManager.closeConnection(con);
			}
		} catch (SQLException e) {

		} catch (NamingException e) {

		}
		return searchResult;
	}
}
