import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RegisterView extends JFrame {

    public RegisterView() {
        setTitle("회원가입");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(createPadding(60, 30, 30, 30));

        // 이름, 비밀번호, 이메일, 학번 입력 부분
        panel.add(createInputPanel("이름:", 50));
        panel.add(createVerticalSpacing(50));
        panel.add(createInputPanel("비밀번호:", 30));
        panel.add(createVerticalSpacing(50));
        panel.add(createInputPanel("이메일:", 40));
        panel.add(createVerticalSpacing(50));
        panel.add(createInputPanel("학번:", 50));

        // 약관 동의 체크박스
        panel.add(createVerticalSpacing(20));
        panel.add(new JCheckBox("서비스의 이용 약관 또는 개인정보 처리방침에 동의합니다."));

        // 관리자 권한 부여 체크박스
        panel.add(new JCheckBox("관리자 권한 부여"));

        // 회원가입 버튼 추가
        panel.add(createVerticalSpacing(20));
        JButton signUpButton = new JButton("회원가입");
        panel.add(signUpButton);
        panel.add(createVerticalSpacing(50));

        add(panel);
        setVisible(true);
    }

    private JPanel createInputPanel(String labelText, int rightPadding) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 0, 10, 0)); // 공통 패딩

        JLabel label = new JLabel(labelText);
        label.setBorder(new EmptyBorder(0, 0, 0, rightPadding));

        JTextField textField = new JTextField();
        setTextFieldSize(textField, 200, 20);

        panel.add(label, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        return panel;
    }

    private void setTextFieldSize(JTextField textField, int width, int height) {
        Dimension size = new Dimension(width, height);
        textField.setPreferredSize(size);
        textField.setMinimumSize(size);
        textField.setMaximumSize(size);
    }

    private Component createVerticalSpacing(int height) {
        return Box.createVerticalStrut(height);
    }

    private Border createPadding(int top, int left, int bottom, int right) {
        return new EmptyBorder(top, left, bottom, right);
    }

    // View 실행
    public static void main(String[] args) {
        new RegisterView();
    }
}