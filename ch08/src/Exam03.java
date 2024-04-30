import javax.swing.*;
import java.util.ArrayList;
import java.util.Vector;

public class Exam03 extends JFrame {
    // 객체 배열의 요소를 JList 의 뷰로 출력
    // 벡터를 이용하여 요소를 JList 의 뷰로 출력
    // 빈 JList 컴포넌트를 생성하고 setListData()로 요소를 제공할 수 있음
    public Exam03() {
        ArrayList al = new ArrayList();
        al.add("사과");
        al.add("배");
        al.add("딸기");

        for (Object a : al) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        new Exam03();
    }
}