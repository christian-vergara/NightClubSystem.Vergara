package Model.Objects;

import Model.Bags.UserBag;

/**
 * Created by chris on 11/6/2016.
 */
public class Customer extends User {

    private static int customerId = 0;


    public Customer(String fName, String lName,String userName, String password) {
        super(fName, lName,userName, password, "cust");
        ++customerId;
        App.App.getUserBag().addUser(this);
    }

    public static int getCustomerId() {
        return customerId;
    }
}
