package src.Product;

public class Monitor extends iProduct {

    private String size;
    private String type;

    public Monitor(String maker, int totalquantity, int price) {
        setMaker(maker);
        setKind("MONITOR");
        setPrice(price);
        setTotalquantity(totalquantity);
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void showitem() {
        System.out.println(kind + ":" + maker + ":" + totalquantity + ":" + price);

    }


}