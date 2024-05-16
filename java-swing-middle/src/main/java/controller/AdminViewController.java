package controller;

import dao.CustomerDAO;
import dao.OrdersDAO;
import models.CustomerDTO;
import models.OrdersDTO;
import models.ProductDTO;
import utils.*;
import view.AdminView;
import view.CustomerChangeInfo;
import view.CustomerRegistration;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class AdminViewController {
    @Field
    private CustomerDAO customerDAO;
    private OrdersDAO ordersDAO;
    private CustomerChangeInfo customerChangeInfo;
    private static final String[] columnNames = {"고객 ID", "이름", "이메일", "전화번호", "주소", "주문 ID", "주문 날짜", "주문 상태"};
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    @Constructor
    public AdminViewController() {
        customerDAO = new CustomerDAO();
        ordersDAO = new OrdersDAO();
    }

    @Method("테이블 열 이름 가져오기")
    public static String[] getColumnNames() {
        return columnNames;
    }

    @Method("테이블 데이터 설정")
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

    @Method("고객 등록 및 주문 등록")
    public boolean registerCustomerAndOrder(CustomerDTO customer, OrdersDTO order) {
        // 고객 등록
        CustomerDTO registeredCustomer = customerDAO.insertModel(customer);
        if (registeredCustomer == null) return false;

        // 주문 등록
        order.setCustomer(registeredCustomer);
        return ordersDAO.insertModel(order) != null;
    }

    @Method("고객 정보 변경")
    public void updateRowData(Object[] rowData) {
        // 선택된 데이터가 없는 경우
        if (rowData == null || rowData.length == 0) {
            JOptionPane.showMessageDialog(null, "선택된 데이터가 없습니다.", "데이터 선택 오류", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 선택된 데이터 출력
        System.out.println("선택된 데이터: " + Arrays.toString(rowData));

        // 데이터 소스에서 최신 데이터를 가져옴
        OrdersDAO ordersDAO = new OrdersDAO();
        ArrayList<OrdersDTO> orders = ordersDAO.getAllModels();
        System.out.println("orders: " + orders);

        // 테이블 데이터 설정
        Object[][] data = prepareTableData(orders);
        System.out.println("테이블 데이터: " + Arrays.deepToString(data));

        // 테이블 모델 업데이트
        //tableModel.setDataVector(data, getColumnNames());

        // 테이블 뷰 갱신
        //tableModel.fireTableDataChanged();
    }


    @Method("사용자 삭제")
    public void deleteCustomerOrder(Object[] rowData) {
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
            //AdminView adminView= AdminView.getInstance();
            AdminView adminView= AdminView.getInstance();
            adminView.createTableData();
            JOptionPane.showMessageDialog(null, "삭제되었습니다.");
        }
    }

    @Method("테이블 데이터 생성")
    public void createTableData(DefaultTableModel tableModel) {
        OrdersDAO ordersDAO = new OrdersDAO();
        ArrayList<OrdersDTO> ordersDTOS = ordersDAO.getAllModels();
        Object[][] tableData = prepareTableData(ordersDTOS);

        // 테이블 모델 업데이트
        tableModel.setDataVector(tableData, getColumnNames());

        // 테이블 뷰 갱신
        tableModel.fireTableDataChanged();
    }

    @Method("이름으로 검색")
    public void searchByName() {
        System.out.println("searchByName 호출됨");
    }

    @Method("네비게이션 메뉴")
    public ActionListener showNavigationMenu(String label, Object[] selectedRowData) {
        return e -> {
            switch (label) {
                case "정보 등록":
                    CustomerRegistration showRegistration = CustomerRegistration.getInstance();
                    showRegistration.setButtonEvent();
                    break;
                case "정보 변경":
                    customerChangeInfo = CustomerChangeInfo.getInstance();
                    customerChangeInfo.setButtonEvent();
                    break;
                case "정보 삭제":
                    deleteCustomerOrder(selectedRowData);
                    break;
                case "프로그램 종료":
                    // JOptionPane을 사용하여 확인 대화상자 표시
                    int response = JOptionPane.showConfirmDialog(null, "프로그램을 종료하시겠습니까?", "프로그램 종료 확인", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

                    // 사용자가 "OK"를 클릭했다면 프로그램 종료
                    if (response == JOptionPane.OK_OPTION) {
                        System.exit(0);
                    }
                    break;
            }
        };
    }

    @EventMethod("검색 버튼 클릭")
    public void onSubmitActionListener(ActionListener e, JTextField searchField) {
        System.out.println("onSubmitActionListener 호출됨");
        // 검색 필드의 텍스트 가져오기
        String inputText = searchField.getText();
        System.out.println("검색어: " + inputText);

        // 입력값이 비어있는지 확인
        if (inputText.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "검색어를 입력해주세요.",
                    "검색어 누락",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
    }

    @EventMethod("검색 텍스트필드 값 입력")
    public void onSearchFieldInput(String inputText) {
        System.out.println("onSearchFieldInput 호출됨");
        System.out.println("검색어: " + inputText);
    }
}