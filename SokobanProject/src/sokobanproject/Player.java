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
        b.addHorizontalWall(0,4,1);
        
        String a = b.displayBoard();
        System.out.println(a);
        b.listPositions[0][0].replaceByPlayer(new Position(0,1), b);
        System.out.println(b.displayBoard());
    }
    
}
