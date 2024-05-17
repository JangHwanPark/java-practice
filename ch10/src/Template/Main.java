package Template;

public class Main {
    public static void main(String[] args) {
        // 업캐스팅 발생
        AbstractDisplay d1 = new CharDisplay('H');

        // Hello... 안녕하세요 출력하는 StringDisplay 객체 생성
        AbstractDisplay d2 = new StringDisplay("Hello, world.");
        AbstractDisplay d3 = new StringDisplay("안녕하세요.");

        d1.display();
        d2.display();
        d3.display();
    }
}