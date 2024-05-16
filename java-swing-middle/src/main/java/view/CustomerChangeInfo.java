package view;

import utils.Constructor;
import utils.Field;
import utils.Method;
import view.abstractView.ICustomerView;

import javax.swing.*;
import java.util.Arrays;

public class CustomerChangeInfo extends ICustomerView {
    @Field
    private static final CustomerChangeInfo customerChangeInfo = new CustomerChangeInfo();
    private Object[] selectedRowData;

    @Constructor
    private CustomerChangeInfo() {
        super("고객 정보 변경", 300, 500);
        initMainPanel();
        initMainPanel();
        //setVisible(true);
    }

    @Method
    public static CustomerChangeInfo getInstance() {
        return customerChangeInfo;
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