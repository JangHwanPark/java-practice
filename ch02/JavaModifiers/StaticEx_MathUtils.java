package JavaModifiers;

public class StaticEx_MathUtils {
    // 유클리드 호제법 - 최대공약수(GCD)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 최소공배수(LCM)
    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    // 팩토리얼
    public static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) res*=i;
        return res;
    }

    // 거듭제곱
    public static double power(double base, int exponent) {
        double res = 1;
        for (int i = 1; i <= exponent; i++) res *= base;
        return res;
    }

    public static void main(String[] args) {
        System.out.println("최대공약수(GCD) - 50 and 20: " + gcd(50, 20));
        System.out.println("최소공배수(LCM) - 50 and 20: " + lcm(50, 20));
        System.out.println("팩토리얼(Factorial) - 5: " + factorial(5));
        System.out.println("거듭제곱(Power) - 2, 5: " + power(2, 5));
    }
}