package src.Shopping;
import src.Product.iProduct;
import src.Product.*;
import src.Service.ServiceUser;
import src.View.ViewCLI;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link MyShop} - 인스턴스를 생성하고 생성된 인스턴스를 출력합니다. (CLI, GUI - 미구현)<br>
 * 사용자와 상품 목록 관리, 장바구니 기능을 제공합니다.
 * */
public class MyShop {
    // Field
    private ProductList productList;
    private ShoppingBasket currentSBasket;
    private ServiceUser currentUser; // User 비즈니스 로직

    private final List<ShoppingBasket> shoppingBaskets = new ArrayList<>();

    public MyShop() {
        this.currentUser = new ServiceUser();
    }

    // Note: ProductList Getter
    public ProductList getProductList() {
        return productList;
    }

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }

    // Note: MyShop 클래스 내 특정 id에 해당하는 장바구니 데이터 가져오기
    public ShoppingBasket getShoppingBasket(int id) {
        return shoppingBaskets.get(id);
    }

    public ShoppingBasket getCurrentsBasket() {
        return currentSBasket;
    }

    // Note: ShoppingBasket Setter
    public void setShoppingBasket(ShoppingBasket sbs) {
        this.shoppingBaskets.add(sbs);
    }

    public void setCurrentSBasket(ShoppingBasket currentSBasket) {
        this.currentSBasket = currentSBasket;
    }

    // Todo: initProducts - Dummy Data
    /**
     * {@code initProducts} 메서드는 상품 객체의 집합을 초기화하며 다형성을 통해, 여러 타입의 상품 객체가 {@link ProductList} 타입으로 업캐스팅되어 하나의 상품 리스트로 관리할 수 있습니다.
     */
    public void initProducts() {
        ProductList productList = new ProductList();
        setProductList(productList);
        
        // 상품 생성 및 등록 (Default Value)
        productList.addProduct(new KeyBoard("Samsung", 12000, 50));
        productList.addProduct(new Monitor("LG", 200000, 40));
        productList.addProduct(new MainBoard("Intel", 500000, 20));
        productList.addProduct(new MainBoard("Cmd", 600000, 30));
        productList.addProduct(new KeyBoard("신세계", 5000, 150));
        productList.addProduct(new Monitor("sk", 130000, 40));
        productList.addProduct(new Monitor("Ansan", 130000, 40));
        
        // Monitor 클래스를 업캐스팅하여 출력하는 GamingMonitor 클래스
        productList.addProduct(new GamingMonitor("LG", 130000, 40, "49", 120, 4, "커브드"));
    }

    // 사용자 입력을 받아 새로운 상품 객체 생성
    public void addProducts(String category, String name, int price, int quantity) {
        switch (category.toLowerCase()) {
            case "keyboard":
                productList.addProduct(new KeyBoard(name, price, quantity));
                break;
            case "monitor":
                productList.addProduct(new Monitor(name, price, quantity));
                break;
            case "mainboard":
                productList.addProduct(new MainBoard(name, price, quantity));
                break;
            default:
                System.out.println("지원하지 않는 상품 카테고리입니다.");
                break;
        }
    }

    // Note: Create Products
    /**
     * 사용자 ID에 해당하는 쇼핑바구니를 검색하거나, 없을 경우 새로운 쇼핑바구니를 생성합니다.<br>
     * 다형성의 이용해 입력에 따라 다른 기능을 제공합니다.
     *
     * @param uid 사용자의 고유 식별자.
     * @return 기존 또는 새로 생성된 사용자 ID와 연관된 쇼핑바구니 인스턴스.
     */
    private ShoppingBasket getOrCreateShoppingBasket(String uid) {
        ShoppingBasket shoppingBasket = findShoppingBasketByUid(uid);
        if (shoppingBasket == null) {
            shoppingBasket = new ShoppingBasket(uid);
            shoppingBaskets.add(shoppingBasket);
        }
        return shoppingBasket;
    }

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
     * 지정된 장바구니에 여러 상품을 상품 ID와 수량 정보를 기반으로 추가합니다.
     *
     * @param basket 상품을 추가할 대상 장바구니.
     * @param productIds 추가할 상품들의 고유 ID 배열.
     * @param quantities 각 상품 ID에 해당하는 수량 정보 배열.
     */
    private void addProductsToBasket(ShoppingBasket basket, int[] productIds, int[] quantities) {
        for (int i = 0; i < productIds.length; i++) {
            iProduct product = productList.findProductById(productIds[i]);
            if (product != null) {
                PickedProduct pickedProduct = pickProduct(product, quantities[i]);
                basket.addProduct(pickedProduct);
            }
        }
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
        ShoppingBasket shoppingBasket = getOrCreateShoppingBasket(uid);
        addProductsToBasket(shoppingBasket, productIds, quantities);
        return shoppingBasket;
    }

    /**
     * {@link ProductList}에서 무작위로 하나의 상품을 선택하여 반환합니다.<br>
     * 다형성을 활용하여 리턴된{@link iProduct}객체가 실제로 어떤 상품의 인스턴스인지에 상관 없이 동일한 방식으로 동작할 수 있도록 합니다.
     *
     * @param productList 상품 목록으로 무작위로 상품이 선택됩니다.
     * @return 선택된 상품 객체로 {@link iProduct}인터페이스를 구현하는 어떤 상품 객체도 리턴할 수 있습니다.
     */
    public iProduct pickupItem(ProductList productList) {
        int max = productList.getProductList().size();
        int id = (int) (Math.random() * max);
        return productList.findItems(id);
    }

    // Note: find
    /**
     * 유저 고유값을 매개변수로 받아 {@link ShoppingBasket}객체를
     * {@link #shoppingBaskets}리스트에서 찾아 반환, 장바구니가 없다면 null 반환.
     * {@link #createShoppingBasketForUser}메서드에서 호출됨
     * @param uid 유저 아이디
     */
    private ShoppingBasket findShoppingBasketByUid(String uid) {
        for (ShoppingBasket basket : shoppingBaskets) {
            if (uid.equals(basket.getUserid())) return basket;
        }
        return null;
    }

    /**
     * 특정 사용자의 모든 장바구니를 검색합니다.
     *
     * @param uid 사용자 ID
     * @return 해당 사용자의 장바구니 목록
     */
    public List<ShoppingBasket> findShoppingBasket(String uid) {
        List<ShoppingBasket> userBasket = new ArrayList<>();
        for (ShoppingBasket shoppingBasket : shoppingBaskets) {
            if (uid.equals(shoppingBasket.getUserid())) userBasket.add(shoppingBasket);
        }
        return userBasket;
    }

    // Note: Main Fn
    public static void main(String[] args) {
        ViewCLI viewCLI = new ViewCLI(new MyShop(), new ServiceUser());
        viewCLI.start(); // CLI 애플리케이션 시작
        // viewGLI.start(); // GUI 인터페이스
    }
}