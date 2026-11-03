package ch11;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class JListEx extends JFrame {

    Container c = getContentPane();
    JList<String> list;
    JTextField tf;
    public JListEx() {
        setTitle("JList Ex");
        setSize(300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] fruits ={"apple","banana","kiwi","mango","melon","pear","peach","berry","strawberry"};
        list = new JList<String>(fruits);
        list.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        list.setVisibleRowCount(5);
        tf= new JTextField(20);
        list.addListSelectionListener(new ListSelectionHandler());
        c.setLayout(new FlowLayout());
        c.add(list);
        c.add(new JScrollPane(list),BorderLayout.WEST);
        c.add(tf,BorderLayout.SOUTH);

        setVisible(true);
    }

    class ListSelectionHandler implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            tf.setText(list.getSelectedValue().toString());
        }
    }

    static void main() {
        new JListEx();
    }
}
