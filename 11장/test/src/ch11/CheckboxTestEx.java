package ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class CheckboxTestEx extends JFrame {
    Container c = getContentPane();
    Checkbox testCk = new Checkbox("사과");
    Checkbox testCk2 = new Checkbox("바나나");
    Checkbox testCk3 = new Checkbox("키위");
    JLabel piclbl = new JLabel("여기에 사진이 표시됩니다.");
    JLabel pricelbl = new JLabel("가격표시");
    ImageIcon apple = new ImageIcon("/Users/clang_error/02_2.GUI/11장/test/images/사과.jpg");
    ImageIcon banana = new ImageIcon("/Users/clang_error/02_2.GUI/11장/test/images/banana.jpg");
    ImageIcon kiwi = new ImageIcon("/Users/clang_error/02_2.GUI/11장/test/images/kiwi.jpg");
    CheckboxGroup group = new CheckboxGroup();

    int price=0;

    Panel ckPnl = new Panel();
    CheckboxTestEx() {
        setTitle("CheckBox");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        piclbl.setHorizontalAlignment(SwingConstants.CENTER);
//        piclbl.setVerticalAlignment(SwingConstants.CENTER);

        pricelbl.setHorizontalAlignment(SwingConstants.CENTER);
        pricelbl.setFont(new Font("",Font.BOLD,24));


        testCk.setCheckboxGroup(group);
        testCk2.setCheckboxGroup(group);
        testCk3.setCheckboxGroup(group);


        ckPnl.add(testCk);
        ckPnl.add(testCk2);
        ckPnl.add(testCk3);

        testCk.addItemListener(e-> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                piclbl.setText(null);
                piclbl.setIcon(apple);
//                price += 10000;
                price = 10000;
                pricelbl.setText("Price:"+price);
            }
            else {
                piclbl.setIcon(null);

//                price -=10000;
//                pricelbl.setText("Price:"+price);
//                if(price == 0) {
//                    piclbl.setText("여기에 사진이 표시됩니다.");
//                    pricelbl.setText("가격표시");
//                }
            }
        });
        testCk2.addItemListener(e-> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                piclbl.setText(null);
                piclbl.setIcon(banana);
//                price += 5000;
                price = 5000;
                pricelbl.setText("Price:"+price);
            }
            else {
                piclbl.setIcon(null);

//                price -= 5000;
//                pricelbl.setText("Price:"+price);
//                if(price == 0) {
//                    piclbl.setText("여기에 사진이 표시됩니다.");
//                    pricelbl.setText("가격표시");
//                }
            }
        });
        testCk3.addItemListener(e-> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                piclbl.setText(null);
                piclbl.setIcon(kiwi);
//                price += 7000;
                price = 7000;
                pricelbl.setText("Price:"+price);
            }
            else {
                piclbl.setIcon(null);

//                price -=7000;
//                pricelbl.setText("Price:"+price);
//
//                if(price == 0) {
//                    piclbl.setText("여기에 사진이 표시됩니다.");
//                    pricelbl.setText("가격표시");
//                }
            }
        });
        c.add(piclbl,BorderLayout.CENTER);
        c.add(ckPnl,BorderLayout.NORTH);
        c.add(pricelbl,BorderLayout.SOUTH);
        setVisible(true);
    }

    static void main() {
        new CheckboxTestEx();
    }
}
