
package sokobanproject;

/**
 *
 * @author apascal002
 */
public class Position {
    final int col;
    final int row;
    Type type;
    public Position(int col, int row, Type type) {
        this.col = col;
        this.row = row;
        this.type = type;
    }
    
}
