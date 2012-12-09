
public class FastEngine
        extends Engine {

    private final int DELAY = 100;
    private RelativeDirection lastDirection;

    @Override
    public int getDelay() {
        return DELAY;
    }

    @Override
    public AbsoluteDirection steer(RelativeDirection direction) {
        AbsoluteDirection retval = AbsoluteDirection.TOP;

        if (lastDirection == null) {
            switch (direction) {
                case TURN_LEFT:
                case TURN_RIGHT:
                    lastDirection = direction;
                // no break here, as we just need to set lastDirection and
                // rotate as normal
                case FORWARD:
                case BEAR_LEFT:
                case BEAR_RIGHT:
                    retval = car.getDirection().rotate(direction);
                    break;
                default:
                    assert (false);
                    break;
            }
        } else {
            /* we're ignoring direction because our engine is inert
             and can only continue in the according direction */
            switch (lastDirection) {
                case TURN_RIGHT:
                case TURN_LEFT:
                    retval = car.getDirection().rotate(lastDirection);
                    lastDirection = null;
                    break;
                default:
                    assert (false);
                    break;
            }
        }

        return retval;
    }
}
