public abstract class Player implements Runnable {
  private final int delay;
  private final String name;

  public Player(String name, int stepDelay) {
    this.name=name;
    this.delay=stepDelay;
  }

  abstract protected void step();
  abstract protected int getPoints();

  public void run() {
    while(true) {
      step();
      try {
        Thread.sleep(delay);
      }
      catch (InterruptedException e) {
        int points;
        points = this.getPoints();

        System.out.print("Player" + name +" has " + getPoints() + " ");
        if(points == 1) {
          System.out.println("Point");
        } else {
          System.out.println("Points");
        }

        return;
      }
    }
  }
}
