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
     * Constructor.
     *
     * @param name Name of the song, name != null [precondition]
     * @param duration Duration of the song, duration != null [precondition]
     * @param releaseDate Date of releasing the song
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
     * Get method for name.
     *
     * @return String Name of the song [postcondition]
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get method for duration.
     * duration != null [invariant]
     *
     * @return Date Duration of the song [postcondition]
     */
    public Date getDuration() {
    	//returns copy of duration [postcondition]
        if(duration == null)
            return null;

        return (Date)this.duration.clone();
    }

    /**
     * Get method for releaseDate.
     *
     * releaseDate != null [invariant]
     *
     * @return Date of releasing the song [postcondition]
     */
    public Date getReleaseDate() {
        if(releaseDate == null)
            return null;

        return (Date)this.releaseDate.clone();
    }

    /**
     * Mark a song as deleted (and when it was deleted).
     *
     * sets discardedDate for a song to current timestamp [postcondition]
     *
     * ERROR: this should not replace a existing discardedDate
     */
    public void delete() {
        this.discardedDate = new Date();
    }

    /**
     * Get method for discardedDate.
     *
     * @return Date of deleting the song or null if song is not deleted [postcondition]
     */
    public Date getDiscardedDate() {
        if(discardedDate == null)
            return null;

        return (Date)this.discardedDate.clone();
    }
}
