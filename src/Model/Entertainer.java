package Model;

/**
 * Created by chris on 11/6/2016.
 */
public class Entertainer extends User {

    private String type;
    private double pay;
    private int hours;
    private String workDate;
    private UserBag userBag = new UserBag();

    public Entertainer(String fName, String lName,String username, String password, String type, double pay, int hours, String workDate) {
        super(fName, lName, username, password, "ent");
        this.type = type;
        this.pay = pay;
        this.hours = hours;
        this.workDate = workDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }
}
