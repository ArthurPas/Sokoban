package sokobanproject;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 *
 * @author apascal002
 */
public class Player {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, SQLException {

        Builder build = new Builder();
        Database base = new Database("jdbc:sqlite:boards.db");
        base.initializeDriverAndDb();
        System.out.println("Welcome in Sokoban !");
        System.out.println("Please select\n"
                + "1. Consult all the boards available\n"
                + "2. choose your board\n"
                + "3. quit\n");
        String choice = KeyboardEntry.readLine();
        switch (choice) {
            case "1":
                base.consultAllBoards("jdbc:sqlite:boards.db");
                main(args);
                break;
            case "2":
                System.out.println("Enter the name of the board");
                String boardChoice = KeyboardEntry.readLine();
                Board b = base.get(build, "jdbc:sqlite:boards.db", boardChoice);
                b.savedInitialType();
                System.out.println(b.boardName);
                System.out.println(b.displayBoard());
                System.out.println("Enter the combination of : \"LRUD\" that you think you will win with");
                String combination = KeyboardEntry.readLine();
                movePlayer(combination, b);
                if(b.checkWin()){
                    System.out.println("Well played ! it was the good combination");
                }
                else{
                    System.out.println("Try again!");
                }
                break;
            case "3":
                System.exit(0);
                break;
        }

    }

    /**
     * Move the player following a String given
     *
     * @param s the string given
     * @param b the board
     */
    public static void movePlayer(String s, Board b) {
        Position nextPosition;
        for (int i = 0; i < s.length(); i++) {
            Position playerPos = b.getPlayerPos();
            switch (s.charAt(i)) {
                case 'L':
                    nextPosition = b.listPositions[playerPos.col - 1][playerPos.row];
                    if (nextPosition.type != Type.WALL) {

                        if (nextPosition.type == Type.BOX) {
                            nextPosition.replaceByBox(b.listPositions[nextPosition.col - 1][nextPosition.row], b);
                            playerPos.replaceByPlayer(nextPosition, b);
                        }
                        playerPos.replaceByPlayer(nextPosition, b);
                    }
                    break;
                case 'R':
                    nextPosition = b.listPositions[playerPos.col + 1][playerPos.row];
                    if (nextPosition.type != Type.WALL) {
                        if (nextPosition.type == Type.BOX) {
                            nextPosition.replaceByBox(b.listPositions[nextPosition.col + 1][nextPosition.row], b);
                            playerPos.replaceByPlayer(nextPosition, b);
                        }
                        playerPos.replaceByPlayer(nextPosition, b);
                    }

                    break;
                case 'U':
                    nextPosition = b.listPositions[playerPos.col][playerPos.row - 1];
                    if (nextPosition.type != Type.WALL) {
                        if (nextPosition.type == Type.BOX) {
                            nextPosition.replaceByBox(b.listPositions[nextPosition.col][nextPosition.row - 1], b);
                            playerPos.replaceByPlayer(nextPosition, b);
                        }
                        playerPos.replaceByPlayer(nextPosition, b);
                    }

                    break;
                case 'D':
                    nextPosition = b.listPositions[playerPos.col][playerPos.row + 1];
                    if (nextPosition.type != Type.WALL) {
                        if (nextPosition.type == Type.BOX) {
                            nextPosition.replaceByBox(b.listPositions[nextPosition.col][nextPosition.row + 1], b);
                            playerPos.replaceByPlayer(nextPosition, b);
                        }
                        playerPos.replaceByPlayer(nextPosition, b);
                    }
                    break;
            }
            System.out.println(b.displayBoard());
        }
    }

}
