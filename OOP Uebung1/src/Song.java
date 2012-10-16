import java.util.Date;

public class Song {
    private String name;
    private Date duration;
    private Date releaseDate;
	private Date discardedDate;
    
    public Song(String name, Date duration, Date releaseDate) {
        this.name = name;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Date getDuration() {
        if(duration == null)
          return null;

        return (Date)this.duration.clone();
    }
    
    public Date getReleaseDate() {
      if(releaseDate == null)
        return null;

        return (Date)this.releaseDate.clone();
    }
	
    public void delete() {
       this.discardedDate = new Date();
    }

    public Date getDiscardedDate() {
      if(discardedDate == null)
        return null;

      return (Date)this.discardedDate.clone();
    }
}
