package src.Shopping;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link ShoppingBasket} - 사용자별 장바구니 인스턴스를 생성하는 클래스 입니다.<br>
 * Todo ShoppingBasket 작성*/
public class ShoppingBasket {
    private int sbId;
    private String uid;
    private String date;
    private boolean payment;
    private int amount;
    private final List<PickedProduct> shoppingList = new ArrayList<>();

    /**
     * 기본 생성자.<br>
     * {@code ShoppingBasket} 객체를 생성할 때 특별한 초기화 작업 없이 객체를 생성합니다.
     */
    public ShoppingBasket() {}

    /** Todo ShoppingBasket 생성자 작성 */
    public ShoppingBasket(String uid) {
        this.uid = uid;
    }

    // Getter
    public int getSbId() {
        return sbId;
    }

    public String getUid() {
        return uid;
    }

    public String getDate() {
        return date;
    }

    private boolean isPayment() {
        return payment;
    }

    public int getAmount() {
        return amount;
    }

    // Setter
    public void setSbId(int sbId) {
        this.sbId = sbId;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private void setPayment(boolean payment) {
        this.payment = payment;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    // Business
    public void addProduct(PickedProduct p) {
        shoppingList.add(p);
    }

    public void pushBuyKey() {
        if (!isPayment()) payment = true;
    }

    // View
    public void showShoppingList() {
        System.out.println("사용자 아이디: " + getUid());
        for (PickedProduct pk : shoppingList) {
            pk.showPickedProduct();
        }
    }

    /**
     * showPayment - 결제 정보를 보여주는 메서드입니다.<br>
     * 총 금액과 결제 방식을 출력합니다.
     */
    public void showPayment() {
        // 결제 상태에 따라 Paid, Not.. 출력
        // String paymentStatus = payment ? "Paid" : "Not Paid";
        System.out.println("==== Payment Information ====");
        System.out.println("Total Amount: " + amount);
        System.out.println("Payment Method: " + payment);
        System.out.println("=============================");
    }

    public void showDate() {

    }

    public void cancelBuy() {

    }

    /**
     * showAmount - 쇼핑리스트 내 모든 상품의 총 금액을 계산하고 출력하는 메서드입니다.<br>
     * 각 상품의 가격과 수량을 곱한 값을 모두 더하여 총 금액을 계산합니다.
     */
    public int showAmount() {
        int totalAmount = 0;
        for (PickedProduct pk : shoppingList) {
            totalAmount += pk.getPrice() * pk.getQuantity();
        }
        return totalAmount;
        //this.amount = totalAmount;
    }

    /**
     * 장바구니에 담긴 상품 목록을 반환합니다.
     * @return 상품 목록
     */
    public List<PickedProduct> getProducts() {
        return new ArrayList<>(shoppingList);
    }
}