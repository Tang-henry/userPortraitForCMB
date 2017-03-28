package com.fid.util.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Component;

@Component
public class MyDateUtil {
	public static String yyyyMMdd = "yyyy-MM-dd";
	public static String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	public static String[] parsePatterns = new String[]{yyyyMMdd, yyyyMMddHHmmss};
	
	public Boolean isGtTheTime(Date nowDate, int hour, int minute){
		return isGtTheTime(nowDate, hour, minute, 0);
	}
	
	public Boolean isGtTheTime(Date nowDate, int hour
			, int minute, int second){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nowDate);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		calendar.set(Calendar.MILLISECOND, 0);
		
		Date theDate = calendar.getTime();
		if(nowDate.compareTo(theDate) > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public String DateToString(Date nowDate, String formatType){
		String str = null;
		DateFormat format = new SimpleDateFormat(formatType);
		str = format.format(nowDate);
		return str;
	}
	
	public String DateToString(Date nowDate){
		String str = null;
		DateFormat format = new SimpleDateFormat(yyyyMMdd);
		str = format.format(nowDate);
		return str;
	}
	
	public Long parseDate(String dateStr){
		Long retLong = null;
		
		try {
			Date date = DateUtils.parseDate(dateStr, parsePatterns);
			retLong = date.getTime();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return retLong;
	}
	
}
