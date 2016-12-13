package Controller.AddCustomerController;

import java.util.EventObject;

/**
 * Created by Studio on 12/12/2016.
 */
public class AddCustomerEventObject extends EventObject {

    private String fName, lName, userName, pass;

    public AddCustomerEventObject(Object source) {
        super(source);
    }

    public AddCustomerEventObject(Object source, String fName, String lName, String userName, String pass) {
        super(source);
        this.fName = fName;
        this.lName = lName;
        this.userName = userName;
        this.pass = pass;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }
}
