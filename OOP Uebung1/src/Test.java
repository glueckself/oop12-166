import java.util.Date;

public class Test {
    public static void main(String[] args) {
		Group group = new Group("Hansi Hinterseer","Death Metal");
        if(group == null) {
          System.err.println("Konnte Gruppe nicht erstellen");
          return;
        }

		group.addEvent(new Performance("London",
              DateFormatter.toDate("12.03.2013 19:45",DateType.DateTime),
              DateFormatter.toDate("02:30",DateType.Time),
              2500));
		group.addEvent(new Performance("Paris",
              DateFormatter.toDate("23.11.2014 20:30",DateType.DateTime),
              DateFormatter.toDate("01:50",DateType.Time),
              1000.50));
		group.addEvent(new Practice("Wien",
              DateFormatter.toDate("19.12.2012 16:00",DateType.DateTime),
              DateFormatter.toDate("02:00",DateType.Time),
              150));


		group.addSong(new Song("Testsong",
              DateFormatter.toDate("04:31",DateType.Song),
              DateFormatter.toDate("23.08.2010",DateType.DateTime)));

        System.out.println(">> Alle Songs");
        printSongs(group.getSongs());

        group.removeSong("Testsong");
        System.out.println(">> Alle ohne Testsong");
        printSongs(group.getSongs());

        System.out.println(">> Songs im Zeitbereich");
        printSongs(GroupMgmt.getSongs(group,DateFormatter.toDate("24.08.2010",DateType.Date)));

		Person person = new Person("Alex","0123456789");
		Instrument instrument = new Instrument("Schlagzeug");
		group.addMember(new Member(person, instrument, DateFormatter.toDate("03.09.2005",DateType.Date)));

        System.out.println(">> Alle Mitglieder");
        printMembers(group.getMembers());

        System.out.println(">> Alle Mitglieder ohne Alex");
		group.removeMember(person, DateFormatter.toDate("08.10.2006",DateType.Date));
        printMembers(group.getMembers());
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
                +" (Dauer: " +DateFormatter.toString(song.getDuration(),DateType.Song)
                +", Release: " +DateFormatter.toString(song.getReleaseDate(),DateType.Date)
                +")");
      }
      System.out.println();
    }


    private  static void printMembers(Member mems[]) {
      for(Member member : mems) {
        System.out.println("Mitglied: " + member.getPerson().getName());
      }
      System.out.println();
    }
}
