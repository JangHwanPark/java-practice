package src.Views;
import java.util.Scanner;

// CLI Interface
public class CLIrun {
    private Scanner scanner;

    public CLIrun() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean isRunning = true;

        System.out.println("-------------- shopping mall --------------------------");
        while (isRunning) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. 사용자 선택");
            System.out.println("2. 쇼핑 시작 또는 쇼핑이력 선택");
            System.out.println("3. 제품 선택");
            System.out.println("4. 장바구니 선택");
            System.out.println("5. 결제 또는 쇼핑계속 선택");
            System.out.println("6. 종료");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    selectUser();
                    break;
                case 2:
                    startOrViewShoppingHistory();
                    break;
                case 3:
                    selectProduct();
                    break;
                case 4:
                    selectShoppingBasket();
                    break;
                case 5:
                    continueOrPay();
                    break;
                case 6:
                    isRunning = false;
                    System.out.println("Exiting shopping mall...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private void selectUser() {
        // 사용자 선택 로직 구현
        System.out.println("User selection not implemented yet.");
    }

    private void startOrViewShoppingHistory() {
        // 쇼핑 시작 또는 이력 선택 로직 구현
        System.out.println("Shopping start/history selection not implemented yet.");
    }

    private void selectProduct() {
        // 제품 선택 로직 구현
        System.out.println("Product selection not implemented yet.");
    }

    private void selectShoppingBasket() {
        // 장바구니 선택 로직 구현
        System.out.println("Shopping basket selection not implemented yet.");
    }

    private void continueOrPay() {
        // 결제 또는 쇼핑 계속 선택 로직 구현
        System.out.println("Continue shopping or pay not implemented yet.");
    }

    public static void main(String[] args) {
        CLIrun cli = new CLIrun();
        cli.start(); // CLI 애플리케이션 시작
    }
}