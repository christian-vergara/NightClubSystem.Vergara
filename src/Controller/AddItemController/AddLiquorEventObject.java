package Controller.AddItemController;

import java.util.EventObject;

/**
 * Created by Studio on 12/14/2016.
 */
public class AddLiquorEventObject extends EventObject{

    private String type, name, description, brand, origin;
    private Double price, alcVol;

    public AddLiquorEventObject(Object source, String type, String name, String description, String brand, String origin, Double price, Double alcVol) {
        super(source);
        this.type = type;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.origin = origin;
        this.price = price;
        this.alcVol = alcVol;
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

    public String getBrand() {
        return brand;
    }

    public String getOrigin() {
        return origin;
    }

    public Double getPrice() {
        return price;
    }

    public Double getAlcVol() {
        return alcVol;
    }
}
