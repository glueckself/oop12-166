import java.util.Date;
import java.util.ArrayList;

class GroupMgmt {
    public static void getEvents(Date startDate, Date endDate, EventType eventtype) {
	    ArrayList<Event> events = Event.getEvents();
    	for(Event event : events) {
          //removed to be able to compile it
	      //System.out.println(event);
          return;
	    }
    }

    public static void getSum(Date startDate, Date endDate, EventType eventtype) {

    }

  public static Member[] getMembers(Group group, Date timestamp) {
    ArrayList<Member> members = Group.getMembers();
    ArrayList<Member> retMem = new ArrayList<Member>();
    Date leftDate;

	for(Member mem : members) {
	    if(mem.getJoinDate().compareTo(timestamp) > 0)
	    continue;

      leftDate = mem.getLeftDate();

      if(leftDate == null) {
        retMem.add(mem);
        continue;
      }

      if(mem.getLeftDate().compareTo(timestamp) < 0)
        continue;
	    
    return (Member[])retMem.toArray();
  }
  }

  public static Song[] getSongs(Group group, Date timestamp) {
    ArrayList<Song> songs = Group.getSongs();
    ArrayList<Song> retSong = new ArrayList<Song>();

	for(Song song: songs) {
	    if(songs.getReleaseDate().compareTo(timestamp) > 0)
	    continue;

	    retSong.add(song);
	}

    return (Song[])retSong.toArray();
  }
}
