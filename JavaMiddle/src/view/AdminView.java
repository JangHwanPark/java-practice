package view;

import controller.CustomerController;
import models.CustomerDTO;
import utils.DummyData;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import static controller.CustomerController.getColumnNames;
import static dao.CustomerDAO.selectCustomerAll;

public class AdminView extends IView {
    private static final String[] BUTTON_LABELS = {"정보 등록", "정보 변경", "정보 삭제", "프로그램 종료"};

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

    @Override
    protected void addComponents() {}


    /* *************** 중앙 패널 생성 *************** */
    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        centerPanel.add(createInputPanel(), BorderLayout.NORTH);
        centerPanel.add(new JScrollPane(createTable()), BorderLayout.CENTER);
        return centerPanel;
    }


    /* *************** 테이블 생성 *************** */
    private JTable createTable() {
        // DAO 메소드를 호출하여 모든 고객 데이터를 가져옴.
        ArrayList<CustomerDTO> customers = null;
        try {
            customers = selectCustomerAll();
            JOptionPane.showMessageDialog(null, "전체 사용자 조회 작업이 완료되었습니다.");
        } catch (SQLException e) {
            e.getStackTrace();
            JOptionPane.showMessageDialog(null, "데이터 조회중 오류가 발생했습니다.");
            return null;
        }

        Object[][] tableData = CustomerController.prepareTableData(customers);
        String[] columnNames = getColumnNames();

        // JTable 객체를 생성하고 초기화
        JPanel tablePanel = new JPanel();
        JTable table = new JTable(tableData, columnNames);
        tablePanel.add(table);

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
            buttonPanel.add(createButton(BUTTON_LABEL));
            buttonPanel.add(Box.createVerticalStrut(30)); // 버튼 사이에 10 픽셀 간격 추가
        }

        // 마지막 버튼 간격 제거 및 반환
        buttonPanel.remove(buttonPanel.getComponentCount() - 1);
        return buttonPanel;
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