/**
 * Testing Events: add
 *
 * @author Alexander Huber
 */
public class EventTest implements ModuleTest {
    private final String name = "Eventtest";
    private String message;
    private Group group;

    //format: Place, Date, Duration, Value
    private final String testData[][] = {
        {"Keller","19.02.2013 14:00","04:30"},
        {"Dachboden","23.02.2013 15:00","04:00"},
        {"Moskau","04.07.2013 20:30","03:00"},
        {"Paris","30.01.2014 18:00","01:45"}
    };

    private Event allEvents[];


    /**
     * Constructor
     *
     * @param group
     */
    public EventTest(Group group) {
        this.group=group;

        this.allEvents=new Event[testData.length];
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
     * @return true if test was successful, false if test failed.
     */
    public boolean runTest() {
        Event[] e_result;

        if(group == null) {
            message="group is null";
            return false;
        }

        for(int i=0; i<allEvents.length-2; i++) {
            allEvents[i] = new Practice(testData[i][0],DateFormatter.toDate(testData[i][1],DateType.DateTime),DateFormatter.toDate(testData[i][2],DateType.Time));
        }
        for(int i=allEvents.length-2; i<allEvents.length; i++) {
            allEvents[i] = new Performance(testData[i][0],DateFormatter.toDate(testData[i][1],DateType.DateTime),DateFormatter.toDate(testData[i][2],DateType.Time));
        }
        for(int i=0; i<allEvents.length; i++) {
            if(!group.addEvent(allEvents[i])) {
                message="Failed to add event";
                return false;
            }
        }

        e_result = group.getEvents();
        for(int i=0; i<e_result.length; i++)
        {
            if(e_result[i].getClass() != allEvents[i].getClass()) {
                message = "Class not matching";
                return false;
            }

            if((e_result[i].getPlace()).compareTo(testData[i][0]) != 0) {
                message = "Place not matching";
                return false;
            }
            else if(DateFormatter.toString(e_result[i].getDate(), DateType.DateTime).compareTo(testData[i][1]) != 0) {
                message = "Date not matching";
                return false;
            }
            else if(DateFormatter.toString(e_result[i].getDuration(), DateType.Time).compareTo(testData[i][2]) != 0) {
                message = "Duration not matching";
                return false;
            }
        }

        return true;
    }
}