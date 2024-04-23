class A {
    public A() {
        System.out.println("Default Constructor A");
    }

    public A(int x) {
        System.out.println("매개변수 생성자 A");
    }
}

class B extends A {
    public B() {
        System.out.println("Default Constructor B");
    }

    public B(int x) {
        super(x);
        System.out.println("매개변수 생성자 B");
    }
}

class C extends B {
    public C() {
        System.out.println("생성자 C");
    }
}

public class Constructor {
    public static void main(String[] args) {
        C c = new C();
        System.out.println("===================");
        B b1 = new B();
        System.out.println("===================");
        B b = new B(5);
        System.out.println("===================");
        A a = new A();
    }
}
