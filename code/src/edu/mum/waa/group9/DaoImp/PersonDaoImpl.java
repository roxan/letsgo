package edu.mum.waa.group9.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.rowset.CachedRowSet;

import edu.mum.waa.group9.beanInterfaces.PersonInterface;
import edu.mum.waa.group9.daoFacade.PersonDaoFacade;
import edu.mum.waa.group9.utils.ConnectionManager;

public class PersonDaoImpl implements PersonDaoFacade {
	String INSERT_RECORD = "INSERT INTO Person (FIRST_NAME, LAST_NAME, PHONE, EMAIL,PASSWORD) VALUES(?,?,?, ?, ?)";
	String INSERT_ADDRESS = "INSERT INTO Address (PERSON_ID, STREET, CITY, STATE, COUNTRY,ZIP) VALUES(?, ?, ?, ?,?,?,?)";
	private final String getUserNameAndPassword = "SELECT EMAIL,PASSWORD FROM PERSON WHERE PERSON.EMAIL=?";
	private final String OFFERED_RIDES = "SELECT * FROM RIDE WHERE PERSON_ID=?";

	private CachedRowSet personInfo;
	private CachedRowSet searchResult;

	private boolean insert_success = false;

	public boolean registerPerson(PersonInterface personBean) {
		int id;
		PreparedStatement ps;
		Connection con;
		try {
			con = ConnectionManager.getConnection();
			try {
				ps = con.prepareStatement(INSERT_RECORD,
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, personBean.getFirstName());
				ps.setString(2, personBean.getLastName());
				ps.setString(3, personBean.getPhone());
				ps.setString(4, personBean.getEmail());
				ps.setString(5, personBean.getPassword());

				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();

				if (rs.next()) {
					id = rs.getInt(1);
					ps = con.prepareStatement(INSERT_ADDRESS);
					ps.setInt(1, id);
					ps.setString(2, personBean.getAddress().getStreet());
					ps.setString(3, personBean.getAddress().getCity());
					ps.setString(4, personBean.getAddress().getState());
					ps.setString(5, personBean.getAddress().getCountry());
					ps.setString(6, personBean.getAddress().getZip());
					/*
					 * queryStr = String.format(INSERT_ADDRESS, id, street,
					 * city, state, zip);
					 */
System.out.println("everything is ok");
					ps.executeUpdate();
					insert_success = true;
				}
				ps.close();

			} finally {
				ConnectionManager.closeConnection(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return insert_success;
	}

	public CachedRowSet getUnameAndPassword(String username) {

		PreparedStatement ps;
		Connection con;
		try {
			con = ConnectionManager.getConnection();
			try {
				ps = con.prepareStatement(getUserNameAndPassword);
				ps.setString(1, username);

				ResultSet rs = ps.executeQuery();

				personInfo = new com.sun.rowset.CachedRowSetImpl();
				personInfo.populate(rs);

				ps.close();
			} finally {
				ConnectionManager.closeConnection(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return personInfo;
	}

	@Override
	public CachedRowSet getOfferedRides(PersonInterface person) {
		PreparedStatement ps;
		Connection con;
		try {
			con = ConnectionManager.getConnection();
			try {
				ps = con.prepareStatement(OFFERED_RIDES);
				ps.setInt(1, person.getId());

				ResultSet rs = ps.executeQuery();

				searchResult = new com.sun.rowset.CachedRowSetImpl();
				searchResult.populate(rs);
				ps.close();
			} finally {
				ConnectionManager.closeConnection(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}		
		return searchResult;
	}
}
