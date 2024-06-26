package view.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InputPanel extends JPanel {
    private final JLabel label;
    private final JTextField textField;

    public InputPanel(String labelText, int width, int height, int padding, Font font) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(new EmptyBorder(10, 0, 10, 0));

        label = new JLabel(labelText);
        label.setBorder(new EmptyBorder(0, 0, 0, padding));
        label.setFont(font);

        textField = new JTextField();
        Dimension size = new Dimension(width, height);
        textField.setBackground(Color.WHITE);
        textField.setPreferredSize(size);
        textField.setMinimumSize(size);
        textField.setMaximumSize(size);
        textField.setFont(font);

        add(label, BorderLayout.WEST);
        add(textField, BorderLayout.CENTER);
    }

    public String getText() {
        return textField.getText();
    }
}