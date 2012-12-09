/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author srdj
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
    
    private AbsoluteDirection(int value) {
        this.value=value;
    }
    
    public AbsoluteDirection rotate(RelativeDirection direction) {
        int newValue = (direction.getValue()+value)%8;
        AbsoluteDirection retval;
        switch(newValue) {
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

    public int getValue() {
        return value;
    }
    }
