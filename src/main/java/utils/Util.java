package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class Util {
    List<User> userList;
    public Util(){
        userList = new ArrayList<>();
    }

    public void addUser(ResultSet rs) throws SQLException {

        User newUser;
        while(rs.next()){
            newUser = new User();
            newUser.setID(rs.getInt("id"));
            newUser.setName(rs.getString("name"));
            newUser.setLastname(rs.getString("lastname"));
            newUser.setEmail(rs.getString("email"));
            newUser.setAge(rs.getInt("age"));
            userList.add(newUser);
        }
    }

    public List<User> getUserList()
    {
        return userList;
    }

}
