import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

// 컴파일 환경에서 찾기
public class JLabelExam01 extends JFrame {
    public JLabelExam01() {
        setTitle("JLabel 예제");
        setSize(500, 600);

        Container container = getContentPane();
        container.setLayout(new FlowLayout(20, 20, 20));

        // 키 이벤트 설정
        container.requestFocus();
        container.setFocusable(true);

        // 컴포넌트 추가
        ImageIcon beauty = new ImageIcon("ch07/src/assets/beauty.jpg");
        ImageIcon normallcon = new ImageIcon("ch07/src/assets/normalIcon.gif");

        JLabel textLabel1 = new JLabel("테스트 문자열");
        JLabel imageLabel1 = new JLabel(beauty);
        JLabel imageLabel2 = new JLabel("보고 싶으면 전화하세요", normallcon, SwingConstants.CENTER);

        JButton button = new JButton("버튼", normallcon);
        JButton button2 = new JButton("버튼2", normallcon);
        button.setPressedIcon(beauty);
        button2.setPressedIcon(normallcon);
        button2.setRolloverIcon(normallcon);

        // 이벤트 리스너
        textLabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("마우스 클릭");
                imageLabel2.setText("전화 ㄴㄴ");
            }
        });

        imageLabel1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("키보드 입력");
                textLabel1.setText("imageLabel1 키보드 입력");
            }
        });

        imageLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("마우스 클릭");
                textLabel1.setText("imageLabel2 클릭했음");
            }
        });

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("버튼 클릭");
            }
        });

        container.add(textLabel1);
        container.add(imageLabel1);
        container.add(imageLabel2);
        container.add(button);
        container.add(button2);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JLabelExam01();
    }
}