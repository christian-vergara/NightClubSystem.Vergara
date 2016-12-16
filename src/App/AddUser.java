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
        m1 = new Employee("Manager", "Example", "manager", "manager", "Manager", "Salary", 55000, "12/7/14", "NA");
        User c1 = new Customer("David", "Appleseed", "customer", "customer" );
        User o1 = new Employee("Johnny", "James", "owner", "owner", "Owner", "Salary", 100000, "NA", "NA");
        //App.getUserBag().addUser(m1);
    }

}
