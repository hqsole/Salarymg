package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	public static Date stringToDate(String date,String pattern){
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		Date newDate=null;
		try {
			if(date!=null&&date.length()>0)
		    	newDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
	}
	public static String dateToString(Date date,String pattern){
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
}
