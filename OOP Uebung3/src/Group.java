import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 * Represents a Group
 *
 * is an empty group object [postcondition]
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
     * creates a group object with name and genre [postcondition]
     * requires a name and a genre for the group [precondition]
     *
     * @param name Name of the Group
     * @param genre Genre of the Group
     */
    public Group(String name, String genre) {
    	//name != null, genre != null [precondition]
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
     * Set method for name.
     * updates name of its group object iif name != "" [postcondition]
     *
     * @param name Name of the group. name != null [precondition]
     */
    public void setName(String name) {
      //ERROR: does not check if precondition is met
        if(name.equals(""))
            return;

        this.name = name;
        Serializer.get().serialize();
    }

    /**
     * Set method for genre.
     * updates genre of its group object iif genre != "" [postcondition]
     *
     * @param genre Genre of the group. genre != null [precondition]
     */
    public void setGenre(String genre) {
        if(genre.equals(""))
            return;

        this.genre = genre;
        Serializer.get().serialize();
    }

    /**
     * Get method for name.
     *
     * @return String Name of the Group
     */
    public String getName() {
    	//returns the name of the group [postcondition]
        return this.name;
    }

    /**
     * Get method for name.
     *
     * @return String Genre of the Group
     */
    public String getGenre() {
    	//returns the genre of the group [postcondition]
        return this.genre;
    }

    /**
     * Get method for events.
     *
     * @return Event[] Array containing all Events. 
     */
    public final Event[] getEvents() {
    	//returns the events as array of the group [postcondition]
        return events.toArray(new Event[events.size()]);
    }

    /**
     * Get method for members.
     *
     * @return Member[] Array containing all Members
     */
    public final Member[] getMembers() {
    	//returns the members as array of the group [postcondition]
        return members.toArray(new Member[members.size()]);
    }

    /**
     * Get method for songs.
     *
     * @return Song[] Array containing all Songs
     */
    public final Song[] getSongs() {
    	//returns the songs as array of the group [postcondition]
        return songs.toArray(new Song[songs.size()]);
    }

    /**
     * Adding an Event.
     * event is added iff the group has members and all members accept this event [postcondition]
     * all members are notified about the new event [postcondition]
     * client is notified about success [postcondition]
     *
     * @param event Event to be added, event != null [precondition]
     * @return boolean true on success
     */
    public boolean addEvent(Event event) {
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
     * Remove an Event.
     * event is marked as deleted from list iff its found [postcondition]
     * client is notified about success [postcondition]
     *
     * NOTE: initial idea was to remove event from the list and has been
     * changed by Alexander to be only marked as deleted. This may have broken
     * compatibility
     * @param event Event to be deleted, event != null [precondition]
     * @return boolean true on success
     */
    public boolean removeEvent(Event event) {
        int index;
        index=events.indexOf(event);

        if(index == -1) return false;
        // ERROR: Not sure if indexOf uses the compare-Method to find the index or compares the reference.
        // If the reference is compared, then the following line will work. If not, then this only marks
        // another object with the same values as deleted, not the actual object in the list. 

        event.delete(true);
        return true;
    }

    /**
     * Remove an Event.
     * event is marked as deleted iff it matches the requested criteria. [postcondition]
     * 
     * @param location location of the event, location != null [postcondition]
     * @param date date of the event, event != null [postcondition]
     * @param type type of the event
     * @return boolean true on success
     */
    public boolean removeEvent(String location, Date date, EventType type) {
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
    	//event != null [precondition]
    	//marks the event as not-deleted [postcondition]
        event.delete(false);
        return true;
    }

    /**
     * Adding a Member.
     *
     * @param member Member to be added
     * @return boolean true on success
     */
    public boolean addMember(Member member) {
    	//adds member and returns true, or false if member is null [postcondition]
        if(member == null) return false;
        this.members.add(member);
        Serializer.get().serialize();
        return true;
    }

    /**
     * Adding a Song.
     *
     * @param song Song to be added
     * @return boolean true on success
     */
    public boolean addSong(Song song) {
        if(song == null) return false;
        this.songs.add(song);
        Serializer.get().serialize();
        return true;
    }

    /**
     * Removing a Member (current Date used as time of leaving the Group).
     *
     * person != null [precondition]
     * person is member of this group [precondition]
     *
     * person is marked as "left" with the current timestamp as leftDate [postcondition]
     *
     * @param person Person to be removed
     * @return boolean true on success [postcondition]
     */
    public boolean removeMember(Person person) {
        return this.removeMember(person,new Date());
    }

    /**
     * Removing a Member (custom Date used as time of leaving the Group).
     * leftDate != null [precondition]
     * person != null [precondition]
     * person is member of this group [precondition]
     * 
     * person is marked as "left" with date leftDate [postcondition]
     *
     * ERROR: this method can alter leftDate of a person.
     *
     * @param person Person to be removed
     * @param leftDate Custom Date for removed Member
     * @return boolean true on success [postcondition]
     */
    public boolean removeMember(Person person, Date leftDate) {
        for(Member mem: members) {
            if(mem.getPerson() != person) continue;
            mem.setLeftDate(leftDate);
            Serializer.get().serialize();
            return true;
        }
        return false;
    }

    /**
     * Removing a Song.
     * name must be name of a song of this group [precondition]
     * song of a group is marked as deleted with the current timestamp [postcondition]
     *
     * @param name Name of the Song to be removed
     * @return boolean true on success
     */
    public boolean removeSong(String name) {
          //ERROR: String comparing: equals()
        for(Song song: songs) {
            if(song.getName() != name) continue;
            song.delete();
            Serializer.get().serialize();
            return true;
        }
        return false;
    }

    /**
     * @return finances [postcondition]
     */
    public Finance[] getFinances() {
        return finances.toArray(new Finance[finances.size()]);
    }

    /**
     * @return false is finance is null, otherwise true [postcondition]
     * Adds finance to finances, if finance is not null [postcondition]
     */
    public boolean addFinance(Finance finance) {
        if(finance == null) {
            return false;
        }

        this.finances.add(finance);
        Serializer.get().serialize();
        return true;
    }
}
