package src.Utils;
import java.util.Scanner;

public class ScannerUtil {
    private static Scanner scanner = new Scanner(System.in);

    // 문자열 입력 유틸 함수
    public static String getStringScanner(String input) {
        System.out.println("Test: " + input);
        return scanner.nextLine();
    }

    // 정수 입력 유틸 함수
    public static int getIntegerScanner(String input) {
        // Fixme: 프롬프트 출력문자 (파라미터로 받을 예정)
        System.out.println("test: " + input);

        // 입력값이 정수가 아니면 오류메세지 출력
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Test: " + input + " 은(는) 정수가 아님.");
            System.out.println(input);
        }
        return scanner.nextInt(); 
    }

    // Test
    /*public static void main(String[] args) {
        String n = ScannerUtil.getStringScanner("name: ");
        int i = ScannerUtil.getIntegerScanner("int: ");

        System.out.println("name: " + n + " i: " + i);
    }*/
}