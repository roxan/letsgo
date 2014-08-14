package edu.mum.waa.group9.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateUtil {
	public static java.sql.Date sqlDate(java.util.Date dateUtil) {
		return new java.sql.Date(dateUtil.getTime());
	}

	public static java.util.Date utilDate(java.sql.Date dateSql) {
		return new java.util.Date(dateSql.getTime());
	}

	public static int ageInYears(java.util.Date dateUtil){
		 Calendar calend = new GregorianCalendar();
		 java.util.Date now = new java.util.Date();
	      calend.set(Calendar.HOUR_OF_DAY, 0);
	      calend.set(Calendar.MINUTE, 0);
	      calend.set(Calendar.SECOND, 0);
	      calend.set(Calendar.MILLISECOND, 0);
	    
	      calend.setTimeInMillis(now.getTime() - dateUtil.getTime());

	      float result = 0;
	      result = calend.get(Calendar.YEAR) - 1970;
	      result += (float) calend.get(Calendar.MONTH) / (float) 12;
	      return (int)result;
	}
}
