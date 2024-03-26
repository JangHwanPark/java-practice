interface PhoneInterface {
    public static final int timeOut = 10000;

    public abstract void sendCall();

    public abstract void receiveCall(String s);
    public abstract void sum(int a, int b);
    public default void printLogo() {
        System.out.println("default Method: Phone");
    }
}

public class InterfaceEx implements PhoneInterface {
    @Override
    public void sendCall() {
        System.out.println("sendCall");
    }

    @Override
    public void receiveCall(String s) {
        System.out.println(s);
    }

    @Override
    public void sum(int a, int b) {
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        InterfaceEx phone = new InterfaceEx();
        System.out.println(timeOut);
        phone.receiveCall("receiveCall");
        phone.sendCall();
        phone.printLogo();
        phone.sum(5, 55);

        PhoneInterface interPhone = new InterfaceEx();
        System.out.println(timeOut);
        interPhone.receiveCall("interPhone");
        interPhone.printLogo();
    }
}
