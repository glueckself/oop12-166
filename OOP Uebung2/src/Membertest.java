import java.util.Date;

/**
 * ModuleTest for Members
 *
 * @author Srdjan Markovic
 */
class Membertest implements ModuleTest {
    private final String name = "Membertest";
    private Group group;
    private Logger log;

    //format: Name, Phonenumber, Instrument, Join date
    private final String testData[][] = {
        {"Alex","12345","Guitar","21.02.2010"},
        {"Hans","9879879","Drums","10.10.2010"},
        {"Max","81728","Bass","21.12.2011"},
        {"Moriz","1209348","Guitar","14.12.2011"}
    };

    private String leftDates[];
    private Person allPersons[];
    private Instrument allInstruments[];
    private Member allMembers[];


    public Membertest(Group group) {
        this.group=group;

        allPersons=new Person[testData.length];
        allInstruments=new Instrument[testData.length];
        allMembers=new Member[testData.length];
        leftDates=new String[testData.length];
        log = Test.getTestLogger("Membertest");
    }

    /**
     * Returns the name of the test (for logs/UI/...)
     *
     * @return Name of the test
     */
    public String getName() {
        return name;
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
     *
     * @return true if test was successful, false if test failed.
     */
    public boolean runTest() {
        Member[] m_result;
        boolean success=true;
        
        if(group == null) {
            log.addMessage("Group is null");
            return false;
        }
        
        for(int i=0; i<allPersons.length; i++) {
            allPersons[i] = new Person(testData[i][0],testData[i][1]);
        }

        for(int i=0; i<allInstruments.length; i++) {
            allInstruments[i] = new Instrument(testData[i][2]);
        }

        //we use here "return false" because we need to be sure that Person and
        //Instrument are working correctly, otherwise Member won't work anyway.
        for(int i=0; i<allMembers.length; i++) {
            if(!allPersons[i].getName().equals(testData[i][0])) {
                log.addMessage("Person #"+i+" error: name mismatch");
                return false;
            }

            if(!allPersons[i].getPhone().equals(testData[i][1])) {
                log.addMessage("Person #"+i+" error: phone mismatch");
                return false;
            }

            if(!allInstruments[i].getName().equals(testData[i][2])) {
                log.addMessage("Instrument #"+i+" error");
                return false;
            }

            allMembers[i] = new Member(allPersons[i],allInstruments[i],DateFormatter.toDate(testData[i][3],DateType.Date));

            if(!group.addMember(allMembers[i])) {
                log.addMessage("Failed to add member");
                return false;
            }
        }

        if(group.addMember(null)) {
            log.addMessage("added null member");
            return false;
        }

        log.pushLevel("All members");
        if(verifyResult(group.getMembers(), new int[]{0,1,2,3})) {
          success=false;
        }
        log.popLevel();
        
        log.pushLevel("Timestamp 1");
        m_result=GroupMgmt.getMembersTimestamp(group,DateFormatter.toDate("17.11.2011",DateType.Date));
        if(verifyResult(m_result,new int[]{0,1})) {
            success=false;
        }
        log.popLevel();
        
        log.pushLevel("Active members");
        leftDates[0]=DateFormatter.toString(new Date(),DateType.Date);
        leftDates[3]="1.2.2012";
        group.removeMember(allPersons[0]);
        group.removeMember(allPersons[3],DateFormatter.toDate(leftDates[3],DateType.Date));
        
        m_result=GroupMgmt.getMembersActive(group);
        if(verifyResult(m_result,new int[]{1,2})) {
            success=false;
        }
        log.popLevel();
        
        log.pushLevel("Timestamp 2");
        m_result=GroupMgmt.getMembersTimestamp(group,DateFormatter.toDate("4.2.2012",DateType.Date));
        if(verifyResult(m_result,new int[]{0,1,2}))  {
          success=false;
        }
        log.popLevel();

        return success;
    }

    private boolean verifyResult(Member result[], int validEntries[]) {
        boolean successful;
        Date leftDate;

        if(result.length != validEntries.length) {
            log.addMessage("result length different than expected"
                    +" (is: "+ result.length+ ", expected: " +validEntries.length +").");
            return true;
        }

        for(int i=0; i<validEntries.length; i++) {
            successful=false;

            for(int j=0; j<result.length; j++) {
                if(result[j] == null) {
                    log.addMessage("null result element");
                    return true;
                }
                
                if(result[j].getPerson() != allPersons[validEntries[i]]) continue;
                if(result[j].getInstrument() != allInstruments[validEntries[i]]) continue;
                
                if(!DateFormatter.compare(result[j].getJoinDate(),testData[validEntries[i]][3],DateType.Date)) {
                    log.addMessage("Join date mismatch for member #"+j);
                    return true;
                }

                leftDate=result[j].getLeftDate();
                if(leftDates[validEntries[i]]==null) {
                    if(leftDate != null) {
                        log.addMessage("unexpected leftDate on member #"+j);
                        return true;
                    }
                } else {
                    if(leftDate == null) {
                        log.addMessage("expected leftDate but not found on member #"+j);
                        return true;
                    }
                    if(!DateFormatter.compare(leftDate,leftDates[validEntries[i]],DateType.Date)) {
                        log.addMessage("leftDate mismatch on member #"+j);
                        return true;
                    }
                }
                
                successful=true;
            }
            
            if(successful) continue;
            
            log.addMessage("Member #"+i+" not found");
            return true;
        }
        
        return false;
    }
}

