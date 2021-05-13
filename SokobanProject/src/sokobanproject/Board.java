package sokobanproject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author apascal002
 */
public class Board {
    String boardName;
    int nbCol;
    int nbRow;
    public Position[][] listPositions;
    HashMap<Position, Type> saved = this.savedInitialType();
    /**
     * Construtor of the Board
     * @param boardName the name of the board
     * @param nbCol the number of columns
     * @param nbrow the number of rows
     */
    public Board(String boardName, int nbCol, int nbrow) {
        this.boardName = boardName;
        this.nbCol = nbCol;
        this.nbRow = nbrow;
        this.listPositions = new Position[this.nbCol][this.nbRow];
        this.saved = new HashMap<>();
    }

    /**
     * Get the Position of the player
     * @return the Position of the player
     */
    public Position getPlayerPos(){
        for (int col = 0; col < this.nbCol; col++) {
            for (int row = 0; row < this.nbRow; row++) {
                if(this.listPositions[col][row].type == Type.PLAYER){
                    return new Position(col,row);
                }
            }
        }
        return null;
    }
        /**
     * Get the Position of the box
     * @return the Position of the player
     */
    public ArrayList<Position> getBoxPos(){
        ArrayList<Position> BoxesPos= new ArrayList<>();
        for (int col = 0; col < this.nbCol; col++) {
            for (int row = 0; row < this.nbRow; row++) {
                if(this.listPositions[col][row].type == Type.BOX){
                    BoxesPos.add(this.listPositions[col][row]);
                }
            }
        }
        return BoxesPos;
    }
    public ArrayList<Position> getTargetsPos(){
        ArrayList<Position> BoxesPos= new ArrayList<>();
        for (int col = 0; col < this.nbCol; col++) {
            for (int row = 0; row < this.nbRow; row++) {
                if(this.listPositions[col][row].type == Type.TARGET){
                    BoxesPos.add(this.listPositions[col][row]);
                }
            }
        }
        return BoxesPos;
    }
    /**
     * Add some horizontal wall on the board
     * @param posCol the position of the column
     * @param posRow the position of the row
     * @param length the length to determinate how many wall it will add
     */
    public void addHorizontalWall(int posCol, int posRow, int length){
        for (int i = 0; i < length; i++) {
            if(posCol+i < this.nbCol){
                this.listPositions[posCol+i][posRow].type = Type.WALL;
            }
        }
    }
    /**
     * Add some vertical wall on the board
     * @param posCol the position of the column
     * @param posRow the position of the row
     * @param length the length to determinate how many wall it will add
     */
    public void addVerticalWall(int posCol, int posRow, int length){
        for (int i = 0; i < length; i++) {
            if(posRow+i < this.nbRow){
                this.listPositions[posCol][posRow+i].type = Type.WALL;
            }
        }
    }
    
    /**
     * Add a box on the board
     * @param posCol the position of the column
     * @param posRow the position of the row
     */
    public void addBox(int posCol, int posRow){
        this.listPositions[posCol][posRow].type = Type.BOX;
    }
    
    /**
     * Add a target on the board
     * @param posCol the position of the column
     * @param posRow the position of the row
     */
    public void addTarget(int posCol, int posRow){
        this.listPositions[posCol][posRow].type =  Type.TARGET;
    }
    
    /**
     * Set the player's position
     * @param posCol the position of the column
     * @param posRow the position of the row
     */
    public void setPosition(int posCol, int posRow){
        this.listPositions[posCol][posRow].type = Type.PLAYER;
    }
    
    /**
     * Method which fill the board with empty position
     */
    public void fillBoard(){
        for (int col = 0; col < this.nbCol; col++) {
            for (int row = 0; row < this.nbRow; row++) {
                Position p = new Position(col,row);
                this.listPositions[col][row] = p.emptyPosition();;
            }
        }
    }
    public HashMap<Position, Type> savedInitialType(){
        for (int col = 0; col < this.nbCol; col++) {
            for (int row = 0; row < this.nbRow; row++) {
                if(this.listPositions[col][row].type != Type.PLAYER && this.listPositions[col][row].type != Type.BOX ){
                    saved.put(this.listPositions[col][row], this.listPositions[col][row].type);
                }
                else if (this.listPositions[col][row].type == Type.BOX){
                    saved.put(this.listPositions[col][row],Type.EMPTY);
                }
                else if(this.listPositions[col][row].type == Type.PLAYER ){
                    saved.put(this.listPositions[col][row],Type.EMPTY);
                }
                
            }
        }
        return saved;
    } 
    /**
     * String that represent an empty board
     * @return the string that represent an empty board
     */
    public String displayEmptyBoard(){
        StringBuilder builder = new StringBuilder("").append(System.lineSeparator());
        for (int row=-1; row< this.nbRow ;row++){

            if(row!=-1 && row<10){
                builder.append(row);
            }
            else if(row>-1){
                builder.append(row);
            }
            for (int col=-1; col<this.nbCol ;col++){
                if(col==-1){
                    builder.append(" ");
                }
                if(row==-1 && col>-1){
                    builder.append("  ");
                    builder.append(col);
                }
                if(row>-1 && col>-1){
                    builder.append(" . ");
                }
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    /**
     * Display the board with all the position refreshed with their type
     * @return the String that display the board with all the position refreshed 
     * with their type
     */
    public String displayBoard(){
        StringBuilder builder = new StringBuilder("").append(System.lineSeparator());
        for (int row=-1; row< this.nbRow ;row++){

            if(row!=-1 && row<10){
                builder.append(row);
            }
            else if(row>-1){
                builder.append(row);
            }
            for (int col=-1; col<this.nbCol ;col++){
                if(col==-1){
                    builder.append(" ");
                }
                if(row==-1 && col>-1){
                    builder.append("  ");
                    builder.append(col);
                }
                if(row>-1 && col>-1){
                    builder.append(" ").append(listPositions[col][row].type).append(" ");
                }
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
    public boolean checkWin(){
        boolean bool = true;
        ArrayList<Position> boxesPos= getBoxPos();
        ArrayList<Position> targetsPos= getTargetsPos();
        return boxesPos.containsAll(targetsPos);
    }
    /**
     * Check if the position is on the board
     * @param p the position 
     * @return true if the position is on the board
     */
    public boolean isOnBoard(Position p){
       return p.col <= this.nbCol && p.row <= this.nbRow && p.col >= 0 && p.row>= 0;
    }
}
