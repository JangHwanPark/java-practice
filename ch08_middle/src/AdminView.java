package src;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AdminView extends JFrame {
    private static final String[] BUTTON_LABELS = {"정보 등록", "정보 변경", "정보 삭제", "프로그램 종료"};
    private static final int EXAM_TABLE_ROWS = 50;
    private static final int EXAM_TABLE_COLUMNS = 7;
    private static final Color DEBUG_BACKGROUND_COLOR = Color.CYAN;

    // 생성자
    public AdminView() {
        // 프레임 설정
        setTitle("Admin View");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 컨텐트팬 설정
        Container con = getContentPane();
        con.setLayout(new BorderLayout(50, 30));
        con.setBackground(DEBUG_BACKGROUND_COLOR);

        // 각 패널 생성 및 추가
        con.add(createButtonPanel(), BorderLayout.WEST);
        con.add(createCenterPanel(), BorderLayout.CENTER);

        createButtonPanel();
        createCenterPanel();
        setVisible(true);
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        centerPanel.add(createInputPanel(), BorderLayout.NORTH);
        centerPanel.add(new JScrollPane(createTable()), BorderLayout.CENTER);

        // DebugLog
        centerPanel.setBackground(Color.BLACK);
        return centerPanel;
    }

    private JTable createTable() {
        String[] columnNames = createColumnTitles(EXAM_TABLE_COLUMNS);
        Object[][] randomData = createRandomData(EXAM_TABLE_ROWS, EXAM_TABLE_COLUMNS);
        JTable table = new JTable(randomData, columnNames);

        // JTable의 모든 컬럼을 프레임 크기에 맞추도록 설정
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        return table;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 20));
        for (String label : BUTTON_LABELS) {
            buttonPanel.add(createButton(label));
        }
        return buttonPanel;
    }

    private JButton createButton(String label) {
        return new JButton(label);
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JComboBox<>(new String[]{"Dropdown"}), BorderLayout.WEST);
        inputPanel.add(new JTextField(20), BorderLayout.CENTER);
        inputPanel.add(createButton("검색"), BorderLayout.EAST);

        // DebugLog
        inputPanel.setBackground(Color.YELLOW);
        return inputPanel;
    }

    // 중앙 패널 테이블 더미데이터 생성
    private Object[][] createRandomData(int rows, int columns) {
        Random random = new Random(); // Random 객체 생성
        Object[][] data = new Object[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 각 셀에 랜덤한 값을 할당 (Ex. 정수 범위를 0~99로 설정)
                data[i][j] = "Data" + (i+1) + "-" + (j+1) + ": " + random.nextInt(100);
            }
        }

        return data;
    }

    private String[] createColumnTitles(int columns) {
        String[] columnTitles = new String[columns];
        for (int i = 0; i < columns; i++) {
            columnTitles[i] = "컬럼 " + (i + 1);
        }
        return columnTitles;
    }

    // View 실행
    public static void main(String[] args) {
        new AdminView();
    }
}