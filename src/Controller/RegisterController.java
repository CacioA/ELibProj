package Controller;

import Model.Book;
import Model.User;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterController {

    @FXML
    private TextField text_first_name;

    @FXML
    private TextField text_last_name;

    @FXML
    private TextField text_dob;

    @FXML
    private TextField text_username;

    @FXML
    private TextField text_email;

    @FXML
    private PasswordField pwd_password;

    @FXML
    private PasswordField pwd_re_password;

    @FXML
    private Button btn_register;

    @FXML
    private Button btn_cancel;



    public static DBConnection dbc;
    public static Connection conn;
    public static UserDao userDao;

    public void initialize() throws SQLException {

        this.dbc= new DBConnection();
        this.conn=dbc.DBCon();
        this.userDao=new UserDaoImpl();
    }

    @FXML
    void btn_cancel_clicked(ActionEvent event) {

        //return to previous page

    }

    @FXML
    void btn_register_clicked(ActionEvent event) throws SQLException {
        if(fieldsAreNotEmpty()==true && passwordsMatch() ==true){

            User user = new User(text_first_name.getText(),text_last_name.getText(),pwd_password.getText(),text_email.getText());

           if( userDao.checkUserExists(text_email.getText()) ==true){

               //userDao.createUser();
               System.out.println("user does not exist");
           }
           else {
               System.out.println("does exist");
           }




        }


    }

    public boolean fieldsAreNotEmpty(){

        boolean result=false;
        if(!text_first_name.getText().isEmpty() && !text_last_name.getText().isEmpty()  &&!pwd_password.getText().equals("") && !pwd_re_password.getText().equals(""))

            return true;

        else return false;




    }

    public boolean passwordsMatch(){

        if(pwd_password.getText().length()>=12 && pwd_re_password.getText().length()>=12  &&pwd_password.getText().equals(pwd_re_password.getText())) {
            System.out.println("pwd ok");
            return true;
        }
        else return false;
    }
}
