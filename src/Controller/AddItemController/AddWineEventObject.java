package Controller.AddItemController;

import java.util.EventObject;

/**
 * Created by Studio on 12/14/2016.
 */
public class AddWineEventObject extends EventObject {

    private String type, name, description, brand, origin, color;
    private Double price, alcVol;

    public AddWineEventObject(Object source, String type, String name, String description, String brand, String origin, String color, Double price, Double alcVol) {
        super(source);
        this.type = type;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.origin = origin;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public Double getPrice() {
        return price;
    }

    public Double getAlcVol() {
        return alcVol;
    }
}
