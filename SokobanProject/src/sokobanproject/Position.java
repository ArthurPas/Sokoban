package sokobanproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
     *
     * @param col
     * @param row
     */
    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    /**
     * Make the position empty (with an empty type)
     *
     * @return
     */
    public Position emptyPosition() {
        Position empty = new Position(this.col, this.row);
        empty.type = Type.EMPTY;
        return empty;
    }

    /**
     * Replace a new position by a player if the old position was a player
     *
     * @param destination the destination of the player
     * @param b the board
     */
    public void replaceByPlayer(Position destination, Board b) {
        if (b.listPositions[this.col][this.row].type == Type.PLAYER) {
            Position oldPos = b.listPositions[this.col][this.row];
            b.listPositions[destination.col][destination.row].type = oldPos.type;
            oldPos.type = b.saved.get(oldPos);
        }
    }

    /**
     * Replace a new position by a box if the old position was a box
     *
     * @param destination the destination of the box
     * @param b the board
     */
    public void replaceByBox(Position destination, Board b) {
        if (b.listPositions[this.col][this.row].type == Type.BOX) {
            Position oldPos = b.listPositions[this.col][this.row];
            b.listPositions[destination.col][destination.row].type = oldPos.type;
            oldPos.type = b.saved.get(oldPos);
        }
    }

    /**
     * Method that compare two position to determinate if they are the same
     *
     * @param otherPos the other position to compare
     * @return true if it's the same position
     */
    @Override
    public boolean equals(Object otherPos) {
        Position Compare = (Position) otherPos;
        return this.col == Compare.col && this.row == Compare.row;
    }

}
