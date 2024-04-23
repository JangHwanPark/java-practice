package JavaModifiers;

public class StaticEx_01 {
    // Static Method
    static void staticMethod() {
        System.out.println("static method(정적 메서드)는 객체를 생성하지 않고 접근이 가능하다.");
    }

    // Public Method
    public void publicMethod() {
        System.out.println("public method(공개 메서드)는 객체를 생성하여 호출해야 한다.");
    }

    // Main Method
    public static void main(String[] args) {
        // Call the static method
        staticMethod();

        // Error
        // publicMethod();

        // Create an object of StaticEx01 and Call the public method
        StaticEx_01 publicObject = new StaticEx_01();
        publicObject.publicMethod();
    }
}