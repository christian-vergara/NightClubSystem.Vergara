package Model.Objects;

import Model.Bags.CustomerBag;
import Model.Bags.TableBag;
import Model.Bags.UserBag;
import Model.Objects.Customer;
import javafx.scene.control.*;

/**
 * Created by chris on 11/6/2016.
 */
public class Table {

    private int tblNbr;
    private int tblCapacity;
    private CustomerBag customerBag = new CustomerBag();

    public Table(int tblNbr, int tblCapacity) {
        this.tblNbr = tblNbr;
        this.tblCapacity = tblCapacity;

    }

    public void addCustomer(Customer customer) {
        customerBag.addCustomer(customer);
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

    public CustomerBag getCustomerBag() {
        return customerBag;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tblNbr=" + tblNbr +
                ", tblCapacity=" + tblCapacity +
                ", customerBag=" + customerBag +
                '}';
    }
}



