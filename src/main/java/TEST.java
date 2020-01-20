import app.dao.DAO;
import app.entities.User;

import java.sql.SQLException;

public class TEST {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        User user = new User("name", "qwerty123");
        DAO dao = new DAO();
        dao.addUser(user);

    }
}
