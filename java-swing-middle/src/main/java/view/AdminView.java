package view;

import controller.AdminViewController;
import dao.OrdersDAO;
import models.OrdersDTO;
import utils.EventMethod;
import utils.Field;
import utils.Method;
import view.abstractView.IView;

import javax.management.ConstructorParameters;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import static controller.AdminViewController.getColumnNames;
import static controller.AdminViewController.prepareTableData;


public class AdminView extends IView {
    @Field("instance")
    private  static AdminView instance;
    private static final String[] BUTTON_LABELS = {"정보 등록", "정보 변경", "정보 삭제", "프로그램 종료"};

    private Object[] selectedRowData;
    private JPanel centerPanel, inputPanel, buttonPanel;
    private JTable table;
    private JButton submitButton, button;
    private JTextField searchField;
    private DefaultTableModel tableModel;
    private AdminViewController controller;

    @ConstructorParameters({"title", "width", "height"})
    private AdminView() {
        super("관리자 페이지", 1200, 600);
        controller = new AdminViewController();
        initMainPanel();
        initComponents();
        connectEvents();
        setVisible(true);
    }

    @Method("getInstance")
    public static AdminView getInstance() {
        if (instance == null) instance = new AdminView();
        return instance;
    }

    @Override
    protected void initMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        getContentPane().add(mainPanel);
    }

    @Override
    protected void initComponents() {
        // 버튼 패널 생성
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(new EmptyBorder(50, 20, 50, 20));

        for (String BUTTON_LABEL : BUTTON_LABELS) {
            button = new JButton(BUTTON_LABEL);
            button.setMaximumSize(new Dimension(150, 50));
            button.setAlignmentX(Component.LEFT_ALIGNMENT);
            button.addActionListener(controller.showNavigationMenu(BUTTON_LABEL, selectedRowData));

            buttonPanel.add(button);
            buttonPanel.add(Box.createVerticalStrut(30));
        }

        // 마지막 버튼 간격 제거 및 반환
        buttonPanel.remove(buttonPanel.getComponentCount() - 1);
        mainPanel.add(buttonPanel, BorderLayout.WEST);

        // 입력 패널 생성
        inputPanel = new JPanel(new BorderLayout());
        searchField = new JTextField(20);
        submitButton = new JButton("검색");

        // 패널에 부착
        inputPanel.add(new JComboBox<>(new String[]{"전체","이름","전화번호"}), BorderLayout.WEST);
        inputPanel.add(searchField, BorderLayout.CENTER);
        inputPanel.add(submitButton, BorderLayout.EAST);

        // 테이블 생성
        tableModel = new DefaultTableModel(prepareTableData(new OrdersDAO().getAllModels()), getColumnNames());
        table = new JTable(tableModel);
        createTableData();

        // 중앙 패널 생성
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        centerPanel.add(inputPanel, BorderLayout.NORTH);
        centerPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
    }

    @Method("테이블 생성")
    public void createTableData() {
        controller.createTableData(tableModel);
    }

    @Method("이벤트 연결")
    public void connectEvents() {
        submitButton.addActionListener(e -> onSubmitActionListener(e, searchField));

        // 테이블 행 선택 이벤트 리스너
        table.getSelectionModel().addListSelectionListener(this::onTableDataClicked);

        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                controller.onSearchFieldInput(String.valueOf(e.getKeyChar()));
            }
        });
    }

    @EventMethod("테이블 데이터 클릭")
    private void onTableDataClicked(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {         // 이벤트가 두 번 발생하는 것을 방지
            if (table.getSelectedRow() != -1) { // 선택된 행이 있는지 확인
                int selectedRow = table.getSelectedRow();
                selectedRowData = new Object[table.getColumnCount()];

                for (int i = 0; i < table.getColumnCount(); i++) {
                    selectedRowData[i] = table.getValueAt(selectedRow, i);
                }

                // 선택된 행의 데이터를 콘솔에 출력
                controller.updateRowData(selectedRowData);
            }
        }
    }

    @EventMethod("검색 버튼 클릭")
    private void onSubmitActionListener(ActionEvent e, JTextField searchField) {
        controller.onSubmitActionListener((ActionListener) e, searchField);
    }

    public static void main(String[] args) {
        new AdminView();
    }
}