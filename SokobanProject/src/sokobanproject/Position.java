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
        Position empty = new Position(this.col, this.row);
        empty.type=Type.EMPTY;
        return empty;
    }
    
    /**
     * Replace a new position by a player if the old position was a player
     * @param destination the destination of the player
     * @param b the board
     */
    public void replaceByPlayer(Position destination, Board b){
        if(b.listPositions[this.col][this.row].type==Type.PLAYER){
            Position oldPos = b.listPositions[this.col][this.row] ;
            b.listPositions[destination.col][destination.row].type=oldPos.type;
            oldPos.type= Type.EMPTY;
        }
        else{
            //TODO exception 
        }
                                                                                
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
