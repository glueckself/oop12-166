public class Car
  extends Player {

  private Movement moveGen;
  private Engine engine;

  public Car(String name, Movement movementGenerator, Engine engine) {
    super(name,engine.getDelay());
    this.moveGen=movementGenerator;
    this.engine=engine;
  }

  protected void step() {
    return;
  }

  protected int getPoints() {
    return 0;
  }
}
