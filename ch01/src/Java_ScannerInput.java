package src;

import java.util.Scanner;

class ScannerInput {

}

public class Java_ScannerInput {
    public static void main(String[] args) {
        // Scanner Input
        Scanner scanner = new Scanner(System.in);
        System.out.println("======== Scanner Input ========");
        System.out.println("이름을 입력하세요.");
        String scannerName = scanner.nextLine();

        System.out.println("나이를 입력하세요.");
        int scannerAge = scanner.nextInt();

        scanner.close();
        System.out.println("이름(name): " + scannerName);
        System.out.println("나이(age): " + scannerAge);
    }
}