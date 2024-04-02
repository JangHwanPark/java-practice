import java.sql.Array;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        int integer = 123; // Integer i = 123;
        System.out.println(integer);
        System.out.println(Integer.toString(integer)); // i.toString();

        String s = "Hello";
        System.out.println(s + ": "+ System.identityHashCode(s));

        s = "Java";
        System.out.println(s + ": " + System.identityHashCode(s));

        // Vector get 메소드 -> 주소값 리턴
        Vector<Integer> v = new Vector<Integer>();
        for (int i = 0; i < 10; i++) v.add(i);
        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i) + ": " + System.identityHashCode(v.get(i)));
        }

    }
}