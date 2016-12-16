package Model.Objects;

import App.App;

import java.io.Serializable;

/**
 * Created by chris on 11/6/2016.
 */
public class Item implements Serializable {

    private String type;
    private String name;
    private String description;
    private double price;



    public Item(String type, String name, String description, double price) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
        App.getItemBag().addItem(this);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
