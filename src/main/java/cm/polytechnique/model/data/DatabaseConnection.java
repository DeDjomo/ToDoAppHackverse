package cm.polytechnique.model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection{
    //Attributes
    private static Connection connection;
    //private static String url = "database/ToDoBD.db";
    private static String url = "jdbc:sqlite:database/ToDoBD.db";

    //
    public static Connection getConnection() {
        try{
            connection = DriverManager.getConnection(url);
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}