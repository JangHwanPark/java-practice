package exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextInput extends JFrame {
    JTextField name,age;

    public TextInput() {
        //프레임 완전하게 끄기
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,200);
        this.setVisible(true);

        //Layout 배치설정자
        this.setLayout(new GridLayout(5,2));
        add(new JLabel("   !"));

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("  이름 :"));
        name=new JTextField(20);
        panel1.add(name);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("  나이 :"));
        age =new JTextField(3);
        panel2.add(age);

        this.add(panel1);
        add(panel2);
        JButton button = new JButton("확인");
        add(button);
        this.setVisible(true);

        //버튼 리스너 연결
        button.addActionListener(new Listener(this));
    }

    class Listener implements ActionListener {
        JFrame frame;
        public Listener(JFrame f){
            frame =f;
        }
        @Override
        public void actionPerformed(ActionEvent arg0) {
            //버튼을 누르면 이쪽으로 제어가 이동
            System.out.println(arg0.getActionCommand());
            String n =name.getText();
            System.out.println(n);
            String a =age.getText();
            System.out.println(a);

            //다이얼로그
            JOptionPane.showMessageDialog(frame, n+a);
        }
    }

    public static void main(String[] args) {
        new TextInput();
    }
}