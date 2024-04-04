package src.Product;

public class KeyBoard extends iProduct {

    private String type;
    private String color;

    public KeyBoard() {

    }

    public KeyBoard(String maker, int totalquantity, int price) {

        setMaker(maker);
        setKind("KEYBOARD");
        setPrice(price);
        setTotalquantity(totalquantity);
        color = "Black";
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void showitem() {
        System.out.println(kind + ":" + maker + ":" + totalquantity + ":" + price + "   color : " + color);

    }


}