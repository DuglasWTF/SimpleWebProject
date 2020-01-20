package app.dao;

import app.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "root";

    Connection connection;




    public DAO() throws SQLException {
        /*try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            if (!connection.isClosed()) {
                System.out.println("подключение к БЛ произошло");
            }
        } catch (SQLException e) {
            System.out.println("Не удалось загрузить класс драйвера");
            e.printStackTrace();
        }*/
    }

    public void addUser(User user) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASS);
            String name = user.getName();
            String passwords = user.getPassword();
            String sql = "INSERT INTO users_table (name, pass) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, passwords);
            preparedStatement.execute();
            System.out.println("Пользователь добвален");
           /* Statement statement = connection.createStatement();
            statement.execute("INSERT INTO users_table(name,pass) VALUES("+ name +" , "+ passwords +" );");*/
        } catch (SQLException e) {
            System.out.println("что-то не так");
            e.printStackTrace();
        }
    }

}
