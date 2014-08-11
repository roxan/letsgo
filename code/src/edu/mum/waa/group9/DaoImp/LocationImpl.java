package edu.mum.waa.group9.DaoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import edu.mum.waa.group9.daoFacade.LocationDaoFacade;
import edu.mum.waa.group9.utils.ConnectionManager;

public class LocationImpl implements LocationDaoFacade {

	private final String QUERY = "SELECT cityName, stateName, zip FROM LOCATION where LOWER(cityName) like '";

	@Override
	public List<String> getLocation(String str) {
		List<String> output = new ArrayList<String>();
		Statement stmt;
		Connection con;
		try {
			con = ConnectionManager.getConnection();
			try {
				stmt = con.createStatement();
				// ToDo: use preparedStatement
				ResultSet rs = stmt.executeQuery(QUERY + str.toLowerCase()
						+ "%' FETCH FIRST 10 ROWS ONLY");
				while (rs.next()) {
					output.add(rs.getString(1) + "," + rs.getString(2) + ","
							+ rs.getString(3));
				}
				stmt.close();
			} finally {
				ConnectionManager.closeConnection(con);
			}
		} catch (SQLException e) {

		} catch (NamingException e) {

		}
		return output;
	}

}
