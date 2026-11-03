package ch11;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;

public class JTextAreaEx extends JFrame {
    Container c = getContentPane();

    JLabel[] lbl = new JLabel[4];
    JTextField[] tf = new JTextField[4];

    JLabel passlbl;
    JPasswordField passwd;
    JButton btn;

    JTextArea area;

    JTextAreaEx() {
        setTitle("Area Test");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        String[] field = {"이름", "학과", "주소", "전화"};
        String[] text = {"고현석", "컴퓨터공학과", "부산광역시", "-"};

        for (int i = 0; i < tf.length; i++) {
            lbl[i] = new JLabel(field[i]);
            tf[i] = new JTextField(text[i], 20);

            if (field[i].equals("주소"))  {
                c.add(new LineBreak());
            }
            c.add(lbl[i]);
            c.add(tf[i]);
        }

        passlbl = new JLabel("비밀번호");
        passwd = new JPasswordField(18);
        btn = new JButton("등록");

        c.add(new LineBreak());
        c.add(passlbl);
        c.add(passwd);
        c.add(btn);

        area = new JTextArea(30, 65);
        area.setEnabled(false);

        c.add(area);

        btn.addActionListener(e -> {
            area.append("이름 : " + tf[0].getText() + "\n");
            area.append("학과 : " + tf[1].getText() + "\n");
            area.append("주소 : " + tf[2].getText() + "\n");
            area.append("전화 : " + tf[3].getText() + "\n");
            area.append("비밀번호 : " + new String(passwd.getPassword()) + "\n");
            area.append("--------------------\n");
        });

        setVisible(true);
    }
    class LineBreak extends JLabel{
        public Dimension getPreferredSize() {
            return new Dimension(2000,0);
        }
    }

    static void main() {
        new JTextAreaEx();
    }
}
