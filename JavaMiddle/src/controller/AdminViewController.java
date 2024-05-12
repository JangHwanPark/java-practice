package controller;

import dao.OrdersDAO;
import models.CustomerDTO;
import models.OrdersDTO;
import models.ProductDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AdminViewController {
    public static String[] getColumnNames() {
        return new String[]{"고객 ID", "이름", "이메일", "전화번호", "주소", "주문 ID", "주문 날짜", "주문 상태"};
    }

    public static Object[][] prepareTableData(ArrayList<OrdersDTO> orders) {
        // 테이블 열 이름, 데이터 배열 생성
        String[] columnNames = getColumnNames();
        Object[][] data = new Object[orders.size()][columnNames.length];
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // 고객 데이터를 테이블 데이터 배열에 할당
        for (int i = 0; i < orders.size(); i++) {
            OrdersDTO order = orders.get(i);
            CustomerDTO customer = order.getCustomer();
            ProductDTO product = order.getProduct();

            data[i][0] = customer.getUserId();
            data[i][1] = customer.getName();
            data[i][2] = customer.getEmail();
            data[i][3] = customer.getPhone();
            data[i][4] = customer.getAddress();
            data[i][5] = product.getModel();  // 제품 모델 추가
            data[i][6] = dateFormat.format(order.getPurchaseDate());  // 주문 날짜
            data[i][7] = order.isPaymentStatus() ? "결제 완료" : "결제 대기";  // 주문 상태
        }

        return data;
    }
}