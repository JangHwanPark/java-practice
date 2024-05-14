// 구현 클래스
public class StringDisplayImpl extends DisplayImpl {
    private String string;
    private int integer;
    private int width;

    public StringDisplayImpl(String string) {
        this.string = string;
        this.width = string.getBytes().length;
        System.out.println("StringDisplayImpl 생성자 호출: " + string + ", width: " + width);
    }

    public StringDisplayImpl(int integer) {
        this.integer = integer;
        this.width = String.valueOf(integer).length();
        System.out.println("StringDisplayImpl 생성자 호출: " + integer + ", width: " + width);
    }

    public void rawOpen() {
        printLine();
    }

    public void rawPrint() {
        System.out.println("rawPrint 호출: " + string);
        System.out.println("|" + string + "|");
    }

    public void rawClose() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    public void integerText() {
        System.out.println("\nintegerText 호출: " + integer);
        System.out.println("|" + integer + "|");
    }
}