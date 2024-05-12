package view.abstractView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class ICustomerView extends IView {
    private JPanel formPanel;
    protected JTextField idField, nameField, addressField, emailField, phoneField, carField, purchaseDateField;

    public JPanel getFormPanel() {
        return formPanel;
    }

    public ICustomerView(String title, int width, int height) {
        super(title, width, height);
    }

    @Override
    public void initComponents() {
        formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        idField = new JTextField(10);
        nameField = new JTextField(10);
        addressField = new JTextField(10);
        emailField = new JTextField(10);
        phoneField = new JTextField(10);
        carField = new JTextField(10);
        purchaseDateField = new JTextField(10);

        JTextField[] fields = {idField, nameField, addressField, emailField, phoneField, carField, purchaseDateField};
        String[] fieldNames = {"고객ID", "이름", "주소", "이메일", "전화번호", "구매 차량", "구매 날짜"};

        for (int i = 0; i < fields.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            formPanel.add(new JLabel(fieldNames[i] + ":"), gbc);

            gbc.gridx = 1;
            formPanel.add(fields[i], gbc);
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