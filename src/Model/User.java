package Model;

/**
 * Created by chris on 11/6/2016.
 */
public class User {

    private String fName;
    private String lName;
    private static int userId = 0;
    private String password;

    public User(String fName, String lName, String password) {
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        ++userId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

}
