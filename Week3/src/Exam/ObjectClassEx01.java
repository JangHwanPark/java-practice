package src.Exam;

public class ObjectClassEx01 {
    public String name;
    public int age;

    public ObjectClassEx01(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ObjectClassEx01 {name = '" + name + "', age = " + age + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ObjectClassEx01 obj = (ObjectClassEx01) object;
        return age == obj.age && name.equals(obj.name);
    }

    public static void main(String[] args) {
        // Wrapper Class 예시
        Integer num = Integer.valueOf(10); // int를 Integer 객체로 변환
        int n = num.intValue(); // Integer 객체를 int 기본 자료형으로 변환

        ObjectClassEx01 obj1 = new ObjectClassEx01("name1", 10);
        ObjectClassEx01 obj2 = new ObjectClassEx01("name2", 20);

        System.out.println(obj1);
        System.out.println(obj1.equals(obj1));
        System.out.println(obj1.equals(obj2));
    }
}