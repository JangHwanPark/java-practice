package LayoutExam;

import javax.swing.*;
import java.awt.*;

public class LayoutExam01 extends JFrame {
    JPanel panel;
    Container container;

    public LayoutExam01() { // LayoutExam01 생성자
        setTitle("스윙 레이아웃 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 컨텐트팬 생성 및 BorderLayout 적용 및 버튼 배치
        container = getContentPane();
        container.setLayout(new BorderLayout(50, 30));

        // 판 생성 후 FlowLayout 레이아웃 적용
        panel = new JPanel();
        panel.setLayout(new FlowLayout(20));
        panel.add(new JButton("이름"));
        panel.add(new JButton("학번"));
        panel.add(new JButton("학과"));
        panel.add(new JButton("과목"));
        container.add(panel, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(50));
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        container.add(panel, BorderLayout.SOUTH);
        //container.add(new JButton("add"), BorderLayout.CENTER);
        //container.add(new JButton("add"), BorderLayout.EAST);

        // 프레임 설정
        setSize(500, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutExam01();
    }
}