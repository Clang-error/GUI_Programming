package ch09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FlowLayoutEx extends JFrame {
    Container c = getContentPane();
//    JButton okbtn = new JButton("OK");
//    JButton cancelbtn = new JButton("CANCEL");
//    JButton igbtn = new JButton("IGNORE");
    JButton[] btn = new JButton[3];
    JTextArea tf = new JTextArea(25,10);
    JPanel pnl = new JPanel();

    public FlowLayoutEx() {
        setTitle("FlowLayout");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new FlowLayout(FlowLayout.CENTER,15,20)); //이거하면 사이즈 지정안하고 위치 지정안해도 알아서 만들어짐
        setLayout(new BorderLayout());
        c.setBackground(Color.YELLOW);


        //버튼생성
        String[] btnText ={"Save","clear","callFile"};
//        String[] borderLocation ={"NORTH","WEST","EAST"};
        for(int i=0; i<btn.length; i++) {
            btn[i] = new JButton(btnText[i]);
            btn[i].setFont(new Font("",Font.BOLD,24));
        }
        tf.setFont(new Font("",Font.PLAIN,24));

        pnl.add(btn[0]);
        btn[0].addActionListener(e->{
            int result = JOptionPane.showConfirmDialog(null,"내용을 저장하시곘습니까?","저장",JOptionPane.OK_CANCEL_OPTION);
            if (tf.getInputContext() != null) {
                tf.getInputContext().endComposition();
            }
            if (result == JOptionPane.OK_OPTION) {
                try (FileWriter fw = new FileWriter("data.txt")) {
                    fw.write(tf.getText());
                    JOptionPane.showMessageDialog(null,"저장되었습니다");
                } catch (IOException b) {
                    b.printStackTrace();
                }
            }
        });
        pnl.add(btn[1]);
        btn[1].addActionListener(e->{
            int result = JOptionPane.showConfirmDialog(null,"전부 지우시겠습니까?","지우기",JOptionPane.OK_CANCEL_OPTION);
            if(result == JOptionPane.OK_OPTION) {
                tf.setText("");
                if (tf.getInputContext() != null) {
                    tf.getInputContext().endComposition();
                }
                int result2 = JOptionPane.showConfirmDialog(null,"파일내용도 삭제하시겠습니까?","파일삭제",JOptionPane.OK_CANCEL_OPTION);
                if(result2 == JOptionPane.OK_OPTION) {
                    try (FileWriter fw = new FileWriter("data.txt")) {
                        fw.write(tf.getText());
                        JOptionPane.showMessageDialog(null,"삭제되었습니다");
                    } catch (IOException b) {
                        b.printStackTrace();
                    }
                }
            }
        });
        pnl.add(btn[2]);
        btn[2].addActionListener(e->{
            int result = JOptionPane.showConfirmDialog(null,"파일을 불러오시겠습니까?","파일 불러오기",JOptionPane.OK_CANCEL_OPTION);
            if(result == JOptionPane.OK_OPTION) {
                if (tf.getInputContext() != null) {
                    tf.getInputContext().endComposition();
                }
                try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    tf.setText(sb.toString());
                } catch (IOException r) {
                    r.printStackTrace();
                }
            }
        });
        c.add(pnl,BorderLayout.SOUTH);
        c.add(tf);

        //키보드 입력 (창닫기 단축키 입력)
        getRootPane().registerKeyboardAction(
                e->dispose(), KeyStroke.getKeyStroke(KeyEvent.VK_W,Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()),
                JComponent.WHEN_IN_FOCUSED_WINDOW
        );
        //add 섹션
        //add를 넣는 순서대로 flow가 순서대로 생성함
//        c.add(tf,BorderLayout.SOUTH);
//        c.add(btn[0]);
//        c.add(btn[1]);
//        c.add(btn[2]);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main() {
        FlowLayoutEx myFlow = new FlowLayoutEx();
    }
}

