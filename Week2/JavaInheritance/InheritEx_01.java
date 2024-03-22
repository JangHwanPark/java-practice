package JavaInheritance;

final class Engine {
    private String engineType;
    private int horsepower;

    public Engine(String engineType, int horsepower) {
        this.engineType = engineType;
        this.horsepower = horsepower;
    }

    public String getEngineType() {
        return engineType;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void start() {
        System.out.println(engineType + " 엔진이 작동중입니다. 마력: " + horsepower);
    }

    public void stop() {
        System.out.println(engineType + " 엔진이 정지되었습니다. 마력: " + horsepower);
    }
}

class Vehicle {
    private String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void honk() {
        System.out.println("빵빵");
    }
}

class Car extends Vehicle {
    private String modelName;
    private int modelPrice;
    private final Engine engine;

    public Car(String brand, String modelName, int modelPrice, Engine engine) {
        super(brand);
        this.modelName = modelName;
        this.modelPrice = modelPrice;
        this.engine = engine;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getModelPrice() {
        return modelPrice;
    }

    public void setModelPrice(int modelPrice) {
        this.modelPrice = modelPrice;
    }

    public void displayCarInfo() {
        System.out.println("브랜드: " + getBrand());
        System.out.println("모델명: " + modelName);
        System.out.println("가격: $" + modelPrice);
        System.out.println("엔진: " + engine.getEngineType() + " (마력: " + engine.getHorsepower() + ")");
    }

    public void startCarEngine() {
        engine.start();
    }

    public void stopCarEngine() {
        engine.stop();
    }
}

public class InheritEx_01 {
    public static void main(String[] args) {
        // Engine 객체 생성
        Engine myEngine = new Engine("V8", 470);

        // Car 객체 생성 시 Engine 객체 포함
        Car myCar = new Car("Ford", "Mustang", 36000, myEngine);

        // Car 객체의 정보를 출력
        myCar.displayCarInfo();

        // Car 객체의 Engine을 시작/종료
        myCar.startCarEngine();
        myCar.stopCarEngine();
    }
}