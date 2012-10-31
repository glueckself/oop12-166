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
     * creates a member [postcondition]
     * @param person != null [precondition]
     * @param instrument != null [precondition]
     * @param joinDate != null [precondition]
     */
    public Member(Person person, Instrument instrument, Date joinDate) {
        stdConstructor(person,instrument,joinDate);
        Serializer.get().serialize();
    }

    /**
     * creates a member that has already left the group [postcondition]
     * @param person != null [precondition]
     * @param instrument != null [precondition]
     * @param joinDate != null [precondition]
     * @param leftDate != null [precondition]
     */
    public Member(Person person, Instrument instrument, Date joinDate, Date leftDate) {
    	//BAD: doesn't check joinDate-leftDate invariant
        stdConstructor(person,instrument,joinDate);
        this.leftDate = leftDate;
        Serializer.get().serialize();
    }

    /**
     * NOTE: Helper method for Constructor
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
     * @return person [postcondition]
     */
    public Person getPerson() {
        return this.person;
    }

    /**
     * @return instrument [postcondition]
     */
    public Instrument getInstrument() {
        return this.instrument;
    }

    /**
     * @return a copy of joinDate [postcondition]
     */
    public Date getJoinDate() {
        if(this.joinDate == null) return null;
        return (Date)this.joinDate.clone();
    }

    /**
     * @return a copy of leftDate [postcondition]
     */
    public Date getLeftDate() {
        if(this.leftDate == null) return null;

        return (Date)this.leftDate.clone();
    }

    /**
     * sets leftDate of member [postcondition]
     * leftDate before joinDate, else no action performed [precondition]
     * @param leftDate != null [precondition]
     */
    public void setLeftDate(Date leftDate) {
    	//BAD: should return boolean
        if(leftDate == null) return;
        if(this.leftDate != null) return;

        if(leftDate.before(this.joinDate)) return;

        this.leftDate = leftDate;
        Serializer.get().serialize();
    }
}
