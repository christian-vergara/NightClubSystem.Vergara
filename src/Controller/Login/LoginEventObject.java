package Controller.Login;

import java.util.EventObject;

/**
 * Created by chris on 11/9/2016.
 */
public class LoginEventObject extends EventObject{

    private String userName;
    private String password;

    public LoginEventObject(Object source) {
        super(source);
    }

    public LoginEventObject(Object source, String username, String password) {
        super(source);
        this.userName = username;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
