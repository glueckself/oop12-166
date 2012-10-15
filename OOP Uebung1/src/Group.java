import java.util.ArrayList;
import java.util.Date;

public class Group {
	private String name;
	private String genre;
	private ArrayList<Practice> practice;
	private ArrayList<Performance> performance;
	private ArrayList<Member> member;
	private ArrayList<Song> song;
	
	public Group(String name, String genre) {
		this.name = name;
		this.genre = genre;
		this.practice = new ArrayList<Practice>();
		this.performance = new ArrayList<Performance>();
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
	
	public String genre() {
		return this.genre;
	}
	
	public void addPractice(String place, Date date, String duration, float rent) {
		this.practice.add(new Practice(place,date,duration,rent));
	}
	
	public void addPerformance(String place, Date date, String duration, float salary) {
		this.performance.add(new Performance(place,date,duration,salary));
	}
	
	public void addMember(String name, String phone, String instrument) {
		this.member.add(new Member(name,phone,instrument));
	}
	
	public void addSong(String name, String duration, Date releaseDate) {
		this.song.add(new Song(name,duration,releaseDate));
	}
}
