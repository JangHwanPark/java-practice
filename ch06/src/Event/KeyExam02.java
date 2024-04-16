package Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyExam02 extends JFrame {
    private JLabel la = new JLabel();

    // 생성자
    public KeyExam02() {
        setTitle("키보드 이벤트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.addKeyListener(new ActionKeyExam01());

        setSize(300, 150);
        setVisible(true);

        // 키입력 받을수 있도록
        c.setFocusable(true);
        c.requestFocus();
    }

    class ActionKeyExam01 extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            la.setText(KeyEvent.getKeyText(e.getKeyCode()));

            if (e.getKeyChar() == 'y') {
                createRootPane().setBackground(Color.YELLOW);
            } else if (e.getKeyCode() == KeyEvent.VK_F1) {
                createRootPane().setBackground(Color.GRAY);
            }
        }
    }

    public static void main(String[] args) {
        new KeyExam02();
    }
}