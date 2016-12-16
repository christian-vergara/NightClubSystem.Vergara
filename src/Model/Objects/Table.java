package Model.Objects;

import App.App;
import Model.Bags.CustomerBag;
import Model.Bags.TableBag;
import Model.Bags.UserBag;
import Model.Objects.Customer;
import javafx.scene.control.*;

import java.io.Serializable;

import static App.App.*;

/**
 * Created by chris on 11/6/2016.
 */
public class Table implements Serializable{

    private int tblNbr;
    private int tblCapacity;
    private CustomerBag customerBag;
    private int currentSitting;

    public Table(int tblNbr, int tblCapacity) {
        this.tblNbr = tblNbr;
        this.tblCapacity = tblCapacity;
        customerBag = new CustomerBag(tblCapacity);
        App.getTableBag().addTable(this);
    }

    public void addCustomer(Customer customer) {
        customerBag.addCustomer(customer);
        currentSitting++;
    }

    public void removeCustomer(Customer customer) {
        customerBag.removeCustomer(customer);
        currentSitting--;
    }

    public String printCustomer(){
        String customers = " ";
        if(customerBag == null){
            customers = "Empty";
        } else{
            for(int i = 0;i < customerBag.getSize();i++) {
                customers += " " + customerBag.getCustomers(i).getfName() + " " + customerBag.getCustomers(i).getlName() + " + " + (customerBag.getCustomers(i).getTicketAmount() - 1) + " | ";
            }
        }
        return customers;
    }


    public void setCurrentSitting(int currentSitting) {
        this.currentSitting = currentSitting;
    }

    public void addSitting(int number) {
        currentSitting += number;
    }

    public void removeSitting(int number) {
        currentSitting -= number;
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

    public int getCurrentSitting() {
        return currentSitting;
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



