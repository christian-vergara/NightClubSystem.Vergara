package Model.Objects;

/**
 * Created by chris on 11/6/2016.
 */
public class Beer extends Item {

    private String brand;
    private String origin;
    private double alcVol;

    public Beer(String type, String name, String description, double price, String brand, String origin, double alcVol) {
        super(type, name, description, price);
        this.brand = brand;
        this.origin = origin;
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

    public double getAlcVol() {
        return alcVol;
    }

    public void setAlcVol(double alcVol) {
        this.alcVol = alcVol;
    }
}
