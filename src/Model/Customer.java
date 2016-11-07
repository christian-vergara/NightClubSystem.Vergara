package Model;

/**
 * Created by chris on 11/6/2016.
 */
public class Customer extends User {

    private static int customerId = 0;

    public Customer(String fName, String lName, String password) {
        super(fName, lName, password);
        ++customerId;
    }
}
