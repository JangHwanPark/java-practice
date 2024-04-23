import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JCheckBoxExam01 extends JFrame {
    public JCheckBoxExam01() {
        super("CheckBox Example");
        setSize(500, 800);

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        // 컴포넌트 추가
        ImageIcon beauty = new ImageIcon("ch07/src/assets/beauty.jpg");
        ImageIcon normallcon = new ImageIcon("ch07/src/assets/normalIcon.gif");

        JCheckBox checkBox1 = new JCheckBox("버튼 활성화1");
        JCheckBox checkBox2 = new JCheckBox("버튼 활성화 true", true);
        JCheckBox checkBox3 = new JCheckBox("버튼 활성화 이미지" , beauty);

        checkBox3.setBorderPainted(true);
        checkBox3.setSelectedIcon(normallcon);

        JButton button = new JButton("버튼");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("마우스 클릭");
                checkBox1.setText("버튼 클릭했음");
            }
        });

        container.add(checkBox1);
        container.add(checkBox2);
        container.add(checkBox3);

        container.add(button);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JCheckBoxExam01();
    }
}