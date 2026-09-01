package ch09;
import java.awt.*;
import javax.swing.*;
//set title set size set Default... setLayout은 기본 후 레이블 생성
// label을 출력하려면 어디에 출력할것인지 알려줘야한 x,y 그리고 로케이션
// 타이틀을 제외한 나머지를 전부 Content Pane 이라함
public class NullLayoutEx extends JFrame{

    public static void main(String[] args) {
        NullLayoutEx frame= new NullLayoutEx();
    }
    Container c = getContentPane();
    public NullLayoutEx() {
        setTitle("First Frame");
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //기본값
        setLocationRelativeTo(null);
        setLayout(null); //이걸주면 지정이가능해짐 add를 해도 씹고 내가 지정
        c.setBackground(new Color(255,255,180));
        //뼈대 라벨
        JLabel label = new JLabel("Hello GUI");
        label.setLocation(100,50); //이거 조절해도 add()하면 그냥 붙여버림
        label.setSize(120,50); //위치 지정
        label.setFont(new Font("", Font.BOLD,24));
        label.setOpaque(true); //투명하지 않은 컴포넌트로 변경
        label.setBackground(Color.red); //백그라운드 색상 red
        label.setForeground(Color.blue); //포그라운드 색상 blue

        //텍스트필드
        JTextField tf= new JTextField(10); //텍스트필드 생성
        tf.setLocation(220,50);
        tf.setSize(200,30);
        tf.setFont(new Font(" ", Font.BOLD,24));

        //버튼1
        JButton btn = new JButton(" SAVE ");
        btn.setLocation(200,300); //이거 조절해도 add()하면 그냥 붙여버림
        btn.setSize(150,40); //위치 지정
        btn.setFont(new Font(" ", Font.BOLD,24));

        //버튼2
        JButton btn2 = new JButton(" CANCEL ");
        btn2.setLocation(350,300); //이거 조절해도 add()하면 그냥 붙여버림
        btn2.setSize(150,40); //위치 지정
        btn2.setFont(new Font(" ", Font.BOLD,24));

        //메뉴바
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu1 = new JMenu("Edit");
        JMenu menu = new JMenu("File");
        menuBar.add(menu1);
        menuBar.add(menu);

        //패널
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setSize(300,100);
        panel.setLocation(200,100);
        panel.setBackground(Color.yellow);

        c.add(menuBar); // add로 추가하지않으면 gui에서 표시되지않음.
        c.add(label);
        c.add(tf);
        c.add(btn);
        c.add(btn2);
        c.add(panel);
        setVisible(true);

        System.out.println("hello world");
    }
}
