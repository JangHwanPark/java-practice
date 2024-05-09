import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Random;

public class AdminView extends JFrame {
    private static final String[] BUTTON_LABELS = {"정보 등록", "정보 변경", "정보 삭제", "프로그램 종료"};
    private static final int EXAM_TABLE_ROWS = 50;
    private static final int EXAM_TABLE_COLUMNS = 7;

    // 생성자
    public AdminView() {
        // 프레임 설정
        setTitle("Admin View");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 컨텐트팬 설정
        Container con = getContentPane();
        con.setLayout(new BorderLayout(0, 0));

        // 각 패널 생성 및 추가
        con.add(createButtonPanel(), BorderLayout.WEST);
        con.add(createCenterPanel(), BorderLayout.CENTER);

        createButtonPanel();
        createCenterPanel();
        setVisible(true);
    }

    // 중앙 패널 생성
    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        centerPanel.add(createInputPanel(), BorderLayout.NORTH);
        centerPanel.add(new JScrollPane(createTable()), BorderLayout.CENTER);
        return centerPanel;
    }

    // 테이블 생성
    private JTable createTable() {
        String[] columnNames = createColumnTitles(EXAM_TABLE_COLUMNS);
        Object[][] randomData = createRandomData(EXAM_TABLE_ROWS, EXAM_TABLE_COLUMNS);
        JPanel tablePanel = new JPanel();
        JTable table = new JTable(randomData, columnNames);
        tablePanel.add(table);

        // JTable의 모든 컬럼을 프레임 크기에 맞추도록 설정
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        return table;
    }

    // 버튼 패널 생성
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(new EmptyBorder(50, 20, 50, 20)); // 공통 패딩

        for (int i = 0; i < BUTTON_LABELS.length; i++) {
            JButton button = new JButton(BUTTON_LABELS[i]);
            button.setMaximumSize(new Dimension(150, 50));
            button.setAlignmentX(Component.LEFT_ALIGNMENT);
            buttonPanel.add(button);

            // 마지막 버튼에는 간격 추가하지 않음
            if (i < BUTTON_LABELS.length - 1) {
                buttonPanel.add(Box.createVerticalStrut(30)); // 버튼 사이에 10 픽셀 간격 추가
            }
        }
        return buttonPanel;
    }

    // 입력 패널 생성
    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JComboBox<>(new String[]{"Dropdown"}), BorderLayout.WEST);
        inputPanel.add(new JTextField(20), BorderLayout.CENTER);
        inputPanel.add(new JButton("검색"), BorderLayout.EAST);
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

    // 테이블 컬럼 제목 생성
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