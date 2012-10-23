import java.util.ArrayList;
import java.util.Date;
/**
 * Represents a Group
 *
 * @author Alexander Huber
 * @author Srdjan Markovic
 */
public class Group {
    private String name;
    private String genre;
    private ArrayList<Event> events;
    private ArrayList<Member> members;
    private ArrayList<Song> songs;
    private ArrayList<Finance> finances;

    /**
     * Constructor
     *
     * @param name Name of the Group
     * @param genre Genre of the Group
     */
    public Group(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.events = new ArrayList<Event>();
        this.members = new ArrayList<Member>();
        this.songs = new ArrayList<Song>();
	this.finances = new ArrayList<Finance>();
    }

    /**
     * Set method for name
     *
     * @param name Name of the Group
     */
    public void setName(String name) {
        if(!name.equals(""))
            this.name = name;
    }

    /**
     * Set method for genre
     *
     * @param genre Genre of the Group
     */
    public void setGenre(String genre) {
        if(!genre.equals(""))
            this.genre = genre;
    }

    /**
     * Get method for name
     *
     * @return String Name of the Group
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get method for name
     *
     * @return String Genre of the Group
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * Get method for events
     *
     * @return Event[] Array containing all Events
     */
    public final Event[] getEvents() {
        return events.toArray(new Event[events.size()]);
    }

    /**
     * Get method for members
     *
     * @return Member[] Array containing all Members
     */
    public final Member[] getMembers() {
        return members.toArray(new Member[members.size()]);
    }

    /**
     * Get method for songs
     *
     * @return Song[] Array containing all Songs
     */
    public final Song[] getSongs() {
        return songs.toArray(new Song[songs.size()]);
    }

    /**
     * Adding an Event
     *
     * @param event Event to be added
     * @return boolean true on success
     */
    public boolean addEvent(Event event) {
        if(event == null) return false;
        this.events.add(event);

        return true;
    }

    /**
     * Adding a Member
     *
     * @param member Member to be added
     * @return boolean true on success
     */
    public boolean addMember(Member member) {
        if(member == null) return false;

        this.members.add(member);
        return true;
    }

    /**
     * Adding a Song
     *
     * @param song Song to be added
     * @return boolean true on success
     */
    public boolean addSong(Song song) {
        if(song == null) return false;

        this.songs.add(song);
        return true;
    }

    /**
     * Removing a Member (current Date used as time of leaving the Group)
     *
     * @param person Person to be removed
     * @return boolean true on success
     */
    public boolean removeMember(Person person) {
        return this.removeMember(person,new Date());
    }

    /**
     * Removing a Member (custom Date used as time of leaving the Group)
     *
     * @param person Person to be removed
     * @param leftDate Custom Date for removed Member
     * @return boolean true on success
     */
    public boolean removeMember(Person person, Date leftDate) {
        for(Member mem: members) {
            if(mem.getPerson() != person) continue;

            mem.setLeftDate(leftDate);
            return true;
        }
        return false;
    }

    /**
     * Removing a Song
     *
     * @param name Name of the Song to be removed
     * @return boolean true on success
     */
    public boolean removeSong(String name) {
        for(Song song: songs) {
            if(song.getName() != name) continue;
            song.delete();

            return true;
        }
        return false;
    }

    /**
     * Returns all finances.
     *
     * @return Finance[] Array containing all finances.
     */
    public Finance[] getFinances() {
	return finances.toArray(new Finance[finances.size()]);
    }

    /**
     * Add an income or spending.
     *
     * @param finance Income or spending to be added.
     * @return boolean True on success or false on failure.
     */
    public boolean addFinance(Finance finance) {
	if(finance == null) {
	    return false;
	}

	this.finances.add(finance);
	return true;
    }
}

