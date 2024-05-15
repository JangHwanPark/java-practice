package pizza.not;

public class AmericanPepperoniPizza extends INotPizza {
    void prepare() {
        System.out.println("Preparing American style Pepperoni Pizza");
    }
    void bake() {
        System.out.println("Baking American style Pepperoni Pizza");
    }
    void cut() {
        System.out.println("Cutting American style Pepperoni Pizza");
    }
    void box() {
        System.out.println("Boxing American style Pepperoni Pizza");
    }
}