package Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonExam01 extends JFrame {
    // 생성자
    public ButtonExam01() {
        setTitle("버튼 이벤트 리스너 예제 01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 컨텐트팬 가져오고 플로우 레이아웃 적용
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        // 버튼 생성 후 이벤트 리스너 부착
        JButton btn = new JButton("Action");
        btn.addActionListener(new ActionButtonExam01());
        container.add(btn);

        // new Btn
        JButton btn2 = new JButton("Action2");
        btn2.addActionListener(new ActionButtonExam01());
        container.add(btn2);

        // 익명 클래스? 생성 ( new SuperClass -> Abstruct Method)
        JButton btn3 = new JButton("Action3");
        btn3.addActionListener(new ActionButtonExam01() {
            public void actionPerformed(ActionEvent event) {
                JButton btn2 = (JButton) event.getSource();

                // 실행할 로직
                if (btn2.getText().equals("Action2")) {
                    btn2.setText("액션2");
                } else {
                    btn2.setText("Action2");
                }
            }
        });
        container.add(btn2);

        // 판 사이즈, 화면 출력 여부 설정
        setSize(500, 300);
        setVisible(true);
    }

    // 이벤트 리스너에서 수행할 비즈니스 로직 (ActionListener 인터페이스 상속)
    private class ActionButtonExam01 implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton btn = (JButton) event.getSource();
            JButton btn2 = (JButton) event.getSource();
            boolean isAction = true;

            if (btn.getText().equals("Action") || btn2.getText().equals("Action2")) {
                btn.setText("액션");btn2.setText("액션2");
            } else {
                btn.setText("Action");btn2.setText("Action2");
            }

            ButtonExam01.this.setTitle(btn2.getText());
        }
    }

    public static void main(String[] args) {
        new ButtonExam01();
    }
}