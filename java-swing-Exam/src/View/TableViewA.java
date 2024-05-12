package Table;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableViewA extends JFrame {
    private JTable table;
    private TableSettingsA tableSettingsA;

    public TableViewA() {
        // TableSettingsA 클래스의 인스턴스 생성
        tableSettingsA = new TableSettingsA();
        tableSettingsA.setData("John", "Doe", 30);
        initTableData();

        add(new JScrollPane(table));
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initTableData() {
        // 데이터와 테이블 초기화
        String[] columnNames = {"First Name", "Last Name", "Age"};
        Object[][] data = {
                {"John", "Doe", 30},
                {"Jane", "Doe", 28}
        };

        table = new JTable(data, columnNames);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int row = table.getSelectedRow();
                    // 선택된 데이터를 tableSettingsA 클래스에 전달
                    tableSettingsA.setData((String) table.getValueAt(row, 0), (String) table.getValueAt(row, 1), (int) table.getValueAt(row, 2));
                }
            }
        });
    }

    public static void main(String[] args) {
        new TableViewA();
    }
}