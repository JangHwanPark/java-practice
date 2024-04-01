import java.util.HashSet;
import java.util.Set;

public class ObjectsClassTest {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동", 20);
        Person p2 = new Person("홍길동", 20);

        // 두 객체의 해시 코드
        System.out.println(p1.hashCode()); // 54150093
        System.out.println(p2.hashCode()); // 54150093

        // 해시코드가 달라도, equals를 재정의 했기 때문에 동등함
        System.out.println(p1.equals(p2)); // true

        // SET를 생성하고 두 객체 데이터를 추가한다.
        Set<Person> people = new HashSet<>();
        people.add(p1);
        people.add(p2);

        // 그리고 SET의 길이를 출력한다.
        System.out.println(people.size()); // 1
    }
}