package ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionEventEx extends JFrame {
    Container c = getContentPane();
    JButton testBtn = new JButton("테스트");
    JButton testBtn2 = new JButton("테스트");
    public ActionEventEx() {
        setSize(400,400);
        setTitle("ActionEvent");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(new FlowLayout());
        Font font = new Font("",Font.BOLD,24);

        testBtn.setFont(font);
        testBtn.addActionListener(e->{
            JOptionPane.showMessageDialog(null,"누르지마라.");
        });
        testBtn2.addActionListener(e->{
            JOptionPane.showMessageDialog(null,"누르지마라.");
        });

        c.addMouseListener(new MouseHandler());
        c.add(testBtn);
        c.add(testBtn2);
        setVisible(true
        );
    }

    static void main() {
        new ActionEventEx();
    }

    class MouseHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JOptionPane.showMessageDialog(null,"ㅎㅇ");
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JOptionPane.showMessageDialog(null,"들어왔다");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JOptionPane.showMessageDialog(null,"나갔다");
        }
    }

    class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==testBtn)
                c.setBackground(Color.yellow);
            else
                c.setBackground(Color.blue);
        }
    }
}
