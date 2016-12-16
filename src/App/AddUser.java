package App;

import Model.Bags.UserBag;
import Model.Objects.Employee;
import Model.Objects.User;

/**
 * Created by Studio on 12/14/2016.
 */
public class AddUser {
    private static User m1;
    public static void main(String args[]) {
        User e1;
        e1 = new Employee("Joe", "McMullan", "mc12", "mc12", "General", "Hourly", 24.50, "11/9/16", "11/10/16");
        m1 = new Employee("Jack", "Dack", "jd1221", "password", "Manager", "Salary", 55000, "NA", "NA");
        App.getUserBag().addUser(m1);
    }

}
