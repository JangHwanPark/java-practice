package Factory.idcard;

import Factory.framework.Product;

// 구현부
public class IDCard extends Product {
    private String owner;
    private int number = 2000;

    IDCard(String owner, int number) {
        System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
        this.number = number;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public void delete() {
        System.out.println(this + "을 삭제합니다.");
    }

    @Override
    public String toString() {
        return "[IDCard:" + owner + ", CardNumber: " + number + "]";
    }

    public String getOwner() {
        return owner;
    }

    public String getNumber() {
        return String.valueOf(number);
    }
}