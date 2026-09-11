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

        //그리드 레이아웃 사용
        //row를 5로 지정하면 정사각형 그리드가 나옴
        //row를 0 cols 7로하면 버튼이 7개가 한 열에 나옴
        c.setLayout(new GridLayout(5,5));

        //버튼 생성및 추가
        for(int i=0; i<btn.length;i++) {
            btn[i]=new JButton((i+1)+"");
            c.add(btn[i]);
        }



        setVisible(true);
    }

    static void main() {
        GridLayoutEx myGrid = new GridLayoutEx();
    }
}
