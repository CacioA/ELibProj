package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.sql.*;

public class Controller {

    @FXML
    private ListView<String> list_user_loans;
    @FXML
    private TextArea search_user;

    @FXML
    private Button btn_search_user;

    @FXML
    private Label lbl_welcome_user;


    public void initialize() throws SQLException {

        Main main = new Main();
        //DBConnection dbc = new DBConnection();




        list_user_loans.getItems().add("Toni");
        // String query = "SELECT * FROM users";

    }



    @FXML
    void btn_search_user_clicked(ActionEvent event) throws SQLException {
        DBConnection dbc = new DBConnection();
        Connection conn = dbc.DBCon();
        String query = "SELECT * FROM loanedbooks WHERE EXISTS (SELECT * FROM users WHERE userID=" + search_user.getText() + ");";

        // create the java statement
        // Statement st = conn.createStatement();

        PreparedStatement st = conn.prepareStatement(query);
        // execute the query, and get a java resultset
        // ResultSet rs = searchByUserID(20,conn);
        //st.setInt(1,20);

        ResultSet rs = st.executeQuery(query);


        // iterate through the java resultset
        while (rs.next()) {
/*
            //manipulate data here
            String firstN = rs.getString("firstName");
            String lastN = rs.getString("lastName");
            int id = rs.getInt("userID");
            String idString = Integer.toString(id);
            String result = firstN + " " + lastN + " " + id;
            list_user_loans.getItems().add(result);

            this if to search by user where id = ? in loanedbooks

 */
            String bookName = rs.getString("bookName");
            String bookWriter = rs.getString("bookWriter");
            int id = rs.getInt("userID");
            int bookID = rs.getInt("bookID");

            String result = "Book: "+bookName+"// "+"Author: "+bookWriter+"//"+"Book ID:"+bookID+ "//"+"User ID: "+id;
            list_user_loans.getItems().add(result);
        }
    }


}