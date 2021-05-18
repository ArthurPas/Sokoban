/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanproject;

import java.io.File;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
