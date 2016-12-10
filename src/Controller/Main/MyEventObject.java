package Controller.Main;

import java.util.EventObject;
import java.util.Objects;

/**
 * Created by chris on 11/9/2016.
 */
public class MyEventObject extends EventObject{

    private String userName;
    private String password;

    public MyEventObject(Object source) {
        super(source);
    }

    public MyEventObject(Object source, String username, String password) {
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
