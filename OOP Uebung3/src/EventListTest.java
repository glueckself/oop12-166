/**
 * @author Julian Grosshauser
 */

public class EventListTest implements ModuleTest {
    private final String name = "EventListTest";
    private String message;
    private Group group;

    /**
     * @return New EventListTest object [postcondition]
     */
    public EventListTest(Group group) {
        this.group = group;
    }

    /**
    * @return name [postcondition]
    */
    public String getName() {
        return this.name;
    }

    /**
    * @return message [postcondition]
    */
    public String getMessage() {
        return this.message;
    }

    /**
     * @return true if all tests were successfull
     * otherwise false [postcondition]
     * If an error occurred,
     * message will be set according to the error. [postcondition]
    */
    public boolean runTest() {
        Event[] returnedEvents;

        if(this.group == null) {
            this.message = "group is null";
            return false;
        }

        Event[] events = new Event[3];

        events[0] = new Performance("02 Arena",
		    DateFormatter.toDate("23.10.2012 20:00", DateType.DateTime),
		    DateFormatter.toDate("01:30", DateType.Time));
        events[1] = new Performance("House of Blues",
		    DateFormatter.toDate("30.10.2012 21:00", DateType.DateTime),
		    DateFormatter.toDate("01:00", DateType.Time));
        events[2] = new Practice("Studio",
		    DateFormatter.toDate("01.11.2012 15:00", DateType.DateTime),
		    DateFormatter.toDate("02:00", DateType.Time));

        for(Event event : events) {
            this.group.addEvent(event);
        }

        returnedEvents = GroupMgmt.getEvents(group,
		 DateFormatter.toDate("23.10.2012 18:00", DateType.DateTime),
		 DateFormatter.toDate("24.10.2012 00:00", DateType.DateTime),
		 EventType.ALL);

        if(returnedEvents.length != 1) {
            this.message = "number of returned events is false";
            return false;
        }

        if(!returnedEvents[0].equals(events[0])) {
            this.message = "returned event is false";
            return false;
        }

        returnedEvents = GroupMgmt.getEvents(group,
		 DateFormatter.toDate("23.10.2012 18:00", DateType.DateTime),
		 DateFormatter.toDate("24.10.2012 00:00", DateType.DateTime),
		 EventType.PRACTICE);

        if(returnedEvents.length != 0) {
            this.message = "number of returned events is false";
            return false;
        }

        returnedEvents = GroupMgmt.getEvents(group,
		 DateFormatter.toDate("23.10.2012 18:00", DateType.DateTime),
		 DateFormatter.toDate("30.10.2012 23:00", DateType.DateTime),
		 EventType.ALL);

        if(returnedEvents.length != 2) {
            this.message = "number of returned events is false";
            return false;
        }

        if(!returnedEvents[0].equals(events[0])) {
            this.message = "returned event is false";
            return false;
        }

        if(!returnedEvents[1].equals(events[1])) {
            this.message = "returned event is false";
            return false;
        }

        returnedEvents = GroupMgmt.getEvents(group,
		 DateFormatter.toDate("23.10.2012 18:00", DateType.DateTime),
		 DateFormatter.toDate("02.11.2012 23:00", DateType.DateTime),
		 EventType.ALL);

        if(returnedEvents.length != 3) {
            this.message = "number of returned events is false";
            return false;
        }

        if(!returnedEvents[0].equals(events[0])) {
            this.message = "returned event is false";
            return false;
        }

        if(!returnedEvents[1].equals(events[1])) {
            this.message = "returned event is false";
            return false;
        }

        if(!returnedEvents[2].equals(events[2])) {
            this.message = "returned event is false";
            return false;
        }

        returnedEvents = GroupMgmt.getEvents(group,
		 DateFormatter.toDate("23.10.2012 18:00", DateType.DateTime),
		 DateFormatter.toDate("02.11.2012 23:00", DateType.DateTime),
		 EventType.PRACTICE);

        if(returnedEvents.length != 1) {
            this.message = "number of returned events is false";
            return false;
        }

        if(!returnedEvents[0].equals(events[2])) {
            this.message = "returned event is false";
            return false;
        }

        returnedEvents = GroupMgmt.getEvents(group,
		 DateFormatter.toDate("23.10.2013 18:00", DateType.DateTime),
		 DateFormatter.toDate("02.11.2013 23:00", DateType.DateTime),
		 EventType.ALL);

        if(returnedEvents.length != 0) {
            this.message = "number of returned events is false";
            return false;
        }

        return true;
    }
}
