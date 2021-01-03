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
    public void createUser(User user) throws SQLException {

            String queryCreateUser = "INSERT INTO users(firstName, lastName, userID, userPassword, userUsername) " +
                                     "VALUES (?, ?, NULL,?, ?) ";
        PreparedStatement st = this.conn.prepareStatement(queryCreateUser);
        st.setString(1,user.getFirstName());
        st.setString(2,user.getLastName());
        st.setString(3,user.getUserPassword());
        st.setString(4,user.getUserUsername());

        st.execute();

    }

    @Override
    public boolean checkUserExists(String userUsername) throws SQLException {

        String queryCheckUser =" SELECT * FROM users WHERE userUsername = ? ;";




            PreparedStatement st = this.conn.prepareStatement(queryCheckUser);
            st.setString(1,userUsername);

            ResultSet rs = st.executeQuery();

            if(!rs.isBeforeFirst()){
                System.out.println("no data, create user");
                return true;
            }
            else{
                System.out.println("user found, don't");
                return false;
            }



//        if(rs.next()){
//            //user email not created
//            //call function to create the user
//            System.out.println(rs.getString("userUsername"));
//            if(rs.getString("userUsername").equals(userUsername)) {
//                System.out.println("username not found, create user");
//
//            }
//            return true;
//
//        }
//        else {
//            //user email exists
//            System.out.println("username  found, can't create user");
//
//            return false;
        }






}
