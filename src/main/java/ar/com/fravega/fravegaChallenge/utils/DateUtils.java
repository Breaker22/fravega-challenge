package ar.com.fravega.fravegaChallenge.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private DateUtils() {

	}

	public static Date getParsedDate(String dateToConvert) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		return dateFormat.parse(dateToConvert);
	}

}
