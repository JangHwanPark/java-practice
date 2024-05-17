package view;

import controller.AdminViewController;
import models.OrdersDAO;
import utils.EventMethod;
import utils.Field;
import utils.Method;

import javax.management.ConstructorParameters;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;

import static controller.AdminViewController.getColumnNames;
import static controller.AdminViewController.prepareTableData;


public class AdminView extends IView {
    @Field("instance")
    private  static AdminView instance;
    private static final String[] BUTTON_LABELS = {"정보 등록", "정보 변경", "정보 삭제", "프로그램 종료"};

    private Object[] selectedRowData;
    private JPanel centerPanel, inputPanel, buttonPanel;
    JComboBox<String> comboBox;
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
        comboBox = new JComboBox<>(new String[]{"전체","이름","전화번호"});
        inputPanel.add(comboBox, BorderLayout.WEST);
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
        // 검색 버튼
        submitButton.addActionListener(e -> {
            controller.onSubmitActionListener(searchField);
        });

        // 테이블 행 선택 이벤트 리스너
        table.getSelectionModel().addListSelectionListener(e ->{
            controller.onTableDataClicked(e, table, selectedRowData);
        });

        // 콤보박스
        comboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selected = (String) e.getItem();
                controller.onComboBoxSelected(selected, searchField);
            }
        });
    }

    public static void main(String[] args) {
        new AdminView();
    }
}