import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person {
    String name;
    int age;
    
    // 생성자
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("이름 : %s, 나이 %d", this.name, this.age);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}