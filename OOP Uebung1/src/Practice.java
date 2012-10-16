import java.util.Date;

public class Practice extends Event {
    private double rent;
    
    public Practice(String place, Date date, Date duration, double rent) {
        super(place,date,duration);
        this.rent = rent;
    }
    
    public double getRent() {
        return this.rent;
    }
}
