package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginView extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private LoginController controller;
    private JButton loginButton;
    private JPanel panel;
    private JLabel registerLink;

    public LoginView() {
        setTitle("로그인");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        /* ******************** 패널 생성 ******************** */
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        getContentPane().add(panel);
        /* ************************************************* */


        /* ******************** 라벨 설정 ******************** */
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        /* ************************************************* */


        // 이메일 라벨
        JLabel emailLabel = new JLabel("이메일:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(emailLabel, gbc);

        // 이메일 필드
        emailField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(emailField, gbc);

        // 비밀번호 라벨
        JLabel passwordLabel = new JLabel("비밀번호:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        // 비밀번호 필드
        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField, gbc);

        // 로그인 버튼
        loginButton = new JButton("로그인");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // 버튼을 두 칼럼에 걸쳐 배치
        panel.add(loginButton, gbc);

        // 회원가입 링크
        registerLink = new JLabel("회원가입", SwingConstants.CENTER); // 텍스트 중앙 정렬
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(registerLink, gbc);

        // 이벤트 핸들러 등록
        bindEventHandlers();
        setVisible(true);
    }

    private void bindEventHandlers() {
        // 로그인 버튼 클릭 시 이벤트 처리
        loginButton.addActionListener(e -> onSubmit());

        // 회원가입 버튼 클릭 시 이벤트 처리
        registerLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClickRegister();
            }
        });
    }

    private void onClickRegister() {
        System.out.println("회원가입 링크 클릭됨");
        new RegisterView();
        setVisible(false);
    }


    /* *************** 로그인 버튼 클릭 시 이벤트 처리 ****************/
    private void onSubmit() {
        System.out.println("로그인 버튼 클릭됨");
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        System.out.println("email: " + email + ", password: " + password);

        controller = new LoginController(email, password);
        controller.loginUser(email, password);

        System.out.println("로그인 성공");
        AdminView adminView = AdminView.getInstance();
        adminView.refreshTableData();
        setVisible(false);
    }
    /* ********************************************************** */


    // Test
    public static void main(String[] args) {
        new LoginView();
    }
}