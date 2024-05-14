// 기능 인터페이스
public class Display {
    private DisplayImpl displayImpl;

    public Display(DisplayImpl displayImpl) {
        this.displayImpl = displayImpl;
        System.out.println("Display 생성자 호출: " + displayImpl.getClass().getName());
    }

    public void open() {
        displayImpl.rawOpen();
    }

    public void print() {
        displayImpl.rawPrint();
    }

    public void close() {
        displayImpl.rawClose();
    }

    public void integerText() {
        displayImpl.integerText();
    }

    public final void display() {
        open();
        print();
        close();
        integerText();
    }
}