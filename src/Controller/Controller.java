package Controller;

import Model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Controller {


    @FXML
    private TextArea search_book;

    @FXML
    private TableView<Book> table_books;

    @FXML
    private TableColumn<Book, String> col_book_name;

    @FXML
    private TableColumn<Book, String> col_author;

    @FXML
    private TableColumn<Book, Integer> col_year;

    @FXML
    private TableColumn<Book, Integer> col_edition;

    @FXML
    private TableColumn<Book, Integer> col_availability;

    @FXML
    private Button btn_loan_book;

    @FXML
    private Button btn_log_in;

    @FXML
    private Button btn_register;


    public static DBConnection dbc;
    public static Connection conn;
    private final ObservableList<Book> dataList = FXCollections.observableArrayList();



    public void initialize() throws SQLException {

        Main main = new Main();

        //Initialise the DBConnection class and create a connection
        this.dbc= new DBConnection();
        this.conn=dbc.DBCon();
        this.table_books.setPlaceholder(new Label(""));
        //set cell value to take a book object and data type.
        // the name of the table view coloumn is named after the db column that it will use
        col_book_name.setCellValueFactory(new PropertyValueFactory<Book,String>("bookName"));
        col_author.setCellValueFactory(new PropertyValueFactory<Book,String>("bookAuthor"));
        col_year.setCellValueFactory(new PropertyValueFactory<Book,Integer>("bookYear"));
        col_edition.setCellValueFactory(new PropertyValueFactory<Book,Integer>("bookEdition"));
        col_availability.setCellValueFactory(new PropertyValueFactory<Book,Integer>("bookAvailability"));

    }



    @FXML
    void btn_search_book_clicked(ActionEvent event) throws SQLException {

        // Query to display books that contain the textfield content in full or partial
        // in book name, author or year

        String query = "SELECT * FROM books WHERE bookYear like '%" + search_book.getText() + "%'"+
                       "OR bookAuthor like '%"+search_book.getText()+"%'"+
                       "OR bookName like '%"+search_book.getText()+"%'";

        //Using prepared statement- safer version of statement against injections.

        PreparedStatement st = this.conn.prepareStatement(query);


        ResultSet rs = st.executeQuery(query);


        // clear tableview before each search. This way, previous search results will be deleted, showing only the new result
        table_books.getItems().clear();

        // iterate through the java resultset
        while (rs.next()) {


            //create a book using the shorter constructor. This creates a book with only the attributes that need to
            // be displayed.
            // bookID and userID do not need to be displayed to the user.


            dataList.add(new Book(rs.getString("bookName"),rs.getString("bookAuthor"),
                                    rs.getInt("bookAvailability"),rs.getInt("bookEdition"),
                                    rs.getInt("bookYear")));


            //add the new book to the tableview
            table_books.setItems(dataList);



        }
    }



    @FXML
    void btn_loan_book_clicked(ActionEvent event) throws SQLException {
        Book book = table_books.getSelectionModel().getSelectedItem();


        String query ="SELECT bookAvailability FROM books WHERE bookName ='"+book.getBookName()+"';"; // search for book, minus 1 availability if >0

        PreparedStatement st = this.conn.prepareStatement(query);

        ResultSet rs = st.executeQuery(query);

        while(rs.next()){

            if(rs.getInt("bookAvailability")>=1)
            {
                System.out.println(rs.getInt("bookAvailability"));
                System.out.println("can be loaned");
            }
        }
    }


    @FXML
    void btn_log_in_clicked(ActionEvent event) throws IOException {


    }

    @FXML
    void btn_register_clicked(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("/View/Register.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
}