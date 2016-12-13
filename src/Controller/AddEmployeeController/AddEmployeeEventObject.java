package Controller.AddEmployeeController;


import java.util.EventObject;

/**
 * Created by Studio on 12/13/2016.
 */
public class AddEmployeeEventObject extends EventObject {

    private String fName, lName, uName, pass, rank, payType, hiringDate;
    private Double pay;

    public AddEmployeeEventObject(Object source) {
        super(source);
    }

    public AddEmployeeEventObject(Object source, String fName, String lName, String uName, String pass, String rank, String payType, Double pay, String hiringDate) {
        super(source);
        this.fName = fName;
        this.lName = lName;
        this.uName = uName;
        this.pass = pass;
        this.rank = rank;
        this.payType = payType;
        this.pay = pay;
        this.hiringDate = hiringDate;
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

    public String getRank() {
        return rank;
    }

    public String getPayType() {
        return payType;
    }

    public Double getPay() {
        return pay;
    }

    public String getHiringDate() {
        return hiringDate;
    }
}
