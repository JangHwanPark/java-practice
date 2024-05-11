package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CustomerRegistrationView extends IView {
    public CustomerRegistrationView() {
        super("고객 정보 등록", 300, 400);
        setVisible(true);
    }

    @Override
    public void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // 정보 입력 패널 설정
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // 각 필드 추가
        String[] fieldNames = {"이름", "주소", "이메일", "전화번호", "구매 차량", "구매 날짜"};
        for (int i = 0; i < fieldNames.length; i++) {
            gbc.gridx = 0;  // 라벨 위치
            gbc.gridy = i;  // 행 위치
            gbc.weightx = 0.1;
            gbc.fill = GridBagConstraints.NONE;
            formPanel.add(new JLabel(fieldNames[i] + ":"), gbc);

            gbc.gridx = 1;  // 필드 위치
            gbc.gridy = i;
            gbc.weightx = 1.0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            formPanel.add(new JTextField(10), gbc);
        }

        // 버튼 패널
        JPanel buttonPanel = new JPanel();
        JButton registerButton = new JButton("등록");
        JButton backButton = new JButton("돌아가기");
        buttonPanel.add(registerButton);
        buttonPanel.add(backButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);

        // 버튼 이벤트 : 현재 창을 닫고 이전 화면으로 돌아감
        backButton.addActionListener(e -> this.dispose());
    }

    public static void main(String[] args) {
        new CustomerRegistrationView();
    }
}