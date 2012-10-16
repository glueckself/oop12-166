import java.util.Date;
import java.util.ArrayList;

final class GroupMgmt {
    public static void getEvents(Group group, Date startDate, Date endDate, EventType eventtype) {
        Event[] events = group.getEvents();
        for(Event event : events) {
            //removed to be able to compile it
            //System.out.println(event);
            return;
        }
    }
    
    public static void getSum(Date startDate, Date endDate, EventType eventtype) {
        
    }
    
    public static Member[] getMembers(Group group, Date timestamp) {
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
    
    public static Song[] getSongs(Group group, Date timestamp) {
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
            if(tmpDate.compareTo(timestamp) < 0)
                continue;

            retSong.add(song);
        }
        
        return retSong.toArray(new Song[retSong.size()]);
    }
}
