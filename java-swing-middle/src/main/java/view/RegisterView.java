package view;

import controller.AuthController;
import models.AdminDTO;
import utils.Constructor;
import utils.EventMethod;
import utils.Field;
import utils.Method;
import view.abstractView.IView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RegisterView extends IView {
    @Field
    private static RegisterView instance;
    private JTextField nameField, emailField, phoneField, addressField, passwordField;
    private AuthController controller;
    private JPanel mainPanel;

    @Constructor
    public RegisterView() {
        super("회원가입", 400, 430);
        initMainPanel();
        initComponents();
        setVisible(true);
    }

    @Method("getInstance - 싱글톤")
    public static RegisterView getInstance() {
        if (instance == null) instance = new RegisterView();
        return instance;
    }

    @Override
    protected void initMainPanel() {
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(20, 30, 20, 30));
        this.add(mainPanel);
    }

    @Override
    public void initComponents() {
        // 컴포넌트 객체 초기화
        JButton signUpButton = new JButton();

        // 모델과 컨트롤러 객체 생성
        AdminDTO userModel = new AdminDTO(0, "", "", "", "", "");
        controller = new AuthController(userModel);

        // 폰트 설정
        Font font = new Font("맑은 고딕", Font.PLAIN, 14);

        // 패널 설정
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // 요소들이 가로로 꽉 차게
        gbc.insets = new Insets(5, 5, 5, 5); // 요소간 간격 설정

        // 입력 필드 라벨 및 텍스트필드
        JLabel nameLabel = new JLabel("이름: ");
        nameField = new JTextField("admin",20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        mainPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        mainPanel.add(nameField, gbc);

        JLabel emailLabel = new JLabel("이메일: ");
        emailField = new JTextField("admin@ansan.ac.kr",20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        mainPanel.add(emailField, gbc);

        JLabel phoneLabel = new JLabel("전화번호: ");
        phoneField = new JTextField("010-1234-1234",20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(phoneField, gbc);

        JLabel addressLabel = new JLabel("주소: ");
        addressField = new JTextField("안산대학교",20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(addressLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(addressField, gbc);

        JLabel passwordLabel = new JLabel("비밀번호: ");
        passwordField = new JTextField("admin",20);
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(passwordField, gbc);

        // 체크 박스 설정
        JCheckBox termsCheckbox = new JCheckBox("서비스의 이용 약관 동의");
        termsCheckbox.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        mainPanel.add(termsCheckbox, gbc);

        JCheckBox adminCheckbox = new JCheckBox("관리자 권한 부여");
        adminCheckbox.setFont(font);
        gbc.gridy = 6;
        mainPanel.add(adminCheckbox, gbc);

        // 회원가입 버튼 설정
        signUpButton.setText("회원가입");
        signUpButton.setFont(font);
        signUpButton.setBackground(new Color(100, 149, 237));
        signUpButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        mainPanel.add(signUpButton, gbc);
        signUpButton.addActionListener(e -> onSubmit());
    }

    @EventMethod
    private void onSubmit() {
        System.out.println("회원가입 버튼 클릭");

        // 컨트롤러 메소드 호출을 위해 사용자 입력값을 가져옴
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        String password = passwordField.getText();
        System.out.println(name + " " + email + " " + phone + " " + address + " " + password);

        // 컨트롤러의 메소드를 호출하여 사용자 등록 처리
        controller.registerUser(name, email, phone, address, password, "admin");
        int response = JOptionPane.showConfirmDialog(
                this,
                "회원가입이 완료되었습니다. 바로 로그인 하시겠습니까?"
        );

        // 팝업의 확인 버튼 클릭시 회원가입 윈도우로 이동
        if (response == JOptionPane.YES_OPTION) {
            this.dispose();    // 프레임 종료
            new LoginView().setVisible(true);
        } else {
            this.dispose();    // 프레임 종료
        }
    }
}