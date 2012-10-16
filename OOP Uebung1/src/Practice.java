import java.util.Date;
/**
 * Represents an Event as Practice
 *
 * @author Alexander Huber
 */
public class Practice extends Event {
    private double rent;
    /**
     * Constructor
     * 
     * @param place Place of the practice
     * @param date Date of the practice
     * @param duration Duration of the practice
     * @param rent Rent of the room for practice
     */
    public Practice(String place, Date date, Date duration, double rent) {
        super(place,date,duration);
        this.rent = rent;
    }
    
    /**
     * Get method for rent
     * 
     * @return double Rent of the room for practice
     */
    public double getValue() {
        return this.rent;
    }
}
