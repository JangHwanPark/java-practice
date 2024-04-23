package src;

class ParamConstructors {
    int price;
    String name;

    public ParamConstructors(int priceParam, String nameParam) {
        price = priceParam;
        name = nameParam;
    }
}

public class Ch2Constructors {
    int x, y;

    public Ch2Constructors() {
        x = 5;
        y = 15;
    }

    public static void main(String[] args) {
        // Ch2Constructors
        Ch2Constructors constructors = new Ch2Constructors();
        System.out.println("x: " + constructors.x + ", y: " + constructors.y);
        System.out.println("sum: " + constructors.x + constructors.y);  // 515
        System.out.println("sum: " + (constructors.x + constructors.y));// 20

        // ParamConstructors
        ParamConstructors param = new ParamConstructors(5, "nameParam");
        System.out.println("param.price: " + param.price);
        System.out.println("param.name: " + param.name);
    }
}