package Model;

public class User {
    private String firstName;
    private String lastName;
    private int userID;
    private String userPassword;
    private String userEmail;

    public User(String firstName, String lastName, String userPassword, String userEmail){

        this.firstName=firstName;
        this.lastName=lastName;
        this.userPassword=userPassword;
        this.userEmail=userEmail;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
