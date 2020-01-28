package app.model;

import app.dao.DAO;
import app.entities.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance;

    static {
        try {
            instance = new Model();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    DAO db;

    private List<User> model;


    public static Model getInstance() {
        return instance;
    }

    private Model () throws SQLException {

        this.model = new ArrayList<>();
        this.db = new DAO();

    }

    public void add (User user){
        model.add(user);
    }

    public void addUser(User user) throws SQLException, ClassNotFoundException {
        db.addUser(user);
    }

    public List<String> list(){
        return model.stream().map(User::getName).collect(Collectors.toList());
    }
}
