package app.dao;

import app.entities.User;
import app.serveices.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    DBConnector dbConnector = new DBConnector();
    Connection connection = dbConnector.getConnection();


    /*   public DAO() {
        this.connection = DBConnector.getInstance().getConnection();
    }*/

    public void addUser(User user) {
        String name = user.getName();
        String passwords = user.getPassword();
        String sql = "INSERT INTO users_table (name, pass) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, passwords);
            preparedStatement.executeUpdate();
            System.out.println("Пользователь добвален");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Что-то не так");
        }
    }
}
