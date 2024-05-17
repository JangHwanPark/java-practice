package Singleton;

public class ExamMain {
    public static void main(String[] args) {
        System.out.println("Start.");
        SingleExam01 obj1 = SingleExam01.getInstance();
        SingleExam01 obj2 = SingleExam01.getInstance();

        if (obj1 == obj2) {
            System.out.println("같은 인스턴스입니다.");
        } else {
            System.out.println("다른 인스턴스입니다.");
        }
        System.out.println("End.");
    }
}