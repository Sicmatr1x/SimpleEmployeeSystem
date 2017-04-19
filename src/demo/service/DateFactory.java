package demo.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFactory {
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 
	 * @param date like"2010-09-13"
	 * @throws ParseException 时间格式错误
	 * @return Date对象
	 */
	public static Date getDate(String date) throws ParseException{
		return dateFormat.parse(date);
		
	}
	
	public static String getDateToString(Date date){
		return dateFormat.format(date);
	}
}
