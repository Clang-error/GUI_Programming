package ch09;
import java.awt.*;
import javax.swing.*;

public class ThreeButton extends JFrame {
    Container c = getContentPane();
    public ThreeButton() {
        setTitle("3-button"); //여기서부터
        setSize(1000,600); //창사이즈
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료시 메모리회수해서 같이 죽고
        c.setLayout(null);// 창 사이즈 내가 조절함
        //여기까지는 기본값임
        c.setBackground(new Color(205, 195, 37));

        JButton Okbtn = new JButton("OK");
        Okbtn.setSize(120,60);
        Okbtn.setLocation(320,10);
        Okbtn.setFont(new Font(" ", Font.BOLD,24));

        JButton Cbtn = new JButton("CANCEL");
        Cbtn.setSize(120,60);
        Cbtn.setLocation(440,10);
        Cbtn.setFont(new Font(" ", Font.BOLD,24));

        JButton Igbtn = new JButton("IGNORE");
        Igbtn.setSize(120,60);
        Igbtn.setLocation(560,10);
        Igbtn.setFont(new Font(" ", Font.BOLD,24));


        c.add(Okbtn);
        c.add(Cbtn);
        c.add(Igbtn);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main() {
        ThreeButton mybtn = new ThreeButton();
    }
}
