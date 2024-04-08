package src.View;

import src.Service.ServiceUser;
import src.Shopping.MyShop;
import src.Shopping.PickedProduct;
import src.Shopping.ShoppingBasket;
import src.Utils.ScannerUtil;
import java.util.List;

// Note: CLI Interface
public class ViewCLI {
    private final MyShop myShop;
    private final ServiceUser currentUser;

    /**
     * 매개변수를 받는 생성자
     * @param myShop 상점 정보를 가지고있는 객체
     */
    public ViewCLI(MyShop myShop, ServiceUser currentUser) {
        this.myShop = myShop;
        this.currentUser = currentUser;
    }

    public void start() {
        // Test: 더미 데이터 설정 및 출력
        myShop.initProducts();
        myShop.getProductList().showProductList(); // MyShop.class <- ProductList.class
        System.out.println("\n" +
                "initUsers, initProducts 메서드가 호출되었습니다.\n" +
                "테스트 데이터 설정이 완료되었습니다.");

        // Debuglog
        System.out.println("더미 데이터 사용자 정보: " + currentUser.getUser(0));
        System.out.println("더미 데이터 사용자 정보: " + currentUser.getCurrentUser());

        boolean isRunning = true;
        while (isRunning) { // Main Menu
        System.out.println("\n┌----------------------------------------┐");
        System.out.println("│\t\t\t [안산대학교 쇼핑몰]\t\t\t │");
        System.out.println("└----------------------------------------┘");
            System.out.println("아래 메뉴를 선택해주세요.");
            System.out.println("=".repeat(32));
            System.out.println("""
                    0. 로그인 | 회원가입
                    1. 상품 선택
                    2. 상품 추가
                    3. 상품 조회
                    4. 상품 삭제
                    5. 상품 수정
                    6. 장바구니
                    7. 종료""");
            System.out.println("=".repeat(32));
            System.out.print("Admin: ");

            // Todo: 사용자 등록 및 검색
            switch (ScannerUtil.getIntegerScanner("메뉴 선택 > ")) {
                case 0:
                    showShinInOrRegister();       // 0 - 로그인 회원가입 선택
                    break;
                case 1:
                    showAddProductUserBasket();   // 1 - 사용자 장바구니에 상품 추가
                    break;
                case 2:
                    showFindProducts();     // 2 - 새로운 상품 등록
                    break;
                case 3:
                    showAddProducts();      // 3 - 상품 조회
                    break;
                case 4:
                    showDeletedProducts();  // 4 - 상품 삭제
                    break;
                case 5:
                    showChangeProducts();   // 5 - 상품 정보 수정
                    break;
                case 6:
                    String uid = inputForValidUserID(); // 6 - 상품 정보 수정
                    showUserShoppingBaskets(uid);
                    break;
                case 7:
                    isRunning = false;
                    System.out.println("이용해 주셔서 감사합니다.");
                    break;
                default:
                    System.out.println("잘못된 옵션입니다. 다시 시도해 주세요.");
            }
        }
    }

    public void showShinInOrRegister() {
        System.out.println("""
                1. 로그인
                2. 회원가입
                """);
        // System.out.print("User: ");
        int isRunning = ScannerUtil.getIntegerScanner("메뉴 선택 > ");
        switch (isRunning) {
            case 1:
                showSingIn(); // 로그인
                break;
            case 2:
                showRegister(); // 회원가입
                break;
            default:
                System.out.println("잘못된 옵션입니다. 다시 시도해 주세요.");
        }
    }

    public void showSingIn() { // 0.1 - 로그인
        System.out.println("=============== 로그인 =================");
        String uid = ScannerUtil.getStringScanner("아이디: "); // 아이디 입력
        String password = ScannerUtil.getStringScanner("비밀번호: "); // 비밀번호 입력

        boolean loginSuccess = currentUser.signInUser(uid, password);
        if (loginSuccess) System.out.print(uid + "님이 로그인하셨습니다.");
        else System.out.println("Error: 아이디 또는 비밀번호가 잘못되었습니다.");
    }
    
    public void showRegister() { // 0.2 - 회원가입
        System.out.println("=============== 회원가입 =================");
        String uid = ScannerUtil.getStringScanner("아이디: "); // 아이디 입력
        String password = ScannerUtil.getStringScanner("비밀번호: "); // 비밀번호 입력

        // ServiceUser의 createUser 메서드를 호출하여 회원가입 시도
        boolean registrationSuccess = currentUser.createUser(uid, password);
        if (registrationSuccess) System.out.println("회원가입이 완료되었습니다.");
        else System.out.println("회원가입에 실패했습니다.");
    }

    public String inputForValidUserID() {   // 사용자 아이디 유효성 검사
        String uid;

        while (true) {
            uid = ScannerUtil.getStringScanner("아이디: ");
            System.out.println("\nDebuglog 입력값: " + uid);  // Debuglog

            if (currentUser.findUserById(uid) != null) {
                System.out.println("Debuglog 조건 참: " + uid); // Debuglog
                return uid;
            } else {
                System.out.println("존재하지 않는 사용자 입니다.");
            }
        }
    }

    public void showAddProductUserBasket() {  // 1 - 사용자 장바구니에 상품 추가
        String userId = inputForValidUserID();
        int numOfProduct = ScannerUtil.getIntegerScanner("장바구니에 추가할 상품의 개수를 입력하세요: ");
        int[] productIds = new int[numOfProduct];
        int[] quantities = new int[numOfProduct];

        for (int i = 0; i < numOfProduct; i++) {
            productIds[i] = ScannerUtil.getIntegerScanner((i + 1) + " 번째 상품 ID를 입력하세요: "); // 상품 종류
            quantities[i] = ScannerUtil.getIntegerScanner((i + 1) + " 번째 상품 수량을 입력하세요: "); // 상품 개수
        }

        myShop.createShoppingBasketForUser(userId, productIds, quantities);
        System.out.println("\n상품이 \"" + userId + "\" 님의 장바구니에 추가되었습니다.");
    }

    public void showAddProducts() { // 2 - 새로운 상품 등록
        System.out.println("----------------[ 상품 등록 ]---------------");
        String category = ScannerUtil.getStringScanner("카테고리: ");
        String name = ScannerUtil.getStringScanner("상품명: ");
        int price = ScannerUtil.getIntegerScanner("가격: ");
        int quantity = ScannerUtil.getIntegerScanner("재고: ");
        
        // 상품 추가 및 추가한 상품 출력
        myShop.addProducts(category, name, price, quantity);
        System.out.println(name + " 상품이 추가되었습니다.");
    }

    public void showFindProducts() { // 3 - 상품 조회
        System.out.println("------------------------------------------");
        System.out.print("조회할 상품 ID : ");
    }

    public void showDeletedProducts() { // Fixme: 4 - 상품 삭제
        System.out.println("------------------------------------------");
        System.out.print("삭제할 상품 ID : ");
    }

    public void showChangeProducts() {    // Fixme: 6 - 상품 정보 수정
        System.out.println("------------[ 상품 정보 수정 ]-----------");
        System.out.print("상품명: ");
        System.out.print("가격: ");
        System.out.print("재고: ");
        System.out.print("상품설명: ");
    }

    /** @param uid 사용자의 고유 ID */
    public void showUserShoppingBaskets(String uid) {   // 5 - 사용자 장바구니
        List<ShoppingBasket> uBaskets = myShop.findShoppingBasket(uid);

        System.out.println("\n======== " + uid + "의 장바구니 ========");
        for (ShoppingBasket basket : uBaskets) {
            showShoppingBasket(basket);
        }
    }

    /**
     * 장바구니 객체의 상세 정보를 화면에 표시합니다. 이 메서드는 장바구니에 담긴 각 상품의 정보(상품명, 수량, 가격 등)와, 장바구니의 총 금액을 사용자에게 보여줍니다.
     *
     * @param basket 표시할 장바구니 객체로 {@link ShoppingBasket} 타입이어야 합니다.
     */
    public void showShoppingBasket(ShoppingBasket basket) {
        System.out.println("사용자 아이디: " + basket.getUserid());

        // 장바구니에 담긴 각 상품 정보 출력
        for (PickedProduct product : basket.getProducts()) {
            System.out.println(product);
        }

        // 장바구니 총액 계산 및 출력
        int totalAmount = basket.showAmount();
        System.out.println("총 결제 금액: " + totalAmount + "원");
    }
}