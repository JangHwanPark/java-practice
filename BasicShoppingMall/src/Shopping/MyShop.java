package src.Shopping;
import src.Product.iProduct;
import src.Product.*;
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
    private User currentUser;
    
    // 벡터 -> 어레이 리스트로 변경
    private final List<User> users = new ArrayList<>();
    private final List<ShoppingBasket> shoppingBaskets = new ArrayList<>();

    // Note: Getter
    public ProductList getProductList() {
        return productList;
    }

    public User getUsers(int id) {
        return users.get(id);
    }

    // Note: MyShop 클래스 내 모든 장바구니 데이터 가져오기
    public List<ShoppingBasket> getAllShoppingBaskets() {
        return new ArrayList<>(shoppingBaskets);
    }

    // Note: MyShop 클래스 내 특정 id에 해당하는 장바구니 데이터 가져오기
    public ShoppingBasket getShoppingBasket(int id) {
        return shoppingBaskets.get(id);
    }

    /**
     * 현재 장바구니 가져오기 (getCurrentsBasket)<br>
     * {@link #createShoppingBasketForUser}메소드에서 사용
     */
    public ShoppingBasket getCurrentsBasket() {
        return currentSBasket;
    }

    /**
     * 현재 사용자 정보 가져오기 (getCurrentsBasket)<br>
     * {@link #createShoppingBasketForUser}메소드에서 사용
     */
    public User getCurrentUser() {
        return currentUser;
    }

    // Note: Setter
    public void setProductList(ProductList productList) {
        this.productList = productList;
    }

    public void setUsers(User user) {
        this.users.add(user);
    }

    public void setShoppingBasket(ShoppingBasket sbs) {
        this.shoppingBaskets.add(sbs);
    }

    public void setCurrentSBasket(ShoppingBasket currentSBasket) {
        this.currentSBasket = currentSBasket;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    // Note: init Product
    // Hack: Scanner 사용 예정
    /**
     * {@code initProducts} 메서드는 상품 객체의 집합을 초기화하며 다형성을 통해, 여러 타입의 상품 객체가 {@link ProductList} 타입으로 업캐스팅되어 하나의 상품 리스트로 관리할 수 있습니다.
     */
    private void initProducts() {
        ProductList productList = new ProductList();
        setProductList(productList);
        
        // 상품 생성 및 등록
        productList.addProduct(new KeyBoard("Samsung", 12000, 50));
        productList.addProduct(new Monitor("LG", 200000, 40));
        productList.addProduct(new MainBoard("Intel", 500000, 20));
        productList.addProduct(new MainBoard("Cmd", 600000, 30));
        productList.addProduct(new KeyBoard("신세계", 5000, 150));
        productList.addProduct(new Monitor("sk", 130000, 40));
        productList.addProduct(new Monitor("Ansan", 130000, 40));
        
        // Monitor 클래스를 업캐스팅하여 출력하는 GamingMonitor 클래스
        productList.addProduct(new GamingMonitor("LG", 130000, 40, "49", 120, 4, "커브드"));
        
        // Test: 전체 출력
        // productList.showProductList();
    }

    // Note: init User
    // Hack: Scanner 사용 예정
    /**
     * {@code initUsers}메서드는 각 사용자의 데이터(아이디, 비밀번호)를 캡슐화하고,
     * 외부로부터의 접근을 제한하여 데이터의 안전성을 보장하며 {@link User}객체를 초기화합니다.
     */
    private void initUsers() {
        // 사용자 등록
        setUsers(new User("kim", "1234"));
        setUsers(new User("Lee", "5678"));
        setUsers(new User("박뇬성", "1111"));

        // 기본 사용자 선택
        User t = findUserById(0);
        setCurrentUser(t);
        // User t1 = findUserById(1);
        // setCurrentUser(t1);
        // User t2 = findUserById(2);
        // setCurrentUser(t2);
    }

    // Fixme: 스캐너 작업 끝나면 삭제 예정 (setup())
    /**
     * {@code setup}초기 설정을 위한 메서드입니다.<br>
     * {@link #initProducts()}와 {@link #initUsers()}메서드를 순차적으로 호출합니다.
     */
    public void setup() {
        initProducts();
        initUsers();
    }

    // Note: Create Products
    // Hack: 추후 입력값을 받아 장바구니에 추가하도록 수정 예정
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

    /**
     * 사용자 목록에서 인덱스에 해당하는 사용자를 선택합니다.
     *
     * @param index 사용자 목록에서의 위치를 나타내는 인덱스
     * @return 선택된 사용자 객체. 인덱스가 범위를 벗어난 경우, IndexOutOfBoundsException을 발생시킬 수 있습니다.
     */
    public User findUserById(int index) {
        // 인덱스 유효성 검사
        if (index >= 0 && index < users.size()) {
            currentUser = users.get(index);
            System.out.println("선택: " + currentUser.getUid()); // 디버깅 로그
            return currentUser;
        } else {
            System.out.println("없는 인덱스: " + index); // 유효하지 않은 인덱스
            return null;
        }
    }

    /**
     * 사용자 ID를 기준으로 사용자 목록에서 사용자를 찾아 반환합니다.
     *
     * @param id 사용자의 고유 식별자(ID)를 나타내는 문자열
     * @return 해당 ID를 가진 사용자 객체. 해당 ID의 사용자가 목록에 없을 경우 null을 반환합니다.
     */
    public User findUserById(String id) {
        for (User user : users) {
            if (id.equals(user.getUid())) return user;
        }
        return null;
    }

    // Note: Main Fn
    public static void main(String[] args) {
        PickedProduct product = new PickedProduct(1, "Keyboard", 10000, 2);
        System.out.println(product.toString());


        ViewCLI viewCLI = new ViewCLI(new MyShop());
        viewCLI.start(); // CLI 애플리케이션 시작
        // viewGLI.start(); // GUI 인터페이스
    }
}