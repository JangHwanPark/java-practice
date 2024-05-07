package AdapterI;

public class AdapterMain {
    public static void main(String[] args) {
        Banner b = new Banner("어댑터 패턴 테스트 배너");
        Print p = new PrintBanner("어댑터 패턴 테스트 프린트");
        p.printWeak();
        p.printStrong();

        b.showWithParen();
        b.showWithAster();
    }
}