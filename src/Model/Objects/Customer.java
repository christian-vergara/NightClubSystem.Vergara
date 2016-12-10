package Model.Objects;

import Model.Bags.UserBag;

/**
 * Created by chris on 11/6/2016.
 */
public class Customer extends User {

    private static int customerId = 0;
    private UserBag userBag = new UserBag();

    public Customer(String fName, String lName,String userName, String password) {
        super(fName, lName,userName, password, "cust");
        ++customerId;
    }
}
