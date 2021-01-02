package Controller;

import Model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

        public List<User> getAllStudents();
        public User getUser(int userID);
        public void updateUser(User User);
        public void deleteUser(User User);
        public void createUser(User user);
        public boolean checkUserExists(String userEmail) throws SQLException;
    }

