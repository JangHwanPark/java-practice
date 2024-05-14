package view.abstractView;

import javax.swing.*;
import java.awt.*;

public abstract class IView extends JFrame {
    protected JPanel mainPanel;
    
    public IView(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);  // 기본 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // 창을 화면 중앙에 배치
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        getContentPane().add(mainPanel);
        initComponents();  // 컴포넌트 초기화
        //addComponents();  // 패널에 컴포넌트 추가
        setVisible(true);
    }

    protected abstract void initComponents();
    //protected abstract void addComponents();
}