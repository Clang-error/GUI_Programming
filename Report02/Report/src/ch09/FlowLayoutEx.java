package ch09;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutEx extends JFrame {
    Container c = getContentPane();
    JButton[] btn= new JButton[25];
    FlowLayoutEx() {
        setTitle("FlowLayout Test");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //레이아웃을 Flow레이아웃으로 설정
        c.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        //버튼 생성, 및 생성
        for(int i=0; i<btn.length; i++){
            btn[i] = new JButton((i+1)+"");
//            btn[i].setMargin(new Insets(0,0,0,0));
            btn[i].setFont(new Font("",Font.BOLD,12));
            c.add(btn[i]);
        }


        setVisible(true);
    }
    static void main() {
        FlowLayoutEx myFlow = new FlowLayoutEx();
    }
}
