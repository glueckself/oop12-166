import java.util.Date;

public class Practice extends Event {
	private double rent;
	
	public Practice(String place, Date date, Date duration, double rent) {
		super(place,date,duration);
		this.rent = rent;
	}
	
	public double getRent() {
		return this.rent;
	}
	
	public String toString() {
		return ("Probe in "+getPlace()+", Zeit "+DateFormatter.toString(getDate(),DateType.DateTime)+", Dauer "+DateFormatter.toString(getDuration(),DateType.Time)+"h, Raummiete "+rent);
	}
}
