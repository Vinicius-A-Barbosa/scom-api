package scom.project.api.util;

import java.time.LocalDate;

public class DateUtils {
	public static String getDate(LocalDate date) {
		String dateString = date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth();
		return dateString;
	}
}
