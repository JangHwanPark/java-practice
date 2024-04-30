/*
import javafx.beans.value.ChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;

public class Exam05 extends JFrame {
    private JLabel colorLabel;
    private JSlider [] sl = new JSlider[3];

    public Exam05() {
        setTitle("Exam05 슬라이더 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container con = getContentPane();
        con.setLayout(new FlowLayout());
        colorLabel = new JLabel("SLIDER EXAMPLE");

        for (int i = 0; i < sl.length; i++) {
            sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 555, 128);
            sl[i].setPaintLabels(true);
            sl[i].setPaintTicks(true);
            //sl[i].setPaintTrack(true);

            sl[i].setMajorTickSpacing(100);
            sl[i].setMinorTickSpacing(10);
            sl[i].addChangeListener(new MyChangeListener());
            con.add(sl[i]);
        }

        // 슬라이더 색상 설정
        sl[0].setForeground(Color.RED);
        sl[1].setForeground(Color.GREEN);
        sl[2].setForeground(Color.BLUE);

        // 텍스트 색상 설정
        int r = sl[0].getValue();
        int g = sl[1].getValue();
        int b = sl[2].getValue();

        colorLabel.setOpaque(true);
        colorLabel.setBackground(new Color(r, g, b));

        setSize(500, 500);
        setVisible(true);
    }

    class MyChangeListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            // 슬라이더 별로 r g b 값 가져오기
            int r = sl[0].getValue();
            int g = sl[1].getValue();
            int b = sl[2].getValue();
            colorLabel.setBackground(new Color(r, g, b));
        }
    }

    public static void main(String[] args) {
        new Exam05();
    }
}*/