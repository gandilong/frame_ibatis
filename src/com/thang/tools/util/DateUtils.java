package com.thang.tools.util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.joda.time.DateTime;

public class DateUtils {
	
	public final static String YYYY_MM="YYYY-MM"; 
	public final static String YYYY_MM_DD="YYYY-MM-dd"; 
	public final static String YYYY_MM_DD_HH_mm_ss="YYYY-MM-dd HH:mm:ss"; 
	public final static String YYYY_MM_DD_HH_mm_ss_SS="YYYY-MM-dd HH:mm:ss SS"; 
	public final static SimpleDateFormat sdf=new SimpleDateFormat();
	
	public final static Calendar car=Calendar.getInstance();
	
	static {//设置时区为本地默认时�?
		sdf.setTimeZone(TimeZone.getDefault());
		car.setTimeZone(TimeZone.getDefault());
	}
	
	/**
	 * ===============================================
	 *         常用方法返回类型为字符串
	 * ================================================
	 */
	
	
	/**
	 * 返回YYYY-MM 为格式的时间字符
	 * @return String
	 */
	public static String getSysmonth(){
		return DateTime.now().toString(DateUtils.YYYY_MM);
	}
	
	/**
	 * 返回YYYY-MM-DD 为格式的时间字符
	 * @return String
	 */
	public static String getSysdate(){
		return DateTime.now().toString(DateUtils.YYYY_MM_DD);
	}
	
	/**
	 * 返回YYYY-MM-DD HH:mm:ss 为格式的时间字符
	 * @return String
	 */
    public static String getSystime(){
		return DateTime.now().toString(DateUtils.YYYY_MM_DD_HH_mm_ss);
	}
    
    
    /**
     * 返回当前年
     * @return int
     */
    public static int getYear(){
		return DateTime.now().getYear();
	}
    
   /**
    * 返回当前月份
    * @return int
    */
    public static int getMonth(){
		return DateTime.now().getMonthOfYear();
	}
    
    /**
     * 返回当天是当月的第几号
     * @return int
     */
    public static int getDay(){
		return DateTime.now().getDayOfMonth();
	}
    
    /**
     * 返回当前小时
     * @return String
     */
    public static int getHour(){
		return DateTime.now().getHourOfDay();
	}
    
}
