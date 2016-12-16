package Controller.ViewEmployeeController;


import java.util.EventObject;

/**
 * Created by Studio on 12/13/2016.
 */
public class ViewEmployeeEventObject extends EventObject {

    private String fName, lName, uName, pass, rank, payType, hiringDate, leaveDate;
    private Double pay;

    public ViewEmployeeEventObject(Object source) {
        super(source);
    }

    public ViewEmployeeEventObject(Object source, String fName, String lName, String uName, String pass, String rank, String payType, Double pay, String hiringDate, String leaveDate) {
        super(source);
        this.fName = fName;
        this.lName = lName;
        this.uName = uName;
        this.pass = pass;
        this.rank = rank;
        this.payType = payType;
        this.pay = pay;
        this.hiringDate = hiringDate;
        this.leaveDate = leaveDate;
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

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }
}
