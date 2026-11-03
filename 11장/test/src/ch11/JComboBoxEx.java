package ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComboBoxEx extends JFrame {
    Container c =getContentPane();
    JComboBox<String> combo;
    JTextField tf;

    public JComboBoxEx() {
        setTitle("JComboBox Ex");
        setSize(500,430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font= new Font("",Font.PLAIN,24);
        String[] fruits ={"apple","banana","kiwi","Mango","pear","peach"};
        combo = new JComboBox<String>(fruits);
        combo.setMaximumRowCount(4);
        combo.setSelectedIndex(3);

        tf=new JTextField(20);
        combo.setFont(font);
        combo.addActionListener(new ActionHandler());

        tf.setFont(font);
        c.setLayout(new FlowLayout());
        c.add(combo,BorderLayout.WEST);
        setVisible(true);
    }

    class ActionHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    static void main() {
        new JComboBoxEx();
    }
}
