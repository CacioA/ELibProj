package Controller;

import Model.Book;
import Model.User;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class RegisterController {

    @FXML
    private TextField text_first_name;

    @FXML
    private TextField text_last_name;

    @FXML
    private TextField text_username;


    @FXML
    private PasswordField pwd_password;

    @FXML
    private PasswordField pwd_re_password;

    @FXML
    private Button btn_register;

    @FXML
    private Button btn_cancel;

    @FXML
    private Label lbl_user_created_notif;



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
    void btn_register_clicked(ActionEvent event) throws SQLException, InterruptedException, IOException {
        if(fieldsAreNotEmpty()==true && passwordsMatch() ==true){

            User user = new User(text_first_name.getText(),text_last_name.getText(),pwd_password.getText(),text_username.getText());

           if( userDao.checkUserExists(text_username.getText()) ==true){

               userDao.createUser(user);
               this.lbl_user_created_notif.setVisible(true);
               TimeUnit.SECONDS.sleep(4);

           }
           else {
               System.out.println("does exist");
               openMainMenu(event);
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

    public void openMainMenu(ActionEvent event) throws IOException {

        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("/View/MainView.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
}
