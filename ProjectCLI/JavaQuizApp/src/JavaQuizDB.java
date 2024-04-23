import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class JavaQuizDB {
    public static void main(String[] args) {
        HashMap<Integer, String> quiz = new HashMap<Integer, String>();
        // 해시맵에 값 추가 put(키, 값)
        quiz.put(1, "add HashMap");
        quiz.put(2, "add HashMap2");
        quiz.put(3, "add HashMap3");
        System.out.println(quiz);

        // 해시맵 접근 get(키)
        System.out.println(quiz.get(1));

        // 해시맵 제거 remove(키)
        quiz.remove(1);
        System.out.println(quiz);

        // 모든 요소 제거 clear();
        quiz.clear();

        try {
            // File 클래스의 객체 생성 (quizDB = data/QuizDB.txt)
            File quizDBTest = new File("JavaQuizApp/src/data/QuizDB.txt");
            FileWriter insertQuiz = new FileWriter("JavaQuizApp/src/data/QuizDB.txt");
            Scanner scanner = new Scanner(quizDBTest);

            insertQuiz.write("insert");
            insertQuiz.close();

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println("data : " + data);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException : 오류가 발생했습니다.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("RuntimeException : 오류가 발생했습니다.");
            throw new RuntimeException(e);
        }
    }
}