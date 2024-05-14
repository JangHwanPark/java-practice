/*
package view.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ButtonPanel {
    JPanel buttonPanel;

    public ButtonPanel() {
        buttonPanel = new JPanel();
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
}*/