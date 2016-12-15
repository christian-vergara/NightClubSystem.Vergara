package Controller.ViewEntertainerController;

import java.util.EventObject;

/**
 * Created by Studio on 12/12/2016.
 */
public class ViewEntertainerEventObject extends EventObject {

    String fName, lName, uName, pass, type;
    Double pay;

    public ViewEntertainerEventObject(Object source) {
        super(source);
    }

    public ViewEntertainerEventObject(Object source, String fName, String lName, String uName,
                                      String pass, String type, Double pay) {
        super(source);
        this.fName = fName;
        this.lName = lName;
        this.uName = uName;
        this.pass = pass;
        this.type = type;
        this.pay = pay;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getuName() {
        return uName;
    }

    public String getPass() {
        return pass;
    }

    public String getType() {
        return type;
    }

    public Double getPay() {
        return pay;
    }
}
