// 구체적인 기능클래스 (Display 클래스의 서브클래스)
public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl displayImpl) {
        super(displayImpl);
    }

    public void multiDisplay(int times) {
        System.out.println("\nmultiDisplay 호출: " + times);
        open();
        for (int i = 0; i < times; i++) print();
        close();
    }
}