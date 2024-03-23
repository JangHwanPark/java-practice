package JavaAbstractAnimal;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Lion lion = new Lion();
        Cat cat = new Cat();

        // 사자 메서드 출력
        zoo.eatAnimal(lion);
        zoo.hearAnimal(lion);

        // 야옹이 메서드 출력
        zoo.eatAnimal(cat);
        zoo.hearAnimal(cat);
    }
}