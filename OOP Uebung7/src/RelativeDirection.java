public enum RelativeDirection {
  TURN_RIGHT(2),
  FORWARD(0),
  TURN_LEFT(-2);
  
  private int value;
  
  private RelativeDirection(int value) {
      this.value=value;
  }
  
  public int getValue() {
      return value;
  }
}
