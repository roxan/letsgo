package edu.mum.waa.group9.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {

	public static Connection getConnection() throws NamingException, SQLException {
		Context ctx = new InitialContext();
		return ((DataSource) ctx.lookup("javadb/letsgodb")).getConnection();
	}

	public static void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}
}
