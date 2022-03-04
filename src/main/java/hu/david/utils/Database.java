package hu.david.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private Connection con;

    public Connection createConnection(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/best_apple","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public Connection getCon() {
        return con;
    }

    public void closeConnection(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
