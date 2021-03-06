package Model.Objects;

import App.App;
import Model.Bags.UserBag;

/**
 * Created by chris on 11/6/2016.
 */
public class Customer extends User {

    private static int customerId = 0;
    private int ticketAmount;


    public Customer(String fName, String lName,String userName, String password) {
        super(fName, lName,userName, password, "cust");
        ++customerId;
    }

    public static int getCustomerId() {
        return customerId;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }
}


