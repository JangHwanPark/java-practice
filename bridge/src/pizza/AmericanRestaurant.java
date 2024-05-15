package pizza;

public class AmericanRestaurant {
    public void makePizza(Pizza pizza) {
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        System.out.println("이탈리아 스타일로 피자를 만듭니다.");
    }
}