package src;

import src.components.InputPanelComponent;
import src.controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private InputPanelComponent nameField, emailField;
    private LoginController controller;
    private JButton loginButton;
    private JPanel panel;

    public LoginView() {
        setTitle("로그인");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // 컨텐트팬에 패널 추가
        getContentPane().add(panel);

        // 기본 설정
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // 각 구성 요소 사이의 여백

        // 이메일 라벨
        JLabel emailLabel = new JLabel("이메일:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(emailLabel, gbc);

        // 이메일 필드
        JTextField emailField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(emailField, gbc);

        // 비밀번호 라벨
        JLabel passwordLabel = new JLabel("비밀번호:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        // 비밀번호 필드
        JPasswordField passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField, gbc);

        // 로그인 버튼
        loginButton = new JButton("로그인");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // 버튼을 두 칼럼에 걸쳐 배치
        panel.add(loginButton, gbc);

        // 이벤트 핸들러 등록
        bindEventHandlers();
        setVisible(true);
    }

    private void bindEventHandlers() {
            // 로그인 버튼 클릭 시 이벤트 처리
        loginButton.addActionListener(e -> onSubmit());
     }

    private void onSubmit() {
        // 로그인 버튼 클릭 시 이벤트 처리
        System.out.println("로그인 버튼 클릭됨");

        String name = nameField.getText();
        String email = emailField.getText();
        controller.loginUser(name, email);
        JOptionPane.showMessageDialog(panel, "로그인 성공");
    }

    // View 실행
    public static void main(String[] args) {
        new LoginView();
    }
}