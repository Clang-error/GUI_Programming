package ch09;

import javax.swing.*;
import java.awt.*;

public class GridLayout extends JFrame {
    Container c = getContentPane();
    JButton[] btn=new JButton[25];
    JPanel pnl = new JPanel();

    public GridLayout() {
        setTitle("GirdLayout");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pnl.setLayout(new java.awt.GridLayout(5,5));
        c.setBackground(Color.ORANGE);

        for (int i = 0; i<btn.length; i++) {
            btn[i]=new JButton((i+1)+" ");
            btn[i].setFont(new Font("",Font.PLAIN,24));
            pnl.add(btn[i]);
        }

        pnl.setBackground(Color.ORANGE);

        c.add(pnl);
        setVisible(true);
    }

    static void main() {
        GridLayout myGrid = new GridLayout();
    }
}
