import java.util.Date;

/**
 * A few testcases for the group managment program.
 *
 * @author Alexander Huber
 * @author Julian Grosshauser
 * @author Srdjan Markovic
 */

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

        System.out.println(">> Alle Events");
        printEvents(group.getEvents());

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

	/* getEvents testcases */
	System.out.println(">> Alle Events zwischen 18.12.2012 und 24.11.2014 auflisten");
	printEvents(GroupMgmt.getEvents(group, DateFormatter.toDate("18.12.2012", DateType.Date), DateFormatter.toDate("24.11.2014", DateType.Date), EventType.ALL));

	System.out.println(">> Alle Events zwischen 18.12.2012 und 22.11.2014 auflisten");
	printEvents(GroupMgmt.getEvents(group, DateFormatter.toDate("18.12.2012", DateType.Date), DateFormatter.toDate("22.11.2014", DateType.Date), EventType.ALL));

	System.out.println(">> Alle Events zwischen 20.12.2012 und 22.11.2014 auflisten");
	printEvents(GroupMgmt.getEvents(group, DateFormatter.toDate("20.12.2012", DateType.Date), DateFormatter.toDate("22.11.2014", DateType.Date), EventType.ALL));

	System.out.println(">> Alle Practices zwischen 18.12.2012 und 24.11.2014 auflisten");
	printEvents(GroupMgmt.getEvents(group, DateFormatter.toDate("18.12.2012", DateType.Date), DateFormatter.toDate("24.11.2014", DateType.Date), EventType.PRACTICE));

	System.out.println(">> Alle Performances zwischen 18.12.2012 und 24.11.2014 auflisten");
	printEvents(GroupMgmt.getEvents(group, DateFormatter.toDate("18.12.2012", DateType.Date), DateFormatter.toDate("24.11.2014", DateType.Date), EventType.PERFORMANCE));

	/* getSum testcases */
	System.out.println(">> Summe aller Events zwischen 18.12.2012 und 24.11.2014 ausgeben");
	printSum(GroupMgmt.getSum(group, DateFormatter.toDate("18.12.2012", DateType.Date), DateFormatter.toDate("24.11.2014", DateType.Date), EventType.ALL));

	System.out.println(">> Summe aller Practices zwischen 18.12.2012 und 24.11.2014 ausgeben");
	printSum(GroupMgmt.getSum(group, DateFormatter.toDate("18.12.2012", DateType.Date), DateFormatter.toDate("24.11.2014", DateType.Date), EventType.PRACTICE));

	System.out.println(">> Summe aller Performances zwischen 18.12.2012 und 24.11.2014 ausgeben");
	printSum(GroupMgmt.getSum(group, DateFormatter.toDate("18.12.2012", DateType.Date), DateFormatter.toDate("24.11.2014", DateType.Date), EventType.PERFORMANCE));
	
	System.out.println(">> Summe aller Events zwischen 20.12.2012 und 22.11.2014 ausgeben");
	printSum(GroupMgmt.getSum(group, DateFormatter.toDate("20.12.2012", DateType.Date), DateFormatter.toDate("22.11.2014", DateType.Date), EventType.ALL));

        /* Members-Test */
	Person alex = new Person("Alex","0123456789");
        Person hans = new Person("Hans","1234");

	Instrument schlagzeug = new Instrument("Schlagzeug");
        Instrument gitarre = new Instrument("Gitarre");

	group.addMember(new Member(alex, schlagzeug, DateFormatter.toDate("03.09.2005",DateType.Date)));
        group.addMember(new Member(hans, gitarre, DateFormatter.toDate("01.01.2005",DateType.Date)));
		group.addMember(new Member(alex, schlagzeug, DateFormatter.toDate("03.09.2005",DateType.Date)));
        group.addMember(new Member(hans, gitarre, DateFormatter.toDate("01.01.2006",DateType.Date)));

        System.out.println(">> Alle Mitglieder");
        printMembers(group.getMembers());

        System.out.println(">> Alle aktiven Mitglieder");
	group.removeMember(alex, DateFormatter.toDate("08.10.2006",DateType.Date));
		group.removeMember(alex, DateFormatter.toDate("08.10.2006",DateType.Date));
        System.out.println(">> Alle aktiven Mitglieder");
        printMembers(GroupMgmt.getMembersActive(group));

        System.out.println(">> Alle Mitglieder am 01.10.2005");
        printMembers(GroupMgmt.getMembersTimestamp(group,DateFormatter.toDate("01.10.2005",DateType.Date)));
    }

    /**
     * Print events.
     * @param events Contains the events to print
     */
    private static void printEvents(Event events[]) {
      for(Event event : events) {
	  System.out.print("Place: " + event.getPlace() + ", Date: " + DateFormatter.toString(event.getDate(), DateType.Date) + ", Duration: " + DateFormatter.toString(event.getDuration(), DateType.Time) + "h, ");
	  if(event instanceof Performance) System.out.print("Salary: ");
	  if(event instanceof Practice) System.out.print("Rent: ");
	  System.out.println(event.getValue());
      }
      System.out.println();
    }

    /**
     * Print sum.
     *
     * @param sum Sum to print
     */
    private static void printSum(double sum) {
	System.out.println("Sum: " + sum);
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
