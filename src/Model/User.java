package Model;

/**
 * Created by chris on 11/6/2016.
 */
public class User {

    private String fName;
    private String lName;
    // type to separate different types of users
    // emp, cust, ent
    private String type;
    private static int userId = 0;
    private String userName;
    private String password;

    public User() {
    }

    public User(String fName, String lName, String userName, String password, String type) {
        this.fName = fName;
        this.lName = lName;
        this.userName = userName;
        this.password = password;
        this.type = type;
        ++userId;
        UserBag.getUserBagClass().addUser(this);
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
