package JavaModifiers;

public class StaticEx_Calculator {
    // 더하기 연산을 수행하는 static 메소드
    public static int add(int a, int b) {
        return a + b;
    }

    // 빼기 연산을 수행하는 static 메소드
    public static int subtract(int a, int b) {
        return a - b;
    }

    // 곱하기 연산을 수행하는 static 메소드
    public static int multiply(int a, int b) {
        return a * b;
    }

    // 나누기 연산을 수행하는 static 메소드
    public static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("분모는 0이 될 수 없습니다.");
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println("add: " + add(1, 1));
        System.out.println("subtract: " + subtract(5, 1));
        System.out.println("multiply: " + multiply(5, 5));
        System.out.println("divide: " + divide(9, 3));

        // Error
        // System.out.println("divide(분모 0): " + divide(9, 0));
    }
}