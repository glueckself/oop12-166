public abstract class Player implements Runnable {
    public final int MAX_POINTS = 10;
    public final int MAX_STEPS = 100;
  final int delay;
  final String name;
  int points;
  protected Field currentField;
  protected AbsoluteDirection direction;
  private Thread controlThread;
  private int steps;
  
  public Player(String name, int stepDelay) {
    this.name=name;
    this.delay=stepDelay;
    this.points=0;
    direction=AbsoluteDirection.TOP;
  }
  
  public void setControlThread(Thread controlThread) {
    this.controlThread = controlThread;
  }
  
  abstract protected void step();
  
  public AbsoluteDirection getDirection() {
      return direction;
  }
  
  protected void movePlayer(AbsoluteDirection direction) {
      int newpoints;
      int xpos, ypos;
      int orientation;
      int nextX, nextY;
      Field nextField;
      newpoints=currentField.removePlayer(this);
      nextField=currentField.getNextField(direction);
      if(nextField == null) {
          return;
      }
        xpos=currentField.getXPos();
        ypos=currentField.getYPos();
        nextX=nextField.getXPos();
        orientation=direction.getValue();
        nextY=nextField.getYPos();
      synchronized(System.out) {
          System.out.println("Player \"" + name +"\": O:"+orientation+", ("+xpos+","+ypos+") -> ("+nextX+","+nextY+").");
      }
      nextField.addPlayer(this,currentField);
      currentField=nextField;
      points+=newpoints;
  }

    /**
     * Main method for player threads.
     * 
     * SleepWhileInLoop is suppressed because the game is separated from the
     * steps. The final implementation of this class can configure how long we
     * should wait and needs only to take care of its step.
     */
    @Override
    @SuppressWarnings("SleepWhileInLoop")
  public void run() {
    while(true) {
      step();
      steps++;
      if(points == MAX_POINTS) {
          if(controlThread != null) {
              controlThread.interrupt();
          }
      }
      if(steps == MAX_STEPS) {
          if(controlThread != null) {
              controlThread.interrupt();
          }
      }
      try {
        Thread.sleep(delay);
      }
      catch (InterruptedException e) {
        synchronized(System.out) {
            System.out.print("Player \"" + name +"\" has " + points + " ");
            if(points == 1) {
              System.out.println("Point");
            } else {
              System.out.println("Points");
            }
        }

        return;
      }
    }
  }
}
