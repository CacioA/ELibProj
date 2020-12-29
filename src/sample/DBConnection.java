package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "SQLToni20!") ;

    public DBConnection() throws SQLException {
    }

    public Connection DBCon() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "SQLToni20!") ;
        return conn;
    }
    public void deleteUser(int id) throws SQLException{
        String query = "DELETE from users where id= ?";
        PreparedStatement st = null;

        st = this.conn.prepareStatement(query);
        st.setInt(1,id);
        st.executeUpdate();

    }
}
