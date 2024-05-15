package pizza.not;

public class ItalianCheesePizza extends INotPizza {
    void prepare() {
        System.out.println("Preparing Italian style Cheese Pizza");
    }
    void bake() {
        System.out.println("Baking Italian style Cheese Pizza");
    }
    void cut() {
        System.out.println("Cutting Italian style Cheese Pizza");
    }
    void box() {
        System.out.println("Boxing Italian style Cheese Pizza");
    }
}