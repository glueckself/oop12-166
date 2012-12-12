/**
 * Abstract engine.
 * A engine is always connected to the car, and once connected, can't be removed.
 * @author srdj
 */
public abstract class Engine {
    Car car;
    
    /**
     * Connects a engine to a car.
     * @param car Car to connect to.
     */
    public void useInCar(Car car) {
        if(this.car != null) {
            return;
        }
        
        if(car == null) {
            return;
        }
        
        this.car=car;
    }
    
    /**
     * Returns a delay for stepping.
     * @return Delay.
     */
    public abstract int getDelay();
    
    /**
     * Steers a car.
     * 
     * @param direction Direction to turn to.
     * @return The new direction the car is facing.
     */
    public abstract AbsoluteDirection steer(RelativeDirection direction);
}
