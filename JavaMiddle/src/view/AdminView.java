package view;

import dao.OrdersDAO;
import models.OrdersDTO;
import view.abstractView.IView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import static controller.AdminViewController.getColumnNames;
import static controller.AdminViewController.prepareTableData;


public class AdminView extends IView {
    private static final String[] BUTTON_LABELS = {"정보 등록", "정보 변경", "정보 삭제", "프로그램 종료"};
    private CustomerChangeInfoView customerChangeInfoView;
    private Object[] selectedRowData;


    /* *************** 생성자 *************** */
    public AdminView() {
        super("관리자 페이지", 1200, 600);
        initComponents();
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


    /* *************** 테이블 생성 *************** */
    private JTable createTable() {
        OrdersDAO ordersDAO = new OrdersDAO();
        ArrayList<OrdersDTO> orders = ordersDAO.getAllModels();
        Object[][] tableData = prepareTableData(orders);
        String[] columnNames = getColumnNames();

        JTable table = new JTable(tableData, columnNames);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    selectedRowData = new Object[table.getColumnCount()];
                    System.out.println("createTable MouseE : " + Arrays.toString(selectedRowData));
                    for (int i = 0; i < table.getColumnCount(); i++) {
                        selectedRowData[i] = table.getValueAt(row, i);
                        System.out.println("createTable MouseE Loop : " + Arrays.toString(selectedRowData));
                    }
                }
            }
        });

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
                    JOptionPane.showMessageDialog(null, "정보등록 클릭");
                    break;
                case "정보 변경":
                    if (selectedRowData != null) {
                        if (customerChangeInfoView == null) {  // 인스턴스가 null일 경우에만 새로 생성
                            customerChangeInfoView = new CustomerChangeInfoView();
                        }
                        customerChangeInfoView.displayRowDataInInputFields(selectedRowData);
                        customerChangeInfoView.setVisible(true);  // 사용자가 버튼을 클릭했을 때만 창을 보이게 함
                    } else {
                        JOptionPane.showMessageDialog(null, "변경할 데이터를 선택해주세요.", "변경할 데이터 선택", JOptionPane.WARNING_MESSAGE);
                    }
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
        JButton submitButton = new JButton("검색");
        JTextField searchField = new JTextField(20);

        // 검색 입력 필드
        inputPanel.add(new JComboBox<>(new String[]{"Dropdown"}), BorderLayout.WEST);
        inputPanel.add(searchField, BorderLayout.CENTER);
        searchField.addKeyListener(userInputKeyListener());

        // 검색 버튼
        inputPanel.add(submitButton, BorderLayout.EAST);
        submitButton.addActionListener(onSubmitActionListener());
        return inputPanel;
    }

    private KeyListener userInputKeyListener() {
        return new KeyListener() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                System.out.println("키 입력됨");
            }

            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                System.out.println("키 눌림");
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                System.out.println("키 놓임");
            }
        };
    }

    private ActionListener onSubmitActionListener() {
        return e -> {
            JOptionPane.showMessageDialog(null, "검색버튼 클릭", "검색", JOptionPane.INFORMATION_MESSAGE);
        };
    }


    public static void main(String[] args) {
        new AdminView();
    }
}