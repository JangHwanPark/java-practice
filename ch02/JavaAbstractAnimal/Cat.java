package JavaAbstractAnimal;

public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("츄르 냠냠");
    }

    @Override
    public void makeSound() {
        System.out.println("집사!");
    }
}