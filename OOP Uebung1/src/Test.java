

public class Test {
	public static void main(String[] args)
	{
		Group group = new Group("Hansi Hinterseer","Death Metal");
		group.addPerformance("London", "12.03.2013 19:45", "02:30", 2500);
		group.addPerformance("Paris", "23.11.2014 20:30", "01:50", 1000.50);
		group.addPractice("Wien", "19.12.2012 16:00", "02:00", 150);
		for (Event event : group.getEvents())
		{
		    System.out.println(event.toString());
		}
		group.addSong("Shitsong", "04:31", "23.08.2010");
		for (Song song : group.getSongs())
		{
		    System.out.println(song.toString());
		}
		Person person = new Person("Alex","0123456789");
		Instrument instrument = new Instrument("Schlagzeug");
		group.addMember(person, instrument, "03.09.2005");
		for (Member member : group.getMembers())
		{
		    System.out.println(member.toString());
		}
		group.removeMember(person, "08.10.2006");
		for (Member member : group.getMembers())
		{
		    System.out.println(member.toString());
		}
	}
}
