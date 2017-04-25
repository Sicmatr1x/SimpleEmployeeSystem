package demo.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	
	/**
	 * 获取指定月份的该月天数
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date){
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		//System.out.println(c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public static void main(String[] args){
		try {
			System.out.println(DateFactory.getDayOfMonth(DateFactory.getDate("2017-02-01")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
