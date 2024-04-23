import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JRadio03 extends JFrame {
    private JRadioButton[] radio = new JRadioButton[3];
    private String[] names = {"사과", "배", "체리"};
    private ImageIcon[] image = {
            new ImageIcon("ch07/src/assets/beauty.jpg"),
            new ImageIcon("ch07/src/assets/normalIcon.gif"),
            new ImageIcon("ch07/src/assets/beauty.jpg"),
    };
    private JLabel imageLabel = new JLabel();

    public JRadio03() {
        super("라디오 버튼 아이템 이벤트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        JPanel panel = new JPanel();
        ButtonGroup btng = new ButtonGroup();

        JButton jBtn = new JButton("버튼");
        JPanel btnPanel = new JPanel();
        btnPanel.add(jBtn);

        container.setLayout(new BorderLayout());
        for (int i = 0; i < radio.length; i++) {
            radio[i] = new JRadioButton(names[i]);
            radio[i].setBorderPainted(true);
            radio[i].addItemListener(new RadioItemListener());

            int finalI = i;
            radio[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("버튼 클릭: " + radio[finalI].getText());
                    jBtn.setText(radio[finalI].getText());
                }
            });

            btng.add(radio[i]);
            panel.add(radio[i]);
        }




        radio[2].setSelected(true);
        container.add(panel, BorderLayout.NORTH);
        container.add(imageLabel, BorderLayout.CENTER);
        container.add(btnPanel, BorderLayout.SOUTH);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        setSize(300, 500);
        setVisible(true);
    }

    class RadioItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            if (itemEvent.getStateChange() == ItemEvent.DESELECTED) {
                return;
            }
            if (radio[0].isSelected()) imageLabel.setIcon(image[0]);
            else if (radio[1].isSelected()) imageLabel.setIcon(image[1]);
            else imageLabel.setIcon(image[2]);
        }
    }

    public static void main(String[] args) {
        new JRadio03();
    }
}