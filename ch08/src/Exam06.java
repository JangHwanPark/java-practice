import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NewDialog extends JDialog {
    private JTextField tf = new JTextField(10);
    private JButton okBtn = new JButton("확인");

    // 생성자 (this 영역)
    public NewDialog(JFrame frame, String title) {
        // 모달 다이얼 로그 출력
        super(frame, title, true);
        setLayout(new FlowLayout());
        add(tf);
        add(okBtn);
        setSize(200, 100);
        setVisible(false);

        // btn 액션 리스너 (대화 상자 사라지게 하기)
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(actionEvent);
                setVisible(false);
            }
        });
    }

    public String getInput() {
        if(tf.getText().isEmpty()) return null;
        else return tf.getText();

    }
}

public class Exam06 extends JFrame {
    private NewDialog dialog;
    public Exam06() {
        super("대화상자 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btn = new JButton("대화상자 열기");

        // this = NewDialog
        dialog = new NewDialog(this, "대화상자");

        // btn 액션 리스너 (팝업 출력)
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dialog.setVisible(true);

                // getInput 함수 호출 (프로세스는 메모리 내부에 살아있음 그래서 함수가 동작하는거임)
                String text = dialog.getInput();
                JButton btn = new JButton(text);
                if (text != null) btn.setText(text);
            }
        });

        getContentPane().add(btn);
        setSize(250, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Exam06();
    }
}