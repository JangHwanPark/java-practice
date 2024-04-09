package JavaUpDownCasting;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Ansan");
        // Person person = student;
        // person = "에러 발생함";

        // Student의 display() 호출, Person의 display()도 내부적으로 호출됨
        student.display();

        // UpCasting
        Person person = student; // Student를 Person으로 업캐스팅
        person.display(); // 업캐스팅된 객체를 통해 display() 호출

        // DownCasting
        Student backToStudent = (Student) person; // 명시적 다운캐스팅
        backToStudent.displayCheck(); // 다운캐스팅된 객체를 통해 Student 고유 메소드 호출
    }
}