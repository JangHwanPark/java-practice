package view;

import dao.OrdersDAO;
import models.CustomerDTO;
import models.OrdersDTO;
import view.abstractView.IView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import static controller.AdminViewController.getColumnNames;
import static controller.AdminViewController.prepareTableData;


public class AdminView extends IView {
    private static final String[] BUTTON_LABELS = {"정보 등록", "정보 변경", "정보 삭제", "프로그램 종료"};
    private CustomerDTO selectedCustomer;
    private OrdersDTO selectedOrder;


    /* *************** 생성자 *************** */
    public AdminView() {
        super("관리자 페이지", 1200, 600);
    }

    @Override
    protected void initComponents() {
        // 각 패널 생성 및 추가
        mainPanel.add(createButtonPanel(), BorderLayout.WEST);
        mainPanel.add(createCenterPanel(), BorderLayout.CENTER);
    }

    /*@Override
    protected void addComponents() {}*/


    /* *************** 중앙 패널 생성 *************** */
    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        centerPanel.add(createInputPanel(), BorderLayout.NORTH);
        centerPanel.add(new JScrollPane(createTable()), BorderLayout.CENTER);
        return centerPanel;
    }


    /* *************** 셀 클릭 이벤트 *************** */
    private void onClickCellEvent(MouseEvent e) {
        // 선택한 셀의 행번호 계산
        int row = createTable().getSelectedRow();

        if (row == -1) {
            System.out.println("유효하지 않은 행 선택");
        }

        System.out.println("클릭한 셀의 행번호: " + row);
        System.out.println("클릭한 셀의 데이터: " + createTable().getValueAt(row, 0));
    }


    /* *************** 테이블 생성 *************** */
    private JTable createTable() {
        // DAO 메소드를 호출하여 모든 고객 데이터를 가져옴.
        OrdersDAO ordersDAO = new OrdersDAO();
        ArrayList<OrdersDTO> orders = ordersDAO.getAllModels();
        Object[][] tableData = prepareTableData(orders);
        String[] columnNames = getColumnNames();

        // JTable 객체를 생성하고 초기화
        JPanel tablePanel = new JPanel();
        JTable table = new JTable(tableData, columnNames);
        tablePanel.add(table);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //onClickCellEvent(e);
                JTable target = (JTable)e.getSource();
                int row = target.rowAtPoint(e.getPoint());
                int column = target.columnAtPoint(e.getPoint());

                if (row >= 0 && column >= 0) {
                    System.out.println("Clicked value: " + target.getValueAt(row, column));
                }
            }
        });

        // JTable의 모든 컬럼을 프레임 크기에 맞추도록 설정
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        return table;
    }


    /* *************** 버튼 패널 생성 *************** */
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(new EmptyBorder(50, 20, 50, 20)); // 공통 패딩

        for (String BUTTON_LABEL : BUTTON_LABELS) {
            JButton button = createButton(BUTTON_LABEL);
            button.addActionListener(createActionListener(BUTTON_LABEL));

            buttonPanel.add(button);
            buttonPanel.add(Box.createVerticalStrut(30)); // 버튼 사이에 10 픽셀 간격 추가
            System.out.println(BUTTON_LABEL);
        }

        // 마지막 버튼 간격 제거 및 반환
        buttonPanel.remove(buttonPanel.getComponentCount() - 1);
        return buttonPanel;
    }


    /* *************** 버튼 액션 리스너 생성 *************** */
    private ActionListener createActionListener(String label) {
        return e -> {
            switch (label) {
                case "정보 등록":
                    new CustomerRegistrationView();
                    break;
                case "정보 변경":
                    new CustomerChangeInfoView();
                    break;
                case "정보 삭제":
                    DeleteView deleteView = new DeleteView();
                    deleteView.DeleteUser();
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


    /* *************** 버튼 생성 *************** */
    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setMaximumSize(new Dimension(150, 50));
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        return button;
    }


    /* *************** 입력 패널 생성 *************** */
    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JComboBox<>(new String[]{"Dropdown"}), BorderLayout.WEST);
        inputPanel.add(new JTextField(20), BorderLayout.CENTER);
        inputPanel.add(new JButton("검색"), BorderLayout.EAST);
        return inputPanel;
    }


    public static void main(String[] args) {
        new AdminView();
    }
}