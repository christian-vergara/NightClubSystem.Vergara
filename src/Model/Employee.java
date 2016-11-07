package Model;

/**
 * Created by chris on 11/6/2016.
 */
public class Employee extends User {

    private static int employeeId = 0;
    private String rank;
    private String payType;
    private double pay;
    private String hiringDate;
    private String leaveDate;

    public Employee(String fName, String lName, String password, String rank, String payType, double pay, String hiringDate, String leaveDate) {
        super(fName, lName, password);
        this.rank = rank;
        this.payType = payType;
        this.pay = pay;
        this.hiringDate = hiringDate;
        this.leaveDate = leaveDate;
        ++employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }
}
