package src.Utils;
import java.util.Scanner;

public class ScannerUtil {
    private static final Scanner scanner = new Scanner(System.in);

    // 문자열 입력 유틸 함수
    public static String getStringScanner(String text) {
        CLIColor.printColor(text, "white");
        return scanner.nextLine();
    }

    // 정수 입력 유틸 함수
    public static int getIntegerScanner(String text) {
        CLIColor.printColor(text, "white");

        // 입력값이 정수가 아니면 오류메세지 출력
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("숫자만 입력할 수 있습니다.");
            CLIColor.printColor(text, "white");
        }
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }
}