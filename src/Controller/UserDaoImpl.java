package Controller;

import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{
    public static DBConnection dbc;
    public static Connection conn;



        public UserDaoImpl() throws SQLException {
            this.dbc= new DBConnection();
            this.conn=dbc.DBCon();

        }
    @Override
    public List<User> getAllStudents() {
        return null;
    }

    @Override
    public User getUser(int userID) {

        return null;
    }

    @Override
    public void updateUser(User User) {

    }

    @Override
    public void deleteUser(User User) {

    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public boolean checkUserExists(String userEmail) throws SQLException {

            String queryCheckUser =" SELECT EXISTS (SELECT 1 FROM users WHERE userEmail LIKE ?);";

            PreparedStatement st = this.conn.prepareStatement(queryCheckUser);
            st.setString(1,"%"+userEmail+"%");

            ResultSet rs = st.executeQuery(queryCheckUser);


        if(!rs.next()){
            //user email not created
            //call function to create the user
            return true;

        }
        else {
            //user email exists
            return false;
        }





    }
}
