package view;

import controller.LoginController;
import utils.Constructor;
import utils.EventMethod;
import view.abstractView.IView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginView extends IView {
    private RegisterView registerView;
    private JTextField emailField;
    private JPasswordField passwordField;
    private LoginController controller;
    private JButton loginButton;
    private JPanel panel;
    private JLabel registerLink;

    @Constructor
    public LoginView() {
        super("로그인", 400, 300);
        initMainPanel();
        initComponents();
        bindEventHandlers();
        setVisible(true);
    }

    @Override
    protected void initMainPanel() {
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(20, 30, 20, 30));
        this.add(mainPanel);
    }

    @Override
    protected void initComponents() {
        // 패널 생성
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        getContentPane().add(panel);

        // 라벨 설정
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // 이메일 라벨
        JLabel emailLabel = new JLabel("이메일:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        panel.add(emailLabel, gbc);

        // 이메일 필드
        emailField = new JTextField("a1", 20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(emailField, gbc);

        // 비밀번호 라벨
        JLabel passwordLabel = new JLabel("비밀번호:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(passwordLabel, gbc);

        // 비밀번호 필드
        passwordField = new JPasswordField("a1", 20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(passwordField, gbc);

        // 로그인 버튼 설정
        loginButton = new JButton("로그인");
        loginButton.setBackground(new Color(51, 51, 204)); // 배경색 설정
        loginButton.setForeground(Color.WHITE); // 글자색 설정
        loginButton.setFont(new Font("맑은고딕", Font.BOLD, 14)); // 글꼴 설정
        loginButton.setFocusPainted(false); // 포커스 표시 제거
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // 여백 추가
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서 모양 변경
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        panel.add(loginButton, gbc);

        // 회원가입 링크
        registerLink = new JLabel("관리자 등록");
        registerLink.setForeground(new Color(51, 51, 204));
        registerLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(registerLink, gbc);
    }

    @EventMethod
    private void bindEventHandlers() {
        // 로그인 버튼 클릭 시 이벤트 처리
        loginButton.addActionListener(e -> onSubmit());

        // 회원가입 버튼 클릭 시 이벤트 처리
        registerLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new RegisterView();
                setVisible(false);
            }
        });
    }

    @EventMethod("로그인 버튼 클릭 시 이벤트 처리")
    private void onSubmit() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        System.out.println("로그인 버튼 클릭됨");
        System.out.println("email: " + email + ", password: " + password);

        controller = new LoginController(email, password);
        controller.loginUser(email, password);

        if (controller.getUserModel() != null) {
            setVisible(false);
        }
    }
}