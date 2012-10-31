import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Converts a "natural" date/time String into Date and vice versa
 *
 * @author Alexander Huber
 * @author Srdjan Markovic
 */
public class DateFormatter {
    /**
     * the format of the date String must match the DateType that it should be converted to [precondition]
     * @param date != null [precondition]
     * @return Date object according to string or null on error [postcondition]
     */
    public static Date toDate (String date, DateType format) {
    	SimpleDateFormat dateFormat = createSDF (format);
        try {
            return dateFormat.parse (date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * the content of the date should match the DateType that it should be converted to,
     * to receive a proper String [precondition]
     * @param date != null [precondition]
     * @return String according to Date object or null on error [postcondition]
     */
    public static String toString (Date date, DateType format) {
        SimpleDateFormat dateFormat = createSDF (format);
        try {
            return dateFormat.format (date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @return SimpleDateFormat object according to format [postcondition]
     */
    public static SimpleDateFormat createSDF (DateType format) {
        switch (format) {
        case DateTime:
            return new SimpleDateFormat ("dd.MM.yyyy HH:mm");
        case Date:
            return new SimpleDateFormat ("dd.MM.yyyy");
        case Time:
            return new SimpleDateFormat ("HH:mm");
        case Song:
            return new SimpleDateFormat ("mm:ss");
        default:
            return null;
        }
    }

    /**
     * the content of date1 and date2 should match the DateType [precondition]
     * @param date1 != null [precondition]
     * @param date2 != null [precondition]
     * @return true if dates are equal, false if not or conversion failed [postcondition]
     */
    public static boolean compare(Date date1, Date date2, DateType type) {
        String string2 = DateFormatter.toString(date2,type);
        if(string2 == null) return false;

        return compare(date1,string2,type);
    }

    /**
     * the content of date1 and the format of date2 should match the DateType [precondition]
     * @param date1 != null [precondition]
     * @param date2 != null [precondition]
     * @return true if dates are equal, false if not or conversion failed [postcondition]
     */
    public static boolean compare(Date date1, String date2, DateType type) {
        String string1 = DateFormatter.toString(date1,type);
        if(string1 == null) return false;

        return string1.equals(date2);
    }
}
