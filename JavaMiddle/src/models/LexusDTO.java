package models;

public class LexusDTO {
    private String product_id;
    private String make;
    private String model;
    private int year;
    private String color;
    private String vin;

    // Constructors
    public LexusDTO(String product_id, String make, String model, int year, String color, String vin) {
        this.product_id = product_id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
    }

    // Getters and Setters
    public String getProductId() {
        return product_id;
    }

    public void setProductId(String product_id) {
        this.product_id = product_id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    // toString Method
    @Override
    public String toString() {
        return "Car{" +
                "  product_id='" + product_id + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}