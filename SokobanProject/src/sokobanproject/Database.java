/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author apascal002
 */
public class Database {

    String sqlite_driver;
    String path;

    public Database(String path) {
        this.sqlite_driver = "org.sqlite.JDBC";
        this.path = path;
    }

    /**
     * Initialize the database files and the driver
     * @throws SQLException
     */
    public void initializeDriverAndDb() throws SQLException {
        try {
            Class.forName(sqlite_driver);
        } catch (ClassNotFoundException ex) {
            System.err.println(
                    "* Driver " + sqlite_driver + " absent");
            System.exit(1);
        }
        try (Connection c = DriverManager.getConnection(path)) {
            File f = new File("boards.db");
            if(!f.exists()){
            Statement s = c.createStatement();
            s.execute("create table BOARDS "+ "(board_id integer , name text, "
                    + "nb_rows integer, nb_cols integer)");
            s.execute("create table ROWS "+ "(board_id integer , row_num integer, "
                    + "description text)");
            }
        } catch (SQLException e) {
            System.err.println("* Exception " + e.getMessage());
        }
    }
    public void addBoard(Builder build,String pathOfFile, String pathOfDB) throws FileNotFoundException, SQLException{
        ArrayList<String> lines = build.readFile(pathOfFile);
        String boardID = lines.get(0);
        try (Connection c = DriverManager.getConnection(pathOfDB)) {
        Statement s = c.createStatement();
        for (int lineNumber = 1; lineNumber < lines.size(); lineNumber++) {
            s.executeUpdate("insert into ROWS values ('"+boardID+"',"+lineNumber+",'"+lines.get(lineNumber)+"')");
        }
        }catch (SQLException e) {
            System.err.println("* Exception " + e.getMessage());
        }
    }
    public void consultDb(Builder build, String pathOfDB) throws SQLException{
        try (Connection c = DriverManager.getConnection(pathOfDB)) {
        Statement s = c.createStatement(); 
        ResultSet r = s.executeQuery ("select * from rows ");
            while (r.next()) {
            System.out.println(r.getString("board_id")+ r.getInt("row_num")+r.getString("description"));
            }
        }
        catch (SQLException e) {
            System.err.println("* Exception " + e.getMessage());
        }
    }
    public void removeBoardFromDB(Builder build, String pathOfDB, String boardID) throws SQLException{
        try (Connection c = DriverManager.getConnection(pathOfDB)) {
            Statement s = c.createStatement(); 
            s.executeUpdate("DELETE FROM 'ROWS' WHERE board_id = '"+boardID+"'");
        }
        catch (SQLException e) {
            System.err.println("* Exception " + e.getMessage());
        }
    }
    public Board get(Builder build, String pathOfDB, String boardID) throws SQLException, FileNotFoundException{
        ArrayList<String> lines = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(pathOfDB)) {
            Statement s = c.createStatement(); 
            ResultSet r = s.executeQuery ("select description from rows WHERE board_id = '"+boardID+"'");
            while (r.next()) {
                lines.add(r.getString("description"));
            }
        }
        return build.build(lines);
    }
}
