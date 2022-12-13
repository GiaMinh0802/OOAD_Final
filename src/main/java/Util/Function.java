package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Function {
	public static String convertDateForSQL(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		Date dateconvert = null;
		try {
			dateconvert = formatter.parse(date);
		} catch (ParseException e) {
		}
		String result = new SimpleDateFormat("yyyy-MM-dd").format(dateconvert);
		return result;
	}
	public static String convertDateForJSP(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateconvert = null;
		try {
			dateconvert = formatter.parse(date);
		} catch (ParseException e) {
		}
		String result = new SimpleDateFormat("d MMM YYYY").format(dateconvert);
		return result;
	}
	
	public static String convertDateTimeForJSP(String date) {
		date = date.substring(0, 16);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date dateconvert = null;
		try {
			dateconvert = formatter.parse(date);
		} catch (ParseException e) {
		}
		String result = new SimpleDateFormat("d MMM YYYY hh:mm a").format(dateconvert);
		return result;
	}
	
	public static String convertDateTimeForSQL(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm");
		Date dateconvert = null;
		try {
			dateconvert = formatter.parse(date);
		} catch (ParseException e) {
		}
		String result = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(dateconvert);
		return result;
	}
}
