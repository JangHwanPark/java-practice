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
        productList.addProduct(new GamingMonitor("LG", 130000, 40, "49", 120, 4, "커브드"));
        productList.showProductList();
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

    // 로직 실행 메서드
    /** User u - {@link #selectUserByIndex}사용자중 한명을 현재 사용자로선택 */
    public void run() {
        selectUserByIndex(0); // 사용자 선택
        selectProductsForCurrentUser(); // 상품 선택, 장바구니 생성
        viewShoppingBasketForUser(currentUser.getUid()); // n 번째 사용자의 장바구니 정보 출력

        // 모든 사용자 장바구니 보기
        viewAllShoppingBaskets();
    }

    /**
     * 사용자 ID를 기반으로 해당 사용자의 모든 장바구니 정보를 조회한 후, {@link #displayShoppingBasket(ShoppingBasket)} 메서드를 호출하여 각 장바구니의 상세 내용을 출력합니다.
     *
     * @param uid 표시할 사용자의 ID. 이 ID에 해당하는 사용자의 모든 장바구니 정보가 표시됩니다.
     * @see #selectShoppingBasket(String) 사용자 ID에 따른 장바구니 정보 조회
     * @see #displayShoppingBasket(ShoppingBasket) 장바구니 상세 정보 출력
     */
    private void viewShoppingBasketForUser(String uid) {
        System.out.println("\n---------- " + uid + "의 쇼핑리스트 -------------");
        List<ShoppingBasket> uBaskets = selectShoppingBasket(uid);
        for (ShoppingBasket basket : uBaskets) {
            displayShoppingBasket(basket);
        }
    }

    /**
     * 시스템에 등록된 모든 장바구니 정보를 순회하며, {@link #displayShoppingBasket(ShoppingBasket)} 메서드를 호출하여 모든 사용자 장바구니의 상세 내용을 출력합니다.
     *
     * @see #displayShoppingBasket(ShoppingBasket) 장바구니 상세 정보 출력
     */
    private void viewAllShoppingBaskets() {
        System.out.println("\n---------- 모든 사용자 쇼핑리스트 -------------");
        for (ShoppingBasket basket : shoppingBaskets) {
            displayShoppingBasket(basket);
        }
    }

    /**
     * 주어진 장바구니 객체의 상세 정보를 화면에 표시합니다.
     * 이 메서드는 장바구니에 담긴 각 상품의 정보(상품명, 수량, 가격 등)와,
     * 장바구니의 총 금액을 사용자에게 보여줍니다.
     *
     * @param basket 표시할 장바구니 객체
     */
    private void displayShoppingBasket(ShoppingBasket basket) {
        System.out.println("장바구니 ID: " + basket.getUid());
        System.out.println("================================");

        // 장바구니에 담긴 각 상품 정보 출력
        List<PickedProduct> products = basket.getProducts();
        for (PickedProduct product : products) {
            System.out.println("상품명: " + product.getItemName() + ", 수량: " + product.getQuantity() + ", 가격: " + product.getPrice());
        }

        // 장바구니 총액 계산 및 출력
        int totalAmount = 0;
        for (PickedProduct product : products) {
            totalAmount += product.getPrice() * product.getQuantity();
        }
        System.out.println("장바구니 총 금액: " + totalAmount + "원");
        System.out.println("================================\n");
    }


    // 상품을 선택하고 장바구니에 추가하는 메서드
    private void selectProductsForCurrentUser() {
        ShoppingBasket shoppingBasket = generateShoppingBasket(currentUser.getUid());
        setCurrentSBasket(shoppingBasket);

        // 장바구니에 추가 addRandomProductToBasket 호출
        addRandomProductToBasket(2);
        addRandomProductToBasket(3);
        addRandomProductToBasket(4);
    }

    /**
     * 지정된 수량만큼 무작위 상품을 현재 장바구니에 추가합니다.<br>
     * 캡슐화 원칙을 적용하여 장바구니에 상품을 추가하는 프로세스를 추상화 하며, {@link #pickupItem(ProductList)}
     * 메서드를 사용하여 {@link ProductList}에서 무작위 상품을 선택합니다.
     *
     * @param quantity 추가할 상품의 수량. 이 값에 따라 장바구니에 추가될 상품의 개수가 결정됨
     */
    private void addRandomProductToBasket(int quantity) {
        iProduct product = pickupItem(productList);
        PickedProduct pickedProduct = new PickedProduct(product.getPid(), product.getMaker(), product.getPrice(), quantity);
        currentSBasket.addProduct(pickedProduct);
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
     * @param uid 사용자 ID
     * @return 생성된 장바구니
     */
    public ShoppingBasket generateShoppingBasket(String uid) {
        ShoppingBasket mySb = new ShoppingBasket(uid);

        //장바구니 등록
        setSbs(mySb);
        return mySb;
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

    // 메인 함수
    public static void main(String[] args) {
        MyShop myshop = new MyShop();
        myshop.setup();
        myshop.run();   // 다른 객체를 테스트하기 위한 메소드  사용자 인터페이스가 없음
        //	myshop.CLIrun(); // CLI 인터페이스
        //	myshop.GUIrun(); // GUI 인터페이스
    }
}