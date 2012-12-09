public class Car
  extends Player {
  private Movement moveGen;
  private Engine engine;

  public Car(String name, Movement movementGenerator, Engine engine) {
    super(name,engine.getDelay());
    this.moveGen=movementGenerator;
    this.engine=engine;
    engine.useInCar(this);
  }

    @Override
  protected void step() {
    RelativeDirection steeringDirection=moveGen.getDirection();
    direction=engine.steer(steeringDirection);
    movePlayer(direction);
  }
}
