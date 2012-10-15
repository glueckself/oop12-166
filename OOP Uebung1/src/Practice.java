import java.util.Date;

public class Practice extends Event {
	private float rent;
	
	public Practice(String place, Date date, String duration, float rent) {
		super(place,date,duration);
		this.rent = rent;
	}
	
	public float getRent() {
		return this.rent;
	}
}
