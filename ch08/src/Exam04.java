import javax.swing.*;
import java.awt.*;

// 콤보 박스 예제
public class Exam04 extends JFrame {
    private String[] fruits = {"apple", "banana", "kiwi", "mango"};
    private String[] test = {"test1", "test2", "test3"};
    private String name;
    public Exam04() {
        setTitle("Exam04 콤보박스");setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        Container con = getContentPane();
        con.setLayout(new FlowLayout());

        JButton btn = new JButton(this.name);
        btn.setText("버튼");
        btn.setText("버튼1");
        btn.setText("버튼2");
        con.add(btn);

        // 콤보 박스 추가
        JComboBox<String> sCom = new JComboBox<>(fruits);
        con.add(sCom);

        JComboBox<String> sCom2 = new JComboBox<>(test);
        for (int i = 0; i < fruits.length; i++) {
            sCom.addItem(fruits[i]);
        }

        con.add(sCom2);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Exam04();
    }
}