package Model;

/**
 * Created by chris on 11/6/2016.
 */
public class Item {

    private String type;
    private String name;
    private String description;
    private double Price;



    public Item(String type, String name, String description, double price) {
        this.type = type;
        this.name = name;
        this.description = description;
        Price = price;
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
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
