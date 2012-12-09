import java.util.ArrayList;

public class Carriageway {
  private Field[][] fields;
  private ArrayList<Thread> players;

  public Carriageway(int x, int y) {
    if(x < 1) {
          throw new IllegalArgumentException("X must be > 0");
      }
    if(y < 1) {
          throw new IllegalArgumentException("Y must be > 0");
      }

    players = new ArrayList<Thread>();

    fields = new Field[x][y];
    
    for(int i=0; i < x; i++) {
      for(int j=0;j<x;j++) {
        fields[i][j] = new Field(i,j);
        if(j>0) {
            fields[i][j].connectToField(AbsoluteDirection.LEFT, fields[i][j-1]);
            fields[i][j-1].connectToField(AbsoluteDirection.RIGHT,fields[i][j]);
        }
        if(i>0) {
            fields[i][j].connectToField(AbsoluteDirection.TOP, fields[i-1][j]);
            fields[i-1][j].connectToField(AbsoluteDirection.BOTTOM, fields[i][j]);
        }
        if((i>0) && (j>0)) {
            fields[i][j].connectToField(AbsoluteDirection.TOP_LEFT,fields[i-1][j-1]);
            fields[i-1][j-1].connectToField(AbsoluteDirection.BOTTOM_RIGHT, fields[i][j]);
        }
        if((i < (x-1)) && (j > 0)) {
            fields[i][j].connectToField(AbsoluteDirection.TOP_RIGHT,fields[i+1][j]);
            fields[i+1][j].connectToField(AbsoluteDirection.BOTTOM_LEFT,fields[i][j]);
        }
      }
    }
  }

  public void addPlayer(int x, int y, Player player) {
    Thread playerThread;
    try {
      fields[x][y].addPlayer(player);
    }
    catch (ArrayIndexOutOfBoundsException e) {
      fields[0][0].addPlayer(player);
    }

    playerThread = new Thread(player);
    playerThread.start();
    players.add(playerThread);
  }

  public void endGame() {
    for(Thread player : players) {
      player.interrupt();
    }
  }
}
