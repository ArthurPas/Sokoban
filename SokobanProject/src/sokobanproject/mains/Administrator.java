/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanproject.mains;

import sokobanproject.databaseAndFiles.Database;
import sokobanproject.databaseAndFiles.Builder;
import sokobanproject.playermanager.KeyboardEntry;
import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 *
 * @author arthu
 */
public class Administrator {
    static Database db = new Database("jdbc:sqlite:boards.db");
    static Builder build = new Builder();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        System.out.println("Welcome in the menu of admin");
        System.out.println("Please select\n"
                + "1. Create new database\n"
                +"2. List boards\n"
                +"3. Show board\n"
                + "4. Add board from file\n"
                + "5. Remove board from database [DANGEROUS]\n"
                + "6. Quit.");
        String choice = KeyboardEntry.readLine();
        switch(choice){
            case "1":
                System.out.println("Please select a name for the new database");
                String name = KeyboardEntry.readLine();
                db.initializeDriverAndDb();
                break;
            case "2":
                db.consultAllBoards("jdbc:sqlite:boards.db");
                break;
            case "3":
                db.consultDb(build, "jdbc:sqlite:boards.db");
                break;
            case "4":
                System.out.println("Please select the path of the file for the new boards");
                String pathOfFile = KeyboardEntry.readLine();
                db.addBoard(build, pathOfFile, "jdbc:sqlite:boards.db");
                break;
            case "5":
                System.out.println("Please select the name of the board to delete");
                String boardName = KeyboardEntry.readLine();
                db.removeBoardFromDB(build,("jdbc:sqlite:boards.db"),boardName);
                break;
            case "6":
                System.exit(0);
                break;
            }
    }
}
