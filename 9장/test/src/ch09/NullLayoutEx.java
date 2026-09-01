package ch09;
import java.awt.*;
import javax.swing.*;
//set title set size set Default... setLayout은 기본 후 레이블 생성
// label을 출력하려면 어디에 출력할것인지 알려줘야한 x,y 그리고 로케이션

public class NullLayoutEx extends JFrame{
    public static void main(String[] args) {
        new NullLayoutEx();
    }

    public NullLayoutEx() {
        setTitle("First Frame");
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //기본값
        setLocationRelativeTo(null);
        setLayout(null); //이걸주면 지정이가능해짐 add를 해도 씹고 내가 지정

        JLabel label = new JLabel("Hello GUI");
        label.setLocation(300,50); //이거 조절해도 add()하면 그냥 붙여버림
        label.setSize(100,100); //위치 지정
        label.setFont(new Font(" ", Font.BOLD,24));
        label.setOpaque(true);
        label.setBackground(Color.red);
        label.setForeground(Color.blue);

        JButton btn = new JButton(" SAVE ");
        btn.setLocation(200,150); //이거 조절해도 add()하면 그냥 붙여버림
        btn.setSize(150,40); //위치 지정
        btn.setFont(new Font(" ", Font.BOLD,24));

        JButton btn2 = new JButton(" CANCEL ");
        btn2.setLocation(350,150); //이거 조절해도 add()하면 그냥 붙여버림
        btn2.setSize(150,40); //위치 지정
        btn2.setFont(new Font(" ", Font.BOLD,24));


        add(label);
        add(btn);
        add(btn2);
        setVisible(true);

        System.out.println("hello world");
    }
}
