public class AgileEngine
    extends Engine {
    private final int DELAY=300;

    @Override
    public int getDelay() {
        return DELAY;
    }

    @Override
    public AbsoluteDirection steer(RelativeDirection rotDirection) {
        return car.getDirection().rotate(rotDirection);
    }
}
