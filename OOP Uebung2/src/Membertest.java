import java.util.Date;

/**
 * ModuleTest for Members
 *
 * @author Srdjan Markovic
 */
class Membertest implements ModuleTest {
    private final String name = "Membertest";
    private String message;
    private Group group;

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
        return message;
    }

    /**
     * Executes the test.
     *
     * @return true if test was successful, false if test failed.
     */
    public boolean runTest() {
        Member[] m_result;
        
        if(group == null) {
            message="group is null";
            return false;
        }
        
        for(int i=0; i<allPersons.length; i++) {
            allPersons[i] = new Person(testData[i][0],testData[i][1]);
        }

        for(int i=0; i<allInstruments.length; i++) {
            allInstruments[i] = new Instrument(testData[i][2]);
        }

        for(int i=0; i<allMembers.length; i++) {
            if(!allPersons[i].getName().equals(testData[i][0])) {
                message="Person #"+i+" error: name mismatch";
                return false;
            }

            if(!allPersons[i].getPhone().equals(testData[i][1])) {
                message="Person #"+i+" error: phone mismatch";
                return false;
            }

            if(!allInstruments[i].getName().equals(testData[i][2])) {
                message="Instrument #"+i+" error";
                return false;
            }

            allMembers[i] = new Member(allPersons[i],allInstruments[i],DateFormatter.toDate(testData[i][3],DateType.Date));

            if(!group.addMember(allMembers[i])) {
                message="Failed to add member";
                return false;
            }
        }

        if(group.addMember(null)) {
            message="added null member";
            return false;
        }


        if(verifyResult(group.getMembers(), new int[]{0,1,2,3})) {
            message="All members: "+message;
            return false;
        }
        
        m_result=GroupMgmt.getMembersTimestamp(group,DateFormatter.toDate("17.11.2011",DateType.Date));
        if(verifyResult(m_result,new int[]{0,1})) {
            message="Timestamp members: "+message;
            return false;
        }
        
        leftDates[0]=DateFormatter.toString(new Date(),DateType.Date);
        leftDates[3]="1.2.2012";
        group.removeMember(allPersons[0]);
        group.removeMember(allPersons[3],DateFormatter.toDate(leftDates[3],DateType.Date));
        
        m_result=GroupMgmt.getMembersActive(group);
        if(verifyResult(m_result,new int[]{1,2})) {
            message="Active members: "+message;
            return false;
        }
        
        m_result=GroupMgmt.getMembersTimestamp(group,DateFormatter.toDate("4.2.2012",DateType.Date));
        if(verifyResult(m_result,new int[]{0,1,2}))  {
            message="Timestamp members 2: "+message;
            return false;
        }

        return true;
    }

    private boolean verifyResult(Member result[], int validEntries[]) {
        boolean successful;
        Date leftDate;

        if(result.length != validEntries.length) {
            message="group.getSongs length different than expected"
                    +" (is: "+ result.length+ ", expected: " +validEntries.length +").";
            return true;
        }

        for(int i=0; i<validEntries.length; i++) {
            successful=false;

            for(int j=0; j<result.length; j++) {
                if(result[j] == null) {
                    message="null result element";
                    return true;
                }
                
                if(result[j].getPerson() != allPersons[validEntries[i]]) continue;
                if(result[j].getInstrument() != allInstruments[validEntries[i]]) continue;
                
                if(!DateFormatter.compare(result[j].getJoinDate(),testData[validEntries[i]][3],DateType.Date)) {
                    message="Join date mismatch for member #"+j;
                    return true;
                }

                leftDate=result[j].getLeftDate();
                if(leftDates[validEntries[i]]==null) {
                    if(leftDate != null) {
                        message="unexpected leftDate on member #"+j;
                        return true;
                    }
                } else {
                    if(leftDate == null) {
                        message="expected leftDate but not found on member #"+j;
                        return true;
                    }
                    if(!DateFormatter.compare(leftDate,leftDates[validEntries[i]],DateType.Date)) {
                        message="leftDate mismatch on member #"+j;
                        return true;
                    }
                }
                
                successful=true;
            }
            
            if(successful) continue;
            
            message="Member #"+i+" not found";
            return true;
        }
        
        return false;
    }
}

