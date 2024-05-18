package view;

import models.CustomerDTO;
import models.OrdersDTO;
import utils.Constructor;
import utils.Field;
import utils.Method;

import javax.swing.*;

public class ChangeInfoView extends ICustomerView {
    @Field
    private static final ChangeInfoView customerChangeInfo = new ChangeInfoView();

    @Constructor
    private ChangeInfoView() {
        super("고객 정보 변경", 300, 500);
        initMainPanel();
        initComponents();
        setVisible(true);
    }

    @Method
    public static ChangeInfoView getInstance() {
        return customerChangeInfo;
    }

    public void setCustomerData(CustomerDTO customer, OrdersDTO order) {
        if (customer != null) {
            // 각 필드에 데이터 설정
            idField.setText(String.valueOf(customer.getUserId()));
            nameField.setText(customer.getName());
            emailField.setText(customer.getEmail());
            phoneField.setText(customer.getPhone());
            addressField.setText(customer.getAddress());
            roleField.setText(customer.getRole());
            carField.setText(order.getProduct().getModel());
            productIdField.setText(String.valueOf(order.getProduct().getProductId()));
            adminIdField.setText(String.valueOf(order.getAdmin().getUserId()));
            purchaseDateField.setText(order.getPurchaseDate().toString());
            serviceDueDateField.setText(order.getServiceDueDate().toString());
            paymentStatusField.setSelected(order.isPaymentStatus());

            revalidate();
            repaint();
        }
    }

    @Override
    public JPanel getFormPanel() {
        return super.getFormPanel();
    }

    @Override
    protected void initMainPanel() {
        super.initMainPanel();
    }

    @Override
    public void initComponents() {
        super.initComponents();
        createButtonPanel("변경", "취소");
    }

    @Override
    public void setButtonEvent() {
        System.out.println("고객 정보 변경 버튼 클릭");
    }
}