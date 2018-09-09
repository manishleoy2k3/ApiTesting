package com.api.framework.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTime {

	public static String getCurrentTime(String timeFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
		Calendar calendar = Calendar.getInstance();
		return sdf.format(calendar.getTime());
	}
}
