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
     * creates a group object with name and genre [postcondition]
     * @param name != null [precondition]
     * @param genre != null [precondition]
     */
    public Group(String name, String genre) {
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
     * updates name of its group object if name != "" [postcondition]
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
     * updates genre of its group object if genre != "" [postcondition]
     *
     * @param genre Genre of the group. genre != null [precondition]
     */
    public void setGenre(String genre) {
    	//ERROR: does not check if precondition is met
        if(genre.equals(""))
            return;

        this.genre = genre;
        Serializer.get().serialize();
    }

    /**
     * @return the name of the group [postcondition]
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the genre of the group [postcondition]
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * @return the events as array of the group [postcondition]
     */
    public final Event[] getEvents() {
        return events.toArray(new Event[events.size()]);
    }

    /**
     * @return the members as array of the group [postcondition]
     */
    public final Member[] getMembers() {
        return members.toArray(new Member[members.size()]);
    }

    /**
     * @return the songs as array of the group [postcondition]
     */
    public final Song[] getSongs() {
        return songs.toArray(new Song[songs.size()]);
    }

    /**
     * event is added if the group has members and all members accept this event [postcondition]
     * all members are notified about the new event [postcondition]
     *
     * @param event != null [precondition]
     * @return boolean true on success, else false [postcondition]
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
     * event is marked as deleted from list if its found [postcondition]
     *
     * NOTE: initial idea was to remove event from the list and has been
     * changed by Alexander to be only marked as deleted. This may have broken
     * compatibility
     * @param event != null [precondition]
     * @return boolean true on success, else false [postcondition]
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
     * event is marked as deleted if it matches the requested criteria. [postcondition]
     * 
     * @param location != null [precondition]
     * @param date != null [precondition]
     * @return boolean true on success, else false [postcondition]
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
     * marks the event as not-deleted [postcondition]
     * @param event != null [precondition]
     */
    public boolean restoreEvent(Event event) {
    	//BAD: does not care if the event is part of this group
    	//ERROR: always returns true
        event.delete(false);
        return true;
    }

    /**
     * adds a member [postcondition]
     * @param member != null [precondition]
     * @return boolean true on success, false if member is null [postcondition]
     */
    public boolean addMember(Member member) {
        if(member == null) return false;
        this.members.add(member);
        Serializer.get().serialize();
        return true;
    }

    /**
     * adds a song [postcondition]
     * @param song != null [precondition]
     * @return boolean true on success, false if song is null [postcondition]
     */
    public boolean addSong(Song song) {
        if(song == null) return false;
        this.songs.add(song);
        Serializer.get().serialize();
        return true;
    }

    /**
     * person != null [precondition]
     * person is member of this group [precondition]
     *
     * person is marked as "left" with the current timestamp as leftDate [postcondition]
     *
     * @return boolean true on success [postcondition]
     */
    public boolean removeMember(Person person) {
        return this.removeMember(person,new Date());
    }

    /**
     * leftDate != null [precondition]
     * person != null [precondition]
     * person is member of this group [precondition]
     * 
     * person is marked as "left" with date leftDate [postcondition]
     *
     * ERROR: this method can alter leftDate of a person.
     * @return boolean true on success, else false [postcondition]
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
     * name must be name of a song of this group [precondition]
     * song of a group is marked as deleted with the current timestamp [postcondition]
     *
     * @param name != null [precondition]
     * @return boolean true on success, else false [postcondition]
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
     * @param finance != null [precondition]
     * @return false if finance is null, otherwise true [postcondition]
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
