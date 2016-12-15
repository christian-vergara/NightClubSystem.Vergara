package App;

import Model.Bags.UserBag;
import Model.Objects.Employee;
import Model.Objects.User;

/**
 * Created by Studio on 12/14/2016.
 */
public class AddUser {


    public static void main(String args[]) {
        User e1;
        e1 = new Employee("Joe", "McMullan", "mc12", "mc12", "General", "Hourly", 24.50, "11/9/16", "11/10/16");
        App.getUserBag().addUser(e1);
    }

}
