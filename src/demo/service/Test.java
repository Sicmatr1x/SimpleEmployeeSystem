package demo.service;

import java.text.ParseException;
import java.util.Date;

public class Test {
	
	
	
	public static void main(String[] args) {
		try {
			Date date = DateFactory.getDate("2017-01-01");
			Date date2 = DateFactory.getDate("2017-04-01");
			System.out.println(date.getYear());
			System.out.println(date2.getYear());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
