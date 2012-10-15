import java.util.ArrayList;
import java.util.Date;


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
		this.name = name;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public ArrayList<Event> getEvents()
	{
		return events;
	}
	
	public ArrayList<Member> getMembers()
	{
		return members;
	}
	
	public ArrayList<Song> getSongs()
	{
		return songs;
	}
	
	//Add
	public void addEvent(Event event) {
		this.events.add(event);
	}
	
	public boolean addPerformance(String place, String dateString, String durationString, double salary) {
		Date date = DateFormatter.toDate(dateString,DateType.DateTime);
		Date duration = DateFormatter.toDate(durationString,DateType.Time);
		if(date != null && duration != null) {
			this.events.add(new Performance(place,date,duration,salary));
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean addPractice(String place, String dateString, String durationString, double rent) {
		Date date = DateFormatter.toDate(dateString,DateType.DateTime);
		Date duration = DateFormatter.toDate(durationString,DateType.Time);
		if(date != null && duration != null) {
			this.events.add(new Practice(place,date,duration,rent));
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addMember(Member member) {
		this.members.add(member);
	}
	
	public boolean addMember(Person person, Instrument instrument, String joinDateString) {
		Date joinDate = DateFormatter.toDate(joinDateString,DateType.Date);
		if(joinDate != null) {
			this.members.add(new Member(person,instrument,joinDate));
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean addMember(Person person, Instrument instrument, String joinDateString, String leftDateString) {
		Date joinDate = DateFormatter.toDate(joinDateString,DateType.Date);
		Date leftDate = DateFormatter.toDate(leftDateString,DateType.Date);
		if(joinDate != null && leftDate != null) {
			this.members.add(new Member(person,instrument,joinDate,leftDate));
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addSong(Song song) {
		this.songs.add(song);
	}
	
	public boolean addSong(String name, String durationString, String releaseDateString) {
		Date duration = DateFormatter.toDate(durationString,DateType.Song);
		Date releaseDate = DateFormatter.toDate(releaseDateString,DateType.Date);
		if(duration != null && releaseDate != null) {
			this.songs.add(new Song(name,duration,releaseDate));
			return true;
		}
		else {
			return false;
		}
	}
	
	//Remove
	public boolean removeMember(Person person, String leftDate) {
		for(Member mem: members) {
			if(mem.getPerson() != person) continue;
	      
			mem.setLeftDate(DateFormatter.toDate(leftDate, DateType.Date));
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
