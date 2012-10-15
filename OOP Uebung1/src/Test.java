import java.util.Date;
import java.text.SimpleDateFormat;


public class Test {
    public static void main(String[] args) {
        
    }
    
    public void createEvents() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
        try {
            Date date = dateFormat.parse("14.09.2013 12:45");
            Date duration = timeFormat.parse("03:00");
            Event event = new Performance("London", date, duration, 2400);
        } catch(Exception e) {
            System.out.println("Fehler");
        }
    }
}
