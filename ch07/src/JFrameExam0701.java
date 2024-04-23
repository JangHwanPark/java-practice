import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameExam0701 extends JFrame {
    // 생성자
    public JFrameExam0701() {
        super("JComponent 상속 예제");

        // 컨텐트팬 생성 및 팬 레이아웃 설정
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        // 버튼 생성
        JButton b1 = new JButton("버튼1");
        JButton b2 = new JButton("버튼2");
        JButton b3 = new JButton("버튼3");
        JButton b4 = new JButton("버튼3");

        b1.setBackground(Color.YELLOW);
        b1.setForeground(Color.blue);
        b1.setFont(new Font("Arial", Font.ITALIC, 30));

        b2.addActionListener(actionEvent -> {
            if (b2.isEnabled()) {
                System.out.println("버튼 2 클릭: " + b2.isEnabled());
            }
            b2.setEnabled(false);
        });

        b3.addActionListener(actionEvent -> {
            System.out.println("버튼3 클릭");
            JButton btn = (JButton) actionEvent.getSource();
            JFrameExam0701 frame = (JFrameExam0701) btn.getTopLevelAncestor();
            frame.setTitle(btn.getX() + " " + btn.getY());
            b2.setEnabled(true);
        });

        b4.addActionListener(actionEvent -> {

        });

        // 컨텐트 팬에 버튼 추가
        container.add(b1);
        container.add(b2);
        container.add(b3);

        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) {
        new JFrameExam0701();
    }
}