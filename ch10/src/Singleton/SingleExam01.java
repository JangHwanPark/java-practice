package Singleton;

public class SingleExam01 {
    private static SingleExam01 instance = new SingleExam01();
    private SingleExam01() {
        System.out.println("인스턴스를 생성했습니다.");
    }

    public static SingleExam01 getInstance() {
        return instance;
    }
}