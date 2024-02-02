package dcatano.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
	private DateUtils(){}

	public static int getDateDiff(Date date1, Date date2) {
		LocalDate localDate1 = date1.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
		LocalDate localDate2 = date2.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
		return Period.between(localDate1, localDate2).getYears();
	}
}
