package app.serveices;

import com.mysql.cj.MysqlConnection;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private Connection connector = null;
    private final String URL = "jdbc:mysql://localhost:3306/testdb?serverTimezone=Europe/Moscow&useSSL=false";
    private final String USER = "root";
    private final String PASS = "root";



    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        try {
            this.connector = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {

        }
        return connector;
    }

}
