package edu.mum.waa.group9.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.rowset.CachedRowSet;

import edu.mum.waa.group9.beanInterfaces.SearchInterface;
import edu.mum.waa.group9.daoFacade.SearchDaoFacade;
import edu.mum.waa.group9.utils.ConnectionManager;
import edu.mum.waa.group9.utils.DateUtil;

public class SearchDaoImpl implements SearchDaoFacade {
	private final String QUERY = "SELECT  p.ID as PERSON_ID, r.ID as RIDE_ID, a.ID as ADDRESS_ID, p.*, r.*, a.*  "
			+ "FROM (RIDE r JOIN PERSON p ON r.PERSON_ID = p.ID) "
			+ "JOIN PERSON_ADDRESS a ON p.ID = a.PERSON_ID "
			+ "WHERE r.SOURCE=? AND r.DESTINATION=? "
			+ "AND r.DEPART_DATE=? AND r.RETURN_DATE=?";

	CachedRowSet searchResult;

	public CachedRowSet search(SearchInterface searchBean) {

		PreparedStatement ps;
		Connection con;
		try {
			con = ConnectionManager.getConnection();
			try {
				ps = con.prepareStatement(QUERY);
				ps.setString(1, searchBean.getFromLocation());
				ps.setString(2, searchBean.getToLocation());
				ps.setDate(3, DateUtil.sqlDate(searchBean.getFromDate()));
				ps.setDate(4, DateUtil.sqlDate(searchBean.getToDate()));

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
