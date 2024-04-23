package JavaAbstractAnimal;

public class Lion extends Animal {
    @Override
    public void eat() {
        System.out.println("사자가 밥을 먹는다 !!!");
    }

    @Override
    public void makeSound() {
        System.out.println("사자가 소리를 내고 있다!!!");
    }
}