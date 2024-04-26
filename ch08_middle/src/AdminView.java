import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame {
    Container con;
    JPanel centerPanel;
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

    // 좌측 버튼 패널 추가
    public void createButtonPanel() {
        // GridBagLayout을 가진 JPanel을 생성
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // 간격 설정

        // 버튼을 생성하고 크기를 설정
        JButton changeButton = new JButton("정보 변경");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttonPanel.add(changeButton, gbc);

        JButton registerButton = new JButton("정보 등록");
        gbc.gridy = 1;
        buttonPanel.add(registerButton, gbc);

        JButton deleteButton = new JButton("정보 삭제");
        gbc.gridy = 2;
        buttonPanel.add(deleteButton, gbc);

        JButton exitButton = new JButton("종료");
        gbc.gridy = 3;
        buttonPanel.add(exitButton, gbc);

        // 패널을 컨테이너에 추가
        con.add(buttonPanel, BorderLayout.WEST);
    }

    // 중앙 패널 추가 (사용자 정보, 검색 필드, 테이블)
    public void createCenterPanel() {
        // 중앙 패널 생성
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // 상단 입력 패널 추가
        createInputPanel(centerPanel);

        // 테이블 데이터와 컬럼 이름을 위한 임시 데이터
        String[] columnNames = {"Column 1", "Column 2", "Column 3", "Column 4"};
        Object[][] data = {
                {"Data1-1", "Data1-2", "Data1-3", "Data1-4"},
                {"Data2-1", "Data2-2", "Data2-3", "Data2-4"},
                {"Data3-1", "Data3-2", "Data3-3", "Data3-4"},
                // 더 많은 데이터...
        };

        // 테이블 생성
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        centerPanel.add(scrollPane, BorderLayout.CENTER); // 테이블을 중앙에 추가

        // 메인 컨테이너에 중앙 패널 추가
        con.add(centerPanel, BorderLayout.CENTER);

        // DebugLog
        centerPanel.setBackground(Color.black);
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

    public void createShowUserPanel() {

    }

    // View 실행
    public static void main(String[] args) {
        new AdminView();
    }
}