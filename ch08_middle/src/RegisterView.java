import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RegisterView extends JFrame {
    public RegisterView() {
        setTitle("회원가입");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // 상단, 하단 패딩 = 0 좌측, 우측 패딩 = 10으로 설정
        panel.setBorder(new EmptyBorder(0, 30, 0, 30));

        // 이름 입력 부분
        JPanel namePanel = new JPanel(new BorderLayout());
        // 패널의 상단에 10픽셀 패딩 추가
        namePanel.setBorder(new EmptyBorder(50, 0, 0, 0));

        JLabel nameLabel = new JLabel("이름:");
        nameLabel.setBorder(new EmptyBorder(0, 0, 0, 50)); // 레이블 오른쪽에 패딩 추가

        JTextField nameField = new JTextField();
        namePanel.add(nameLabel, BorderLayout.WEST);
        namePanel.add(nameField, BorderLayout.CENTER);

        // 비밀번호 입력 부분
        JPanel passwordPanel = new JPanel(new BorderLayout());
        JLabel passwordLabel = new JLabel("비밀번호:");
        passwordLabel.setBorder(new EmptyBorder(0, 0, 0, 30)); // 레이블 오른쪽에 패딩 추가

        JTextField passwordField = new JPasswordField();
        passwordPanel.add(passwordLabel, BorderLayout.WEST);
        passwordPanel.add(passwordField, BorderLayout.CENTER);

        // 이메일 입력 부분
        JPanel emailPanel = new JPanel(new BorderLayout());
        JLabel emailLabel = new JLabel("이메일:");
        emailLabel.setBorder(new EmptyBorder(0, 0, 0, 40)); // 레이블 오른쪽에 패딩 추가

        JTextField emailField = new JTextField();
        emailPanel.add(emailLabel, BorderLayout.WEST);
        emailPanel.add(emailField, BorderLayout.CENTER);

        // 학번 입력 부분
        JPanel studentNumberPanel = new JPanel(new BorderLayout());
        JLabel studentNumberLabel = new JLabel("학번:");
        studentNumberLabel.setBorder(new EmptyBorder(0, 0, 0, 50)); // 레이블 오른쪽에 패딩 추가

        JTextField studentNumberField = new JTextField();
        studentNumberPanel.add(studentNumberLabel, BorderLayout.WEST);
        studentNumberPanel.add(studentNumberField, BorderLayout.CENTER);

        // 패널에 컴포넌트 추가
        panel.add(namePanel);
        panel.add(Box.createVerticalStrut(50)); // 이름, 비밀번호 사이 간격 추가
        panel.add(passwordPanel);
        panel.add(Box.createVerticalStrut(50)); // 비밀번호, 이메일 사이 간격 추가
        panel.add(emailPanel);
        panel.add(Box.createVerticalStrut(50)); // 이메일, 학번 사이 간격 추가
        panel.add(studentNumberPanel);

        // 약관 동의 체크박스
        panel.add(Box.createVerticalStrut(20)); // 이전 컴포넌트와 체크박스 사이 간격 추가
        JCheckBox termsCheckBox = new JCheckBox("서비스의 이용 약관 또는 개인정보 처리방침에 동의합니다.");
        panel.add(termsCheckBox);

        // 관리자 권한 부여 체크박스
        JCheckBox adminRightsCheckBox = new JCheckBox("관리자 권한 부여");
        panel.add(adminRightsCheckBox);

        // 회원가입 버튼 추가
        JButton signUpButton = new JButton("회원가입");
        // 관리자 권한 체크박스, 회원가입 사이 간격 추가
        panel.add(Box.createVerticalStrut(20));
        panel.add(signUpButton);
        panel.add(Box.createVerticalStrut(50)); // 회원가입 버튼 하단 간격 추가

        Dimension textFieldSize = new Dimension(200, 20);
        nameField.setPreferredSize(textFieldSize);
        nameField.setMinimumSize(textFieldSize);
        nameField.setMaximumSize(textFieldSize);

        passwordField.setPreferredSize(textFieldSize);
        passwordField.setMinimumSize(textFieldSize);
        passwordField.setMaximumSize(textFieldSize);

        emailField.setPreferredSize(textFieldSize);
        emailField.setMinimumSize(textFieldSize);
        emailField.setMaximumSize(textFieldSize);

        studentNumberField.setPreferredSize(textFieldSize);
        studentNumberField.setMinimumSize(textFieldSize);
        studentNumberField.setMaximumSize(textFieldSize);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterView();
    }
}