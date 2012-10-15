
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatter {
	public static Date toDate(String date, DateType format) {
		try {
			Date simpleDate= new Date();
			if(format == DateType.DateTime) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
				simpleDate = dateFormat.parse(date);
				return simpleDate;
			}
			if(format == DateType.Date) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
				simpleDate = dateFormat.parse(date);
				return simpleDate;
			}
			else if(format == DateType.Time) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
				simpleDate = dateFormat.parse(date);
				return simpleDate;
			}
			else if(format == DateType.Song) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
				simpleDate = dateFormat.parse(date);
				return simpleDate;
			}
			else {
				return null;
			}
		} catch (ParseException e) {
			return null;
		}
	}
	public static String toString(Date date, DateType format) {
		if(format == DateType.DateTime) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
			return dateFormat.format(date);
		}
		if(format == DateType.Date) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
			return dateFormat.format(date);
		}
		else if(format == DateType.Time) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
			return dateFormat.format(date);
		}
		else if(format == DateType.Song) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
			return dateFormat.format(date);
		}
		else {
			return null;
		}
	}
}
