import java.util.Date;

public abstract class Event {
	private String place;
	private Date date;
	private Date duration;
	
	protected Event(String place, Date date, Date duration) {
		this.place = place;
		this.date = date;
		this.duration = duration;
	}
	
	public String getPlace() {
		return this.place;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public Date getDuration() {
		return this.duration;
	}
	
	public abstract String toString();
}
