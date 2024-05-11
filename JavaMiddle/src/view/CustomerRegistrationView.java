package view;

import view.abstractView.ICustomerView;

import javax.swing.*;

public class CustomerRegistrationView extends ICustomerView {
    public CustomerRegistrationView() {
        super("고객 등록", 300, 400);
        setVisible(true);
    }

    @Override
    public void initComponents() {
        super.initComponents();
        createButtonPanel("등록", "취소");
    }

    @Override
    public void setButtonEvent() {
        JOptionPane.showMessageDialog(null, "등록 버튼 클릭");
    }
}