package edu.mum.waa.group9.utils;

public class DateUtil {
	public static java.sql.Date sqlDate(java.util.Date dateUtil) {
		return new java.sql.Date(dateUtil.getTime());
	}

	public static java.util.Date utilDate(java.sql.Date dateSql) {
		return new java.util.Date(dateSql.getTime());
	}

}
