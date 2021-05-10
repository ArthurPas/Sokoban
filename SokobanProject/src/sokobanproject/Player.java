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
        String s = "LLL";
        movePlayer(s, b);
    }
    public static void movePlayer(String s, Board b){
        Position nextPosition = new Position(0,0);
        for (int i = 0; i < s.length(); i++) {
            Position playerPos = b.getPlayerPos();
            switch (s.charAt(i)) {
                case 'L':
                    nextPosition = new Position(playerPos.col-1, playerPos.row);
                    playerPos.replaceByPlayer(nextPosition, b);
                case 'R':
                    nextPosition = new Position(playerPos.col+1, playerPos.row);
                    playerPos.replaceByPlayer(nextPosition, b);
                case 'U':
                    nextPosition = new Position(playerPos.col, playerPos.row-1);
                    playerPos.replaceByPlayer(nextPosition, b);
                case 'D':
                    nextPosition = new Position(playerPos.col, playerPos.row+1);
                    playerPos.replaceByPlayer(nextPosition, b);
            }
            System.out.println(b.displayBoard());
        }
    }
}
