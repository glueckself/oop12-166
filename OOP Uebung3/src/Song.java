import java.io.Serializable;
import java.util.Date;
/**
 * Represents a song.
 *
 * @author Alexander Huber
 * @author Srdjan Markovic
 */

public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Date duration;
    private Date releaseDate;
    private Date discardedDate;
    //releaseDate before discardedDate [invariant]
    
    /**
     * creates a new song [postcondition]
     * @param name != null [precondition]
     * @param duration != null [precondition]
     * @param releaseDate can be null to take the actual timestamp as releaseDate [precondition]
     */
    public Song(String name, Date duration, Date releaseDate)
    throws IllegalArgumentException {
        if(name == null) throw new IllegalArgumentException("name is null");
        if(name.equals("")) throw new IllegalArgumentException("name is a empty string");
        this.name = name;

        if(duration == null) throw new IllegalArgumentException("duration is null");
        this.duration = duration;

        if(releaseDate == null)
            this.releaseDate=new Date();
        else
            this.releaseDate = releaseDate;
    }

    /**
     * @return name of the song [postcondition]
     */
    public String getName() {
        return this.name;
    }

    /**
     * duration != null [invariant]
     * @return a copy of duration [postcondition]
     */
    public Date getDuration() {
        if(duration == null)
            return null;

        return (Date)this.duration.clone();
    }

    /**
     * releaseDate != null [invariant]
     * @return a copy of releaseDate [postcondition]
     */
    public Date getReleaseDate() {
        if(releaseDate == null)
            return null;

        return (Date)this.releaseDate.clone();
    }

    /**
     * sets discardedDate for a song to current timestamp [postcondition]
     *
     * ERROR: this should not replace a existing discardedDate
     */
    public void delete() {
        this.discardedDate = new Date();
    }

    /**
     * @return Date of deleting the song or null if song is not deleted [postcondition]
     */
    public Date getDiscardedDate() {
        if(discardedDate == null)
            return null;

        return (Date)this.discardedDate.clone();
    }
}
