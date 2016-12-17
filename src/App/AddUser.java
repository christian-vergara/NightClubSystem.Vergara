package App;

import Model.Bags.UserBag;
import Model.Objects.Customer;
import Model.Objects.Employee;
import Model.Objects.User;

/**
 * Created by Studio on 12/14/2016.
 */
public class AddUser {
    private static User m1;
    public static void main(String args[]) {
        User e1;
        e1 = new Employee("Joe", "Brown", "employee", "employee", "General", "Hourly", 24.50, "11/9/16", "11/10/16");

        User c1 = new Customer("David", "Appleseed", "customer", "customer" );

        //App.getUserBag().addUser(m1);
    }

}
