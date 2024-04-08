package src.Shopping;
import src.Product.iProduct;
import src.Service.ServiceProducts;
import src.Service.ServiceShoppingBasket;
import src.Service.ServiceUser;
import java.util.List;

/**
 * {@link MyShop} - 인스턴스를 생성하고 생성된 인스턴스를 출력합니다. (CLI, GUI - 미구현)<br>
 * 사용자와 상품 목록 관리, 장바구니 기능을 제공합니다.
 * */
public class MyShop {
    private final ServiceUser currentUser;
    /** Field - 사용자, 장바구니, 상품 비즈니스 로직 분리 */
    private final ServiceProducts  serviceProducts;
    private final ServiceShoppingBasket serviceShoppingBasket;

    public MyShop(ServiceProducts serviceProducts, ServiceUser serviceUser, ServiceShoppingBasket serviceShoppingBasket) {
        this.serviceProducts = serviceProducts;
        this.currentUser = serviceUser;
        this.serviceShoppingBasket = serviceShoppingBasket;
    }

    public ServiceUser getCurrentUser() { // currentUser에 대한 참조를 반환
        return currentUser;
    }

    public ServiceProducts getServiceProducts() { // currentUser에 대한 참조를 반환
        return serviceProducts;
    }

    // 상품 초기화 - 더미 데이터로 상품 추가
    public void initProducts() {
        serviceProducts.initDefaultProducts();
    }

    // Note: Create Products
    /**
     * 상품 정보와 수량을 기반으로 선택된 상품 객체를 생성합니다.
     *
     * @param product 사용자가 선택한 상품.
     * @param quantity 선택한 상품의 수량.
     * @return 상품 정보와 수량을 담은 PickedProduct 객체.
     */
    private PickedProduct pickProduct(iProduct product, int quantity) {
        return new PickedProduct(product.getPid(), product.getMaker(), product.getPrice(), quantity);
    }

    /**
     * 사용자 ID와 상품 정보를 기반으로 사용자의 쇼핑바구니를 생성하거나 기존의 쇼핑바구니에 상품을 추가합니다.
     *
     * @param uid 상품을 추가할 사용자의 고유 식별자.
     * @param productIds 추가할 상품들의 고유 ID 배열.
     * @param quantities 각 상품의 수량 정보 배열.
     * @return 최종적으로 업데이트된 쇼핑바구니 객체.
     */
    public ShoppingBasket createShoppingBasketForUser(String uid, int[] productIds, int[] quantities) {
        ShoppingBasket shoppingBasket = serviceShoppingBasket.getOrCreateShoppingBasket(uid);
        serviceShoppingBasket.addProductToBasket(shoppingBasket, productIds, quantities);
        return shoppingBasket;
    }

    /**
     * 특정 사용자의 모든 장바구니를 검색합니다.
     *
     * @param uid 사용자 ID
     * @return 해당 사용자의 장바구니 목록
     */
    public List<ShoppingBasket> findShoppingBasket(String uid) {
        return serviceShoppingBasket.findShoppingBasketByUserId(uid);
    }
}