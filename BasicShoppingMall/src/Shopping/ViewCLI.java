package src.Shopping;

import java.util.List;
import java.util.Scanner;

// CLI Interface
// Todo : 중복 로직(메서드) 삭제 예정
public class ViewCLI {
    private final Scanner scanner;
    private final MyShop myShop;

    public ViewCLI(MyShop myShop) {
        this.scanner = new Scanner(System.in);
        this.myShop = myShop;
    }

    public void start() {
        // 초기 데이터 설정 (더미데이터)
        myShop.setup();
        System.out.println("setup() 메서드가 호출되었습니다.");
        System.out.println("데이터 설정이 완료되었습니다.");
        boolean isRunning = true;

        while (isRunning) {
        System.out.println("\n========== Ansan Mall ==========");
            System.out.println("아래 메뉴를 선택해주세요.");
            System.out.println("=".repeat(32));
            System.out.println("1. 새 장바구니 설정");
            System.out.println("2. 장바구니 조회");
            System.out.println("3. 모든 사용자의 장바구니 조회");
            System.out.println("4. 종료");
            System.out.println("=".repeat(32));
            System.out.print("User: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showInitUserBasket();
                    break;
                case 2:
                    // Todo: 값을 하나만 받고있어서 case3 하나만 출력됨
                    showUserShoppingBaskets("kim");
                    break;
                case 3:
                    System.out.println("모든 사용자 쇼핑리스트.");
                    showAllShoppingBaskets();
                    break;
                case 4:
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
        // String uid = scanner.next(); // 사용자 ID 입력 받음
        String uid = "kim"; // tc
        int[] quantities = {1, 2, 1}; // tc
        myShop.setupShoppingBasketForUser(uid, quantities);
        System.out.println("\n" + uid + " 님의 장바구니가 설정되었습니다.");

        // 임시값
        //showShoppingBasket(newBasket); // 설정된 장바구니의 상세 내용을 출력
    }

    /**
     * case 2<br>
     * 사용자 ID에 매핑된 장바구니 정보를 조회하고, 해당 장바구니들에 포함된 상품들의 상세 정보 및 총 금액을
     * 사용자 인터페이스를 통해 표시합니다. 이 과정에서 {@code MyShop} 객체의 인터페이스를 통해
     * 상품 정보의 읽기 접근을 추상화합니다. 또한, 사용자에게 데이터를 보여주는 방법에 대한 세부 구현을 캡슐화하고, {@link MyShop}에서 데이터를 가져오는 로직과 UI 로직을 분리 합니다.
     *
     * @param uid 사용자의 고유 ID
     */
    public void showUserShoppingBaskets(String uid) {
        List<ShoppingBasket> uBaskets = myShop.getShoppingBasketsForUser(uid);
        System.out.println("\n========== " + uid + "의 쇼핑리스트 ==========");
        for (ShoppingBasket basket : uBaskets) {
            showShoppingBasket(basket);
        }
    }

    /**
     * case 3<br>
     * 등록된 모든 장바구니 정보를 순회하며, {@link MyShop}클래스의 getAllShoppingBaskets 메서드를 호출하여 모든 사용자 장바구니의 상세 내용을 출력합니다.
     */
    public void showAllShoppingBaskets() {
        System.out.println("\n========== 모든 사용자 쇼핑리스트 ==========");
        for (ShoppingBasket basket : myShop.getAllShoppingBaskets()) {
            showShoppingBasket(basket);
        }
    }

    /**
     * 장바구니 객체의 상세 정보를 화면에 표시합니다. 이 메서드는 장바구니에 담긴 각 상품의 정보(상품명, 수량, 가격 등)와, 장바구니의 총 금액을 사용자에게 보여줍니다.
     *
     * @param basket 표시할 장바구니 객체로 {@link ShoppingBasket} 타입이어야 합니다.
     */
    private void showShoppingBasket(ShoppingBasket basket) {
        System.out.println("장바구니 ID: " + basket.getUid());
        System.out.println("================================");

        // 장바구니에 담긴 각 상품 정보 출력
        List<PickedProduct> products = basket.getProducts();
        for (PickedProduct product : products) {
            System.out.println("상품명: " + product.getItemName() + ", 수량: " + product.getQuantity() + ", 가격: " + product.getPrice());
        }

        // 장바구니 총액 계산 및 출력
        int totalAmount = basket.showAmount();
        System.out.println("========== 총 결제 금액 ==========");
        System.out.println("장바구니 총 금액: " + totalAmount + "원");
        System.out.println("================================\n");
    }
}