import java.io.Serializable;
import java.util.Date;

/**
 * EventChangePlace
 * 
 * @author Alexander Huber
 */
public class EventChangePlace extends EventChange implements Serializable {
	private static final long serialVersionUID = 1L;
	public EventChangePlace(String place, Date date, Date duration, double value) {
		super(place, date, duration, value);
	}
	
	public String toString() {
		return ("Place " + this.place);
	}
}
