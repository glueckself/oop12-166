import java.util.Date;

class GroupMgmt {
  public static Member[] getMembers(Group group, Date timestamp) {
    ArrayList<Member> members = Group.getMembers();
    ArrayList<Member> retMem = new ArrayList<Member>();

    for(Member mem : members) {
      if(mem.getJoinDate().compareTo(timestamp) > 0)
        continue;

      if(mem.getLeftDate().compareTo(timestamp) < 0)
        continue;

      retMem.add(mem);
    }
  
    return retMem.toArray();
  }

  public static Song[] getSongs(Group group, Date timestamp) {
    ArrayList<Song> songs = Group.getSongs();
    ArrayList<Song> retSong = new ArrayList<Member>();

    for(Song song: songs) {
      if(songs.getReleaseDate().compareTo(timestamp) > 0)
        continue;

      retSong.add(song);
    }

    return retSong.toArray();
  }


}

