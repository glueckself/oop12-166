public class CircleMovement
    implements Movement {
    
    private int radius;
    private int counter;
    private boolean straight;
    private RelativeDirection direction;
    
    public CircleMovement(int radius, boolean clockwise) {
        if(radius < 1) {
            throw new IllegalArgumentException("Radius must be > 1");
        }
        this.radius=radius;
        this.straight=true;
        this.counter = 0;
        if(clockwise) {
            direction=RelativeDirection.TURN_RIGHT;
        } else {
            direction=RelativeDirection.TURN_LEFT;
        }
    }
        
    @Override
    public RelativeDirection getDirection() {
        if(counter < radius) {
            counter++;
            if(straight) {
                return RelativeDirection.FORWARD;
            } else {
                return direction;
            }
        } else {
            counter=0;
            straight=(!straight);
            return getDirection();
        }
    }
}
