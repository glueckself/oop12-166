import java.util.Date;

class GroupMgmt {
    public static void getEvents(Date startDate, Date endDate, Eventtype eventtype) {
	ArrayList<Event> events = Event.getEvents();
	for(Date event : events) {
	    System.out.println(event);
	}
    }

    public static void getSum(Date startDate, Date endDate, Eventtype eventtype) {

    }
}
