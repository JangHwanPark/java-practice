import java.util.Vector;

public class VectorEx {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < 15; i++) vector.add(i);
        vector.add(3, 100);

        // elementAt() ?
        System.out.println("vector");
        System.out.println("벡터 내 객체 수: " + vector.size());
        System.out.println("벡터 현재 용량: " + vector.capacity());
        for (Integer i : vector) System.out.print(i + " ");


        Vector<Integer> vector2 = vector;
        System.out.println("\n\nvector2");
        System.out.println("벡터 내 객체 수: " + vector2.size());
        System.out.println("벡터 현재 용량: " + vector2.capacity());
        for (Integer i : vector2) System.out.print(i + " ");

        // 삭제
        for (int i = 0; i < vector.size(); i++) vector.remove(i);
        System.out.println("\n\nRemove Vector");
        System.out.println("벡터 내 객체 수: " + vector.size());
        System.out.println("벡터 현재 용량: " + vector.capacity());
        for (Integer i : vector) System.out.print(i + " ");
    }
}
