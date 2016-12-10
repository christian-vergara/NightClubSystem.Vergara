package Model.Bags;

import Model.Objects.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 11/6/2016.
 */
public class CustomerBag {

    private List<Customer> customerBag = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customerBag.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customerBag.remove(customer);
    }

    public Customer findCustomer(Customer customer) {
        for(int i = 0;i < customerBag.size();i++) {
            if (customerBag.get(i) == customer) {
                return customerBag.get(i);
            }
        }
        return null;
    }

}
