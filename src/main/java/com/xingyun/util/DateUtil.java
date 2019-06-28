package com.xingyun.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil {
	/**
	 * 日期转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getStrFromDate(Date date,String format){
		SimpleDateFormat df = new SimpleDateFormat(format);
		String str = df.format(date);
		return str;
	}
	/**
	 * 字符串--->日期
	 * @param str
	 * @param format
	 * @return
	 */
	public static Date getDateFromStr(String str,String format){
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = df.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static List<Date> getDateFromStrList(List<String> strList,String format){
		//SimpleDateFormat df = new SimpleDateFormat(format);
		List<Date> dateList = new ArrayList<>();
		for(String str : strList){
			Date date = getDateFromStr(str,format);
			dateList.add(date);
		}
		return dateList;
	}
}
