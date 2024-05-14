import framework.Factory;
import framework.Product;
import idcard.IDCardFactory;
import tv.ModelTVFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("Youngjin Kim");
        Product card2 = factory.create("JangHwan");
        card1.use();
        card2.use();
        System.out.println("\n====================\n");

        Factory factory1 = new ModelTVFactory();
        Product tv1 = factory1.create("LG");
        Product tv2 = factory1.create("삼성");
        tv1.use();
        tv2.use();

        tv1.delete();
    }
}