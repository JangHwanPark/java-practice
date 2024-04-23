import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JCheckBoxExam02 extends JFrame {
    private JCheckBox[] fruits = new JCheckBox[3];
    private JRadioButton[] radio = new JRadioButton[6];
    private String[] names = {"사과", "배", "체리"};
    private Label sumLabel;

    public JCheckBoxExam02() {
        super("체크박스 아이템 이벤트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(new JLabel("사과 1000원, 배 5000원, 체리 10000원"));

        // 체크박스 생성
        CheckBoxItemListener itemListener = new CheckBoxItemListener();
        JPanel panel1 = new JPanel();
        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = new JCheckBox(names[i]);
            fruits[i].setBorderPainted(true);
            container.add(fruits[i]);
            fruits[i].addItemListener(itemListener);
            panel1.add(fruits[i]);
        }
        panel1.setLayout(new GridLayout(1, 3));
        panel1.setBackground(Color.RED);


        // 라디오 버튼 생성
        ButtonGroup g = new ButtonGroup();
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 3));
        panel2.setBackground(Color.YELLOW);
        String fs[] = {"사과", "배", "체리", "사과", "배", "체리"};
        for (int i = 0; i < fs.length; i++) {
            radio[i] = new JRadioButton(fs[i]);
            radio[i].setBorderPainted(true);
            g.add(radio[i]);
            panel2.add(radio[i]);
        }

        sumLabel = new Label("현재 0 원 입니다.");
        container.add(sumLabel, BorderLayout.NORTH);
        container.add(panel1, BorderLayout.CENTER);
        container.add(panel2, BorderLayout.SOUTH);
        setSize(300, 500);
        setVisible(true);
    }

    class CheckBoxItemListener implements ItemListener {
        private int sum = 0;

        @Override
        public void itemStateChanged(ItemEvent e) {
            System.out.println("체크박스 상태 변경");
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (e.getItem() == fruits[0]) {
                    sum += 1000;
                } else if (e.getItem() == fruits[1]) {
                    sum += 5000;
                } else {
                    sum += 10000;
                }
            } else {
                if (e.getItem() == fruits[0]) {
                    sum -= 1000;
                } else if (e.getItem() == fruits[1]) {
                    sum -= 5000;
                } else {
                    sum -= 10000;
                }
            }
            sumLabel.setText("현재 " + sum + "원 입니다.");
        }
    }
    public static void main(String[] args) {
        new JCheckBoxExam02();
    }
}