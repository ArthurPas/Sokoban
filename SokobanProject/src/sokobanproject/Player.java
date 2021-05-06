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
        b.listPositions[0][0].replaceByPlayer(new Position(0,1), b);
        System.out.println(b.displayBoard());
    }
    
}
