import java.util.Date;

public class Test {
    public static void main(String[] args) {

		Group group = new Group("Hansi Hinterseer","Death Metal");
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

		for (Event event : group.getEvents())
		{
//		    System.out.println(event.toString());
        }

		group.addSong(new Song("Shitsong",
              DateFormatter.toDate("04:31",DateType.Song),
              DateFormatter.toDate("23.08.2010",DateType.DateTime)));

		for (Song song : group.getSongs())
		{
		    System.out.println("Song: "+song.getName()
                +" (Dauer: " +DateFormatter.toString(song.getDuration(),DateType.Song)
                +", Release: " +DateFormatter.toString(song.getReleaseDate(),DateType.Date)
                +")");
		}
		Person person = new Person("Alex","0123456789");
		Instrument instrument = new Instrument("Schlagzeug");
		group.addMember(new Member(person, instrument, DateFormatter.toDate("03.09.2005",DateType.Date)));
		for (Member member : group.getMembers())
		{
//		    System.out.println(member.toString());
		}
		group.removeMember(person, DateFormatter.toDate("08.10.2006",DateType.Date));
		for (Member member : group.getMembers())
		{
//		    System.out.println(member.toString());
		}
        
    }
}
