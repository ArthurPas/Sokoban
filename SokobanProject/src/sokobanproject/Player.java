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
        Board b = new Board("a",10,10);
        b.fillBoard();
        b.addBox(0, 0);
        b.setPosition(6, 6);
        String a = b.displayBoard();
        System.out.println(a);
        b.listPositions[6][6].replaceByPlayer(new Position(0,1), b);
        System.out.println(b.displayBoard());
    }
    
}
