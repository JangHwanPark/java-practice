package pizza.not;

public class AmericanCheesePizza extends INotPizza {
    void prepare() {
        System.out.println("Preparing American style Cheese Pizza");
    }
    void bake() {
        System.out.println("Baking American style Cheese Pizza");
    }
    void cut() {
        System.out.println("Cutting American style Cheese Pizza");
    }
    void box() {
        System.out.println("Boxing American style Cheese Pizza");
    }
}