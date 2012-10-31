import java.io.Serializable;
import java.util.Date;
/**
 * Represents a member (of a group)
 *
 * @author Alexander Huber
 */
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    private Person person;
    private Instrument instrument;
    private Date joinDate;
    private Date leftDate = null;
    //joinDate before leftDate [invariant]

    /**
     * Constructor
     *
     * @param person Person that becomes a Member
     * @param instrument Instrument played
     * @param joinDate Date of joining a Group
     */
    public Member(Person person, Instrument instrument, Date joinDate) {
    	//person != null, instrument != null, joinDate != null [precondition]
    	//creates a member [postcondition]
        stdConstructor(person,instrument,joinDate);
        Serializer.get().serialize();
    }

    /**
     * overloaded Constructor in case you want to add previous Members
     *
     * @param person Person that becomes a Member
     * @param instrument Instrument played
     * @param joinDate Date of joining a Group
     * @param leftDate Date of leaving a Group
     */
    public Member(Person person, Instrument instrument, Date joinDate, Date leftDate) {
    	//BAD: doesn't check joinDate-leftDate invariant
    	//person != null, instrument != null, joinDate != null, leftDate != null [precondition]
    	//creates a member that has already left the group [postcondition]
        stdConstructor(person,instrument,joinDate);
        this.leftDate = leftDate;
        Serializer.get().serialize();
    }

    /**
     * Helper method for Constructor
     *
     * @param person Person that becomes a Member
     * @param instrument Instrument played
     * @param joinDate Date of joining a Group
     *
     * @throws IllegalArgumentException
     */
    private void stdConstructor(Person person, Instrument instrument, Date joinDate)
    throws IllegalArgumentException {
        if(person == null)
            throw new IllegalArgumentException("Missing argument: person");
        this.person = person;

        if(instrument == null)
            throw new IllegalArgumentException("Missing argument: instrument");
        this.instrument = instrument;

        if(joinDate == null)
            this.joinDate = new Date();
        else
            this.joinDate = joinDate;
    }

    /**
     * Get method for Person
     *
     * @return Person Person that is the Member
     */
    public Person getPerson() {
    	//returns person [postcondition]
        return this.person;
    }

    /**
     * Get method for Instrument
     *
     * @return Instrument Instrument played
     */
    public Instrument getInstrument() {
    	//returns instrument [postcondition]
        return this.instrument;
    }

    /**
     * Get method for joinDate
     *
     * @return Date Date of joining the Group
     */
    public Date getJoinDate() {
    	//returns a copy of joinDate [postcondition]
        if(this.joinDate == null) return null;
        return (Date)this.joinDate.clone();
    }

    /**
     * Get method for leftDate
     *
     * @return Date Date of leaving the Group
     */
    public Date getLeftDate() {
    	//returns a copy of leftDate [postcondition]
        if(this.leftDate == null) return null;

        return (Date)this.leftDate.clone();
    }

    /**
     * Set method for leftDate
     *
     * @param leftDate Date of leaving the Group
     */
    public void setLeftDate(Date leftDate) {
    	//BAD: should return boolean
    	//leftDate before joinDate, else no action performed [precondition]
    	//sets leftDate of member [postcondition]
        if(leftDate == null) return;
        if(this.leftDate != null) return;

        if(leftDate.before(this.joinDate)) return;

        this.leftDate = leftDate;
        Serializer.get().serialize();
    }
}
