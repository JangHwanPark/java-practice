import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== Java Quiz App ==========");
        System.out.println("1. 퀴즈 시작");
        System.out.println("2. 종료");
        System.out.println("===================================");

        JavaQuizApp quiz = new JavaQuizApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    quiz.startQuiz();
                    break;
                case 2:
                    quiz.endQuiz();
                    scanner.close();
                    return;
                default:
                    quiz.isNotKeyword();
                    break;
            }
        }
    }
}