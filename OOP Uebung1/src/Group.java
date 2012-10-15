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
	
	public void addPerformance(String place, Date date, Date duration, float salary) {
		this.events.add(new Performance(place,date,duration,salary));
	}
	
	public void addPractice(String place, Date date, Date duration, float rent) {
		this.events.add(new Practice(place,date,duration,rent));
	}
	
	public void addMember(Member member) {
		this.members.add(member);
	}
	
	public void addMember(Person person, String instrument, Date joinDate) {
		this.members.add(new Member(person,instrument,joinDate));
	}
	
	public void addMember(Person person, String instrument, Date joinDate, Date leftDate) {
		this.members.add(new Member(person,instrument,joinDate,leftDate));
	}
	
	public void addSong(Song song) {
		this.songs.add(song);
	}
	
	public void addSong(String name, String duration, Date releaseDate) {
		this.songs.add(new Song(name,duration,releaseDate));
	}
	
}
