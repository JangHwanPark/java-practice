package Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyExam01 extends JFrame {
    private JLabel[]  keyMessage;

    // 생성자
    public KeyExam01() {
        setTitle("키보드 이벤트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.addKeyListener(new ActionKeyExam01());

        keyMessage = new JLabel [3];
        keyMessage[0] = new JLabel(" getKeyCode() ");
        keyMessage[1] = new JLabel(" getKeyChar() ");
        keyMessage[2] = new JLabel(" getKeyText() ");

        for (int i = 0; i < keyMessage.length; i++) {
            c.add(keyMessage[i]);
            keyMessage[i].setOpaque(true);
            keyMessage[i].setBackground(Color.blue);
        }

        setSize(300, 150);
        setVisible(true);

        // 키입력 받을수 있도록
        c.setFocusable(true);
        c.requestFocus();
    }

    class ActionKeyExam01 extends KeyAdapter {
        public void keyPressed(KeyEvent e) {

            int keyCode = e.getKeyCode();
            char keyChar = e.getKeyChar();



            keyMessage[0].setText(Integer.toString(keyCode));
            keyMessage[1].setText(Character.toString(keyChar));
            keyMessage[2].setText(e.getKeyText(keyCode));
        }
    }

    public static void main(String[] args) {
        new KeyExam01();
    }
}