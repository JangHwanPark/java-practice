package src;

import src.controller.ResisterController;
import src.models.AdminUserDTO;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RegisterView {
    private JTextField nameField, emailField, phoneField, addressField;
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
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(createPadding(60, 30, 30, 30));

        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        addressField = new JTextField();
        signUpButton = new JButton("회원가입");
    }

    private void layoutComponents() {
        String[] labels = {"이름", "비밀번호", "이메일", "학번"};
        JTextField[] fields = {nameField, emailField, phoneField, addressField};
        int[] paddings = {50, 30, 40, 50};

        for (int i = 0; i < labels.length; i++) {
            panel.add(createInputPanel(labels[i] + ": ", paddings[i], fields[i]));
            panel.add(createVerticalSpacing(50));
        }

        panel.add(createVerticalSpacing(20));
        panel.add(new JCheckBox("서비스의 이용 약관 또는 개인정보 처리방침에 동의합니다."));
        panel.add(new JCheckBox("관리자 권한 부여"));
        panel.add(createVerticalSpacing(20));
        panel.add(signUpButton);
        panel.add(createVerticalSpacing(50));

        frame.add(panel);
    }

    private void bindEventHandlers() {
        signUpButton.addActionListener(e -> onSubmit());
    }

    private void finalizeFrame() {
        frame.setVisible(true);
    }

    private void onSubmit() {
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

    private JPanel createInputPanel(String labelText, int rightPadding, JTextField textField) {
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        JLabel label = new JLabel(labelText);
        label.setBorder(new EmptyBorder(0, 0, 0, rightPadding));
        
        // 인풋창 크기 설정
        setTextFieldSize(textField, 200, 20);

        // 레이웃 설정 및 인자로 받은 텍스트 필드 사용
        inputPanel.add(label, BorderLayout.WEST);
        inputPanel.add(textField, BorderLayout.CENTER);
        return inputPanel;
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

    public static void main(String[] args) {
        new RegisterView();
    }
}