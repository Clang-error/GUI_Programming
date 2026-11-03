package ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.Arrays;

public class JTextFieldEx extends JFrame {
    Container c = getContentPane();
    JLabel[] lbl = new JLabel[5];
    JTextField[] tf = new JTextField[5];
    JLabel passlbl;
    JPasswordField passwd;
    JButton btn;

    JTextFieldEx() {
        setTitle("fieldTest");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(new FlowLayout());
        setResizable(false);

        String[] field = {"이름","학과","주소","취미","전화"};
        String[] text ={"고현석","컴퓨터공학과","부산광역시","없음","-"};
        for (int i = 0; i<tf.length; i++) {
            lbl[i] = new JLabel(field[i]);
            tf[i] = new JTextField(text[i],20);
//            tf[i].addKeyListener(new KeyBoardHandler());
            c.add(lbl[i]);
            c.add(tf[i]);
        }
//        tf[2].setEditable(false); //수정안됨
        tf[2].setEnabled(false);
        tf[1].setEnabled(false);
        passlbl = new JLabel("비밀번호");
        btn=new JButton("등록");
        passwd=new JPasswordField(18);

        btn.addActionListener(e->{
            System.out.println(tf[0].getText());
            System.out.println(tf[1].getText());
            System.out.println(tf[2].getText());
            System.out.println(tf[3].getText());
            System.out.println(passwd.getPassword());
            JOptionPane.showMessageDialog(null,tf[0].getText() +"\n"+ tf[1].getText()+"\n"+
                    tf[2].getText()+"\n"+ tf[3].getText()+"\n"+ Arrays.toString(passwd.getPassword()));

        });

        c.add(passlbl);
        c.add(passwd);
        c.add(btn);

//        addKeyListener(new KeyBoardHandler());
        setVisible(true);
        requestFocus();
    }
//    class KeyBoardHandler implements KeyListener {
//
//        @Override
//        public void keyTyped(KeyEvent e) {
//
//        }
//
//        @Override
//        public void keyPressed(KeyEvent e) {
//            String test = KeyEvent.getKeyText(e.getKeyCode());
//            System.out.println(test);
//        }
//
//        @Override
//        public void keyReleased(KeyEvent e) {
//
//        }
//    }

    static void main() {
        new JTextFieldEx();
    }


}