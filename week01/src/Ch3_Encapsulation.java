package src;

// 캡슐화(Encapsulation) 예제
class Car {
    private String name;
    private int price;
    private int year;
    private boolean isRunning;

    public Car() {};

    // Getter
    public String getModel() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public boolean getIsRunning() {
        return isRunning;
    }

    // Setter
    public void setModelName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        if (price > 0) this.price = price;
        else System.out.println("Error: 가격이 잘못되었습니다.");
    }

    public void setYear(int year) {
        if (year > 0) this.year = year;
        else System.out.println("Error: 잘못된 연도입니다.");
    }

    public void setIsRunning(boolean running) {
        isRunning = running;
    }
}

public class Ch3_Encapsulation {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.setModelName("Tesla Model S");
        myCar.setPrice(100000000);
        myCar.setYear(2020);
        myCar.setIsRunning(true);

        System.out.println("Car Model: " + myCar.getModel());
        System.out.println("Car Price: " + myCar.getPrice());
        System.out.println("Car Year: " + myCar.getYear());
        System.out.println("Is Car Running? " + myCar.getIsRunning());
    }
}