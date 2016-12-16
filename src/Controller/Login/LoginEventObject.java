package Controller.Login;

import java.util.EventObject;

/**
 * Created by chris on 11/9/2016.
 */
public class LoginEventObject extends EventObject{

    private String userName;
    private String password;
    private String type;
    private int userId;

    public LoginEventObject(Object source) {
        super(source);
    }

    public LoginEventObject(Object source, String username, String password, String type, int userId) {
        super(source);
        this.userName = username;
        this.password = password;
        this.type = type;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public int getUserId() {
        return userId;
    }
}
