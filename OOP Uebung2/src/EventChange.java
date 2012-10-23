import java.io.Serializable;
import java.util.Date;


public abstract class EventChange implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String place = null;
	protected Date date = null;
	protected Date duration = null;
	protected double value = 0;
	
    protected EventChange(String place, Date date, Date duration, double value) {
    	this.place = place;
    	this.date = date;
    	this.duration = duration;
    	this.value = value;
    }
    
    public String getPlace() {
    	return this.place;
    }
    
    public Date getDate() {
    	return this.date;
    }
    
    public Date getDuration() {
    	return this.duration;
    }
    
    public double getValue() {
    	return this.value;
    }
    
    public abstract String toString();

}
