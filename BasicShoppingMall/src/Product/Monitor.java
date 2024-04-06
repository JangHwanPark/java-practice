package src.Product;

/**
 * {@link Monitor} 클래스는 {@link iProduct} 추상 클래스를 상속받아 구현된 클래스입니다.<br>
 * 이 클래스는 모니터에 대한 정보를 관리합니다, 모니터의 크기와 유형(예: LCD, LED 등)을 포함합니다.
 */
public class Monitor extends iProduct {
    private String size;
    private String type;

    /**
     * {@link Monitor} 객체의 생성자입니다.
     *
     * @param maker 모니터의 제조사
     * @param totalQuantity 모니터의 총 수량
     * @param price 모니터의 가격
     */
    public Monitor(String maker, int totalQuantity, int price) {
        setMaker(maker);
        setKind("MONITOR");
        setPrice(price);
        setTotalQuantity(totalQuantity);
    }

    // Getter
    /**
     * 모니터의 크기를 가져옵니다.
     *
     * @return 모니터의 크기 (예: "27인치")
     */
    public String getSize() {
        return size;
    }

    /**
     * 모니터의 유형을 가져옵니다.
     *
     * @return 모니터의 유형 (예: "LCD", "LED")
     */
    public String getType() {
        return type;
    }

    // Setter
    /**
     * 모니터의 크기를 설정합니다.
     *
     * @param size 설정할 모니터의 크기
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * 모니터의 유형을 설정합니다.
     *
     * @param type 설정할 모니터의 유형
     */
    public void setType(String type) {
        this.type = type;
    }

    // View
    public void showItem() {
        System.out.println("==== Monitor Information ====");
        System.out.println("Kind: " + kind);
        System.out.println("Maker: " + maker);
        System.out.println("Quantity: " + totalQuantity);
        System.out.println("Price: " + price);
        System.out.println("Size: " + size);
        System.out.println("Type: " + type);
        System.out.println("=============================");
    }
}