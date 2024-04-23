package JavaModifiers;
import java.util.Scanner;

// 유효성 검사
public class StaticEx_Validation {
    // 입력값 공백 검사
    public static boolean isNotEmpty(String inputValue) {
        return inputValue != null && !inputValue.isEmpty();
    }

    // 입력값 길이 검사
    public static boolean isValidLength(String inputValue, int min, int max) {
        return inputValue != null && inputValue.length() >= min && inputValue.length() <= max;
    }

    // 숫자인지 검사
    public static boolean isNumeric(String inputValue) {
        try {
            Double.parseDouble(inputValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    // 유효성 검사 테스트 코드
    public static void testValidation() {
        String testEmpty = "";
        String testNull = null;
        String testValidString = "Hello World";
        String testNumericString = "1234";
        String testNonNumericString = "Hello123";

        // 공백 검사 테스트
        System.out.println("공백 검사 테스트");
        System.out.println("빈 문자열: " + isNotEmpty(testEmpty));
        System.out.println("Null 문자열: " + isNotEmpty(testNull));
        System.out.println("유효한 문자열: " + isNotEmpty(testValidString));

        // 길이 검사 테스트
        System.out.println("\n길이 검사 테스트");
        System.out.println("길이가 5-20인 유효한 문자열: " + isValidLength(testValidString, 5, 20));
        System.out.println("길이가 1-5인 유효한 문자열: " + isValidLength(testValidString, 1, 5));

        // 숫자 검사 테스트
        System.out.println("\n숫자 검사 테스트");
        System.out.println("숫자 문자열: " + isNumeric(testNumericString));
        System.out.println("숫자가 아닌 문자열: " + isNumeric(testNonNumericString));
    }
    
    public static void main(String[] args) {
        // 사용자 입력 테스트
        Scanner scanner = new Scanner(System.in);
        String testcase;
        System.out.println("===== 사용자 입력 테스트 =====");
        System.out.print("유효성 검사: ");
        testcase = scanner.nextLine();
        System.out.println("입력값 공백 검사 결과: " + isNotEmpty(testcase));
        System.out.println("입력값 길이 검사 결과(min 8, max 32): " + isValidLength(testcase,8,32));
        System.out.println("숫자여부 검사 결과: " + isNumeric(testcase));

        // 유효성 검사 테스트 코드 실행
        System.out.println("\n===== 유효성 검사 테스트 코드 실행 =====");
        testValidation();
    }
}