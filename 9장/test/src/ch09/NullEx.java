package ch09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class NullEx extends JFrame {
    Container c = getContentPane();
    JLabel mylbl =new JLabel("Test");
    JButton savebtn = new JButton("SAVE");
    JButton canelbtn = new JButton("CANEL");
    JTextField tf = new JTextField("여기에 이름");
    public NullEx() {
        setTitle("NullEX");
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        c.setBackground(new Color(255,127,255));
        setResizable(false);

        //라벨 세팅
        mylbl.setBounds(100,100,100,100);
//        mylbl.setOpaque(true);
//        mylbl.setBackground(Color.BLUE);
        mylbl.setFont(new Font("",Font.BOLD,24));

        // 세이브 버튼
        savebtn. setBounds(400,100,100,100);
        savebtn.addActionListener(e-> {
            JOptionPane.showMessageDialog(null,"save 눌렀네요");
        });

        //캔슬 버튼
        canelbtn. setBounds(500,100,100,100);

        //텍스트필드
        tf.setBounds(200,100,200,100);
        tf.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(tf.getText().equals("여기에 이름"))
                    tf.setText("");
            }
            public void focusLost(FocusEvent e) {
                if(tf.getText().isEmpty())
                    tf.setText("여기에 이름");
            }
        });



        c.add(mylbl);
        c.add(savebtn);
        c.add(canelbtn);
        c.add(tf);
        setVisible(true);
        savebtn.requestFocusInWindow();
    }

    public static void main() {
        NullEx myEx = new NullEx();
    }
}
