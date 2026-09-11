package ch09;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx extends JFrame {
    Container c = getContentPane();
    JPanel northPnl = new JPanel();
    JPanel southPnl = new JPanel();
    JPanel centerPnl = new JPanel();
    JButton[] btn = new JButton[25];
    BorderLayoutEx() {
        setTitle("BorderLayout test");

        //실행 시 폭이 좁아 글이 짤리는 현상이 발생하여 폭을 넓힘
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //border 레이아웃 사용
        c.setLayout(new BorderLayout(5,5));
        
        //백그라운드 색상 세팅
        northPnl.setBackground(Color.YELLOW);
        southPnl.setBackground(Color.YELLOW);
        
        //버튼 생성 및 추가
        for (int i=0; i<btn.length; i++) {
            btn[i] = new JButton((i+1)+"");
            if(i<5) {
                northPnl.add(btn[i]);
            } else if (i<=19) {
                centerPnl.add(btn[i]);
            } else {
                southPnl.add(btn[i]);
            }
        }
        

        c.add(northPnl,BorderLayout.NORTH);
        c.add(southPnl,BorderLayout.SOUTH);
        c.add(centerPnl,BorderLayout.CENTER);
        setVisible(true);
    }

    static void main() {
        BorderLayoutEx myBoreder = new BorderLayoutEx();
    }
}
