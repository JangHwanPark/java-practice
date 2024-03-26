abstract class Calculator {
    public abstract int add (int a, int b);
    public abstract int subtract(int a, int b);
    public abstract double average(int[] a);
}

class AddCal extends Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double average(int[] a) {
        return a[0];
    }
}

public class AbstractCalculator {
    public static void main(String[] args) {

    }
}
