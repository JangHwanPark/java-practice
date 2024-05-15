package pizza.not;

public class NotPizza {
    public static void main(String[] args) {
        INotPizza italianPepperoniPizza = new ItalianPepperoniPizza();
        INotPizza americanPepperoniPizza = new AmericanPepperoniPizza();
        INotPizza italianCheesePizza = new ItalianCheesePizza();
        INotPizza americanCheesePizza = new AmericanCheesePizza();

        italianPepperoniPizza.prepare();
        italianPepperoniPizza.bake();
        italianPepperoniPizza.cut();
        italianPepperoniPizza.box();

        americanPepperoniPizza.prepare();
        americanPepperoniPizza.bake();
        americanPepperoniPizza.cut();
        americanPepperoniPizza.box();

        italianCheesePizza.prepare();
        italianCheesePizza.bake();
        italianCheesePizza.cut();
        italianCheesePizza.box();

        americanCheesePizza.prepare();
        americanCheesePizza.bake();
        americanCheesePizza.cut();
        americanCheesePizza.box();
    }
}