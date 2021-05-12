package sokobanproject;

/**
 *
 * @author apascal002
 */
public class Player {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board("a",5,6);
        b.fillBoard();
        b.addHorizontalWall(0,5,6); 
        b.addHorizontalWall(0,0,6);
        b.addVerticalWall(0,0,5); 
        b.addVerticalWall(4,0,5);
        b.addBox(2,1); 
        b.addBox(2,3);
        b.addTarget(3,1); 
        b.addTarget(3,2);
        b.setPosition(3,4);
        String a = b.displayBoard();
        System.out.println(a);
        String s = "LULURU";
        movePlayer(s, b);
    }

    /**
     * Move the player following a String given 
     * @param s the string given
     * @param b the board
     */
    public static void movePlayer(String s, Board b){
        Position nextPosition = new Position(0,0);
        for (int i = 0; i < s.length(); i++) {
            Position playerPos = b.getPlayerPos();
            switch (s.charAt(i)) {
                case 'L':
                    nextPosition = b.listPositions[playerPos.col-1][playerPos.row];
                    if(nextPosition.type != Type.WALL){
                    
                        if(nextPosition.type == Type.BOX){
                            nextPosition.replaceByBox(b.listPositions[nextPosition.col-1][nextPosition.row], b);
                            playerPos.replaceByPlayer(nextPosition, b);
                        }
                    playerPos.replaceByPlayer(nextPosition, b);
                    }
                    break;
                case 'R':
                    nextPosition = b.listPositions[playerPos.col+1][playerPos.row];
                    if(nextPosition.type != Type.WALL){
                        if(nextPosition.type == Type.BOX ){
                            nextPosition.replaceByBox(b.listPositions[nextPosition.col+1][nextPosition.row], b);
                            playerPos.replaceByPlayer(nextPosition, b);
                        }
                    playerPos.replaceByPlayer(nextPosition, b);
                    }
                    
                    break;
                case 'U':
                    nextPosition = b.listPositions[playerPos.col][playerPos.row-1];
                    if(nextPosition.type != Type.WALL){
                    
                        if(nextPosition.type == Type.BOX){
                            nextPosition.replaceByBox(b.listPositions[nextPosition.col][nextPosition.row-1], b);
                            playerPos.replaceByPlayer(nextPosition, b);
                        }
                        playerPos.replaceByPlayer(nextPosition, b);
                    }
                    
                    break;
                case 'D':
                    nextPosition = b.listPositions[playerPos.col][playerPos.row+1];
                    if(nextPosition.type != Type.WALL){
                        if(nextPosition.type == Type.BOX){
                            nextPosition.replaceByBox(b.listPositions[nextPosition.col][nextPosition.row+1], b);
                            playerPos.replaceByPlayer(nextPosition, b);
                        }
                    playerPos.replaceByPlayer(nextPosition, b);
                    }
                    break;
            }
            System.out.println(b.displayBoard());
        }
    }
}
