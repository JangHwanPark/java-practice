package Prototype;

public class Manager {
    private java.util.HashMap<String, Product> showcase = new java.util.HashMap<String, Product>();

    public void register(String name, Product proto) {
        showcase.put(name, proto);
    }

    public Product create(String protoname) {
        Product p = showcase.get(protoname);
        return p.createClone();
    }
}