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
     * Converts a string into Date
     *
     * @param date String to convert
     * @param format Format used in date
     * @return Date object according to string or null on error
     */
    public static Date toDate (String date, DateType format) {
        SimpleDateFormat dateFormat = createSDF (format);
        try {
            return dateFormat.parse (date);
        } catch (Exception e) {
            //catching general exception because dateFormat could also be null
            //(not only ParseException)
            return null;
        }
    }

    /**
     * Converts a Date object to String according to format
     *
     * @param date Date object to convert
     * @param format Format used to display date
     * @return String of date
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
     * Creates a SimpleDateFormat object according to format
     *
     * @param format Format enum used to choose constructor argument
     * @return A SimpleDateFormat object
     */
    public static SimpleDateFormat createSDF (DateType format) {
        switch (format) {
        case DateTime:
            return new SimpleDateFormat ("dd.MM.yyyy hh:mm");
        case Date:
            return new SimpleDateFormat ("dd.MM.yyyy");
        case Time:
            return new SimpleDateFormat ("hh:mm");
        case Song:
            return new SimpleDateFormat ("mm:ss");
        default:
            return null;
        }
    }
}
