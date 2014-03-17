package com.thang.utils;

import org.joda.time.DateTime;

public class JodaTest {

	
	public static void main(String[] args) {
		DateTime dt=new DateTime();
		
		System.out.println(dt.getYear());
		System.out.println(dt.getMonthOfYear());
		System.out.println(dt.getDayOfMonth());
		System.out.println(dt.getDayOfWeek());
		System.out.println(dt.getDayOfYear());
		System.out.println(dt.getHourOfDay());
		System.out.println(dt.getMinuteOfDay());
		System.out.println(dt.getMinuteOfHour());
		
	    System.out.println(dt.getSecondOfMinute());
		System.out.println(DateTime.now().toString("YYYY-MM-dd HH:mm:ss"));
		
		
		System.out.println(DateTime.now().minusYears(1).toString("yyyy-MM-dd HH:mm:ss"));
		
	}
}
