package fp.util;

public class DateStringConverter {
	public static String getTimeString(String dateTimeString) {
		return dateTimeString.substring(11, 16);
	}
}
