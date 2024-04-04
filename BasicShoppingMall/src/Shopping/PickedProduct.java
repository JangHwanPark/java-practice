package src.Shopping;

public class PickedProduct {

    private int id;
    private int productid;
    private String itemname;
    private int price;
    private int quantity;

    public PickedProduct() {
    }

    public PickedProduct(int productid, String itemname, int price, int quantity) {
        setProductid(productid);
        setItemname(itemname);
        setPrice(price);
        setQuantity(quantity);

        showPickedProduct();
    }

    public void showPickedProduct() {
        System.out.println(productid + " : " + itemname + " : " + price + " : " + quantity);
    }

    public int getId() {
        return id;
    }

    public int getProductid() {
        return productid;
    }

    public String getItemname() {
        return itemname;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}