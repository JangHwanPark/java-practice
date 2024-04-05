package src.Product;
import java.util.Vector;

/**
 * 상품 목록을 관리하는 클래스입니다.<br>
 * 이 클래스는 상품(Product) 객체의 Vector를 사용하여 상품 목록을 저장하고 관리합니다.<br>
 * 상품은 iProduct 인터페이스를 구현하는 모든 객체를 포함할 수 있습니다.<br>
 * 각 상품에는 고유 ID(pid)가 할당되며, 이 ID는 상품이 목록에 추가될 때 자동으로 생성됩니다.
 */
public class ProductList {
    static private int spid = 0; // 모든 상품에 고유하게 할당될 상품 ID
    private ProductList itemlist; // 특정 조건을 만족하는 상품 목록을 임시로 저장할 필드
    private final Vector<iProduct> productList = new Vector<>(); // 상품 목록을 저장하는 Vector

    // Getter
    /**
     * 저장된 상품 목록을 반환합니다.
     *
     * @return 현재 저장된 모든 상품이 담긴 Vector
     */
    public Vector<iProduct> getProductList() {
        return productList;
    }

    // Setter
    /**
     * 상품 목록을 설정합니다.<br>
     * 주로 다른 상품 목록 인스턴스로부터 상품 목록을 복사할 때 사용됩니다.
     *
     * @param itemlist 복사할 상품 목록 인스턴스
     */
    public void setitemtlist(ProductList itemlist) {
        this.itemlist = itemlist;
    }

    // Business
    /**
     * 새로운 상품을 목록에 추가합니다.<br>
     * 추가되는 상품에는 고유 ID가 자동으로 할당됩니다.
     *
     * @param p 목록에 추가할 상품
     */
    public void addProduct(iProduct p) {
        productList.add(p);
        p.pid = spid;
        spid++;
    }

    /**
     * 주어진 종류(kind)에 해당하는 상품만을 포함하는 새로운 ProductList 인스턴스를 반환합니다.
     *
     * @param kind 필터링할 상품의 종류
     * @return 필터링된 상품 목록
     */
    public ProductList getItems(String kind) {
        itemlist = new ProductList();
        for (iProduct p : productList) {
            if (kind.equals(p.getKind())) {
                itemlist.productList.add(p);
            }
        }
        return itemlist;
    }

    /**
     * 지정된 ID를 가진 상품을 반환합니다.
     *
     * @param id 검색할 상품의 ID
     * @return 일치하는 ID를 가진 상품, 존재하지 않으면 null
     */
    public iProduct selectItems(int id) {
        return productList.elementAt(id);
    }

    // View
    /**
     * 현재 저장된 모든 상품 목록을 출력합니다.<br>
     * 각 상품은 상품이 제공하는 showitem 메서드를 통해 출력됩니다.
     */
    public void showProductlist() {
        for (iProduct p : productList) {
            p.showitem();
        }
    }
}