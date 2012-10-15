import java.util.ArrayList;
import java.util.Date;

public class Group {
	private String name;
	private String genre;
	private ArrayList<Event> event;
	private ArrayList<Member> member;
	private ArrayList<Song> song;
	
	public Group(String name, String genre) {
		this.name = name;
		this.genre = genre;
		this.event = new ArrayList<Event>();
		this.member = new ArrayList<Member>();
		this.song = new ArrayList<Song>();
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
		this.event.add(new Performance(place,date,duration,salary));
	}
	
	public void addMember(Person person, String instrument, Date joinDate) {
		this.member.add(new Member(person,instrument,joinDate));
	}
	
	public void addMember(Person person, String instrument, Date joinDate, Date leftDate) {
		this.member.add(new Member(person,instrument,joinDate,leftDate));
	}
	
	public void addSong(String name, String duration, Date releaseDate) {
		this.song.add(new Song(name,duration,releaseDate));
	}
}
