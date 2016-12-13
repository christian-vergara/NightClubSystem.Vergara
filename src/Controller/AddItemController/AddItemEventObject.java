package Controller.AddItemController;

import java.util.EventObject;

/**
 * Created by Studio on 12/13/2016.
 */
public class AddItemEventObject extends EventObject {


    private String type, name, description;
    private Double price;


    public AddItemEventObject(Object source) {
        super(source);
    }

    public AddItemEventObject(Object source, String type, String name, String description, Double price) {
        super(source);
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
