package JavaAbstractAnimal;

public abstract class Animal {
    // 추상 메서드(자식 클래스에서 오버라이드하여 사용한다.)
    public abstract void eat();
    public abstract void makeSound();

    // 공통적으로 사용하는 메서드
    public void breathe() {
        System.out.println("숨쉬는중...");
    }
}