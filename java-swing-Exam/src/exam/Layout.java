package exam;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Layout extends JFrame {
    public Layout() {
        // JFrame 초기화 및 컴포넌트 설정
        initComponents();
        // JFrame을 화면에 보이게 설정
        setVisible(true);
    }

    public void initComponents() {
        // JFrame 설정
        setTitle("레이아웃"); // 창의 제목 설정
        setSize(300, 400); // 창의 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 동작 설정
        setLocationRelativeTo(null); // 창을 화면의 중앙에 배치

        // JFrame의 컨텐츠 패널에 BorderLayout 배치관리자 설정
        getContentPane().setLayout(new BorderLayout());

        // panel1을 생성하고 GridBagLayout 배치관리자 설정
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setBackground(Color.BLACK); // 배경색을 검정색으로 설정

        // GridBagConstraints 생성 및 기본 설정
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5, 5, 5, 5); // 컴포넌트 주위의 여백 설정
        gridBagConstraints.weightx = 1.0; // 가로 방향의 가중치 설정
        gridBagConstraints.weighty = 1.0; // 세로 방향의 가중치 설정
        gridBagConstraints.fill = GridBagConstraints.BOTH; // 셀의 전체 공간을 채우도록 설정

        // Panel1에 셀 경계를 시각화하기 위한 라벨 추가
        gridBagConstraints.gridx = 0; // 첫 번째 열
        gridBagConstraints.gridy = 0; // 첫 번째 행
        JLabel label1 = new JLabel("0,0"); // 셀의 위치를 표시하는 라벨 생성
        label1.setBorder(new LineBorder(Color.WHITE)); // 라벨에 흰색 경계선 추가
        label1.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        label1.setForeground(Color.WHITE); // 라벨 텍스트 색상을 흰색으로 설정
        panel1.add(label1, gridBagConstraints); // 패널에 라벨 추가

        gridBagConstraints.gridx = 1; // 두 번째 열
        gridBagConstraints.gridy = 0; // 첫 번째 행
        JLabel label2 = new JLabel("1,0"); // 셀의 위치를 표시하는 라벨 생성
        label2.setBorder(new LineBorder(Color.WHITE)); // 라벨에 흰색 경계선 추가
        label2.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        label2.setForeground(Color.WHITE); // 라벨 텍스트 색상을 흰색으로 설정
        panel1.add(label2, gridBagConstraints); // 패널에 라벨 추가

        gridBagConstraints.gridx = 0; // 첫 번째 열
        gridBagConstraints.gridy = 1; // 두 번째 행
        gridBagConstraints.gridwidth = 2; // 두 열에 걸쳐 배치
        JLabel label3 = new JLabel("0,1"); // 셀의 위치를 표시하는 라벨 생성
        label3.setBorder(new LineBorder(Color.WHITE)); // 라벨에 흰색 경계선 추가
        label3.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        label3.setForeground(Color.WHITE); // 라벨 텍스트 색상을 흰색으로 설정
        panel1.add(label3, gridBagConstraints); // 패널에 라벨 추가

        // panel1을 JFrame의 BorderLayout.NORTH 영역에 추가
        getContentPane().add(panel1, BorderLayout.NORTH);

        // panel2 생성 및 설정
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE); // 배경색을 파란색으로 설정
        getContentPane().add(panel2, BorderLayout.CENTER); // panel2를 JFrame의 중앙 영역에 추가

        // panel4 생성 및 설정
        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.YELLOW); // 배경색을 노란색으로 설정
        getContentPane().add(panel4, BorderLayout.WEST); // panel4를 JFrame의 서쪽 영역에 추가

        // panel5 생성 및 설정
        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.GREEN); // 배경색을 녹색으로 설정
        getContentPane().add(panel5, BorderLayout.EAST); // panel5를 JFrame의 동쪽 영역에 추가

        // panel6을 생성하고 GridBagLayout 배치관리자 설정
        JPanel panel6 = new JPanel();
        panel6.setLayout(new GridBagLayout());
        panel6.setBackground(Color.ORANGE); // 배경색을 주황색으로 설정
        getContentPane().add(panel6, BorderLayout.SOUTH); // panel6을 JFrame의 남쪽 영역에 추가

        // Panel6에 셀 경계를 시각화하기 위한 라벨 추가
        gridBagConstraints.gridx = 0; // 첫 번째 열
        gridBagConstraints.gridy = 0; // 첫 번째 행
        gridBagConstraints.gridwidth = 1; // 기본으로 돌려놓기 (한 셀만 차지하도록)
        JLabel label4 = new JLabel("0,0"); // 셀의 위치를 표시하는 라벨 생성
        label4.setBorder(new LineBorder(Color.BLACK)); // 라벨에 검정색 경계선 추가
        label4.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        panel6.add(label4, gridBagConstraints); // 패널에 라벨 추가

        gridBagConstraints.gridx = 1; // 두 번째 열
        gridBagConstraints.gridy = 0; // 첫 번째 행
        JLabel label5 = new JLabel("1,0"); // 셀의 위치를 표시하는 라벨 생성
        label5.setBorder(new LineBorder(Color.BLACK)); // 라벨에 검정색 경계선 추가
        label5.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        panel6.add(label5, gridBagConstraints); // 패널에 라벨 추가

        gridBagConstraints.gridx = 2; // 세 번째 열
        gridBagConstraints.gridy = 0; // 첫 번째 행
        JLabel label6 = new JLabel("2,0"); // 셀의 위치를 표시하는 라벨 생성
        label6.setBorder(new LineBorder(Color.BLACK)); // 라벨에 검정색 경계선 추가
        label6.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        panel6.add(label6, gridBagConstraints); // 패널에 라벨 추가

        gridBagConstraints.gridx = 0; // 첫 번째 열
        gridBagConstraints.gridy = 1; // 두 번째 행
        JLabel label7 = new JLabel("0,1"); // 셀의 위치를 표시하는 라벨 생성
        label7.setBorder(new LineBorder(Color.BLACK)); // 라벨에 검정색 경계선 추가
        label7.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        panel6.add(label7, gridBagConstraints); // 패널에 라벨 추가

        gridBagConstraints.gridx = 1; // 두 번째 열
        gridBagConstraints.gridy = 1; // 두 번째 행
        JLabel label8 = new JLabel("1,1"); // 셀의 위치를 표시하는 라벨 생성
        label8.setBorder(new LineBorder(Color.BLACK)); // 라벨에 검정색 경계선 추가
        label8.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        panel6.add(label8, gridBagConstraints); // 패널에 라벨 추가

        gridBagConstraints.gridx = 2; // 세 번째 열
        gridBagConstraints.gridy = 1; // 두 번째 행
        JLabel label9 = new JLabel("2,1"); // 셀의 위치를 표시하는 라벨 생성
        label9.setBorder(new LineBorder(Color.BLACK)); // 라벨에 검정색 경계선 추가
        label9.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        panel6.add(label9, gridBagConstraints); // 패널에 라벨 추가

        gridBagConstraints.gridx = 0; // 첫 번째 열
        gridBagConstraints.gridy = 2; // 세 번째 행
        JLabel label10 = new JLabel("0,2"); // 셀의 위치를 표시하는 라벨 생성
        label10.setBorder(new LineBorder(Color.BLACK)); // 라벨에 검정색 경계선 추가
        label10.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        panel6.add(label10, gridBagConstraints); // 패널에 라벨 추가

        gridBagConstraints.gridx = 1; // 두 번째 열
        gridBagConstraints.gridy = 2; // 세 번째 행
        JLabel label11 = new JLabel("1,2"); // 셀의 위치를 표시하는 라벨 생성
        label11.setBorder(new LineBorder(Color.BLACK)); // 라벨에 검정색 경계선 추가
        label11.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        panel6.add(label11, gridBagConstraints); // 패널에 라벨 추가

        gridBagConstraints.gridx = 2; // 세 번째 열
        gridBagConstraints.gridy = 2; // 세 번째 행
        JLabel label12 = new JLabel("2,2"); // 셀의 위치를 표시하는 라벨 생성
        label12.setBorder(new LineBorder(Color.BLACK)); // 라벨에 검정색 경계선 추가
        label12.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        panel6.add(label12, gridBagConstraints); // 패널에 라벨 추가

        gridBagConstraints.gridx = 0; // 첫 번째 열
        gridBagConstraints.gridy = 3; // 네 번째 행
        gridBagConstraints.gridwidth = 2; // 두 열에 걸쳐 배치
        JLabel label13 = new JLabel("0,3, 1,3"); // 셀의 위치를 표시하는 라벨 생성
        label13.setBorder(new LineBorder(Color.BLACK)); // 라벨에 검정색 경계선 추가
        label13.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        panel6.add(label13, gridBagConstraints); // 패널에 라벨 추가

        gridBagConstraints.gridx = 2; // 세 번째 열
        gridBagConstraints.gridy = 3; // 네 번째 행
        gridBagConstraints.gridwidth = 1; // 기본으로 돌려놓기 (한 셀만 차지하도록)
        gridBagConstraints.insets = new Insets(10, 10, 10, 10); // 컴포넌트 주위의 여백 설정
        JLabel label14 = new JLabel("2,3"); // 셀의 위치를 표시하는 라벨 생성
        label14.setBorder(new LineBorder(Color.BLACK)); // 라벨에 검정색 경계선 추가
        label14.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        panel6.add(label14, gridBagConstraints); // 패널에 라벨 추가

        gridBagConstraints.gridx = 0; // 첫 번째 열
        gridBagConstraints.gridy = 4; // 다섯 번째 행
        gridBagConstraints.gridwidth = 3; // 세 열에 걸쳐 배치
        gridBagConstraints.insets = new Insets(10, 20, 30, 40);
        JLabel label15 = new JLabel("0,4, 1,4, 2,4"); // 셀의 위치를 표시하는 라벨 생성
        label15.setBorder(new LineBorder(Color.BLACK)); // 라벨에 검정색 경계선 추가
        label15.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        panel6.add(label15, gridBagConstraints); // 패널에 라벨 추가

        gridBagConstraints.gridx = 0; // 첫 번째 열
        gridBagConstraints.gridy = 5; // 여섯 번째 행
        gridBagConstraints.gridwidth = 1; // 기본으로 돌려놓기 (한 셀만 차지하도록)
        gridBagConstraints.insets = new Insets(10, 10, 10, 10); // 컴포넌트 주위의 여백 설정
        JLabel label16 = new JLabel("0,5"); // 셀의 위치를 표시하는 라벨 생성
        label16.setBorder(new LineBorder(Color.BLACK)); // 라벨에 검정색 경계선 추가
        label16.setHorizontalAlignment(SwingConstants.CENTER); // 라벨 텍스트를 가운데 정렬
        panel6.add(label16, gridBagConstraints); // 패널에 라벨 추가

        gridBagConstraints.gridx = 1; // 두 번째 열
        gridBagConstraints.gridy = 5; // 여섯 번째 행
        gridBagConstraints.gridwidth = 2; // 두 열에 걸쳐 배치
        JTextField textField = new JTextField("1,5, 2,5"); // 셀의 위치를 표시하는 텍스트 필드 생성
        textField.setBorder(new LineBorder(Color.BLACK)); // 텍스트 필드에 검정색 경계선 추가
        textField.setHorizontalAlignment(SwingConstants.CENTER); // 텍스트 필드 텍스트를 가운데 정렬
        panel6.add(textField, gridBagConstraints); // 패널에 텍스트 필드 추가
    }

    public static void main(String[] args) {
        // Layout 클래스의 인스턴스를 생성하여 프로그램 실행
        new Layout();
    }
}