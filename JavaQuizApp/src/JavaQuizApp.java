public class JavaQuizApp implements QuizInterface {
    @Override
    public void startQuiz() {
        System.out.println("퀴즈를 시작합니다.");
    }

    @Override
    public void endQuiz() {
        System.out.println("퀴즈가 종료됩니다.");
    }

    @Override
    public void isNotKeyword() {
        System.out.println("명령어가 일치하지 않습니다.");
    }
}