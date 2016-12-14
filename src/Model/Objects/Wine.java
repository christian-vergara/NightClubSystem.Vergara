package Model.Objects;

/**
 * Created by Studio on 12/14/2016.
 */
public class Wine extends Item {

    private String brand;
    private String origin;
    private String color;
    private double alcVol;

    public Wine(String type, String name, String description, double price, String brand, String origin, String color, double alcVol) {
        super(type, name, description, price);
        this.brand = brand;
        this.origin = origin;
        this.color = color;
        this.alcVol = alcVol;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getAlcVol() {
        return alcVol;
    }

    public void setAlcVol(double alcVol) {
        this.alcVol = alcVol;
    }
}
