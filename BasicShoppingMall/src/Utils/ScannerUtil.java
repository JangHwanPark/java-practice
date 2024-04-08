package src.Utils;
import java.util.Scanner;

public class ScannerUtil {
    private static final Scanner scanner = new Scanner(System.in);

    // 문자열 입력 유틸 함수
    public static String getStringScanner() {
        return scanner.nextLine();
    }

    // 정수 입력 유틸 함수
    public static int getIntegerScanner() {
        // 입력값이 정수가 아니면 오류메세지 출력
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt(); 
    }
}