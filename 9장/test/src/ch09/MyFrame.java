package ch09;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    Container c = getContentPane();
    public MyFrame() {
        setTitle("300x300 스윙 프레임 만들기");
        setSize(300,300);

        setVisible(true);
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }
}
