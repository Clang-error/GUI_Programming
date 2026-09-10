package ch09;

import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame {
    Container c = getContentPane();
    JButton[] btn = new JButton[25];
    GridLayoutEx() {
        setTitle("GridLayout test");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(new GridLayout());

        for(int i=0; i<btn.length;i++) {
            btn[i]=new JButton(i+"");
            c.add(btn[i]);
        }



        setVisible(true);
    }

    static void main() {
        GridLayoutEx myGrid = new GridLayoutEx();
    }
}
