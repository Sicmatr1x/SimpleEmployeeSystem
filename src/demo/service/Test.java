package demo.service;

import java.text.ParseException;
import java.util.Date;

public class Test {
	
	
	
	public static void main(String[] args) {
		try {
			Date date = DateFactory.getDate("2017-01-01");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
