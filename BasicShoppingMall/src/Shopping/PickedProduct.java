package src.Shopping;

/**
 * {@link PickedProduct} - 사용자가 선택한 제품의 인스턴스를 생성하는 클래스 입니다.<br>
 */
public class PickedProduct {
    private int id;
    private int productId;
    private String itemName;
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
     * @param productId 선택한 상품 아이디
     * @param itemName 선택한 상품 이름
     * @param price 결제할 상품 가격
     * @param quantity 선택한 수량
     */
    public PickedProduct(int productId, String itemName, int price, int quantity) {
        setProductId(productId);
        setItemName(itemName);
        setPrice(price);
        setQuantity(quantity);
        // showPickedProduct(); // View
    }

    // Getter
    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public String getItemName() {
        return itemName;
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

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // tostr 오버라이드해서 객체를 문자열로 리턴
    @Override
    public String toString() {
        return "--------------------------------------------------\n" +
                "제품아이디: " + productId +
                " 상품명: " + itemName +
                ", 수량: " + quantity +
                ", 가격: " + price + "원";
    }
}