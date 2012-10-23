import java.io.Serializable;
import java.util.Date;
/**
 * Represents a Member (of a Group)
 *
 * @author Alexander Huber
 */
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
    private Person person;
    private Instrument instrument;
    private Date joinDate;
    private Date leftDate = null;

    /**
     * Constructor
     *
     * @param person Person that becomes a Member
     * @param instrument Instrument played
     * @param joinDate Date of joining a Group
     */
    public Member(Person person, Instrument instrument, Date joinDate) {
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
        return this.person;
    }

    /**
     * Get method for Instrument
     *
     * @return Instrument Instrument played
     */
    public Instrument getInstrument() {
        return this.instrument;
    }

    /**
     * Get method for joinDate
     *
     * @return Date Date of joining the Group
     */
    public Date getJoinDate() {
        if(this.joinDate == null) return null;
        return (Date)this.joinDate.clone();
    }

    /**
     * Get method for leftDate
     *
     * @return Date Date of leaving the Group
     */
    public Date getLeftDate() {
        if(this.leftDate == null) return null;

        return (Date)this.leftDate.clone();
    }

    /**
     * Set method for leftDate
     *
     * @param leftDate Date of leaving the Group
     */
    public void setLeftDate(Date leftDate) {
		if(leftDate == null) return;
		if(this.leftDate != null) return;
		
		if(leftDate.before(this.joinDate)) return;
		
        this.leftDate = leftDate;
        Serializer.get().serialize();
    }
}
