package ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyboradActionEx extends JFrame {

    Container c = getContentPane();
    JLabel mylbl = new JLabel("키를 입력하세요");
    int lblWidth =300;
    int lblHeight = 100;
    int lblFont = 12;
    public keyboradActionEx() {
        setTitle("test");
        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        mylbl.setBounds(100,100,lblWidth,lblHeight);
        mylbl.setFont(new Font("",Font.PLAIN,lblFont));
        setFocusable(true); //포커스 안주면 안눌린ㄴㄷ
        c.add(mylbl);
        addKeyListener(new KeyboradHandler());
        setVisible(true);
        requestFocus();
    }

    static void main() {
        keyboradActionEx mykeyBoard = new keyboradActionEx();
    }

    class KeyboradHandler implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            String test= "CHAR:" +e.getKeyChar()+", CODE:"+e.getKeyCode()+", TEXT:"+ KeyEvent.getKeyText(e.getKeyCode());
            System.out.println(test);
            if(e.getKeyChar() == '+') {
                System.out.println("+를 눌렀습니다");
                lblWidth += 10;
                lblHeight += 2;
                mylbl.setSize(lblWidth,lblHeight);
                mylbl.setFont(new Font("",Font.PLAIN,++lblFont));
            } else if (e.getKeyChar() == '-'|| e.getKeyChar() == '_') {
                lblWidth -= 10;
                lblHeight -= 2;
                mylbl.setSize(lblWidth,lblHeight);
                mylbl.setFont(new Font("",Font.PLAIN,--lblFont));
            }
            mylbl.setText(test);
//            JOptionPane.showMessageDialog(null,test+" ");
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
