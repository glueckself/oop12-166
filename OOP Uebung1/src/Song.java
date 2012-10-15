import java.util.Date;

public class Song {
	private String name;
	private String duration;
	private Date releaseDate;
	
	public Song(String name, String duration, Date releaseDate) {
		this.name = name;
		this.duration = duration;
		this.releaseDate = releaseDate;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDuration() {
		return this.duration;
	}
	
	public Date getReleaseDate() {
		return this.releaseDate;
	}
}
