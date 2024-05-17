package Template;

public class AbstractDisplay {
    protected void open() {
    }

    protected void print() {
    }

    protected void close() {
    }

    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}