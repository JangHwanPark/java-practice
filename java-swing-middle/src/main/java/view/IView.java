package view;

import javax.swing.*;

public abstract class IView extends JFrame {
    protected JPanel mainPanel;
    
    public IView(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);  // 기본 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // 창을 화면 중앙에 배치
    }

    protected abstract void initMainPanel();

    protected abstract void initComponents();
}