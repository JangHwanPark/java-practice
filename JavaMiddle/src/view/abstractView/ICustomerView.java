package view.abstractView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class ICustomerView extends IView {
    private JPanel formPanel;

    public ICustomerView(String title, int width, int height) {
        super(title, width, height);
        setVisible(true);
    }

    @Override
    public void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // 정보 입력 패널 설정
        formPanel = new JPanel(new GridBagLayout());
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
    }

    public void createButtonPanel(String setButtonName, String backButtonName) {
        JPanel buttonPanel = new JPanel();
        JButton setButton = new JButton(setButtonName);
        JButton backButton = new JButton(backButtonName);
        buttonPanel.add(setButton);
        buttonPanel.add(backButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);

        // 버튼 이벤트 : 현재 창을 닫고 이전 화면으로 돌아감
        backButton.addActionListener(e -> this.dispose());

        // 버튼 이벤트 : 추상 메소드 호출
        setButton.addActionListener(e -> setButtonEvent());
    }

    // 버튼 이벤트(추상 메소드)
    protected abstract void setButtonEvent();
}