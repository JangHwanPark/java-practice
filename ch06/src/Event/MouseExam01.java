package Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseExam01 extends JFrame {
    private JLabel label = new JLabel();

    public MouseExam01() {
        setTitle("마우스 이벤트 예제1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 컨테이너(컨텐트팬)에 마우스 이벤트 부착
        Container container = new Container();
        container.addMouseListener(new ActionMouseExam01());

        container.setLayout(null);
        label.setSize(50, 20);
        label.setLocation(30, 30);
        container.add(label);

        setSize(250, 250);
        setVisible(true);
    }

    // MouseAdapter : 추상 메서드(인터페이스)몸체를 미리 만들어 논거
    class ActionMouseExam01 extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            label.setLocation(x, y);
            System.out.println("x: " + x + " y: " + y);
        }
        /*public void mouseReleased(MouseEvent e) {};
        public void mouseClicked(MouseEvent e) {};
        public void mouseEntered(MouseEvent e) {};
        public void mouseExited(MouseEvent e) {};*/
    }
    public static void main(String[] args) {
        new MouseExam01();
    }
}