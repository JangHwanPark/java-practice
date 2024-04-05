package src.Shopping;
import src.Product.*;
import java.util.Vector;

/**
 * {@link MyShop} - 인스턴스를 생성하고 생성된 인스턴스를 출력합니다. (CLI, GUI - 미구현)<br>
 * */
public class MyShop {
    private ProductList pl;
    private ShoppingBasket currentSBasket;
    private User currentUser;
    private final Vector<User> Users = new Vector<>();
    private final Vector<ShoppingBasket> Sbs = new Vector<>();

    // private  ProductList Pl;

    public ProductList getPl() {
        return pl;
    }

    public User getUsers(int id) {
        return Users.elementAt(id);
    }

    public ShoppingBasket getSbs(int id) {
        return Sbs.elementAt(id);
    }

    public ShoppingBasket getCurrentSBasket() {
        return currentSBasket;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setPl(ProductList pl) {
        this.pl = pl;
    }

    public void setUsers(User user) {
        this.Users.add(user);
    }

    public void setSbs(ShoppingBasket sbs) {
        this.Sbs.add(sbs);
    }

    public void setCurrentSBasket(ShoppingBasket currentSBasket) {
        this.currentSBasket = currentSBasket;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }


    public void run() {
        //사용자중 한명을 현재 사용자로선택
        User u = selectUser(0);
        setCurrentUser(u);

        //장바구시 생성
        ShoppingBasket mysb = generateShoppingBasket(getCurrentUser().getUid()); // 메소드를 이용한 간접접근

        //현재 장바구니로 설정
        setCurrentSBasket(mysb); //currentSBasket

        //상품선택 1
        iProduct pt = pickupitem(pl);
        //public PickedProduct(int productid,String itemname,int price, int quantity)
        PickedProduct PickedProduct = new PickedProduct(pt.getPid(), pt.getMaker(), pt.getPrice(), 2);
        getCurrentSBasket().addProduct(PickedProduct);

        //상품선택 2
        pt = pickupitem(pl);
        PickedProduct PickedProduct1 = new PickedProduct(pt.getPid(), pt.getMaker(), pt.getPrice(), 3);
        getCurrentSBasket().addProduct(PickedProduct1);

        //상품선택 3
        pt = pickupitem(pl);
        PickedProduct PickedProduct2 = new PickedProduct(pt.getPid(), pt.getMaker(), pt.getPrice(), 4);
        getCurrentSBasket().addProduct(PickedProduct2);

        System.out.println("---------- 쇼핑 리스트 -------------");
        getCurrentSBasket().showShoppingList();
        getCurrentSBasket().showAmount();
        getCurrentSBasket().pushBuyKey();
        getCurrentSBasket().showPayment();

        //두번째 사용자를 위한 장바구니 생성
        u = selectUser(1);
        setCurrentUser(u);

        mysb = generateShoppingBasket(getCurrentUser().getUid());

        //현재 장바구니로 설정
        setCurrentSBasket(mysb); //currentSBasket

        System.out.println("------- 상품 선택 ----------------");
        //상품선택 1
        pt = pickupitem(pl);
        //public PickedProduct(int productid,String itemname,int price, int quantity)
        PickedProduct = new PickedProduct(pt.getPid(), pt.getMaker(), pt.getPrice(), 10);
        getCurrentSBasket().addProduct(PickedProduct);

        //상품선택 2
        pt = pickupitem(pl);
        PickedProduct1 = new PickedProduct(pt.getPid(), pt.getMaker(), pt.getPrice(), 5);
        getCurrentSBasket().addProduct(PickedProduct1);

        //상품선택 3
        pt = pickupitem(pl);
        PickedProduct2 = new PickedProduct(pt.getPid(), pt.getMaker(), pt.getPrice(), 2);
        getCurrentSBasket().addProduct(PickedProduct2);

        //상품선택 3
        pt = pickupitem(pl);
        PickedProduct2 = new PickedProduct(pt.getPid(), pt.getMaker(), pt.getPrice(), 10);
        getCurrentSBasket().addProduct(PickedProduct2);

        System.out.println("---------- 쇼핑 리스트 -------------");
        getCurrentSBasket().showShoppingList();
        getCurrentSBasket().showAmount();
        getCurrentSBasket().pushBuyKey();
        getCurrentSBasket().showPayment();

        // 첫번째 사용자 장바구니 보기
        System.out.println("---------- 첫번째 사용자 쇼핑리스트 -------------");
        u = selectUser(0);
        setCurrentUser(u);

        Vector<ShoppingBasket> firstuserBasket = selectShoppingBasket(u.getUid());
        for (ShoppingBasket sb : firstuserBasket) {
            setCurrentSBasket(sb); //currentSBasket
            getCurrentSBasket().showShoppingList();
            getCurrentSBasket().showAmount();
            getCurrentSBasket().pushBuyKey();
            getCurrentSBasket().showPayment();
        }

        // 모든 사용자 장바구니 보기
        System.out.println("---------- 모든 사용자 쇼핑리스트 -------------");
    	// u = selectUser(1);
    	// setCurrentUser(u);

        for (ShoppingBasket sb : Sbs) {
            sb.showShoppingList();
            sb.showAmount();
            sb.pushBuyKey();
            sb.showPayment();
        }
    }

    public iProduct pickupitem(ProductList pl) {
        int id;
        int max = pl.getProductList().size();

        id = (int) (Math.random() * max);
        return pl.selectItems(id);
    }

    public void setup() {
        ProductList pl = new ProductList();
        setPl(pl);

        //상품생성 및 등록
        iProduct p = new KeyBoard("Samsung", 12000, 50);
        pl.addProduct(p);
        iProduct p1 = new Monitor("Lg", 200000, 40);
        pl.addProduct(p1);
        iProduct p2 = new MainBoard("Intel", 500000, 20);
        pl.addProduct(p2);
        iProduct p3 = new MainBoard("Cmd", 600000, 30);
        pl.addProduct(p3);
        pl.addProduct(new KeyBoard("신세계", 5000, 150));
        pl.addProduct(new Monitor("sk", 130000, 40));
        pl.addProduct(new Monitor("Ansan", 130000, 40));

        // 상품리스트 보기
        for (iProduct dispitem : pl.getProductList())
            dispitem.showitem();

        System.out.println("--------- 전체 상품리스트 보기 --------------");
        pl.showProductlist();

        System.out.println("--------- KEYBOARD 상품리스트 보기 --------------");
        ProductList pKeyboard = pl.getItems("KEYBOARD");
        pKeyboard.showProductlist();

        System.out.println("-------- MAINBOARD 상품리스트 보기 ---------------");
        ProductList pMainBoards = pl.getItems("MAINBOARD");
        pMainBoards.showProductlist();

        System.out.println("------- MONITOR 상품리스트 보기 ----------------");
        ProductList pMonitor = pl.getItems("MONITOR");
        pMonitor.showProductlist();

        //사용자 생성
        User u1 = new User("kim", "1234");
        User u2 = new User("Lee", "5678");
        User u3 = new User("박뇬성", "1111");

        // 쇼핑몰에 사용자 등록
        setUsers(u1);
        setUsers(u2);
        setUsers(u3);
    }

    // 장바구니
    public ShoppingBasket generateShoppingBasket(String uid) {
        ShoppingBasket mysb = new ShoppingBasket(uid);

        //장바구니 등록
        setSbs(mysb);
        return mysb;
    }

    // 유저 검색 (id)
    public User selectUser(int id) {
        User u = Users.elementAt(id);
        return u;
    }
    
    public User selectUser(String id) {
        for (User u : Users) {
            if (id.equals(u.getUid()))
                return u;
        }
        return null;
    }
    
    public Vector<ShoppingBasket> selectShoppingBasket(String uid) {
        Vector<ShoppingBasket> userBasket = new Vector<>();
        for (ShoppingBasket sb : Sbs) {
            if (uid.equals(sb.getUid())) {
                userBasket.add(sb);
            }
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

    // CLI Interface
    private void CLIrun() {
        System.out.println("-------------- shopping mall --------------------------");
        System.out.println("-------------- 사용자 선택 -------------------------------");
        System.out.println("-------------- 쇼핑 시작 또는 쇼핑이력 선택 --------------------");
        System.out.println("-------------- 제품 선택 ---------------------------------");
        System.out.println("-------------- 장바구니 선택 ------------------------------");
        System.out.println("-------------- 결제 또는 쇼핑계속 선택 ------------------------");
    }

    // GUI Interface
    private void GUIrun() {

    }
}