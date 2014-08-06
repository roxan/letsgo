package edu.mum.group9.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataAccess {
	// queries
	String QUERY = "SELECT cityName, stateName FROM LOCATION where LOWER(cityName) like '";

	DataSource ds;
	Connection con;
	Statement s;

	private ResultSet rs;

	public DataAccess() {

		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("jdbc/mydb");
			con = ds.getConnection();
		} catch (NamingException ex) {
			System.out.println(ex.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			if (con != null)
				con.close();
			System.out.println("Connection closed");
		} catch (SQLException ex) {
			System.out.println("Unable to close connection");
			ex.printStackTrace();
		}
	}

	public List<String> getLocation(String str) {
		List<String> output = new ArrayList<String>();
		try {
			s = con.createStatement();
			// ToDo: use preparedStatement
			rs = s.executeQuery(QUERY + str.toLowerCase() + "%' FETCH FIRST 10 ROWS ONLY");
			while (rs.next()) {
				output.add(rs.getString(1) + "," + rs.getString(2));
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != s) {
				try {
					s.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != con) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return output;

	}
}
