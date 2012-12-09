import java.util.Random;

public class RandomMovement
    implements Movement {

    Random rng;
    RelativeDirection[] values;
    
    public RandomMovement() {
        rng = new Random();
        values = RelativeDirection.values();
    }
    
    public RelativeDirection getDirection() {
        int index=rng.nextInt(values.length);
        return values[index];
    }
}
            
