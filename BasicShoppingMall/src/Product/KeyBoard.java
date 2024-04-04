package src.Product;

/**
 * {@code KeyBoard} 클래스는 {@code iProduct}의 구현체로, 키보드 상품 정보를 나타냅니다.
 * 이 클래스는 키보드의 타입과 색상 정보를 추가로 관리합니다.
 */
public class KeyBoard extends iProduct {
    private String type; // 키보드의 타입 (예: 기계식, 멤브레인)
    private String color; // 키보드의 색상

    /**
     * 기본 생성자.<br>
     * {@code KeyBoard} 객체를 생성할 때 특별한 초기화 작업 없이 객체를 생성합니다.
     */
    public KeyBoard() {}

    /**
     * 매개변수를 받는 생성자.<br>
     * 주어진 매개변수로 키보드 객체의 상태를 초기화합니다. 기본 색상은 "Black"으로 설정됩니다.
     *
     * @param maker 키보드의 제조사
     * @param totalquantity 키보드의 총 수량
     * @param price 키보드의 가격
     */
    public KeyBoard(String maker, int totalquantity, int price) {
        setMaker(maker);
        setKind("KEYBOARD"); // 상품 종류는 "KEYBOARD"로 고정
        setPrice(price);
        setTotalquantity(totalquantity);
        this.color = "Black"; // 기본 색상 설정
    }

    /**
     * 키보드의 타입을 반환합니다.
     *
     * @return 키보드의 타입
     */
    public String getType() {
        return type;
    }

    /**
     * 키보드의 색상을 반환합니다.
     *
     * @return 키보드의 색상
     */
    public String getColor() {
        return color;
    }

    /**
     * 키보드의 타입을 설정합니다.
     *
     * @param type 설정할 키보드의 타입
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 키보드의 색상을 설정합니다.
     *
     * @param color 설정할 키보드의 색상
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 키보드 상품의 상세 정보를 콘솔에 출력합니다.<br>
     * 상품 종류, 제조사, 총 수량, 가격 및 색상을 포함한 정보를 출력합니다.
     */
    public void showitem() {
        System.out.println(kind + ":" + maker + ":" + totalquantity + ":" + price + "   color : " + color);
    }
}