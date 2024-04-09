class Calc {
    public static int abs(int a) {
        return a > 0 ? a : -a;
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int min(int a, int b) {
        return (a > b) ? b : a;
    }
}

public class CalcEx {
    public static void main(String[] args) {
        System.out.println("Calc.abs(-5): " + Calc.abs(-5));
        System.out.println("Calc.max(1, 10): " + Calc.max(1, 10));
        System.out.println("Calc.min(2, 5): " + Calc.min(2, 5));

        Calc calc = new Calc();
        System.out.println("abs: " + calc.abs(-10));
        System.out.println("max: " + calc.max(5, 20));
        System.out.println("min: " + calc.min(-1, 5));
    }
}
