package view;

import utils.Constructor;
import utils.EventMethod;
import utils.Field;
import utils.Method;

import javax.swing.*;
import java.awt.*;

public abstract class ICustomerView extends IView {
    @Field
    private JPanel formPanel;
    protected JTextField idField, nameField, addressField, emailField, phoneField, carField, purchaseDateField, roleField, productIdField, adminIdField, serviceDueDateField;
    protected JCheckBox paymentStatusField;

    @Constructor
    public ICustomerView(String title, int width, int height) {
        super(title, width, height);
    }

    @Method
    public JPanel getFormPanel() {
        return formPanel;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getAddressField() {
        return addressField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public JTextField getCarField() {
        return carField;
    }

    public JTextField getPurchaseDateField() {
        return purchaseDateField;
    }

    public JTextField getRoleField() {
        return roleField;
    }

    public JTextField getProductIdField() {
        return productIdField;
    }

    public JTextField getAdminIdField() {
        return adminIdField;
    }

    public JTextField getServiceDueDateField() {
        return serviceDueDateField;
    }

    public JCheckBox getPaymentStatusField() {
        return paymentStatusField;
    }

    @Override
    protected void initMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        getContentPane().add(mainPanel);
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
        roleField = new JTextField(10);
        productIdField = new JTextField(10);
        adminIdField = new JTextField(10);
        serviceDueDateField = new JTextField(10);
        paymentStatusField = new JCheckBox("결제 상태");

        JTextField[] fields = {idField, nameField, addressField, emailField, phoneField, carField, purchaseDateField, roleField, productIdField, adminIdField, serviceDueDateField};
        String[] fieldNames = {"고객ID", "이름", "주소", "이메일", "전화번호", "구매 차량", "구매 날짜", "역할", "제품 ID", "관리자 ID", "서비스 예정일"};

        for (int i = 0; i < fields.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            formPanel.add(new JLabel(fieldNames[i] + ":"), gbc);

            gbc.gridx = 1;
            formPanel.add(fields[i], gbc);
        }

        gbc.gridx = 0;
        gbc.gridy = fields.length;
        formPanel.add(new JLabel("결제 상태:"), gbc);

        gbc.gridx = 1;
        formPanel.add(paymentStatusField, gbc);
    }

    @Method
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

    @EventMethod
    protected abstract void setButtonEvent();
}