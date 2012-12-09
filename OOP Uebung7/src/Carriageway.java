import java.util.ArrayList;

public class Carriageway {
  private Field[][] fields;
  private ArrayList<Thread> players;

  public Carriageway(int x, int y) {
    if(x < 1) throw new IllegalArgumentException("X must be > 0");
    if(y < 1) throw new IllegalArgumentException("Y must be > 0");

    players = new ArrayList<Thread>();

    fields = new Field[x][y];
    for(int i=0; i < x; i++) {
      for(int j=0;j<x;j++) {
        fields[i][y] = new Field();
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
