import java.util.Date;
import java.util.Calendar;

public class Song {
	private String name;
	private String duration;
	private Date timestamp;
	
	public Song(String name, String duration) {
		this.name = name;
		this.duration = duration;
		this.timestamp = Calendar.getInstance().getTime();
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDuration() {
		return this.duration;
	}
	
	public Date getTimestamp() {
		return this.timestamp;
	}
}
