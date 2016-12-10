package Model.Objects;

import Model.Bags.CustomerBag;
import Model.Bags.UserBag;
import Model.Objects.Customer;

/**
 * Created by chris on 11/6/2016.
 */
public class Table {

    private int tblNbr;
    private int tblCapacity;
    private CustomerBag customerBag;
    private UserBag userBag = new UserBag();

    public Table(int tblNbr, int tblCapacity) {
        this.tblNbr = tblNbr;
        this.tblCapacity = tblCapacity;
    }

    public void addCustomer(Customer customer) {

    }

    public void removeCustomer(Customer customer) {
        customerBag.removeCustomer(customer);
    }

    public int getTblNbr() {
        return tblNbr;
    }

    public void setTblNbr(int tblNbr) {
        this.tblNbr = tblNbr;
    }

    public int getTblCapacity() {
        return tblCapacity;
    }

    public void setTblCapacity(int tblCapacity) {
        this.tblCapacity = tblCapacity;
    }
}

