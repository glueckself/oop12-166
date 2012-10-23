import java.io.Serializable;
import java.util.Date;
/**
 * Represents an Event as Practice
 *
 * @author Alexander Huber
 */
public class Practice extends Event implements Serializable {
	private static final long serialVersionUID = 1L;
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
        Serializer.get().serialize();
    }

    /**
     * Get method for rent
     *
     * @return double Rent of the room for practice
     */
    public double getValue() {
        return this.rent;
    }
    
    /**
     * Change rent for the practice and save old one in history
     *
     * @param double new rent for the event 
     */
    public void changeValue(double newValue) {
    	this.history.add(new EventChangeValue(null,null,null,this.rent));
    	this.rent = newValue;
    	Serializer.get().serialize();
    }
}
