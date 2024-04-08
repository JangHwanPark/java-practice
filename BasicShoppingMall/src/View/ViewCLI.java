package src.View;

import src.Service.ServiceProducts;
import src.Service.ServiceShoppingBasket;
import src.Service.ServiceUser;
import src.Shopping.MyShop;
import src.Shopping.PickedProduct;
import src.Shopping.ShoppingBasket;
import src.Shopping.User;
import src.Utils.CLIColor;
import src.Utils.ScannerUtil;

import java.util.List;

// Note: CLI Interface
public class ViewCLI {
    private MyShop myShop;
    private ServiceProducts serviceProducts;
    private ServiceUser serviceUser;
    private ServiceShoppingBasket serviceShoppingBasket;
    private String sessionId = null; // 사용자 아이디 저장

    public ViewCLI() { // MyShop 인스턴스를 직접 생성
        this.serviceProducts = new ServiceProducts();
        this.serviceUser = new ServiceUser();
        this.serviceShoppingBasket = new ServiceShoppingBasket(this.serviceProducts); // ServiceShoppingBasket이 ServiceProducts에 의존

        // 생성된 서비스 인스턴스들을 이용해 MyShop 인스턴스 생성
        this.myShop = new MyShop(serviceProducts, serviceUser, serviceShoppingBasket);
    }

    public void start() {
        // Test: 더미 데이터 설정 및 출력
        serviceProducts.initDefaultProducts();
        serviceProducts.showProductList(); // MyShop.class <- ProductList.class
        CLIColor.printColorln("""
                initUsers, initProducts 메서드가 호출되었습니다.
                테스트 데이터 설정이 완료되었습니다.
                """, "red");
        System.out.println("더미 데이터 사용자 정보: " + serviceUser.getUser(0));

        boolean isRunning = true;
        while (isRunning) { // Main Menu
            CLIColor.printColorln("\n┌----------------------------------------┐", "blue");
            CLIColor.printColorln("│\t\t\t [안산대학교 쇼핑몰]\t\t\t │", "blue");
            CLIColor.printColorln("└----------------------------------------┘", "blue");

            // 세션이 존재한다면 이름 출력
            if (sessionId != null) {
                User user = serviceUser.findUserById(sessionId);
                if (user != null) {
                    CLIColor.printColorln("\t\t\t\t" + user.getUserId() + "님 안녕하세요.", "red");
                }
            }

            System.out.println("\t\t\t 메뉴를 선택 하세요.");
            CLIColor.printColorln("=".repeat(42), "blue");
            CLIColor.printColorln("""
                    1. 로그인 | 회원가입
                    2. 상품 구매
                    3. 상품 관리
                    4. 장바구니
                    5. 종료""", "purple");
            CLIColor.printColorln("=".repeat(42), "blue");

            // Todo: 사용자 등록 및 검색
            switch (ScannerUtil.getIntegerScanner("메뉴 선택: ")) {
                case 1:
                    showShinInOrRegister();       // 로그인 회원가입 선택
                    break;
                case 2:
                    showAddProductUserBasket();   // 사용자 장바구니에 상품 추가
                    break;
                case 3:
                    showProductsView();     // 상품 관리(추가, 조회, 삭제, 수정)
                    break;
                case 4:
                    showUserShoppingBaskets(sessionId); // 장바구니 조회
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("이용해 주셔서 감사합니다.");
                    break;
                default:
                    CLIColor.printColorln("잘못된 옵션입니다. 다시 입력해 주세요.", "red");
            }
        }
    }

    // Note: User View
    public void showShinInOrRegister() {
        CLIColor.printColorln("""
                1. 로그인
                2. 회원가입
                3. 메인메뉴
                """, "purple");
        switch (ScannerUtil.getIntegerScanner("메뉴 선택: ")) {
            case 1:
                showSingIn(); // 로그인
                break;
            case 2:
                showRegister(); // 회원가입
                break;
            case 3:
                break;
            default:
                CLIColor.printColorln("잘못된 옵션입니다. 다시 입력해 주세요.", "red");
        }
    }

    public void showSingIn() { //  로그인
        CLIColor.printColorln("=============== 로그인 =================", "blue");
        String uid = ScannerUtil.getStringScanner("아이디: "); // 아이디 입력
        String password = ScannerUtil.getStringScanner("비밀번호: "); // 비밀번호 입력

        boolean loginSuccess = serviceUser.signInUser(uid, password);
        if (loginSuccess) {
            sessionId = uid;
            CLIColor.printColorln(uid + "님이 로그인하셨습니다.", "yellow");
        } else CLIColor.printColorln("System: 아이디 또는 비밀번호가 잘못되었습니다.", "red");
    }

    public void showRegister() { // 0.2 - 회원가입
        System.out.println("=============== 회원가입 =================");
        String uid = ScannerUtil.getStringScanner("아이디: "); // 아이디 입력
        String password = ScannerUtil.getStringScanner("비밀번호: "); // 비밀번호 입력

        // ServiceUser의 createUser 메서드를 호출하여 회원가입 시도
        boolean registrationSuccess = serviceUser.createUser(uid, password);
        if (registrationSuccess) System.out.println("회원가입이 완료되었습니다.");
        else CLIColor.printColorln("System: 회원가입에 실패했습니다.", "red");
    }

    public String showInputForValidUserID() {   // 사용자 아이디 유효성 검사
        String uid;
        while (true) {
            uid = ScannerUtil.getStringScanner("아이디: ");
            if (serviceUser.isValidUserID(uid)) return uid;
            else CLIColor.printColorln("System: 사용자가 존재하지 않습니다.", "red");
        }
    }

    // Note: Product View
    public void showProductsView() {
        CLIColor.printColorln("""
                1. 신규 상품 등록
                2. 상품 검색
                3. 상품 삭제
                4. 상품 정보 수정
                5. 메인메뉴 이동
                """, "purple");
        switch (ScannerUtil.getIntegerScanner("메뉴 선택: ")) {
            case 1:
                showAddProducts();      // 신규 상품 등록
                break;
            case 2:
                showFindProducts();      // 상품 검색
                break;
            case 3:
                showDeletedProducts();  // 상품 삭제
                break;
            case 4:
                showChangeProducts();   // 상품 정보 수정
                break;
            case 5:
                break;
            default:
                CLIColor.printColorln("잘못된 옵션입니다. 다시 입력해 주세요.", "red");
        }
    }

    public void showAddProductUserBasket() {  // 사용자 장바구니에 상품 추가
        String userId = showInputForValidUserID();
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

    public void showAddProducts() { // 새로운 상품 등록
        CLIColor.printColorln("----------------[ 상품 등록 ]---------------", "blue");
        String category = ScannerUtil.getStringScanner("카테고리: ");
        String name = ScannerUtil.getStringScanner("상품명: ");
        int price = ScannerUtil.getIntegerScanner("가격: ");
        int quantity = ScannerUtil.getIntegerScanner("재고: ");

        // 상품 추가 및 추가한 상품 출력
        serviceProducts.addProducts(category, name, price, quantity);
        System.out.println(name + " 상품이 추가되었습니다.");
    }

    public void showFindProducts() { // 상품 조회
        CLIColor.printColorln("----------------[ 상품 조회 ]---------------", "blue");
        int productId = ScannerUtil.getIntegerScanner("조회할 상품 ID : ");
        System.out.println(serviceProducts.findItems(productId));
    }

    public void showDeletedProducts() { // Fixme: 상품 삭제
        CLIColor.printColorln("----------------[ 상품 삭제 ]---------------", "blue");
        System.out.print("삭제할 상품 ID : ");
    }

    public void showChangeProducts() {    // Fixme: 상품 정보 수정
        CLIColor.printColorln("------------[ 상품 정보 수정 ]-----------", "blue");
        System.out.print("상품명: ");
        System.out.print("가격: ");
        System.out.print("재고: ");
        System.out.print("상품설명: ");
    }

    // Note: ShoppingBasket View

    /**
     * @param sessionId 로그인한 사용자의 고유 ID
     */
    public void showUserShoppingBaskets(String sessionId) {
        List<ShoppingBasket> uBaskets = myShop.findShoppingBasket(sessionId);
        CLIColor.printColorln("\n============ [ " + sessionId + "의 장바구니 ] ============", "blue");
        for (ShoppingBasket basket : uBaskets) showShoppingBasket(basket);
    }

    /**
     * 장바구니 객체의 상세 정보를 화면에 표시합니다. 이 메서드는 장바구니에 담긴 각 상품의 정보(상품명, 수량, 가격 등)와, 장바구니의 총 금액을 사용자에게 보여줍니다.
     *
     * @param basket 표시할 장바구니 객체로 {@link ShoppingBasket} 타입이어야 합니다.
     */
    public void showShoppingBasket(ShoppingBasket basket) {
        CLIColor.printColorln("사용자 아이디: " + basket.getUserid(), "yellow");

        // 장바구니에 담긴 각 상품 정보 출력
        for (PickedProduct product : basket.getProducts()) {
            System.out.println(product);
        }

        // 장바구니 총액 계산 및 출력
        int totalAmount = basket.showAmount();
        System.out.println("총 결제 금액: " + totalAmount + "원");
    }

    public static void main(String[] args) {
        ViewCLI viewCLI = new ViewCLI();
        viewCLI.start(); // CLI 애플리케이션 시작
    }
}