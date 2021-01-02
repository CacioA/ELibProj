package Model;

public class Book {

    private int bookID;
    private String bookName;
    private String bookAuthor;
    private int bookAvailability;
    private int bookEdition;
    private int bookYear;

    public int getBookAvailability() {
        return bookAvailability;
    }

    public void setBookAvailability(int bookAvailability) {
        this.bookAvailability = bookAvailability;
    }

    public int getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(int bookEdition) {
        this.bookEdition = bookEdition;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    public Book(int bookID, String bookName, String bookAuthor, int bookAvailability, int bookEdition, int bookYear){

        this.bookID=bookID;
        this.bookName=bookName;
        this.bookAuthor=bookAuthor;
        this.bookAvailability=bookAvailability;
        this.bookEdition=bookEdition;
        this.bookYear=bookYear;


    }

    //Constructor that is used when running the search by name,author,year,.
    //Created as id is not needed when creating the dummy book object that is passed into the dataList
    //All the attributes are needed to display them.
    public Book( String bookName, String bookAuthor, int bookAvailability,int bookEdition,int bookYear) {

        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookAvailability = bookAvailability;
        this.bookEdition = bookEdition;
        this.bookYear = bookYear;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }



    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }



    public Book(){


    }

   }

