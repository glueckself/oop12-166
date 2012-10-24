/**
 * Module test for eventplaner
 *
 * @author Srdjan Markovic
 */
class EventPlanerTest implements ModuleTest {
    private Group group;
    private Logger log;

    public EventPlanerTest(Group group) {
        this.group=group;
        log=Test.getTestLogger("EventPlaner");
    }

    /**
     * Returns the name of the test (for logs/UI/...)
     *
     * @return Name of the test
     */
    public String getName() {
        return "EventPlaner";
    }

    /**
     * Returns a info message for a failed test.
     *
     * @return Message
     */
    public String getMessage() {
        return "";
    }

    /**
     * Executes the test.
     * Because adding/filtering events is tested elsewhere, this test only
     * tests removing an event.
     *
     * @return true if test was successful, false if test failed.
     */
    public boolean runTest() {
        boolean success=true;
        Event events[];
        //delaying an event is done by removing it and adding it angain.
        if(group == null) {
            log.addMessage("group is null");
            return false;
        }

        events=group.getEvents();

        if(events.length < 2) {
            log.addMessage("no events returned, creating test event");
            events = new Event[1];
            events[0] = new Practice("Testplace",DateFormatter.toDate("1.2.2012",DateType.Date),
                                     DateFormatter.toDate("01:00",DateType.Time));

            for(Event evt: events) {
                if(!group.addEvent(evt)) {
                    log.addMessage("Failed to add event");
                    return false;
                }
            }
        }

        //we need this event because we need to set the Place/Date/Type
        group.addEvent(new Performance("Testplace 2",
                                       DateFormatter.toDate("1.2.2012",DateType.Date),
                                       DateFormatter.toDate("01:00",DateType.Time)));


        if(!group.removeEvent(events[0])) {
            log.addMessage("Could not remove event 0");
            success=false;
        }

        if(!group.removeEvent("Testplace 2",DateFormatter.toDate("1.2.2012",DateType.Date),EventType.PERFORMANCE)) {
            log.addMessage("Could not remove event 1");
            success=false;
        }

        return success;
    }
}
