package src;

class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void honk() {
        System.out.println("======== Display Honk ========");
        System.out.println("on Sound");
    }

    public void displayInfo() {
        System.out.println("======== Display Brand ========");
        System.out.println("Brand: " + brand);
    }
}

class CarInfo extends Vehicle {
    private String model;
    private int year;
    private int price;

    public CarInfo(String brand, String model, int year ,int price) {
        super(brand);
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public void displayVehicleInfo() {
        System.out.println("======== Display VehicleInfo ========");
        super.honk();
        super.displayInfo();
    }

    public void displayCarInfo() {
        System.out.println("======== Display CarInfo ========");
        System.out.println("model: " + model);
        System.out.println("year: " + year);
        System.out.println("price: " + price);
    }
}

public class Ch4_Inheritance extends CarInfo {
    int sales_rate;

    private Ch4_Inheritance(String brand, String model, int year ,int price, int sales_rate) {
        super(brand, model, year, price);
        this.sales_rate = sales_rate;
    }

    public static void main(String[] args) {
        Ch4_Inheritance createCar = new Ch4_Inheritance("BMW", "X4", 2023, 98000000, 1240);
        createCar.honk();
        createCar.displayInfo();
        createCar.displayVehicleInfo();
        createCar.displayCarInfo();
    }
}