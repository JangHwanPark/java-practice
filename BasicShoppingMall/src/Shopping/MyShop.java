package src.Shopping;
import src.Product.iProduct;
import src.Product.*;

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

    // Getter
    public ProductList getProductList() {
        return productList;
    }

    public User getUsers(int id) {
        return users.get(id);
    }

    public ShoppingBasket getSbs(int id) {
        return shoppingBaskets.get(id);
    }

    public ShoppingBasket getCurrentSBasket() {
        return currentSBasket;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    // Setter
    public void setProductList(ProductList productList) {
        this.productList = productList;
    }

    public void setUsers(User user) {
        this.users.add(user);
    }

    public void setSbs(ShoppingBasket sbs) {
        this.shoppingBaskets.add(sbs);
    }

    public void setCurrentSBasket(ShoppingBasket currentSBasket) {
        this.currentSBasket = currentSBasket;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * {@code initProducts} 메서드는 상품 객체의 집합을 초기화하며 다형성을 통해, 여러 타입의 상품 객체가 {@link ProductList} 타입으로 업캐스팅되어 하나의 상품 리스트로 관리할 수 있습니다.
     */
    private void initProducts() {
        productList = new ProductList();
        // iProduct p = new KeyBoard("Samsung", 12000, 50)
        productList.addProduct(new KeyBoard("Samsung", 12000, 50));
        productList.addProduct(new Monitor("LG", 200000, 40));
        productList.addProduct(new MainBoard("Intel", 500000, 20));
        productList.addProduct(new MainBoard("Cmd", 600000, 30));
        productList.addProduct(new KeyBoard("신세계", 5000, 150));
        productList.addProduct(new Monitor("sk", 130000, 40));
        productList.addProduct(new Monitor("Ansan", 130000, 40));
        
        // Monitor 클래스를 업캐스팅하여 출력하는 GamingMonitor 클래스
        productList.addProduct(new GamingMonitor("LG", 130000, 40, "49", 120, 4, "커브드"));
        
        // 전체 출력
        // productList.showProductList();
    }

    /**
     * {@code initUsers}메서드는 각 사용자의 데이터(아이디, 비밀번호)를 캡슐화하고,
     * 외부로부터의 접근을 제한하여 데이터의 안전성을 보장하며 {@link User}객체를 초기화합니다.
     */
    private void initUsers() {
        users.add(new User("kim", "1234"));
        users.add(new User("Lee", "5678"));
        users.add(new User("박뇬성", "1111"));
    }

    /**
     * {@code setup}초기 설정을 위한 메서드입니다.<br>
     * {@link #initProducts()}와 {@link #initUsers()}메서드를 순차적으로 호출합니다.
     */
    public void setup() {
        initProducts();
        initUsers();
    }

    // 비즈니스 로직, 장바구니 데이터 가져오기
    public List<ShoppingBasket> getShoppingBasketsForUser(String uid) {
        return selectShoppingBasket(uid);
    }

    public List<ShoppingBasket> getAllShoppingBaskets() {
        return new ArrayList<>(shoppingBaskets);
    }

    /**
     * 특정 사용자의 모든 장바구니를 검색합니다.
     *
     * @param uid 사용자 ID
     * @return 해당 사용자의 장바구니 목록
     */
    public List<ShoppingBasket> selectShoppingBasket(String uid) {
        List<ShoppingBasket> userBasket = new ArrayList<>();
        for (ShoppingBasket shoppingBasket : shoppingBaskets) {
            if (uid.equals(shoppingBasket.getUid())) userBasket.add(shoppingBasket);
        }
        return userBasket;
    }

    // Todo: 추후 입력값을 받아 장바구니에 추가하도록 수정 예정
    /**
     * 사용자 ID를 받아 새로운 장바구니를 생성하고, 지정된 수량의 무작위 상품을 장바구니에 추가합니다.
     * @param uid 사용자 ID
     * @param quantities 각 상품을 장바구니에 추가할 수량의 배열
     * @return 생성된 장바구니
     */
    public ShoppingBasket setupShoppingBasketForUser(String uid, int[] quantities) {
        ShoppingBasket shoppingBasket = new ShoppingBasket(uid);
        this.shoppingBaskets.add(shoppingBasket); // 장바구니 등록

        for (int quantity : quantities) {
            iProduct product = pickupItem(productList);
            PickedProduct pickedProduct = new PickedProduct(product.getPid(), product.getMaker(), product.getPrice(), quantity);

            shoppingBasket.addProduct(pickedProduct);
        }

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
        return productList.selectItems(id);
    }

    /**
     * 사용자 목록에서 인덱스에 해당하는 사용자를 선택합니다.
     *
     * @param index 사용자 목록에서의 위치를 나타내는 인덱스
     * @return 선택된 사용자 객체. 인덱스가 범위를 벗어난 경우, IndexOutOfBoundsException을 발생시킬 수 있습니다.
     */
    public User selectUserByIndex(int index) {
        // 인덱스 유효성 검사
        if (index >= 0 && index < users.size()) {
            currentUser = users.get(index);
            System.out.println("Selected user: " + currentUser.getUid()); // 디버깅 로그 추가
            return currentUser;
        } else {
            System.out.println("Invalid index: " + index); // 유효하지 않은 인덱스에 대한 로그 추가
            return null;
        }
    }

    /**
     * 사용자 ID를 기준으로 사용자 목록에서 사용자를 찾아 반환합니다.
     *
     * @param id 사용자의 고유 식별자(ID)를 나타내는 문자열
     * @return 해당 ID를 가진 사용자 객체. 해당 ID의 사용자가 목록에 없을 경우 null을 반환합니다.
     */
    public User selectUserById(String id) {
        for (User user : users) {
            if (id.equals(user.getUid())) return user;
        }
        return null;
    }

    // 메인 함수
    public static void main(String[] args) {
        ViewCLI viewCLI = new ViewCLI(new MyShop());
        viewCLI.start(); // CLI 애플리케이션 시작
        //	viewGLI.start(); // GUI 인터페이스
    }
}