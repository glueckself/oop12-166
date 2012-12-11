/**
 * The AgileEngine is the more agile, but slower engine.
 * @author Julian Großhauser
 */
public class AgileEngine
    extends Engine {
    private final int DELAY=300;

    /**
     * Returns the delay of the engine.
     * @return 
     */
    @Override
    public int getDelay() {
        return DELAY;
    }

    /**
     * Steers the car to a new direction.
     * @param rotDirection Direction to steer.
     * @return Direction the car now faces.
     */
    @Override
    public AbsoluteDirection steer(RelativeDirection rotDirection) {
        return car.getDirection().rotate(rotDirection);
    }
}
