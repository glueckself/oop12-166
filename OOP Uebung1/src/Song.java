import java.util.Date;

public class Song {
    private String name;
    private Date duration;
    private Date releaseDate;
	private boolean deleted = false;
    
    public Song(String name, Date duration, Date releaseDate) {
        this.name = name;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Date getDuration() {
        return this.duration;
    }
    
    public Date getReleaseDate() {
        return this.releaseDate;
    }
	
    public void delete() {
       this.deleted = true;
    }
	
	public String toString() {
		return ("Song "+this.name+", Dauer "+DateFormatter.toString(duration, DateType.Song)+"min, Release "+DateFormatter.toString(releaseDate, DateType.Date));
	}
}
