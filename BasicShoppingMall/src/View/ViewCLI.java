package src.View;

import src.Shopping.MyShop;
import src.Shopping.PickedProduct;
import src.Shopping.ShoppingBasket;
import src.Utils.ScannerUtil;
import java.util.List;

// Note: CLI Interface
// Todo : 중복 로직(메서드) 삭제 예정
public class ViewCLI {
    private final MyShop myShop;

    /**
     * 매개변수를 받는 생성자
     * @param myShop 상점 정보를 가지고있는 객체
     */
    public ViewCLI(MyShop myShop) {
        this.myShop = myShop;
    }

    public void start() {
        // 초기 데이터 설정 (더미데이터)
        myShop.setup();
        System.out.println("setup() 메서드가 호출되었습니다.\n" +
                "데이터 설정이 완료되었습니다.");

        boolean isRunning = true;
        while (isRunning) {
        System.out.println("\n========== Ansan Mall ==========");
            System.out.println("아래 메뉴를 선택해주세요.");
            System.out.println("=".repeat(32));
            System.out.println("1. 사용자 등록");
            System.out.println("2. 사용자 검색");
            System.out.println("3. 상품 추가 및 삭제");
            System.out.println("4. 상품 검색");
            System.out.println("5. 장바구니");
            System.out.println("6. 종료");
            System.out.println("=".repeat(32));
            System.out.print("User: ");

            // Todo: 사용자 등록 및 검색
            switch (ScannerUtil.getIntegerScanner()) {
                case 1:
                    showInitUserBasket();
                    break;
                case 2:
                    break;
                case 3:
                    showAddAndDeletedProducts();
                    break;
                case 4:
                    showFindProducts();
                    break;
                case 5:
                    // 장바구니 검색을 위한 사용자 아이디 입력 로직.
                    boolean isValidUid = false;
                    String uid = "";
                    while (!isValidUid) {
                        // Issue: 아이디 입력전 else 문으로 컨티뉴되는 문제 발생중 
                        System.out.print("아이디 입력: ");
                        uid = ScannerUtil.getStringScanner();
                        
                        // getCurrentUser 메소드가 User 타입이라 형변환 필요 없음
                        // 두개의 객체가 같은지 보는게 아닌 동등성을 보기위해 오버라이드 사용
                        // 메모리 주소가 다른 두개의 똑같은 객체
                        if (uid.equals(myShop.getCurrentUser().getUid())) {
                            isValidUid = true;
                        } else {
                            System.out.println("존재하지 않는 사용자 입니다.");
                        }
                    }
                    showUserShoppingBaskets(uid);
                    break;
                case 6:
                    isRunning = false;
                    System.out.println("이용해 주셔서 감사합니다.");
                    break;
                default:
                    System.out.println("잘못된 옵션입니다. 다시 시도해 주세요.");
            }
        }
    }

    // case1
    public void showInitUserBasket() {
        //System.out.print("사용자 ID 입력: ");
        //String uid = scanner.next(); // 사용자 ID 입력 받음
        // Test
        String userId = "kim";
        int[] productIds = {1, 2, 3};
        int[] quantities = {1, 2, 1};
        ShoppingBasket newBasket = myShop.createShoppingBasketForUser(userId, productIds, quantities);
        System.out.println("\n" + userId + " 님의 장바구니가 설정되었습니다.");

        // Test
        showShoppingBasket(newBasket); // 설정된 장바구니의 상세 내용을 출력
    }

    // Todo: 2. 상품 추가 및 삭제
    public void showAddAndDeletedProducts() {
        System.out.println("상품 추가 및 삭제");
    }

    // Todo: 3. 상품 검색
    public void showFindProducts() {
        System.out.println("상품 검색");
    }

    // case 4
    /**
     * 사용자 ID에 매핑된 장바구니 정보를 조회하고, 해당 장바구니들에 포함된 상품들의 상세 정보 및 총 금액을
     * 사용자 인터페이스를 통해 표시합니다. 이 과정에서 {@code MyShop} 객체의 인터페이스를 통해
     * 상품 정보의 읽기 접근을 추상화합니다. 또한, 사용자에게 데이터를 보여주는 방법에 대한 세부 구현을 캡슐화하고, {@link MyShop}에서 데이터를 가져오는 로직과 UI 로직을 분리 합니다.
     *
     * @param uid 사용자의 고유 ID
     */
    public void showUserShoppingBaskets(String uid) {
        List<ShoppingBasket> uBaskets = myShop.findShoppingBasket(uid);
        System.out.println("\n======== " + uid + "의 쇼핑리스트 ========");
        for (ShoppingBasket basket : uBaskets) {
            showShoppingBasket(basket);
        }
    }

    // case 6
    /**
     * 등록된 모든 장바구니 정보를 순회하며, {@link MyShop}클래스의 getAllShoppingBaskets 메서드를 호출하여 모든 사용자 장바구니의 상세 내용을 출력합니다.
     */
    public void showAllShoppingBasketsDetails() {
        System.out.println("\n======= 모든 사용자 쇼핑목록 =======");
        for (ShoppingBasket basket : myShop.getAllShoppingBaskets()) {
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