
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatter {
	public static Date toDate(String date, DateType format) {
      SimpleDateFormat dateFormat = createSDF(format);
      try {
	    return dateFormat.parse(date);
      } catch (Exception e) {
        //catching general exception because dateFormat could also be null
        //(not only ParseException)
        return null;
      }
    }

    public static String toString(Date date, DateType format) {
      SimpleDateFormat dateFormat = createSDF(format);
      try {
		return dateFormat.format(date);
      } catch (Exception e) {
        return null;
      }
    }

	public static SimpleDateFormat createSDF(DateType format) {
        switch(format) {
          case DateTime: return new SimpleDateFormat("dd.MM.yyyy hh:mm");
          case Date:     return new SimpleDateFormat("dd.MM.yyyy");
          case Time:     return new SimpleDateFormat("hh:mm");
          case Song:     return new SimpleDateFormat("mm:ss");
          default:       return null;
        }
    }
}
