package Frame;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
// 타입 동일 - 왼쪽 오른쪽 (부모 또는 동일), 코드 확장 연습

public class ExamFrame01 extends JFrame {
    // Global Val
    private boolean isPanelState;
    JPanel panel;
    Container contentPane;

    public ExamFrame01() {
        // 프레임 생성 (프레임 이름 : Create Frame)
        setTitle("Create Frame");

        // 컨텐트팬 추가 (Container <- ), 프레임 위에 판떼기
        // Container contentPane = getContentPane();
        contentPane = getContentPane();
        contentPane.setBackground(Color.ORANGE);
        contentPane.setLayout(new FlowLayout()); // 자동 반응형

        for (int i = 0; i < 3; i++) {
            contentPane.add(new Button("btn " + i));
        }

        setSize(500, 500); // 프레임 크기 (x * y)
        setVisible(true); // true : 출력, false : 미출력

        // 닫으면 프로그램이 종료됨 (메모리에서 제거)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExamFrame01 examFrame01 = new ExamFrame01();

        boolean isRun = true;
        System.out.print("입력: ");
        while(isRun) {
            int in = scanner.nextInt();
            System.out.print("입력: ");
            switch (in) {
                case 1:
                    //JPanel panel = new JPanel(); // 프레임 변경하기 ?
                    examFrame01.setContentPane(new JPanel());
                    break;
                case 2:
                    examFrame01.setContentPane(examFrame01.contentPane);
                    break;
                case 3:
                    examFrame01.setVisible(false);
                    System.out.println("종료");
                    isRun = false;
                    break;
                default:
                    System.out.println("다시 입력하세요.");
            }
        }
    }
}