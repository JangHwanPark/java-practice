import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AdminView extends JFrame {
    public AdminView() {
        initFrame("Admin View");
        configContent();
        createAndAddPanel();
    }

    // 기본 설정
    public void initFrame(String title) {
        setTitle(title);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // 컨텐트팬 설정
    public void configContent() {
        Container con = getContentPane();
        con.setLayout(new BorderLayout(50, 30));
        con.setBackground(Color.CYAN);
    }

    // 좌측 패널 설정
    public void createAndAddPanel() {
        // 버튼 레이블
        String[] labels = {"사용자 정보 변경", "사용자 등록", "사용자 삭제", "프로그램 종료"};
        ArrayList<JButton> buttons = new ArrayList<>();

        for (String label : labels) {
            JButton button = new JButton(label);
            button.setPreferredSize(new Dimension(200, 50));
            buttons.add(button);
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (JButton button : buttons) {
            panel.add(button);
        }

        panel.setBackground(Color.RED);
        getContentPane().add(panel, BorderLayout.WEST);
    }

    // View 실행
    public static void main(String[] args) {
        new AdminView();
    }
}