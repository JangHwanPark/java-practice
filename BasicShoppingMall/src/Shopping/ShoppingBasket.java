package src.Shopping;

import java.util.Vector;

public class ShoppingBasket {

    private int sbid;
    private String uid;
    private String date;
    private boolean payment;
    private int amount;
    private final Vector<PickedProduct> shoppingList = new Vector<PickedProduct>();

    public ShoppingBasket() {
    }

    public ShoppingBasket(String uid) {
        this.uid = uid;
    }

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

    public void addProduct(PickedProduct p) {
        shoppingList.add(p);
    }

    public void pushBuyKey() {
        if (!isPayment())
            payment = true;
    }

    public void showShoppingList() {
        System.out.println("����� :" + getUid());
        for (PickedProduct pk : shoppingList) {
            pk.showPickedProduct();
        }

    }

    public void showPayment() {
        System.out.println("amount :" + amount + "   payment: " + payment);
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