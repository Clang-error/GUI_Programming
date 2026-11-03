package ch11;

//자바 레포트

import javax.swing.*;
import java.awt.*;
import java.util.Random;

//패널 두개만들어서 각각 다른 레이아웃적용해서 쓰면될ㅠ

public class GridLayoutEx extends JFrame {
    Container c = getContentPane();
    JButton[] btn = new JButton[25];
    Random random = new Random();
    JPanel tPnl =new JPanel(new GridLayout(5,5)); //패널안에 레이아ㅓ웃 방식을 지정
    JPanel bPnl = new JPanel();
    JButton bBtn = new JButton("restart");
    boolean resetArray = false;
    int count=1;
    int[] arraynum = new int[25];
    GridLayoutEx() {
        setTitle("GridLayout Test");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); //기본틀은 보더 레이아웃이지만 버튼배치는 그리드라이아웃을 사용
        setResizable(false); //창 사이즈 변경 막음
        for (int i=0; i<btn.length; i++) { //버튼 생성 및 값 랜덤생성 함수 호출
            int a = random.nextInt(25)+1;
            btn[i] = new JButton(""+randomNum(a));
            btn[i].setFocusable(false); //버튼을 누르고 비활성화되면 옆으로 포커스가 옮겨가는 걸 없앰
            btn[i].addActionListener(e -> {
                JButton clicked = (JButton) e.getSource(); //방금 누른 버튼이 뭔지 값 획득하여 저장
                System.out.println(clicked.getText());
                if(clicked.getText().equals(""+count)) { // 방금 누른값이 카운팅 값이랑 맞는지
                    clicked.setEnabled(false); // 맞다면 버튼 비활성화
                    count++;
                }else{
                    JOptionPane.showMessageDialog(null,"숫자 "+count+"을 클릭해주세요");
                }
            });
            tPnl.add(btn[i]);
        }

        bBtn.addActionListener(e -> {
            resetArray=false;
            count=1;
            for (int i=0; i<btn.length; i++) { //버튼 생성 및 값 랜덤생성 함수 호출
                int a = random.nextInt(25)+1;
                btn[i].setText(""+randomNum(a)); //랜덤버튼 생성
                btn[i].setEnabled(true);
            }
        });

        bPnl.add(bBtn);
        bPnl.setBackground(Color.gray);
        c.add(tPnl,BorderLayout.CENTER);
        c.add(bPnl,BorderLayout.SOUTH);
        setVisible(true);
    }

    public int randomNum(int a) { //값 랜덤생성 함수
        if(!resetArray) {
            for (int i=1; i<26; i++) {arraynum[i-1]=i;} // 랜덤배열값 초기화
            resetArray=true;
        }

        while(true) { //값이 이미 사용되고있을때를 대비한 무한루프
            int temp;
            for (int i =0;i<arraynum.length;i++) { //하나의 값을 1부터 25까지 값을 가진 배열과 비교
                //이진서치쓸지 고민중..
                if(arraynum[i]==a) { // 배열값과 지정된 값이 맞다면 랜덤값이 사용되지 않은걸로 판정
                    temp=arraynum[i];
                    arraynum[i]=0; //사용된 값은 0으로 변경
                    return temp; //값 반환
                }else if(arraynum[i]==0) { //만난 배열 인덱스의 값이 0이라면 다시 랜덤수를 돌려서 무한반복
                    a = random.nextInt(25)+1;
                }
            }
        }
    }

    static void main() {
        new GridLayoutEx();
    }
}

