package ch10;

import javax.swing.*;
import java.awt.*;

public class JLabelEX extends JFrame {
    Container c = getContentPane();
    JLabel mylbl = new JLabel("Nice work dd");
    JButton mybtn = new JButton("버튼");
    JButton btn1,btn2,btn3;

    ImageIcon icon = new ImageIcon("/Users/clang_error/02_2.GUI/10장/test/images/baby.png");
    JLabelEX() {
        setTitle("testtset");
        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        icon = new ImageIcon(icon.getImage().getScaledInstance(200,100, Image.SCALE_DEFAULT));
        JLabel piclbl = new JLabel(icon);
        mylbl.setOpaque(true);
        mylbl.setFont(new Font("바탕체",Font.BOLD,48));
        mylbl.setForeground(Color.RED);
        mylbl.setBackground(Color.YELLOW);

        btn1 = new JButton();
        btn2 = new JButton("노랑");
        btn3 = new JButton("파랑");

        btn1.setIcon(new ImageIcon("/Users/clang_error/02_2.GUI/10장/test/images/red.jpg"));
        btn1.setRolloverIcon(new ImageIcon("/Users/clang_error/02_2.GUI/10장/test/images/yellow.jpg"));
        btn1.setPressedIcon(new ImageIcon("/Users/clang_error/02_2.GUI/10장/test/images/white.jpg"));

        btn1.addActionListener(e -> {
            c.setBackground(Color.RED);
        });
        btn2.addActionListener(e->{
            c.setBackground(Color.yellow);
        });
        btn3.addActionListener(e->{
            c.setBackground(Color.BLUE);
        });

        mybtn.addActionListener(e -> {
            if(mybtn.getText().equals("btn")) {
                mybtn.setText("버튼");
            }else
                mybtn.setText("btn");

        });

        c.add(piclbl);
        c.add(mylbl);
        c.add(mybtn);
        c.add(btn1);
        c.add(btn2);
        c.add(btn3);
        setVisible(true);
    }
    static void main() {
        new JLabelEX();
    }
}
