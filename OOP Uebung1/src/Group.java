import java.util.ArrayList;
import java.util.Date;

public class Group {
	private String name;
	private String genre;
	private ArrayList<Event> events;
	private ArrayList<Member> members;
	private ArrayList<Song> songs;
	
	public Group(String name, String genre) {
		this.name = name;
		this.genre = genre;
		this.events = new ArrayList<Event>();
		this.members = new ArrayList<Member>();
		this.songs = new ArrayList<Song>();
	}
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
	
	public void addEvent(String place, Date date, Date duration, float salary) {
		this.events.add(new Performance(place,date,duration,salary));
	}
	
	public void addMember(Person person, String instrument, Date joinDate) {
		this.members.add(new Member(person,instrument,joinDate));
	}
	
	public void addMember(Person person, String instrument, Date joinDate, Date leftDate) {
		this.members.add(new Member(person,instrument,joinDate,leftDate));
	}
	
	public void addSong(String name, String duration, Date releaseDate) {
		this.songs.add(new Song(name,duration,releaseDate));
	}
}
