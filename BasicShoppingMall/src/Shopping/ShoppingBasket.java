package src.Shopping;
import java.util.Vector;

/**
 * {@link ShoppingBasket} - 사용자별 장바구니 인스턴스를 생성하는 클래스 입니다.<br>
 * Todo ShoppingBasket 작성*/
public class ShoppingBasket {
    private int sbid;
    private String uid;
    private String date;
    private boolean payment;
    private int amount;
    private final Vector<PickedProduct> shoppingList = new Vector<PickedProduct>();

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
    public int getSbid() {
        return sbid;
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
    public void setSbid(int sbid) {
        this.sbid = sbid;
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

    public void showPayment() {
        System.out.println("amount: " + amount + "\n" + "payment: " + payment);
    }

    public void showDate() {

    }

    public void cancelBuy() {

    }

    public void showAmount() {
        int Amount = 0;
        int price;
        int quantity;
        for (PickedProduct pk : shoppingList) {
            Amount = Amount + pk.getPrice() * pk.getQuantity();
        }

        this.amount = Amount;
        System.out.println("Amount = " + amount);
    }
}