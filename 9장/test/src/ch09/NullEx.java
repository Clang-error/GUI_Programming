package ch09;

import javax.swing.*;
import java.awt.*;

public class NullEx extends JFrame {
    public NullEx() {
        setTitle("NullEX");
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel mylbl =new JLabel("Test");
        mylbl.setBounds(100,100,200,100);
        mylbl.setOpaque(true);
        mylbl.setBackground(Color.BLUE);
        mylbl.setFont(new Font("",Font.BOLD,48));

        add(mylbl);
        setVisible(true);
    }

    public static void main() {
        NullEx myEx = new NullEx();
    }
}
