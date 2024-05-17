package Factory.framework;

public abstract class Factory {
    // 구현된 메서드
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    public Product delete(String owner) {
        Product p = createProduct(owner);
        deleteProduct(p);
        return p;
    }

    // 추상 메서드
    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);

    protected abstract void deleteProduct(Product product);
}