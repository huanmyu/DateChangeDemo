package com.bowen.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/** 
 *时间转换类 
 */ 
public class DateUtil { 
    private static String ymdhms = "yyyy-MM-dd HH:mm:ss";  
    private static Calendar cale = Calendar.getInstance();  
    /** 日期格式yyyy-MM字符串常量 */  
    public static final String MONTH_FORMAT = "yyyy-MM";  
    /** 日期格式yyyy-MM-dd字符串常量 */  
    public static final String DATE_FORMAT = "yyyy-MM-dd";  
    /** 日期格式HH:mm:ss字符串常量 */  
    public static final String HOUR_FORMAT = "HH:mm:ss";  
    /** 日期格式yyyy-MM-dd HH:mm:ss字符串常量 */  
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";  
    /** 某天开始时分秒字符串常量  00:00:00 */  
    public static final String DAY_BEGIN_STRING_HHMMSS = " 00:00:00";  
    /**  某天结束时分秒字符串常量  23:59:59  */  
    public static final String DAY_END_STRING_HHMMSS = " 23:59:59";  
    private static SimpleDateFormat sdf_date_format = new SimpleDateFormat(DATE_FORMAT);  
    private static SimpleDateFormat sdf_hour_format = new SimpleDateFormat(HOUR_FORMAT);  
    private static SimpleDateFormat sdf_datetime_format = new SimpleDateFormat(DATETIME_FORMAT);  

   /**
    * 长整型的时间转换成指定格式的时间字符串
    * @param date
    * @param format
    * @return
    */
    public static String longToString(long date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);   
        java.util.Date dt2 = new Date(date);   
        String sDateTime = sdf.format(dt2);
        return sDateTime;   
    } 
    
    public static String longToString(long date) {   
    	return longToString(date, ymdhms);   
    }
    
    public static String dateToString(Date date) {   
    	return dateToString(date, ymdhms);
    }   
    //将Date类型的时间转换成指定格式的时间字符串
    public static String dateToString(Date date, String format) {
    	if (date == null) {
    		return "";
    	} else {
    		return longToString(date.getTime(), format);
    	}
    }
     
    /**
     * 
     * @param date
     * @param format
     * @return
     */
    public static Date stringToDate(String date, String format) {
    	
    	if (null != date) {
	        SimpleDateFormat sdf = new SimpleDateFormat(format);   
	        try {
	            Date tmpDate = sdf.parse(date);
	        	return tmpDate;
	        } catch (ParseException e) {   
	            return null;   
	        }   
    	} else {
    		return null;
    	}
    }   
     
    public static Date stringToDate(String date) {   
    	
    	if (null != date) {
	    	SimpleDateFormat sdf = new SimpleDateFormat(ymdhms);   
	    	try {   
	    	
	            return sdf.parse(date);   
	    	} catch (ParseException e) {   
	    		
	            return null;   
	    	}   
    	} else {
    		return null;
    	}
    }  
    //将字符串时间格式转换date类型的日期
    public static Date addOrRollDays(Date date, int number){
    	Calendar calendar = new GregorianCalendar(); 
        calendar.setTime(date); 
        calendar.add(Calendar.DATE, number);
        return calendar.getTime(); 
    }
    
    /** 
     * 获得服务器当前日期，以格式为：yyyy-MM-dd的日期字符串形式返回 
     */  
    public static String getDate() {  
        try {  
            return sdf_date_format.format(cale.getTime());  
        } catch (Exception e) {  
          
            return "";  
        }  
    }  
    
    /** 
     * 返回日期加X天后的日期 
     */  
    public static String addDay(String date, int i) {  
        try {  
            GregorianCalendar gCal = new GregorianCalendar(  
                    Integer.parseInt(date.substring(0, 4)),   
                    Integer.parseInt(date.substring(5, 7)) - 1,   
                    Integer.parseInt(date.substring(8, 10)));  
            gCal.add(GregorianCalendar.DATE, i);  
            return sdf_date_format.format(gCal.getTime());  
        } catch (Exception e) {  
         
            return getDate();  
        }  
    }  
  
    public static Date addMonth(Date date, int i) {  
    	Calendar calendar = new GregorianCalendar(); 
        calendar.setTime(date); 
        calendar.add(Calendar.MONTH, i);
        return calendar.getTime(); 
    }  
   
    public static Date addYear(Date date, int i) {  
    	Calendar calendar = new GregorianCalendar(); 
        calendar.setTime(date); 
        calendar.add(Calendar.YEAR, i);
        return calendar.getTime(); 
    }

	public static Date addMill(Date date, int mill) {
		Calendar calendar = new GregorianCalendar(); 
        calendar.setTime(date); 
        calendar.add(Calendar.SECOND, mill);
        return calendar.getTime(); 
	}
	public static void main(String[] args) {
		Date telActiveDate = DateUtil.stringToDate("2017/08/01", "yyyy-MM-dd");
		Date interActiveDate = DateUtil.stringToDate("2017-08-01", "yyyy-MM-dd");
		System.out.println("telActiveDate:"+telActiveDate+"\ninterActiveDate:"+interActiveDate);
		String s=DateUtil.dateToString(interActiveDate, "yyy.MM.dd");
		System.out.println(s);
	}
}