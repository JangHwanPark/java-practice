package pizza;

public class ItalianRestaurant {
    public void makePizza(Pizza pizza) {
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        System.out.println("미국 스타일로 피자를 만듭니다.");
    }
}