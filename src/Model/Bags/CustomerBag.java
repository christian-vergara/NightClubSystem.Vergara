package Model.Bags;

import Model.Objects.Customer;
import Model.Objects.Employee;
import Model.Objects.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 11/6/2016.
 */
public class CustomerBag implements Serializable {

    int size = 0;

    public CustomerBag(int size) {
        this.size = size;
    }

    private List<Customer> customerBag = new ArrayList<>(size);

    public void addCustomer(Customer customer) {
        customerBag.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customerBag.remove(customer);
    }

    public Customer findCustomer(int customerId) {
        for(int i = 0;i < customerBag.size();i++) {
            if (customerBag.get(i).getUserId() == customerId) {
                return customerBag.get(i);
            }
        }
        return null;
    }

    public int getSize() {
        return customerBag.size();
    }

    public Customer getCustomers(int index){
        return customerBag.get(index);
    }

    public List<Customer> getCustomerBag() {
        return customerBag;
    }
}
