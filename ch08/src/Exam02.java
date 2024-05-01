import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

/**
 * 요구사항
 * 엔터 입력시 다음 필드로 이동
 * 입력값 콘솔박스? 로 출력
 */

public class Exam02 extends JFrame {
    private JTextField tf = new JTextField(10);
    private Vector<String> v = new Vector<>();
    private JList<String> nameList = new JList<>(v);

    public Exam02() {
        setTitle("Exam02");
        setSize(230, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 컨텐트팬
        Container con = getContentPane();
        con.setLayout(new FlowLayout());

        // 레이블
        con.add(new JLabel("이름"));
        TextField filed1 = new TextField(20);
        con.add(filed1);

        /*JLabel typeLabel = new JLabel("학과");
        TextField filed2 = new TextField("컴퓨터공학과", 20);
        con.add(typeLabel);
        con.add(filed2); // 기본 입력값 설정

        con.add(new JLabel("주소"));
        TextField filed3 = new TextField("서울", 20);
        con.add(filed3);

        // TextArea 추가
        TextArea textArea = new TextArea(5, 20);
        con.add(textArea);*/

        // JList 추가 (컬렉션 오브젝트면 링크드리스트 가능)
        v.add("사과");
        v.add("qo");
        v.add("c");

        tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField t = (JTextField) e.getSource();
                v.add(t.getText());
                t.setText("");
                nameList.setListData(v);
            }
        });

        con.add(nameList);


        /*class ActionsListerTextEvent implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JTextField filed = (JTextField) e.getSource();
                textArea.append(filed.getText() + "\n");
                filed.setText("");
                filed.requestFocus();
            }
        }*/

        /*filed1.addActionListener(e -> {
            new ActionsListerTextEvent().actionPerformed(e);
        });*/

        // 엔터 입력시 액션이벤트 발생 (다음줄로 이동)
        /*class ActionKeyEnter extends KeyAdapter {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (e.getSource() == filed1) {
                        filed2.requestFocus();
                    } else if (e.getSource() == filed2) {
                        filed3.requestFocus();
                    } else if (e.getSource() == filed3) {
                        filed1.requestFocus();
                    }
                }
            }
        }

        filed1.addKeyListener(new ActionKeyEnter());
        filed1.setEditable(false);
        filed2.addKeyListener(new ActionKeyEnter());
        filed3.addKeyListener(new ActionKeyEnter());*/

        // 화면 표시
        setVisible(true);
    }

    public static void main(String[] args) {
        new Exam02();
    }
}