package view;

import view.abstractView.ICustomerView;

import javax.swing.*;

public class CustomerChangeInfoView extends ICustomerView {
    public CustomerChangeInfoView() {
        super("고객 정보 변경", 300, 400);
        setVisible(true);
    }

    @Override
    public void initComponents() {
        super.initComponents();
        createButtonPanel("변경", "취소");
    }

    @Override
    protected void setButtonEvent() {
        JOptionPane.showMessageDialog(null, "변경 버튼 클릭");
    }
}