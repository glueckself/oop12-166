import java.util.Date;
import java.util.ArrayList;

final class GroupMgmt {
    public static Event[] getEvents(Group group, Date startDate, Date endDate, EventType eventType) {
        Event[] events = group.getEvents();
	ArrayList<Event> retEvent = new ArrayList<Event>();
	Date tmpDate;

	if(events == null) return null;
	if(retEvent == null) return null;

        for(Event event : events) {
	    tmpDate = event.getDate();
	    if(tmpDate == null) continue;

	    //if the date of event is between startDate and endDate, add it
	    if(tmpDate.compareTo(startDate) > 0 && tmpDate.compareTo(endDate) < 0) {
		switch(eventType) {
		    case ALL:
			retEvent.add(event);
			break;

		    case PRACTICE:
			if(event instanceof Practice) {
			    retEvent.add(event);
			}

			break;

		    case PERFORMANCE:
			if(event instanceof Performance) {
			    retEvent.add(event);
			}

			break;

		    default:
			break;
		}
	    }
        }
	
	return retEvent.toArray(new Event[retEvent.size()]);
    }
    
    public static void getSum(Date startDate, Date endDate, EventType eventType) {
        
    }

    public static Member[] getMembersActive(Group group) {
      return getMembersTimestamp(group, new Date());
    }
    
    public static Member[] getMembersTimestamp(Group group, Date timestamp) {
        Member[] members = group.getMembers();
        ArrayList<Member> retMem = new ArrayList<Member>();
        Date tmpDate;

        if(members == null) return null;
        if(retMem == null) return null;
        
        for(Member mem : members) {
            tmpDate = mem.getJoinDate();
            if(tmpDate == null) continue;

            if(mem.getJoinDate().compareTo(timestamp) > 0)
                continue;
            
            tmpDate = mem.getLeftDate();
            
            if(tmpDate == null) { //joined, but not left yet -> we can add the member.
                retMem.add(mem);
                continue;
            }
            
            if(tmpDate.compareTo(timestamp) < 0)
                continue;
        
            retMem.add(mem);
        }

        return retMem.toArray(new Member[retMem.size()]);
    }
    
    public static Song[] getSongsActive(Group group) {
      return getSongsTimestamp(group, new Date());
    }

    public static Song[] getSongsTimestamp(Group group, Date timestamp) {
        Song[] songs = group.getSongs();
        ArrayList<Song> retSong = new ArrayList<Song>();
        Date tmpDate;

        if(songs == null) return null;
        if(retSong == null) return null;

        for(Song song: songs) {
          tmpDate = song.getReleaseDate();
          if(tmpDate == null) continue;

            if(tmpDate.compareTo(timestamp) > 0)
                continue;
            
            tmpDate = song.getDiscardedDate();
            if(tmpDate == null) {
              retSong.add(song);
              continue;
            }

            if(tmpDate.compareTo(timestamp) < 0)
                continue;

            retSong.add(song);
        }
        
        return retSong.toArray(new Song[retSong.size()]);
    }
}
