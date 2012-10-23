import java.math.BigDecimal;

/**
 * Tests the getEvents method of GroupMgmt.
 *
 * @author Julian Grosshauser
 */

public class EventListTest implements ModuleTest {
    private final String name = "EventListTest";
    private String message;
    private Group group;

    /**
     * Constructor.
     *
     * @param group Group to test.
     */
    public EventListTest(Group group) {
	this.group = group;
    }

    /**
    * Returns the name of the test (for logs/UI/...)
    *
    * @return Name of the test
    */
    public String getName() {
	return this.name;
    }

    /**
    * Returns a info message for a failed test.
    *
    * @return Message
    */
    public String getMessage() {
	return this.message;
    }

    /**
    * Executes the test.
    *
    * @return True if test was successful, false if test failed.
    */
    public boolean runTest() {
	Event[] returnedEvents;
	BigDecimal returnedSum;

	if(this.group == null) {
	    this.message = "group is null";
	    return false;
	}

	/* Add some events to group*/
	Event[] events = new Event[3];

	events[0] = new Performance("02 Arena",
		DateFormatter.toDate("23.10.2012 20:00", DateType.DateTime),
		DateFormatter.toDate("01:30", DateType.Time),
		new BigDecimal("20000"));
	events[1] = new Performance("House of Blues",
		DateFormatter.toDate("30.10.2012 21:00", DateType.DateTime),
		DateFormatter.toDate("01:00", DateType.Time),
		new BigDecimal("30000"));
	events[2] = new Practice("Studio",
		DateFormatter.toDate("01.11.2012 15:00", DateType.DateTime),
		DateFormatter.toDate("02:00", DateType.Time),
		new BigDecimal("1000"));

	for(Event event : events) {
	    this.group.addEvent(event);
	}

	/* Start actual tests */

	/**
	 * First test:
	 *
	 * This test should return an array of length 1 containing events[0].
	 * The returned sum should be 20000.
	 */
	returnedEvents = GroupMgmt.getEvents(group,
		DateFormatter.toDate("23.10.2012 18:00", DateType.DateTime),
		DateFormatter.toDate("24.10.2012 00:00", DateType.DateTime),
		EventType.ALL);

	returnedSum = GroupMgmt.getSum(group,
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

	if(returnedSum.compareTo(new BigDecimal("20000")) != 0) {
	    this.message = "returned sum is false";
	    return false;
	}

	/**
	 * Second test:
	 *
	 * Same as first test, but it should only return Practices, so the
	 * array will be empty.
	 * The returned sum should be 0.
	 */
	returnedEvents = GroupMgmt.getEvents(group,
		DateFormatter.toDate("23.10.2012 18:00", DateType.DateTime),
		DateFormatter.toDate("24.10.2012 00:00", DateType.DateTime),
		EventType.PRACTICE);

	returnedSum = GroupMgmt.getSum(group,
		DateFormatter.toDate("23.10.2012 18:00", DateType.DateTime),
		DateFormatter.toDate("24.10.2012 00:00", DateType.DateTime),
		EventType.PRACTICE);

	if(returnedEvents.length != 0) {
	    this.message = "number of returned events is false";
	    return false;
	}

	if(returnedSum.compareTo(new BigDecimal("0")) != 0) {
	    this.message = "returned value is false";
	    return false;
	}

	/**
	 * Third test:
	 *
	 * This test should return an array of length 2 containing events[0]
	 * and events[1].
	 * The returned sum should be 50000.
	 */
	returnedEvents = GroupMgmt.getEvents(group,
		DateFormatter.toDate("23.10.2012 18:00", DateType.DateTime),
		DateFormatter.toDate("30.10.2012 23:00", DateType.DateTime),
		EventType.ALL);

	returnedSum = GroupMgmt.getSum(group,
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

	if(returnedSum.compareTo(new BigDecimal("50000")) != 0) {
	    this.message = "returned value is false";
	    return false;
	}

	/**
	 * Forth test:
	 *
	 * This test should return an array of length 3 containing all events.
	 * The returned sum should be 49000.
	 */
	returnedEvents = GroupMgmt.getEvents(group,
		DateFormatter.toDate("23.10.2012 18:00", DateType.DateTime),
		DateFormatter.toDate("02.11.2012 23:00", DateType.DateTime),
		EventType.ALL);

	returnedSum = GroupMgmt.getSum(group,
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

	if(returnedSum.compareTo(new BigDecimal("49000")) != 0) {
	    this.message = "returned value is false";
	    return false;
	}

	/**
	 * Fifth test:
	 *
	 * Same as forth test, but showing only Practices, so it should return
	 * an array of length 1, only containing event[2].
	 * The returned sum should be -1000.
	 */
	returnedEvents = GroupMgmt.getEvents(group,
		DateFormatter.toDate("23.10.2012 18:00", DateType.DateTime),
		DateFormatter.toDate("02.11.2012 23:00", DateType.DateTime),
		EventType.PRACTICE);

	returnedSum = GroupMgmt.getSum(group,
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

	if(returnedSum.compareTo(new BigDecimal("-1000")) != 0) {
	    this.message = "returned value is false";
	    return false;
	}

	/**
	 * Sixth test:
	 *
	 * This test should return an array of length 0, because in this period
	 * of time are no events.
	 * The returned sum should be 0.
	 */
	returnedEvents = GroupMgmt.getEvents(group,
		DateFormatter.toDate("23.10.2013 18:00", DateType.DateTime),
		DateFormatter.toDate("02.11.2013 23:00", DateType.DateTime),
		EventType.ALL);

	returnedSum = GroupMgmt.getSum(group,
		DateFormatter.toDate("23.10.2013 18:00", DateType.DateTime),
		DateFormatter.toDate("02.11.2013 23:00", DateType.DateTime),
		EventType.ALL);

	if(returnedEvents.length != 0) {
	    this.message = "number of returned events is false";
	    return false;
	}

	if(returnedSum.compareTo(new BigDecimal("0")) != 0) {
	    this.message = "returned value is false";
	    return false;
	}

	return true;
    }
}
