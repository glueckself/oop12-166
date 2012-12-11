import java.util.ArrayList;

/**
 * Carriageways are playgrounds for the simulation.
 * 
 * A Carriageway is a two-dimensional grid of fields, which have 8 neighbours
 * (top, top-right, right, bottom-right, bottom, bottom-left, left, top-left).
 * 
 * @author srdj
 */
public class Carriageway {

    private Field[][] fields;
    private ArrayList<Thread> players;

    /**
     * Creates a new carriageway.
     * @param x Horizontal size of the carriageway.
     * @param y Vertical size of the carriageway.
     */
    public Carriageway(int x, int y) {
        if (x < 1) {
            throw new IllegalArgumentException("X must be > 0");
        }
        if (y < 1) {
            throw new IllegalArgumentException("Y must be > 0");
        }

        players = new ArrayList<Thread>();

        fields = new Field[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                fields[i][j] = new Field(i,j);
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (j > 0) {
                    fields[i][j].connectToField(AbsoluteDirection.LEFT, fields[i][j - 1]);
                    fields[i][j - 1].connectToField(AbsoluteDirection.RIGHT, fields[i][j]);
                }
                if (i > 0) {
                    fields[i][j].connectToField(AbsoluteDirection.TOP, fields[i - 1][j]);
                    fields[i - 1][j].connectToField(AbsoluteDirection.BOTTOM, fields[i][j]);
                }
                if ((i > 0) && (j > 0)) {
                    fields[i][j].connectToField(AbsoluteDirection.TOP_LEFT, fields[i - 1][j - 1]);
                    fields[i - 1][j - 1].connectToField(AbsoluteDirection.BOTTOM_RIGHT, fields[i][j]);
                }
                if ((i < (x - 1)) && (j > 0)) {
                    fields[i][j].connectToField(AbsoluteDirection.TOP_RIGHT, fields[i + 1][j]);
                    fields[i + 1][j].connectToField(AbsoluteDirection.BOTTOM_LEFT, fields[i][j]);
                }
            }
        }
    }

    /**
     * Adds a player to a field.
     * 
     * @detail If the requested field is invalid, the player is added to (0,0).
     * @param x Horizontal position of the player.
     * @param y Vertical position of the player.
     * @param player Player to be added.
     */
    public void addPlayer(int x, int y, Player player) {
        Thread playerThread;
        try {
            fields[x][y].addPlayer(player,null);
            player.currentField=fields[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            fields[0][0].addPlayer(player,null);
        }

        player.setControlThread(Thread.currentThread());
        playerThread = new Thread(player);
        playerThread.start();
        players.add(playerThread);
    }

    /**
     * Aborts a game at any given time.
     * 
     * @detail Sends a interrupt to all players, so that they can show stats.
     */
    public void endGame() {
        for (Thread player : players) {
            player.interrupt();
        }
    }
}
