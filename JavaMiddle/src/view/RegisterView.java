package view;

import controller.RegisterController;
import models.AdminDTO;
import view.components.InputPanelComponent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RegisterView {
    /* ******************** 필드 ******************** */
    private final InputPanelComponent[] inputFields;
    private final RegisterController controller;
    private final JFrame frame;
    private JButton signUpButton;

    /* ******************** 생성자 ******************** */
    public RegisterView() {
        /* *************** 회원가입 View 생성 *************** */
        //super("회원가입", 400, 430);
        frame = new JFrame("회원가입");
        frame.setSize(400, 430);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        /* *************** 모델과 컨트롤러 객체 생성 *************** */
        AdminDTO userModel = new AdminDTO(0, "", "", "", "", "");
        controller = new RegisterController(userModel);

        /* ******************** 패널 설정 ******************** */
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 30, 20, 30));
        panel.setBackground(new Color(245, 245, 245));

        /* ******************** 폰트 설정 ******************** */
        Font font = new Font("맑은 고딕", Font.PLAIN, 14);

        /* ******************** 입력 필드 ******************** */
        String[] labels = {"이름: ", "이메일: ", "전화번호: ", "주소: ", "비밀번호: "};
        inputFields = new InputPanelComponent[labels.length];
        for (int i = 0; i < labels.length; i++) {
            inputFields[i] = new InputPanelComponent(labels[i], 200, 30, 10, font);
        }

        /* ******************** 버튼 ******************** */
        signUpButton = new JButton("회원가입");
        signUpButton.setFont(font);
        signUpButton.setBackground(new Color(100, 149, 237));
        signUpButton.setForeground(Color.WHITE);

        /* ******************** 레이아웃 설정 ******************** */
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        for (InputPanelComponent field : inputFields) {
            panel.add(field, gbc);
            gbc.gridy++;
        }

        // 체크 박스 설정
        String[] checkBokLabels = {"서비스의 이용 약관 동의", "관리자 권한 부여"};
        for (String checkBokLabel : checkBokLabels) {
            JCheckBox checkBox = new JCheckBox(checkBokLabel);
            checkBox.setFont(font);
            panel.add(checkBox, gbc);
            gbc.gridy++;
        }

        signUpButton = new JButton("회원가입");
        signUpButton.setFont(font);
        signUpButton.setBackground(new Color(100, 149, 237));
        signUpButton.setForeground(Color.WHITE);
        panel.add(signUpButton, gbc);

        frame.add(panel);
        frame.setVisible(true);

        /* ******************** 이벤트 호출 ******************** */
        bindEventHandlers();
        finalizeFrame();
    }

    private void onSubmit() {
        /* ********** 컨트롤러 메소드 호출을 위해 사용자 입력값을 가져옴 ********** */
        for (InputPanelComponent field : inputFields) {
            System.out.println(field.getText() + " " + field.getText());
        }
        String name = inputFields[0].getText();
        String email = inputFields[1].getText();
        String phone = inputFields[2].getText();
        String address = inputFields[3].getText();
        String password = inputFields[4].getText();

        // DebugLog
        printUser(name, email, phone, address);

        /* ********** 컨트롤러의 메소드를 호출하여 사용자 등록 처리 ********** */
        controller.registerUser(name, email, phone, address, password, "admin");
        int response = JOptionPane.showConfirmDialog(frame, "회원가입 ok");

        /* ********** 팝업의 확인 버튼 클릭시 회원가입 윈도우로 이동 ********** */
        if (response == JOptionPane.YES_OPTION) {
            frame.dispose();    // 프레임 종료
            new LoginView().setVisible(true);
        }
    }

    private void bindEventHandlers() {
        signUpButton.addActionListener(e -> onSubmit());
    }

    private void finalizeFrame() {
        frame.setVisible(true);
    }

    // 사용자 입력을 콘솔에 출력
    public void printUser(String name, String email, String phone, String address) {
        System.out.println("사용자 입력 정보");
        System.out.println("이름: " + name);
        System.out.println("이메일: " + email);
        System.out.println("전화번호: " + phone);
        System.out.println("주소: " + address);
    }
}