package SwingComponents;

import javax.swing.*;

public class NavigationMenu extends JFrame {
    public NavigationMenu() {
        this.setTitle("자바 스윙 상단 메뉴");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createMenu();           // 메뉴 생성 메서드 실행
        this.setVisible(true);  // 윈도우 출력 여부
    }

    public void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        // 메뉴 이름 지정
        JMenu mainMenu = new JMenu("메인 메뉴");
        JMenu subMenu = new JMenu("서브 메뉴");

        // 메뉴 아이템 추가
        mainMenu.add(new JMenuItem("MainMenu"));
        subMenu.add(new JMenuItem("SubMenu"));

        menuBar.add(mainMenu);
        menuBar.add(subMenu);

        // 메인 프레임에 메뉴바 붙이기
        this.setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        new NavigationMenu();
    }
}