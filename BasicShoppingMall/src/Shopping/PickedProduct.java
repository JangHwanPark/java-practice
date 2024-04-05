package src.Shopping;

/**
 * {@link PickedProduct} - 사용자가 선택한 제품의 인스턴스를 생성하는 클래스 입니다.<br>
 * Todo PickedProduct*/
public class PickedProduct {
    private int id;
    private int productid;
    private String itemname;
    private int price;
    private int quantity;

    /**
     * 기본 생성자.<br>
     * {@code PickedProduct} 객체를 생성할 때 특별한 초기화 작업 없이 객체를 생성합니다.
     */
    public PickedProduct() {}

    /**
     * 매개변수를 받는 생성자.<br>
     * 주어진 매개변수와 setter 메소드를 이용해 private 객체의 상태를 초기화 합니다.
     *
     * @param productid 선택한 상품 아이디
     * @param itemname 선택한 상품 이름
     * @param price 결제할 상품 가격
     * @param quantity 선택한 수량
     */
    public PickedProduct(int productid, String itemname, int price, int quantity) {
        setProductid(productid);
        setItemname(itemname);
        setPrice(price);
        setQuantity(quantity);
        showPickedProduct();
    }

    /** 사용자가 선택한 제품을 출력합니다. */
    public void showPickedProduct() {
        System.out.println("--------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-9s | %s\n", "Product ID", "Product Name", "Price (원)", "Quantity");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-10d | %-12s | %-9d | %d\n", productid, itemname, price, quantity);
    }

    // Getter
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

    // Setter
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