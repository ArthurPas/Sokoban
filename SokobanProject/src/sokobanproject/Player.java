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
        String a = b.displayEmptyBoard();
        System.out.println(a);
    }
    
}
