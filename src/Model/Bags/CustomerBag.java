package Model.Bags;

import Model.Objects.Customer;
import Model.Objects.Employee;
import Model.Objects.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 11/6/2016.
 */
public class CustomerBag {

    public CustomerBag() {

    }

    protected static CustomerBag customerBagObject = new CustomerBag();

    private List<Customer> customerBag = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customerBag.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customerBag.remove(customer);
    }

    public Customer findCustomer(int customerId) {
        for(int i = 0;i < customerBag.size();i++) {
            if (customerBag.get(i).getCustomerId() == customerId) {
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

    public static CustomerBag getCustomerBagObject() {
        return customerBagObject;
    }
}
