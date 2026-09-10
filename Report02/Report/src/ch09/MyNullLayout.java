package ch09;

import javax.swing.*;
import java.awt.*;

public class MyNullLayout extends JFrame {
    Container c = getContentPane();
    JButton[] btn = new JButton[2];
    String[] setBtn ={"Push button","Toggle"};
    public MyNullLayout() {
        setTitle("mynull");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(null); //레이아웃을 널로 지정
        c.setBackground(new Color(191, 108, 108));
        setResizable(false);

        for (int i = 0; i<btn.length; i++) {
            btn[i] = new JButton(setBtn[i]);
        }

        //1번 버튼
        btn[0].setBounds(100,100,120,50);

        //2번 버튼
        btn[1].setBounds(250,100,120,50);

        c.add(btn[0]);
        c.add(btn[1]);
        setVisible(true);
    }

    static void main() {
        MyNullLayout myLayout = new MyNullLayout();
    }
}
