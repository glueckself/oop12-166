import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

enum DateFormat {
	DateTime,
	Date,
	Time,
	Song
}

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
	
	public void addPerformance(String place, String dateString, String durationString, double salary) {
		Date date = getSimpleDateFormat(dateString,DateFormat.DateTime);
		Date duration = getSimpleDateFormat(durationString,DateFormat.Time);
		if(date != null && duration != null) {
			this.events.add(new Performance(place,date,duration,salary));
		}
		else {
			System.out.println("Konnte Auftritt nicht hinzufuegen!");
		}
	}
	
	public void addPractice(String place, String dateString, String durationString, double rent) {
		Date date = getSimpleDateFormat(dateString,DateFormat.DateTime);
		Date duration = getSimpleDateFormat(durationString,DateFormat.Time);
		if(date != null && duration != null) {
			this.events.add(new Practice(place,date,duration,rent));
		}
		else {
			System.out.println("Konnte Probe nicht hinzufuegen!");
		}
	}
	
	public void addMember(Member member) {
		this.members.add(member);
	}
	
	public void addMember(Person person, Instrument instrument, String joinDateString) {
		Date joinDate = getSimpleDateFormat(joinDateString,DateFormat.Date);
		if(joinDate != null) {
			this.members.add(new Member(person,instrument,joinDate));
		}
		else {
			System.out.println("Konnte Mitglied nicht hinzufuegen!");
		}
	}
	
	public void addMember(Person person, Instrument instrument, String joinDateString, String leftDateString) {
		Date joinDate = getSimpleDateFormat(joinDateString,DateFormat.Date);
		Date leftDate = getSimpleDateFormat(leftDateString,DateFormat.Date);
		if(joinDate != null && leftDate != null) {
			this.members.add(new Member(person,instrument,joinDate,leftDate));
		}
		else {
			System.out.println("Konnte Mitglied nicht hinzufuegen!");
		}
	}
	
	public void addSong(Song song) {
		this.songs.add(song);
	}
	
	public void addSong(String name, String durationString, String releaseDateString) {
		Date duration = getSimpleDateFormat(durationString,DateFormat.Time);
		Date releaseDate = getSimpleDateFormat(releaseDateString,DateFormat.Date);
		if(duration != null && releaseDate != null) {
			this.songs.add(new Song(name,duration,releaseDate));
		}
		else {
			System.out.println("Konnte Song nicht hinzufuegen!");
		}
	}
	
	//Remove
	public void removeMember(Person person, Date leftDate) {
		for(Member mem: members) {
			if(mem.getPerson() != person) continue;
	      
			mem.setLeftDate(leftDate);
			break;
		}
	}
		
	public void removeSong(String name) {
		for(Song song: songs) {
			if(song.getName() != name) continue;
	     	
			song.delete();
			break;
		}
	}
	
	//Helper
	private Date getSimpleDateFormat(String date, DateFormat format) {
		try {
			Date simpleDate= new Date();
			if(format == DateFormat.DateTime) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
				simpleDate = dateFormat.parse(date);
				return simpleDate;
			}
			if(format == DateFormat.Date) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
				simpleDate = dateFormat.parse(date);
				return simpleDate;
			}
			else if(format == DateFormat.Time) {
				SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
				simpleDate = timeFormat.parse(date);
				return simpleDate;
			}
			else if(format == DateFormat.Song) {
				SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss");
				simpleDate = timeFormat.parse(date);
				return simpleDate;
			}
			else {
				System.out.println("Unbekanntes Datumsformat als Argument!");
				return null;
			}
		} catch (ParseException e) {
			System.out.println("Datum/Zeit falsch formatiert!");
			return null;
		}
	}
}
