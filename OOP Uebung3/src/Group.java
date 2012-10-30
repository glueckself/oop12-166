import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 * Represents a Group
 *
 * @author Alexander Huber
 * @author Srdjan Markovic
 */
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;
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
    	//creates a new Group object with only name and genre [postcondition]
        this.name = name;
        this.genre = genre;
        this.events = new ArrayList<Event>();
        this.members = new ArrayList<Member>();
        this.songs = new ArrayList<Song>();
        this.finances = new ArrayList<Finance>();
        Serializer.get().setGroup(this);
        Serializer.get().serialize();
    }

    /**
     * Set method for name
     *
     * @param name Name of the Group
     */
    public void setName(String name) {
    	//name must not be null [precondition]
    	//sets the name of the group [postcondition]
        if(name.equals(""))
            return;

        this.name = name;
        Serializer.get().serialize();
    }

    /**
     * Set method for genre
     *
     * @param genre Genre of the Group
     */
    public void setGenre(String genre) {
    	//genre must not be null [precondition]
    	//sets the name of the genre [postcondition]
        if(genre.equals(""))
            return;

        this.genre = genre;
        Serializer.get().serialize();
    }

    /**
     * Get method for name
     *
     * @return String Name of the Group
     */
    public String getName() {
    	//returns the name of the group [postcondition]
        return this.name;
    }

    /**
     * Get method for name
     *
     * @return String Genre of the Group
     */
    public String getGenre() {
    	//returns the genre of the group [postcondition]
        return this.genre;
    }

    /**
     * Get method for events
     *
     * @return Event[] Array containing all Events
     */
    public final Event[] getEvents() {
    	//returns the events as array of the group [postcondition]
        return events.toArray(new Event[events.size()]);
    }

    /**
     * Get method for members
     *
     * @return Member[] Array containing all Members
     */
    public final Member[] getMembers() {
    	//returns the members as array of the group [postcondition]
        return members.toArray(new Member[members.size()]);
    }

    /**
     * Get method for songs
     *
     * @return Song[] Array containing all Songs
     */
    public final Song[] getSongs() {
    	//returns the songs as array of the group [postcondition]
        return songs.toArray(new Song[songs.size()]);
    }

    /**
     * Adding an Event
     *
     * @param event Event to be added
     * @return boolean true on success
     */
    public boolean addEvent(Event event) {
    	//event must not be null [precondition]
    	//adds a new event and notifies all members [postcondition]
        if(event == null) return false;

        if(members.size() == 0) return false;

        for(Member mem: members) {
            if(mem.getPerson().notifyEvent(event)) continue;

            return false;
        }

        this.events.add(event);
        Serializer.get().serialize();
        return true;
    }

    /**
     * deleting an Event
     *
     * @param event Event to be deleted
     * @return boolean true on success
     */
    public boolean removeEvent(Event event) {
    	//event must not be null [precondition]
    	//deletes the event from the group (mark as deleted) and returns true.
    	//returns false if the event is not part of this group [postcondition]
        int index;
        index=events.indexOf(event);

        if(index == -1) return false;

        event.delete(true);
        return true;
    }

    /**
     * deleting an Event
     *
     * @param location location of the event
     * @param date date of the event
     * @param type type of the event
     * @return boolean true on success
     */
    public boolean removeEvent(String location, Date date, EventType type) {
    	//searches the event list for a matching event to the given parameters,
    	//deletes the event from the group (mark as deleted) and returns true.
    	//returns false if there is no matching event [postcondition]
        for(int i=0; i<events.size(); i++) {
            if(!events.get(i).getPlace().equals(location)) continue;
            if(events.get(i).getDate().compareTo(date) != 0) continue;

            switch(type) {
            case PRACTICE:
                if(events.get(i) instanceof Practice)
                    events.get(i).delete(true);
                else
                    continue;
                break;

            case PERFORMANCE:
                if(events.get(i) instanceof Performance)
                    events.get(i).delete(true);
                else
                    continue;
                break;

            default:
                return false;
            }

            return true;
        }

        return false;

    }

    /**
     * restoring an Event
     *
     * @param event Event to be restored
     * @return boolean true on success
     */
    public boolean restoreEvent(Event event) {
    	//BAD: does not care if the event is part of this group
    	//event must not be null [precondition]
    	//marks the event as not-deleted [postcondition]
        event.delete(false);
        return true;
    }

    /**
     * Adding a Member
     *
     * @param member Member to be added
     * @return boolean true on success
     */
    public boolean addMember(Member member) {
    	//member must not be null [precondition]
    	//adds member and returns true, or false if member is null [postcondition]
        if(member == null) return false;
        this.members.add(member);
        Serializer.get().serialize();
        return true;
    }

    /**
     * Adding a Song
     *
     * @param song Song to be added
     * @return boolean true on success
     */
    public boolean addSong(Song song) {
    	//song must not be null [precondition]
    	//adds song and returns true, or false if song is null [postcondition]
        if(song == null) return false;
        this.songs.add(song);
        Serializer.get().serialize();
        return true;
    }

    /**
     * Removing a Member (current Date used as time of leaving the Group)
     *
     * @param person Person to be removed
     * @return boolean true on success
     */
    public boolean removeMember(Person person) {
    	//person must not be null [precondition]
    	//removes person from members with the current date as leftDate.
    	//returns true on success, else false [postcondition]
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
    	//person and leftDate must not be null [precondition]
    	//removes person from members with a custom leftDate.
    	//returns true on success, else false [postcondition]
        for(Member mem: members) {
            if(mem.getPerson() != person) continue;
            mem.setLeftDate(leftDate);
            Serializer.get().serialize();
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
    	//name must not be null [precondition]
    	//removes a song, defined by name, returns true on success, else false [postcondition]
        for(Song song: songs) {
            if(song.getName() != name) continue;
            song.delete();
            Serializer.get().serialize();
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
	//return finances [postcondition]
        return finances.toArray(new Finance[finances.size()]);
    }

    /**
     * Add an income or spending.
     *
     * @param finance Income or spending to be added.
     * @return boolean True on success or false on failure.
     */
    public boolean addFinance(Finance finance) {
	//returns false is finance is null, otherwise true [postcondition]
	//adds finance to finances, if finance is not null [postcondition]
        if(finance == null) {
            return false;
        }

        this.finances.add(finance);
        Serializer.get().serialize();
        return true;
    }
}
