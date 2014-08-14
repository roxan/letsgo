package edu.mum.waa.group9.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;

import edu.mum.waa.group9.beanInterfaces.RideInterface;
import edu.mum.waa.group9.daoFacade.RideDaoFacade;
import edu.mum.waa.group9.utils.ConnectionManager;
import edu.mum.waa.group9.utils.DateUtil;

public class RideDaoImpl implements RideDaoFacade {

	private String INSERT_RECORD = "INSERT INTO RIDE (person_id,source,destination,depart_date,depart_time,"
			+ "return_date,return_time,description,capacity,vehicle_description,"
			+ "expected_expense,ride_type) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	private boolean insert_success = false;

	@Override
	public boolean createRide(RideInterface rideBean) {
		System.out.println("Inside RideDaoImpl--createRide");
		PreparedStatement ps;
		Connection con;
		try {
			con = ConnectionManager.getConnection();
			try {
				System.out.println("rideBean.getSource-->"+rideBean.getSource());
				ps = con.prepareStatement(INSERT_RECORD);
				ps.setInt(1, rideBean.getPerson().getId());
				ps.setString(2, rideBean.getSource());
				ps.setString(3, rideBean.getDescription());
				ps.setDate(4, DateUtil.sqlDate(rideBean.getDepartDate()));
				ps.setString(5, rideBean.getDepartTime());
				ps.setDate(6, DateUtil.sqlDate(rideBean.getReturnDate()));
				ps.setString(7, rideBean.getReturnTime());
				ps.setString(8, rideBean.getDescription());
				ps.setInt(9, rideBean.getCapacity());
				ps.setString(10, rideBean.getVehicleDescription());
				ps.setBigDecimal(11, rideBean.getExpectedExpense());
				ps.setString(12, rideBean.getRideType());
				ps.executeUpdate();
				insert_success = true;
				ps.close();

			} finally {
				ConnectionManager.closeConnection(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return insert_success;
	}

}
