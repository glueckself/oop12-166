import java.util.Date;

public class Performance extends Event{
    private double salary;
    
    public Performance(String place, Date date, Date duration, double salary) {
        super(place,date,duration);
        this.salary = salary;
    }
    
    public double getSalary() {
        return this.salary;
    }
	
	public String toString() {
		return ("Auftritt in "+getPlace()+", Zeit "+DateFormatter.toString(getDate(),DateType.DateTime)+", Dauer "+DateFormatter.toString(getDuration(),DateType.Time)+"h, Raummiete "+salary);
	}
}
