import java.util.Date;

public class Performance extends Event{
	private float salary;
	
	public Performance(String place, Date date, Date duration, float salary) {
		super(place,date,duration);
		this.salary = salary;
	}
	
	public float getSalary() {
		return this.salary;
	}
}
