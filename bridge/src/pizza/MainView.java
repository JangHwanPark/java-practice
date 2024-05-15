package pizza;

public class MainView {
    public static void main(String[] args) {
        Pizza pepperoniPizza = new PepperoniPizza();
        Pizza cheesePizza = new CheesePizza();

        // 이탈리아 스타일로 페퍼로니 피자를 만듭니다.
        ItalianRestaurant italianRestaurant = new ItalianRestaurant();
        italianRestaurant.makePizza(pepperoniPizza);

        // 미국 스타일로 치즈 피자를 만듭니다.
        AmericanRestaurant americanRestaurant = new AmericanRestaurant();
        americanRestaurant.makePizza(cheesePizza);
    }
}