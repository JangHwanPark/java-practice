package src;

class Student {
    String name;
    int age;
    int grade;

    public Student() {};

    public void introduce() {
        System.out.println("저는 " + grade + "학년의 " + name + "이고, " + age + "살 입니다.");
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Test";
        student.age = 18;
        student.grade = 12;
        student.introduce();
    }
}