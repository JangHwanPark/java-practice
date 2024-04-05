package src.Product;

/**
 * {@link iProduct} - 상품 정보를 나타내는 추상 클래스입니다.<br>
 * 이 클래스는 상품의 기본적인 속성 정보(상품 ID, 종류, 총 수량, 가격, 제조사, 제조년도, 상품명)를 정의합니다.<br>
 * 상속받는 클래스는 {@link #showitem()} 메소드를 구현하여, 상품 정보를 표시하는 방식을 정의해야 합니다.
 */
public abstract class iProduct {
    protected int pid;
    protected String kind;
    protected int totalquantity;
    protected int price;
    protected String maker;
    protected String year;
    protected String itemname;

    /**
     * 상품 아이디를 반환합니다.
     * @return 상품 아이디
     */
    public int getPid() {
        return pid;
    }

    /**
     * 상품 종류를 반환합니다.
     * @return 상품 종류
     */
    public String getKind() {
        return kind;
    }

    /**
     * 상품의 총 수량을 반환합니다.
     * @return 총 수량
     */
    public int getTotalquantity() {
        return totalquantity;
    }

    /**
     * 상품 가격을 반환합니다.
     * @return 가격
     */
    public int getPrice() {
        return price;
    }

    /**
     * 상품 제조사를 반환합니다.
     * @return 제조사
     */
    public String getMaker() {
        return maker;
    }

    /**
     * 상품의 제조년도를 반환합니다.
     * @return 제조년도
     */
    public String getYear() {
        return year;
    }

    /**
     * 상품명을 반환합니다.
     * @return 상품명
     */
    public String getItemname() {
        return itemname;
    }

    /**
     * 상품 ID를 설정합니다.
     * @param pid 새로 설정할 상품 ID
     */
    public void setPid(int pid) {
        this.pid = pid;
    }

    /**
     * 상품의 종류를 설정합니다.
     * @param kind 새로 설정할 상품 종류
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * 상품의 총 수량을 설정합니다.
     * @param totalquantity 새로 설정할 상품의 총 수량
     */
    public void setTotalquantity(int totalquantity) {
        this.totalquantity = totalquantity;
    }

    /**
     * 상품의 가격을 설정합니다.
     * @param price 새로 설정할 상품 가격
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 상품의 제조사를 설정합니다.
     * @param maker 새로 설정할 상품의 제조사
     */
    public void setMaker(String maker) {
        this.maker = maker;
    }

    /**
     * 상품의 제조년도를 설정합니다.
     * @param year 새로 설정할 상품의 제조년도
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 상품명을 설정합니다.
     * @param itemname 새로 설정할 상품명
     */
    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    /**
     * 상품의 상세 정보를 콘솔에 출력합니다.<br>
     * 이 메소드는 상속받는 클래스에서 구현되어야 합니다.
     */
    public abstract void showitem();
}