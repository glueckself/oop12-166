public enum RelativeDirection {
  TURN_RIGHT(2),
  BEAR_RIGHT(1),
  FORWARD(0),
  BEAR_LEFT(-1),
  TURN_LEFT(-2);
  
  private int value;
  
  private RelativeDirection(int value) {
      this.value=value;
  }
  
  public int getValue() {
      return value;
  }
}
