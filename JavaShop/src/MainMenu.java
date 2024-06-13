package src;

import java.util.Scanner;

public class MainMenu {
    public MainMenu() {
        Scanner scanner = new Scanner(System.in);
        cliDisplay(scanner);
    }

    public void cliDisplay(Scanner scanner) {
        while (true) {
            System.out.println("Welcome to JavaShopping!");
            System.out.println("1. 사용자 등록");
            System.out.println("2. 로그인");
            System.out.println("3. 상품 주문");
            System.out.println("4. 주문내역 확인");
            System.out.println("5. 종료");
            System.out.print("user >> ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("사용자 등록");
                    break;
                case 2:
                    System.out.println("로그인");
                    break;
                case 3:
                    System.out.println("상품 주문");
                    break;
                case 4:
                    System.out.println("주문내역 확인");
                    break;
                case 5:
                    System.out.println("프로그램이 종료됩니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}