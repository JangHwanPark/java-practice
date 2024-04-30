package SwingLayout;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarEntry;

public class Exam01 extends JFrame {
    public Exam01() {
        this.setTitle("BorderLayout");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createLayout();
        this.setVisible(true);  // 윈도우 출력 여부
    }

    public void createLayout() {
        // 컨텐트 팬 생성
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        createButtonComponent(c);
    }

    public void createButtonComponent(Container c) {
        // North 버튼 배치를 위한 판넬
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        JButton[] northButton = new JButton[7];
        for (int i = 0; i < northButton.length; i++) {
            northButton[i] = new JButton("버튼" + (i + 1));
            northPanel.add(northButton[i]);
        }
        northPanel.setBackground(Color.CYAN);
        c.add(northPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new Exam01();
    }
}