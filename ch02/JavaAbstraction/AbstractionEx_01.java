package JavaAbstraction;

// 추상 클래스(Abstract class)
abstract class AbstractClassName {
    public String name = "JangHwan";
    public int age = 28;

    // 추상 메서드(Abstract method)
    public abstract void hobby();
}

// 자식(서브) 클래스(Sub class, inherit from AbstractClassName)
class SubClass extends AbstractClassName {
    public String university = "Ansan University";
    public int graduationYear = 2026;

    // 추상 메서드 본문은 상속받은 서브클래스에서 작성
    public void hobby() {
        System.out.println("취미는 리액트로 웹 제작 입니다.");
    }
}

public class AbstractionEx_01 {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();

        System.out.println("Name: " + subClass.name);
        System.out.println("Age: " + subClass.age);
        System.out.println("University: " + subClass.university);
        System.out.println("GraduationYear: " + subClass.graduationYear);
        System.out.print("Hobby(Method): ");
        subClass.hobby();
    }
}