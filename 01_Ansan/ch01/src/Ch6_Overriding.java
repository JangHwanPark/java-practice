package src;

public class Ch6_Overriding {
    static int plusMethodInt(int x, int y) {
        return x + y;
    }

    static double plusMethodDouble(double x, double y) {
        return x + y;
    }

    public static void main(String[] args) {
        int overridingIntTest1 = plusMethodInt(10, 10);
        double overridingDoubleTest1 = plusMethodDouble(10.5, 10.5);
        System.out.println("int: " + overridingIntTest1);
        System.out.println("double: " + overridingDoubleTest1);
    }
}