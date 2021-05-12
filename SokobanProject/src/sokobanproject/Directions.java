package sokobanproject;

/**
 *
 * @author apascal002
 */
public enum Directions {
    R,  // Right
    L,  // left
    U,  // Up
    D;  // Down// Down

    
    public static Directions[] all() {
        Directions[] directions
                = {U, R, L, D};
        return directions;
    }
    /**
     * Gives the number of position after an horizontal movement
     * @return the number of position after the movement
     **/
    public static int horizontalMovement(Directions d){
        int mvt=0;
        switch(d){
            case R:
                mvt=1;
                break;
            case L:
                mvt=-1;
                break;
            case U:
            case D:
                mvt=0;
                break;
        }
        return mvt;
    }
    /**
     * Gives the number of position after a vertical movement
     * @return the number of position after the movement
    **/ 
    public static int verticalMovement(Directions d){
        int mvt=0;
        switch(d){
            case D:
                mvt=1;
                break;
            case U:
                mvt=-1;
                break;
            case R:
            case L:
                mvt=0;
                break;
        }
        return mvt;
    }
    
}
