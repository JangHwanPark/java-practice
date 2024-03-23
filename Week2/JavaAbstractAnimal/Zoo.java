package JavaAbstractAnimal;

public class Zoo {
    // Animal 타입의 인스턴스를 매개변수로 받아, 그 인스턴스의 eat 메서드를 호출
    public void eatAnimal(Animal animal) {
        animal.eat();
    }

    // Animal 타입의 인스턴스를 매개변수로 받아, 그 인스턴스의 makeSound 메서드를 호출
    public void hearAnimal(Animal animal) {
        animal.makeSound();
    }
}