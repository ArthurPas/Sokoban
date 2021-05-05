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
        b.addVerticalWall(0, 0, 5);
        b.addHorizontalWall(0, 0, 5);
        b.setPosition(6, 6);
        String a = b.displayBoard();
        System.out.println(a);
    }
    
}
