package exam;

import javax.swing.*;
import java.awt.*;

public class Paper extends JFrame {
    public Paper() {
        setTitle("Java Swing UI Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // 레이블
        JLabel label = new JLabel("Label");
        add(label);

        // 버튼
        JButton button = new JButton("Button");
        add(button);

        // 체크박스
        JCheckBox checkBox = new JCheckBox("Checkbox");
        add(checkBox);

        // 라디오버튼
        JRadioButton radioButton1 = new JRadioButton("Radio Button 1");
        JRadioButton radioButton2 = new JRadioButton("Radio Button 2");
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButton1);
        radioButtonGroup.add(radioButton2);
        JPanel radioPanel = new JPanel();
        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);
        add(radioPanel);

        // 텍스트필드
        JTextField textField = new JTextField(10);
        add(textField);

        // 텍스트에어리어
        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane textAreaScrollPane = new JScrollPane(textArea);
        add(textAreaScrollPane);

        // 리스트
        String[] listData = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        JList<String> list = new JList<>(listData);
        JScrollPane listScrollPane = new JScrollPane(list);
        add(listScrollPane);

        // 콤보박스
        String[] comboBoxData = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"};
        JComboBox<String> comboBox = new JComboBox<>(comboBoxData);
        add(comboBox);

        // 슬라이더
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        add(slider);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Paper();
    }
}