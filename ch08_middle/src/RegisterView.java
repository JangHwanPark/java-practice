package src;

import src.components.InputPanelComponent;
import src.controller.ResisterController;
import src.models.AdminUserDTO;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RegisterView {
    private InputPanelComponent nameField, emailField, phoneField, addressField;
    private ResisterController controller;

    private JFrame frame;
    private JPanel panel;
    private JButton signUpButton;

    public RegisterView() {
        // 모델과 컨트롤러 생성
        AdminUserDTO userModel = new AdminUserDTO(0, "", "", "", "", "");
        controller = new ResisterController(userModel);

        // 회원가입 메소드 호출
        initializeFrame();
        initializeComponents();
        layoutComponents();
        bindEventHandlers();
        finalizeFrame();
    }

    private void initializeFrame() {
        frame = new JFrame("회원가입");
        frame.setSize(400, 430);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 30, 20, 30));
        panel.setBackground(new Color(245, 245, 245));  // 밝은 회색 배경

        // 폰트 설정
        Font font = new Font("맑은 고딕", Font.PLAIN, 14);

        nameField = new InputPanelComponent("이름: ", 200, 20, 10, font);
        emailField = new InputPanelComponent("이메일: ", 200, 20, 10, font);
        phoneField = new InputPanelComponent("전화번호: ", 200, 20, 10, font);
        addressField = new InputPanelComponent("주소: ", 200, 20, 10, font);

        signUpButton = new JButton("회원가입");
        signUpButton.setFont(font);
        signUpButton.setBackground(new Color(100, 149, 237));  // 코발트 블루
        signUpButton.setForeground(Color.WHITE);
    }

    private void layoutComponents() {
        panel.add(nameField);
        panel.add(createVerticalSpacing(15));
        panel.add(emailField);
        panel.add(createVerticalSpacing(15));
        panel.add(phoneField);
        panel.add(createVerticalSpacing(15));
        panel.add(addressField);
        panel.add(createVerticalSpacing(20));

        // 체크박스
        JCheckBox termsCheckBox = new JCheckBox("서비스의 이용 약관 동의");
        termsCheckBox.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        panel.add(termsCheckBox);
        panel.add(createVerticalSpacing(10));

        JCheckBox adminCheckBox = new JCheckBox("관리자 권한 부여");
        adminCheckBox.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        panel.add(adminCheckBox);
        panel.add(createVerticalSpacing(20));

        panel.add(signUpButton);
        panel.add(createVerticalSpacing(30));

        frame.add(panel);
    }

    private void bindEventHandlers() {
        signUpButton.addActionListener(e -> onSubmit());
    }

    private void finalizeFrame() {
        frame.setVisible(true);
    }

    private void onSubmit() {
        // 컨트롤러 메소드 호출을 위해 사용자 입력값을 가져옴
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();

        // 사용자 입력을 콘솔에 출력
        System.out.println("사용자 입력 정보");
        System.out.println("이름: " + name);
        System.out.println("이메일: " + email);
        System.out.println("전화번호: " + phone);
        System.out.println("주소: " + address);

        // 컨트롤러의 메소드를 호출하여 사용자 등록 처리
        controller.resisterUser(name, email, phone, address, "admin");
        JOptionPane.showMessageDialog(frame, "회원가입 ok");
    }

    private Component createVerticalSpacing(int height) {
        return Box.createVerticalStrut(height);
    }

    public static void main(String[] args) {
        new RegisterView();
    }
}