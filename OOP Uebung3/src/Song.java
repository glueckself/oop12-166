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
    /* releaseDate and discardedDate are used to enable listing only songs that are
     * "available" on a specific date
     */
    private Date releaseDate;
    private Date discardedDate;
    /**
     * Constructor
     *
     * @param name Name of the song
     * @param duration Duration of the song
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
     * Get method for name
     *
     * @return String Name of the song
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get method for duration
     *
     * @return Date Duration of the song
     */
    public Date getDuration() {
        if(duration == null)
            return null;

        return (Date)this.duration.clone();
    }

    /**
     * Get method for releaseDate
     *
     * @return Date Date of releasing the song
     */
    public Date getReleaseDate() {
        if(releaseDate == null)
            return null;

        return (Date)this.releaseDate.clone();
    }

    /**
     * Mark a song as deleted (and when it was deleted).
     *
     */
    public void delete() {
        this.discardedDate = new Date();
    }

    /**
     * Get method for discardedDate
     *
     * @return Date Date of deleting the song
     */
    public Date getDiscardedDate() {
        if(discardedDate == null)
            return null;

        return (Date)this.discardedDate.clone();
    }
}
