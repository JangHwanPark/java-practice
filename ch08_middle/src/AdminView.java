import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AdminView extends JFrame {
    Container con;
    JPanel centerPanel;
    
    // 생성자
    public AdminView() {
        initFrame("Admin View");
        configContent();
        createButtonPanel();
        createCenterPanel();
        setVisible(true);
    }

    // 기본 설정
    public void initFrame(String title) {
        setTitle(title);
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 컨텐트팬 설정
    public void configContent() {
        con = getContentPane();
        con.setLayout(new BorderLayout(50, 30));
        con.setBackground(Color.CYAN);
    }

    // 중앙 패널 테이블 더미데이터 생성
    public Object[][] createRandomData(int rows, int columns) {
        Random random = new Random(); // Random 객체 생성
        Object[][] data = new Object[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 각 셀에 랜덤한 값을 할당
                // 예를 들어, 정수 범위를 0~99로 설정
                data[i][j] = "Data" + (i+1) + "-" + (j+1) + ": " + random.nextInt(100);
            }
        }

        return data;
    }

    public String[] createDataTitle(int columns) {
        String[] column = new String[columns];

        for (int i = 0; i < columns; i++) {
            column[i] = "이름 " + (i + 1);
        }

        return column;
    }

    // 중앙 패널 추가 (사용자 정보, 검색 필드, 테이블)
    public void createCenterPanel() {
        // 중앙 패널 생성
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // 상단 입력 패널 추가
        createInputPanel(centerPanel);

        // 테이블 데이터와 컬럼 이름을 위한 임시 데이터
        String[] columnNames = createDataTitle(7);
        Object[][] randomData = createRandomData(50, 7);

        // 테이블 생성
        JTable table = new JTable(randomData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        centerPanel.add(scrollPane, BorderLayout.CENTER); // 테이블을 중앙에 추가

        // 메인 컨테이너에 중앙 패널 추가
        con.add(centerPanel, BorderLayout.CENTER);

        // DebugLog
        centerPanel.setBackground(Color.black);
    }

    // 버튼 패널 추가
    public void createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

        String[] buttonArray = {"정보 등록", "정보 변경", "정보 삭제", "프로그램 종료"};
        for (String btnStr : buttonArray) {
            JButton button = new JButton(btnStr);
            buttonPanel.add(button);
        }

        con.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public void createInputPanel(JPanel centerPanel) {
        // 입력 패널 생성
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Dropdown"});
        JTextField textField = new JTextField(20);
        JButton searchButton = new JButton("검색");

        inputPanel.add(comboBox, BorderLayout.WEST);
        inputPanel.add(textField, BorderLayout.CENTER);
        inputPanel.add(searchButton, BorderLayout.EAST);
        centerPanel.add(inputPanel, BorderLayout.NORTH);

        // DebugLog
        inputPanel.setBackground(Color.yellow);
    }

    // View 실행
    public static void main(String[] args) {
        new AdminView();
    }
}