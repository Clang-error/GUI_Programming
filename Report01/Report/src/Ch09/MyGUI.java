package Ch09;
import java.awt.*;
import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Objects;
import java.util.random.*;

public class MyGUI extends JFrame {
    boolean rOneTimeNoti =true;
    boolean lOneTimeNoti =true;
    boolean bOneTimeNoti =true;
    Container c = getContentPane();
    public MyGUI() {
        setTitle("MYGUI"); //상단 타이틀
        setSize(720,700); //사이즈 지정
        setResizable(false); //창 사이즈 임의 조절 막음
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //기본세팅값 닫으면 메모리도 같이 정리하고 죽음
        c.setLayout(null); //레이아웃을 컨트롤 할 수 있게 해줌
        c.setBackground(new Color(0x14163E));


        //메인 라벨
        JLabel lbl = new JLabel(" 라벨은 여기에 있었습니다. ");
        lbl.setBounds(55,350,600,50);
        lbl.setFont(new Font("",Font.BOLD,24));
        lbl.setOpaque(true);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setBackground(new Color(181, 29, 29));
        lbl.setVisible(false);


        //현재rgb값 라벨
        Color startBackGround = c.getBackground();
        JLabel cRgb= new JLabel("");
        //줄넘김하려면 Html 형식 사용해야함 JLabel은 기본적으로 줄넘김을 지원하지않음
        cRgb.setText("<html>현재 배경<br>R: "+startBackGround.getRed()+" G: "+startBackGround.getGreen()+" B: "+startBackGround.getBlue()+"</html>");
        cRgb.setBounds(580,590,200,100);
        cRgb.setFont(new Font("",Font.BOLD,12));
        cRgb.setForeground(Color.WHITE);

        //현재 사용자 표시 라벨
        JLabel myNamelbl=new JLabel("Unknown님 안녕하세요!");
        myNamelbl.setBounds(20,600,200,100);
        myNamelbl.setFont(new Font("",Font.BOLD,12));
        myNamelbl.setForeground(Color.WHITE);


        //이름 입력 텍스트필드
        JTextField nameTf = new JTextField("이름을 입력하세요");
        nameTf.setHorizontalAlignment(SwingConstants.CENTER);
        nameTf.setBounds(55,50,600,50);
        nameTf.setFont(new Font("",Font.BOLD,24));

        nameTf.addFocusListener(new FocusAdapter() { //포커스 리스너, 클릭하면 채워져있던 텍스필드 지고 공백만남ㅜㅁ
            @Override
            public void focusGained(FocusEvent e) {
                if(nameTf.getText().equals("이름을 입력하세요"))
                    nameTf.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) { //포커스가 딴곳으로 갔을때 필드를 다시채움
                if(nameTf.getText().isEmpty()) {
                    nameTf.setText("이름을 입력하세요");
                }
            }
        });

        //이름입력 제출버튼
        JButton nameSubmitBtn = new JButton("제출");
        nameSubmitBtn.setBounds(550,100,100,50);

        nameSubmitBtn.addActionListener(e-> {
            if(nameTf.getInputContext() != null) {
                //조합중인 입력에서 끝나지않으면 버튼이 눌리지않는 버그발생
                //강제 확정시켜서 씹기
                nameTf.getInputContext().endComposition();
            }
            if(Objects.equals("이름을 입력하세요",nameTf.getText())) {
                JOptionPane.showMessageDialog(null,"이름을 입력하시고 제출하세요"); //이름을 입력받게
            }
            else {//예 아니오 확인받고 출력하는 로직
            int result = JOptionPane.showConfirmDialog(null,nameTf.getText() +"님 맞나요?","확인",JOptionPane.OK_CANCEL_OPTION);
            if(result == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(null,nameTf.getText()+"님 안녕하세요!");
                myNamelbl.setText(nameTf.getText()+"님 안녕하세요!");}
            }
        });



        //색상변경 텍스트필드
        JTextField tf = new JTextField("");
        tf.setBounds(210,0,200,50);
        tf.setFont(new Font("",Font.BOLD,24));

        //라벨 숨김 버튼 , 라벨 보이기버튼
        JButton lblShow = new JButton("라벨 보이기");
        JButton lblHide = new JButton("라벨 숨기기");

        //라벨 숨김버튼 기능
        lblHide.setBounds(55,400,600,50);
        lblHide.setFont(new Font("",Font.BOLD,12));
        lblHide.setVisible(false);

        lblHide.addActionListener(e->{
            lbl.setVisible(false);
            lblHide.setVisible(false);
            lblShow.setVisible(true);
        });

        //라벨 표시버튼 기능
        lblShow.setBounds(55,400,600,50);
        lblShow.setFont(new Font("",Font.BOLD,12));
        lblShow.setVisible(true);

        lblShow.addActionListener(e->{
            lbl.setVisible(true);
            lblShow.setVisible(false);
            lblHide.setVisible(true);
        });

        //라벨 색 변경버튼
        JButton btn1 = new JButton("라벨 색 변경");
        btn1.setBounds(10,0,100,50);
        btn1.setFont(new Font("",Font.BOLD,12));
        btn1.addActionListener(e -> { //클릭 이벤트리스너
            int r = (int)(Math.random()*255)+1; //각 값을랜덤으로 받음
            int g = (int)(Math.random()*255)+1;
            int b = (int)(Math.random()*255)+1;
            lbl.setBackground(new Color(r,g,b));
        });

        //배경색 변경 버튼
        JButton btn2 = new JButton("배경 색 변경");
        btn2.setBounds(110, 0,100,50);
        btn2.setFont(new Font("",Font.BOLD,12));
        btn2.addActionListener(e -> {
            int r = (int)(Math.random()*255)+1;
            int g = (int)(Math.random()*255)+1;
            int b = (int)(Math.random()*255)+1;
            c.setBackground(new Color(r,g,b));
            Color current = c.getBackground();
            cRgb.setText("<html>현재 배경<br>R: "+current.getRed()+" G: "+current.getGreen()+" B: "+current.getBlue()+"</html>");
        });

        //필드색 변경버튼
        JButton btn3 = new JButton("필드 색 변경");
        btn3.setBounds(410, 0,100,50);
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




        // 오른쪽 세로 스크롤바
        JScrollBar rscl = new JScrollBar();
        rscl.setBounds(710, 0, 10, 700);
        rscl.setOpaque(true);
        rscl.setMinimum(1); //최솟값 최대값 지정
        rscl.setMaximum(256);
        rscl.setVisibleAmount(1);
        rscl.setValue(startBackGround.getRed());

        rscl.addAdjustmentListener(e->{
            if (rOneTimeNoti) { //한번만 알림
                JOptionPane.showMessageDialog(null,"R값을 변경하는 스크롤 바 입니다.");
                rOneTimeNoti = false;
            }
            int r = e.getValue();
            Color current = c.getBackground(); //current에 현재 rgb값 받기
            c.setBackground(new Color(r,current.getGreen(),current.getBlue()));
            cRgb.setText("<html>현재 배경<br>R: "+current.getRed()+" G: "+current.getGreen()+" B: "+current.getBlue()+"</html>");
        });

        //왼쪽 스크롤
        JScrollBar lscl = new JScrollBar();
        lscl.setBounds(0, 0, 10, 700);
        lscl.setMinimum(1);
        lscl.setMaximum(256);
        lscl.setVisibleAmount(1);
        lscl.setValue(startBackGround.getGreen());

        lscl.addAdjustmentListener(e->{
            if (lOneTimeNoti) { //한번만 알림
                JOptionPane.showMessageDialog(null,"G값을 변경하는 스크롤 바 입니다.");
                lOneTimeNoti = false;
            }
            int g = e.getValue();
            Color current = c.getBackground();
            c.setBackground(new Color(current.getRed(),g,current.getBlue()));
            cRgb.setText("<html>현재 배경<br>R: "+current.getRed()+" G: "+current.getGreen()+" B: "+current.getBlue()+"</html>");
        });

        //하단스크롤
        JScrollBar bscl = new JScrollBar(Adjustable.HORIZONTAL);
        bscl.setBounds(10,662,700,10);
        bscl.setMinimum(1);
        bscl.setMaximum(256);
        bscl.setVisibleAmount(1);
        bscl.setValue(startBackGround.getBlue());

        bscl.addAdjustmentListener(e->{
            if(bOneTimeNoti) {
                JOptionPane.showMessageDialog(null,"B값을 변경하는 스크롤 바 입니다.");
                bOneTimeNoti =false;
            }
            int b = e.getValue();
            Color current = c.getBackground();
            c.setBackground(new Color(current.getRed(),current.getGreen(),b));
            cRgb.setText("<html>현재 배경<br>R: "+current.getRed()+" G: "+current.getGreen()+" B: "+current.getBlue()+"</html>");
        });

        //랜덤버튼
        JButton btn4 = new JButton("전부 랜덤");
        btn4.setBounds(510, 0,100,50);
        btn4.setFont(new Font("",Font.BOLD,12));
        btn4.addActionListener(e->{
            //r g b 각 변수 선언없이아래처럼 하는게 더 효율적임
            c.setBackground(new Color((int)(Math.random() * 256),(int)(Math.random() * 256),(int)(Math.random() * 256)));
            lbl.setBackground(new Color((int)(Math.random() * 256),(int)(Math.random() * 256),(int)(Math.random() * 256)));
            tf.setBackground(new Color((int)(Math.random() * 256),(int)(Math.random() * 256),(int)(Math.random() * 256)));
            Color current = c.getBackground();
            cRgb.setText("<html>현재 배경<br>R: "+current.getRed()+" G: "+current.getGreen()+" B: "+current.getBlue()+"</html>");
        });

        //초기화버튼
        JButton btn5 = new JButton("초기화");
        btn5.setBounds(610, 0,100,50);
        btn5.setFont(new Font("",Font.BOLD,12));
        btn5.addActionListener(e->{
            int result = JOptionPane.showConfirmDialog(null,"전부 초기화하시겠습니까?","초기화",JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                c.setBackground(new Color(0x14163E));
                lbl.setBackground(new Color(181, 29, 29));
                tf.setBackground(Color.WHITE);
                Color current = c.getBackground();
                cRgb.setText("<html>현재 배경<br>R: " + current.getRed() + " G: " + current.getGreen() + " B: " + current.getBlue() + "</html>");
                myNamelbl.setText("Unknown님 안녕하세요!");
                nameTf.setText("이름을 입력하세요");
            } else {
                JOptionPane.showMessageDialog(null,"취소되었습니다.");
            }
        });

        setLocationRelativeTo(null); //실행시 gui를 화면 중앙에 배치
        c.add(lbl);
        c.add(lblHide);
        c.add(lblShow);
        c.add(myNamelbl);
        c.add(nameSubmitBtn);
        c.add(nameTf);
        c.add(cRgb);
        c.add(btn1);
        c.add(btn2);
        c.add(btn3);
        c.add(btn4);
        c.add(btn5);
        c.add(tf);
        c.add(rscl);
        c.add(lscl);
        c.add(bscl);

        setVisible(true); //이거 안키면 안보인다
        JOptionPane.showMessageDialog(null,"반갑습니다!");
    }
    public static void main() {
        MyGUI GUI = new MyGUI();

    }
}