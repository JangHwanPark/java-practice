package view;

import view.abstractView.ICustomerView;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class CustomerChangeInfo extends ICustomerView {
    private static final CustomerChangeInfo customerChangeInfo = new CustomerChangeInfo();
    private Object[] selectedRowData;

    private CustomerChangeInfo() {
        super("고객 정보 변경", 300, 500);
    }

    public static CustomerChangeInfo getInstance() {
        return customerChangeInfo;
    }

    @Override
    public JPanel getFormPanel() {
        return super.getFormPanel();
    }

    @Override
    protected void setupMainPanel() {
        super.setupMainPanel();
    }

    @Override
    public void initComponents() {
        super.initComponents();
        createButtonPanel("변경", "취소");
    }

    /* *************** 선택된 데이터를 인풋 필드에 표시 *************** */
    public void displayRowDataInInputFields(Object[] rowData) {
        System.out.println("roundData: " + Arrays.toString(rowData));

        // Null 검사 추가
        if (rowData == null || rowData.length < 6) {
            JOptionPane.showMessageDialog(null, "유효하지 않은 데이터입니다.", "오류", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SwingUtilities.invokeLater(() -> {
            // 데이터 설정
            nameField.setText(String.valueOf(rowData[0]));
            addressField.setText(String.valueOf(rowData[1]));
            emailField.setText(String.valueOf(rowData[2]));
            phoneField.setText(String.valueOf(rowData[3]));
            carField.setText(String.valueOf(rowData[4]));
            purchaseDateField.setText(String.valueOf(rowData[5]));

            // UI 갱신
            this.revalidate();
            this.repaint();
        });

        // 테스트 출력
        System.out.println(nameField.getText() + " " + addressField.getText() + " " + emailField.getText() + " " + phoneField.getText() + " " + carField.getText() + " " + purchaseDateField.getText());
        System.out.println("displayRowDataInInputFields() called");
    }
    /* ************************************************************ */


    /**/
    public void setSelectedRowData(Object[] selectedRowData) {
        this.selectedRowData = selectedRowData;
    }
    /* ************************************************************ */


    /**/
    @Override
    protected void setButtonEvent() {
        System.out.println("DebugLog: 변경 버튼 클릭됨");
        if (this.selectedRowData != null) {
            this.displayRowDataInInputFields(this.selectedRowData);
            this.setVisible(true);  // 사용자가 버튼을 클릭했을 때만 창을 보이게 함
        } else {
            JOptionPane.showMessageDialog(null, "변경할 데이터를 선택해주세요.", "변경할 데이터 선택", JOptionPane.WARNING_MESSAGE);
        }
    }
    /* ************************************************************ */
}