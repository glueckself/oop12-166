/**
 * Car are playable objects in this game.
 * @author srdj
 */
public class Car
  extends Player {
  private Movement moveGen;
  private Engine engine;

  /**
   * Creates a new car.
   * @param name Name of the player.
   * @param movementGenerator Steering of the car (random, circular, ...).
   * @param engine Cars engine.
   */
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
