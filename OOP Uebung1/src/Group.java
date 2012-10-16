import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;


public class Group {
    private String name;
    private String genre;
    private ArrayList<Event> events;
    private ArrayList<Member> members;
    private ArrayList<Song> songs;
    
    //Constructor
    public Group(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.events = new ArrayList<Event>();
        this.members = new ArrayList<Member>();
        this.songs = new ArrayList<Song>();
    }
    
    //Set/Get
    public void setName(String name) {
      if(name != "")
        this.name = name;
    }
    
    public void setGenre(String genre) {
      if(genre != "")
        this.genre = genre;
    }

    public String getName() {
        return this.name;
    }
    
    public String getGenre() {
        return this.genre;
    }
   
    public final Event[] getEvents()
    {
        return events.toArray(new Event[events.size()]);
    }
    
    public final Member[] getMembers()
    {
        return members.toArray(new Member[members.size()]);
    }
    
    public final Song[] getSongs() {
        return songs.toArray(new Song[songs.size()]);
    }

    //Add
    public boolean addEvent(Event event) {
      if(event == null) return false;
        this.events.add(event);

        return true;
    }
   
    public boolean addMember(Member member) {
      if(member == null) return false;

      this.members.add(member);
      return true;
    }
    
    public boolean addSong(Song song) {
      if(song == null) return false;

      this.songs.add(song);
      return true;
    }

	//Remove
    public boolean removeMember(Person person) {
        return this.removeMember(person,new Date());
    }
    
	public boolean removeMember(Person person, Date leftDate) {
        for(Member mem: members) {
            if(mem.getPerson() != person) continue;
            
			mem.setLeftDate(leftDate);
			return true;
        }
		return false;
    }
    
	public boolean removeSong(String name) {
        for(Song song: songs) {
            if(song.getName() != name) continue;
                song.delete();

	    	return true;
        }
		return false;
    }
}

