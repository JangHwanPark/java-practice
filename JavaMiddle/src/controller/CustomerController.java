package controller;

import models.CustomerDTO;

import java.util.ArrayList;

public class CustomerController {
    public static String[] getColumnNames() {
        return new String[]{"고객 ID", "이름", "이메일", "전화번호", "주소"};
    }

    public static Object[][] prepareTableData(ArrayList<CustomerDTO> customers) {
        // 테이블 열 이름, 데이터 배열 생성
        String[] columnNames = getColumnNames();
        Object[][] data = new Object[customers.size()][columnNames.length];

        // 고객 데이터를 테이블 데이터 배열에 할당
        for (int i = 0; i < customers.size(); i++) {
            CustomerDTO customer = customers.get(i);
            data[i][0] = customer.getUserId();
            data[i][1] = customer.getName();
            data[i][2] = customer.getEmail();
            data[i][3] = customer.getPhone();
            data[i][4] = customer.getAddress();
        }

        return data;
    }
}