
import java.util.ArrayList;
import java.util.Iterator;

public class Field {
    private int xPos;
    private int yPos;
    
    private class PlayerStatus {
        public Player player;
        public int points;
    }

    private Field[] neighbours;
    private final ArrayList<PlayerStatus> playersOnField;

    public Field(int x, int y) {
        xPos = x;
        yPos=y;
        neighbours = new Field[AbsoluteDirection.values().length];
        playersOnField = new ArrayList<PlayerStatus>();
    }
    
    public int getXPos() {
        return xPos;
    }
    
    public int getYPos() {
        return yPos;
    }

    public void connectToField(AbsoluteDirection direction, Field field) {
        neighbours[direction.getValue()] = field;
    }

    public Field getNextField(AbsoluteDirection direction) {
        return neighbours[direction.getValue()];
    }

    public void addPlayer(Player newPlayer, Field incommingField) {
        AbsoluteDirection inDirection = null;
        PlayerStatus newPlayerContainer = new PlayerStatus();
        newPlayerContainer.player=newPlayer;
        newPlayerContainer.points=0;
        
        if(incommingField == null) {
            synchronized(playersOnField) {
                playersOnField.add(newPlayerContainer);
                return;
            }
        }
        
        for(int i=0;i<neighbours.length;i++){ 
            if(neighbours[i] == incommingField) {
                inDirection = AbsoluteDirection.getDirectionFromInt(i);
                break;
            }
        }
        
        if(inDirection == null) {
            assert(false);
        }
        
        synchronized(playersOnField) {
            for(PlayerStatus player : playersOnField) {
                if(inDirection == player.player.direction) {
                    newPlayerContainer.points++;
                    synchronized(System.out) {
                        System.out.println(newPlayer.name + " +1");
                    }
                } else {
                    synchronized(System.out) {
                        System.out.println(player.player.name + " -1");
                    }
                    player.points--;
                }
            }
            playersOnField.add(newPlayerContainer);
        }
        
    }

    public synchronized int removePlayer(Player player) {
        Iterator<PlayerStatus> players = playersOnField.iterator();
        PlayerStatus element;
        int points=0;
        while(players.hasNext()) {
            element=players.next();
            if(element.player != player) {
                continue;
            }
            points = element.points;
            players.remove();
            break;
        }
        return points;
    }
}

