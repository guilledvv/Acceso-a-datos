package util;

import java.lang.module.Configuration;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/pregunta_test?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    private static Connection connection = null;

    private DBConnection(){}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()){
            connection = DriverManager.getConnection(URL, USER, PASSWORD);//driver manager manega los driver para
        }
        System.out.println("hola pesicola");
        return connection;
    }
}
