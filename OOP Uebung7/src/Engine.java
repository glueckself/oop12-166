public abstract class Engine {
    Car car;
    
    public void useInCar(Car car) {
        if(this.car != null) {
            return;
        }
        
        if(car == null) {
            return;
        }
        
        this.car=car;
    }
    
    public abstract int getDelay();
    public abstract AbsoluteDirection steer(RelativeDirection direction);
}
