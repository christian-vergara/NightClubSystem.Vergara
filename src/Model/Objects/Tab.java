package Model.Objects;

import Model.Bags.ItemBag;
import Model.Objects.Customer;
import Model.Objects.Item;

/**
 * Created by chris on 11/6/2016.
 */
public class Tab {

    private double total;
    private Customer customer;
    private ItemBag receipt;

    public Tab(Customer customer, ItemBag receipt) {
        this.customer = customer;
        this.receipt = receipt;
    }

    public void addToReceipt(Item item) {
        receipt.addItem(item);
    }

    public void removeFromReceipt(Item item) {
        receipt.removeItem(item);
    }

    public void calculateTotal() {
        double total = 0;
        for(int i = 0;i < receipt.getSize();i++) {
            total += receipt.getItem(i).getPrice();
        }
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ItemBag getReceipt() {
        return receipt;
    }

    public void setReceipt(ItemBag receipt) {
        this.receipt = receipt;
    }

}
