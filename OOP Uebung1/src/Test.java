import java.util.Date;

public class Test {
    public static void main(String[] args) {
		Group group = new Group("Hansi Hinterseer","Death Metal");

        if(group == null) { 
          System.err.println("Konnte Gruppe nicht erstellen");
          return;
        }
		
        /* Events-Tests */
        group.addEvent(new Performance("Paris",
              DateFormatter.toDate("23.11.2014 20:30",DateType.DateTime),
              DateFormatter.toDate("01:50",DateType.Time),
              1000.50));
		group.addEvent(new Practice("Wien",
              DateFormatter.toDate("19.12.2012 16:00",DateType.DateTime),
              DateFormatter.toDate("02:00",DateType.Time),
              150));

        /* Songs-Test */
		group.addSong(new Song("Testsong",
              DateFormatter.toDate("04:31",DateType.Song),
              DateFormatter.toDate("23.08.2010",DateType.Date)));
		group.addSong(new Song("Testsong 2",
              DateFormatter.toDate("04:21",DateType.Song),
              DateFormatter.toDate("23.08.2012",DateType.Date)));

        System.out.println(">> Alle Songs");
        printSongs(group.getSongs());

        group.removeSong("Testsong");
        System.out.println(">> Alle aktiven Songs");
        printSongs(GroupMgmt.getSongsActive(group));

        System.out.println(">> Alle am 20.08.2010 verfügbare Songs");
        printSongs(GroupMgmt.getSongsTimestamp(group,DateFormatter.toDate("20.08.2010",DateType.Date)));

        System.out.println(">> Alle am 25.08.2010 verfügbare Songs");
        printSongs(GroupMgmt.getSongsTimestamp(group,DateFormatter.toDate("25.08.2010",DateType.Date)));

        /* Members-Test */
		Person alex = new Person("Alex","0123456789");
        Person hans = new Person("Hans","1234");

		Instrument schlagzeug = new Instrument("Schlagzeug");
        Instrument gitarre = new Instrument("Gitarre");

		group.addMember(new Member(alex, schlagzeug, DateFormatter.toDate("03.09.2005",DateType.Date)));
        group.addMember(new Member(hans, gitarre, DateFormatter.toDate("01.01.2005",DateType.Date)));

        System.out.println(">> Alle Mitglieder");
        printMembers(group.getMembers());

        System.out.println(">> Alle aktiven Mitglieder");
		group.removeMember(alex, DateFormatter.toDate("08.10.2006",DateType.Date));
        printMembers(GroupMgmt.getMembersActive(group));

        System.out.println(">> Alle Mitglieder am 01.01.2006");
        printMembers(GroupMgmt.getMembersTimestamp(group,DateFormatter.toDate("01.01.2006",DateType.Date)));
    }

    private static void printEvents(Event events[]) {
      for(Event event : events) {
        break;
      }
      System.out.println();
    }

    private static void printSongs(Song songs[]) {
      for(Song song: songs) {
		    System.out.println("Song: "+song.getName()
                +" (Dauer: " +DateFormatter.toString(song.getDuration(),DateType.Song)+")");
      }
      System.out.println();
    }


    private  static void printMembers(Member mems[]) {
      for(Member member : mems) {
        System.out.println("Mitglied: " + member.getPerson().getName() + " ("
            + "Telefon: "+member.getPerson().getPhone() + ", "
            + "Spielt: "+member.getInstrument().toString()+")");
      }
      System.out.println();
    }
}
