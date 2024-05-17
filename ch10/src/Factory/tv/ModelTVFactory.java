package Factory.tv;

import Factory.framework.Factory;
import Factory.framework.Product;

public class ModelTVFactory extends Factory {
    int modelNumber = 1000;

    @Override
    public Product createProduct(String model) {
        modelNumber++;
        return new ModelTV(model, modelNumber);
    }

    @Override
    public void registerProduct(Product product) {
        System.out.println(product + "을 구매했습니다.");
    }

    @Override
    public void deleteProduct(Product product) {
        System.out.println(product + "을 버렸습니다.");
    }
}