package mtest;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sales extends JFrame {
    Container c = getContentPane();

    JPanel fruitPanel = new JPanel();
    JPanel countPanel = new JPanel();
    JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JCheckBox appleCheck = new JCheckBox("사과");
    JCheckBox pearCheck = new JCheckBox("배");
    JCheckBox peachCheck = new JCheckBox("복숭아");

    JRadioButton r1 = new JRadioButton("1", true);
    JRadioButton r2 = new JRadioButton("2");
    JRadioButton r3 = new JRadioButton("3");
    JRadioButton r4 = new JRadioButton("4");
    JRadioButton r5 = new JRadioButton("5");

    JButton calcBtn = new JButton("계산하기");
    JLabel totalLabel = new JLabel("합계 금액: 0", SwingConstants.CENTER);

    public Sales() {
        setTitle("Sales");
        //교수님께 질의 후 550으로 설정, OS 폰트 차이로 발생하는 문제같아보임
        setSize(550, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c.setLayout(new BorderLayout());

        fruitPanel.setBorder(new TitledBorder("과일선택"));
        fruitPanel.add(appleCheck);
        fruitPanel.add(pearCheck);
        fruitPanel.add(peachCheck);

        countPanel.setBorder(new TitledBorder("개수"));
        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);
        group.add(r5);
        countPanel.add(r1);
        countPanel.add(r2);
        countPanel.add(r3);
        countPanel.add(r4);
        countPanel.add(r5);

        topPanel.add(fruitPanel);
        topPanel.add(countPanel);
        topPanel.add(calcBtn);

        totalLabel.setFont(new Font(totalLabel.getFont().getName(), Font.BOLD, 48));
        totalLabel.setHorizontalAlignment(SwingConstants.CENTER);

        c.add(topPanel, BorderLayout.NORTH);
        c.add(totalLabel, BorderLayout.CENTER);

        calcBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int qty = 1;
                if (r2.isSelected()) qty = 2;
                else if (r3.isSelected()) qty = 3;
                else if (r4.isSelected()) qty = 4;
                else if (r5.isSelected()) qty = 5;

                int sum = 0;
                if (appleCheck.isSelected()) sum += 5000;
                if (pearCheck.isSelected()) sum += 2000;
                if (peachCheck.isSelected()) sum += 3000;

                totalLabel.setText("합계 금액: " + (sum * qty));
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Sales();
    }
}
