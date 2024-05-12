package controller;

import dao.CustomerDAO;
import models.CustomerDTO;
import models.OrdersDTO;
import models.ProductDTO;
import view.AdminView;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class AdminViewController {
    private static final String[] columnNames = {"고객 ID", "이름", "이메일", "전화번호", "주소", "주문 ID", "주문 날짜", "주문 상태"};
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String[] getColumnNames() {
        return columnNames;
    }

    public static Object[][] prepareTableData(ArrayList<OrdersDTO> orders) {
        // 테이블 열 이름, 데이터 배열 생성
        Object[][] data = new Object[orders.size()][columnNames.length];

        // 고객 데이터를 테이블 데이터 배열에 할당
        for (OrdersDTO order : orders) {
            CustomerDTO customer = order.getCustomer();
            ProductDTO product = order.getProduct();
            int index = orders.indexOf(order);

            data[index][0] = customer.getUserId();
            data[index][1] = customer.getName();
            data[index][2] = customer.getEmail();
            data[index][3] = customer.getPhone();
            data[index][4] = customer.getAddress();
            data[index][5] = product.getModel();
            data[index][6] = dateFormat.format(order.getPurchaseDate());
            data[index][7] = order.isPaymentStatus() ? "결제 완료" : "결제 대기";
        }

        return data;
    }

    public void deleteCustomerOrder(Object[] rowData) {
        System.out.println("rowData: " + Arrays.toString(rowData));
        System.out.println("DeleteView 생성자 호출");

        // 고객 아이디 가져오기
        int customerId = (int) rowData[0];
        System.out.println("customerId: " + customerId);

        // 삭제 확인 대화상자 출력
        int deleteRes = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?", "삭제 확인", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if (deleteRes == JOptionPane.OK_OPTION) {
            System.out.println("deleteRes: " + deleteRes);
            
            // DTO 로 객체 생성 후, DAO 를 이용해 삭제 작업 수행
            CustomerDTO customer = new CustomerDTO(customerId);
            customer.setUserId(customerId);

            CustomerDAO customerDAO = new CustomerDAO();
            customerDAO.deleteModel(customer);

            // 데이터 삭제 후 테이블 갱신
            AdminView adminView= AdminView.getInstance();
            adminView.refreshTableData();
            JOptionPane.showMessageDialog(null, "삭제되었습니다.");
        }
    }
}