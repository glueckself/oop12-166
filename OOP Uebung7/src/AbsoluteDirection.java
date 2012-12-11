/**
 * Absolute directions: up, down, left, right, etc.
 * 
 * @detail Every direction has also an integer representation.
 * @author Srdjan Markovic
 */
public enum AbsoluteDirection {
    TOP(0),
    TOP_RIGHT(1),
    RIGHT(2),
    BOTTOM_RIGHT(3),
    BOTTOM(4),
    BOTTOM_LEFT(5),
    LEFT(6),
    TOP_LEFT(7);
    
    private int value;
    
    /**
     * Assigns a integer value to a AbsoluteDirection-Object.
     * @param value Integer represntation to be assigned.
     */
    private AbsoluteDirection(int value) {
        this.value=value;
    }
    
    /**
     * Converts a integer to AbsoluteDirection.
     * @param index Index of direction.
     * @return AbsoluteDirection-Object corresponding to index.
     */
    public static AbsoluteDirection getDirectionFromInt(int index) {
        AbsoluteDirection retval;
        switch(index) {
            case 0: retval=TOP; break;
            case 1: retval=TOP_RIGHT; break;
            case 2: retval=RIGHT; break;
            case 3: retval=BOTTOM_RIGHT; break;
            case 4: retval=BOTTOM; break;
            case 5: retval=BOTTOM_LEFT; break;
            case 6: retval=LEFT; break;
            case 7: retval=TOP_LEFT; break;
            default:
                retval=TOP;
                assert(false);
                break;
        }
        return retval;
        
    }
    
    /**
     * Returns a new AbsoluteDirection rotated from the current one.
     * @param direction Direction to rotate to.
     * @return Rotated direction.
     */
    public AbsoluteDirection rotate(RelativeDirection direction) {
        return getDirectionFromInt((direction.getValue()+value)%8);
    }

    /**
     * Integer representation of a direction.
     * @return Integer of direction.
     */
    public int getValue() {
        return value;
    }
    }
