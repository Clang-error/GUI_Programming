package Ch09;
import java.awt.*;
import javax.swing.*;
import java.util.Objects;
import java.util.random.*;

public class MyGUI extends JFrame {
    Container c = getContentPane();
    public MyGUI() {

        setTitle("MYGUI"); //상단 타이틀
        setSize(700,700); //사이즈 지정
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //기본세팅값 닫으면 메모리도 같이 정리하고 죽음
        c.setLayout(null); //레이아웃을 컨트롤 할 수 있게 해줌
        c.setBackground(new Color(0x14163E));
        JOptionPane.showMessageDialog(null,"반갑습니다!");
        //label
        JLabel lbl = new JLabel(" 라-벨 ");
        lbl.setBounds(0,50,75,50);
        lbl.setFont(new Font("",Font.BOLD,24));
        lbl.setOpaque(true);
        lbl.setBackground(new Color(181, 29, 29));

        //label
        JTextField tf = new JTextField("");
        tf.setBounds(200,0,200,50);
        tf.setFont(new Font("",Font.BOLD,24));

        //버튼 1
        JButton btn1 = new JButton("라벨 색 변경");
        btn1.setBounds(0,0,100,50);
        btn1.setFont(new Font("",Font.BOLD,12));

        btn1.addActionListener(e -> { //클릭 이벤트리스너
            int r = (int)(Math.random()*255)+1; //각 값을랜덤으로 받음
            int g = (int)(Math.random()*255)+1;
            int b = (int)(Math.random()*255)+1;
            lbl.setBackground(new Color(r,g,b));
        });

        //버튼 2
        JButton btn2 = new JButton("배경 색 변경");
        btn2.setBounds(100, 0,100,50);
        btn2.setFont(new Font("",Font.BOLD,12));
        btn2.addActionListener(e -> {
            int r = (int)(Math.random()*255)+1;
            int g = (int)(Math.random()*255)+1;
            int b = (int)(Math.random()*255)+1;
            c.setBackground(new Color(r,g,b));
        });

        //버튼 3
        JButton btn3 = new JButton("필드 색 변경");
        btn3.setBounds(400, 0,100,50);
        btn3.setFont(new Font("",Font.BOLD,12));
        btn3.addActionListener(e -> {
            String tft = tf.getText();
            if (Objects.equals(tft, "빨강") || Objects.equals(tft, "red")) {
                tf.setBackground(Color.RED);
            } else if (Objects.equals(tft, "초록") || Objects.equals(tft, "green")) {
                tf.setBackground(Color.GREEN);
            } else if (Objects.equals(tft, "파랑") || Objects.equals(tft, "blue")) {
                tf.setBackground(Color.BLUE);
            } else {
                JOptionPane.showMessageDialog(null, "빨강,초록,파랑 혹은\nred,green,blue를 입력하세요");
            }

        });

        //버튼4
        JButton btn4 = new JButton("전부 랜덤");
        btn4.setBounds(500, 0,100,50);
        btn4.setFont(new Font("",Font.BOLD,12));
        btn4.addActionListener(e->{
            //r g b 각 변수 선언없이아래처럼 하는게 더 효율적임
            c.setBackground(new Color((int)(Math.random() * 256),(int)(Math.random() * 256),(int)(Math.random() * 256)));
            lbl.setBackground(new Color((int)(Math.random() * 256),(int)(Math.random() * 256),(int)(Math.random() * 256)));
            tf.setBackground(new Color((int)(Math.random() * 256),(int)(Math.random() * 256),(int)(Math.random() * 256)));
        });

        //버튼5
        JButton btn5 = new JButton("초기화");
        btn5.setBounds(600, 0,100,50);
        btn5.setFont(new Font("",Font.BOLD,12));
        btn5.addActionListener(e->{
            c.setBackground(new Color(0x14163E));
            lbl.setBackground(new Color(181, 29, 29));
            tf.setBackground(Color.WHITE);
        });


        setLocationRelativeTo(null); //실행시 gui를 화면 중앙에 배치
        c.add(lbl);
        c.add(btn1);
        c.add(btn2);
        c.add(btn3);
        c.add(btn4);
        c.add(btn5);
        c.add(tf);
        setVisible(true); //이거 안키면 안보인다
    }
    public static void main() {
        MyGUI GUI = new MyGUI();

    }
}