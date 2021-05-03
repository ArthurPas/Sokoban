package sokobanproject;

/**
 *
 * @author apascal002
 */
public class Board {
    String boardName;
    int nbCol;
    int nbRow;

    public Board(String boardName, int nbCol, int nbrow) {
        this.boardName = boardName;
        this.nbCol = nbCol;
        this.nbRow = nbrow;
    }
    public void addHorizontalWall(int posCol, int posRow, int length){
        
    }
    public void addVerticalWall(int posCol, int posRow, int length){
        
    }
    public void addBox(int posCol, int posRow){
        
    }
    public void addTarget(int posCol, int posRow){
        
    }
    public void setPosition(int posCol, int posRow){
        
    }
    public String displayEmptyBoard(){
        StringBuilder builder = new StringBuilder("").append(System.lineSeparator());
        for (int lig=-1; lig< this.nbRow ;lig++){

            if(lig!=-1 && lig<10){
                builder.append(lig);
            }
            else if(lig>-1){
                builder.append(lig);
            }
            for (int col=-1; col<this.nbCol ;col++){
                if(col==-1){
                    builder.append(" ");
                }
                if(lig==-1 && col>-1){
                    builder.append("  ");
                    builder.append(col);
                }
                if(lig>-1 && col>-1){
                    builder.append(" . ");
                }
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
