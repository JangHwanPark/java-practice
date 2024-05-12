package controller;

import dao.OrdersDAO;
import models.CustomerDTO;
import models.OrdersDTO;
import models.ProductDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
}