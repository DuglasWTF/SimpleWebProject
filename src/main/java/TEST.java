import app.dao.DAO;
import app.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TEST {
    /* public static void main(String[] args) throws SQLException, ClassNotFoundException {
         User user = new User("admin", "qwerty123");
         DAO dao = new DAO();
         dao.addUser(user);

     }*/
    public static void main(String[] args) {
        try {
            //Connection connector = null;
            String URL = "jdbc:mysql://localhost:3306/testdb?serverTimezone=Europe/Moscow&useSSL=false";
            String USER = "root";
            String PASS = "root";

            Class.forName("com.mysql.jdbc.Driver");


            try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
                String name = "admin";
                String passwords = "admin";
                String sql = "INSERT INTO users_table (name, pass) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, passwords);
                preparedStatement.executeUpdate();
                System.out.println("Пользователь добвален");
            }
       /*public Connection getConnection() {
           try {
               Class.forName("");
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
               System.out.println(e.toString());
           }
           try {
               this.connector = DriverManager.getConnection(URL, USER, PASS);
           } catch (SQLException e) {

           }
           return connector;
       }*/

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
