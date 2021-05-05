
package sokobanproject;

/**
 *
 * @author apascal002
 */
public class Position {
    final int col;
    final int row;
    Type type = Type.EMPTY;
    
    /**
     * Construcotr of a position
     * @param col
     * @param row
     */
    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }
    
    /**
     * Make the position empty (with an empty type)
     * @return
     */
    public Position emptyPosition() {
        Position vide = new Position(this.col, this.row);
        vide.type=Type.EMPTY;
        return vide;
    }
    
    /**
     * Method that compare two position to determinate if they are the same
     * @param otherPos the other position to compare
     * @return true if it's the same position
     */
    @Override
    public boolean equals(Object otherPos) {
        Position Compare = (Position) otherPos;
        return this.col == Compare.col && this.row == Compare.row;
    }
}
