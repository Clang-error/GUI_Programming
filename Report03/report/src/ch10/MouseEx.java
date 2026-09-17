package ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEx extends JFrame {
    int fontSize = 10;
    int width =150;
    int height = 80;
    boolean dragged = false;
    int startX, startY;
    int TOLERANCE=5;
    JLabel mylbl = new JLabel("Hello GUI WORLD");
    Container c = getContentPane();

    //2초뒤에 원래 타이틀로 복귀하는 Timer 설정
    Timer timer = new Timer(2000,e->{
        setTitle("마우스 연습");

    });
    public MouseEx() {
        setSize(500,400);
        setTitle("마우스 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        mylbl.setOpaque(true);
        mylbl.setBounds(30,30,width,height);
        mylbl.setBackground(Color.YELLOW);
        mylbl.setFont(new Font("",Font.BOLD,fontSize));

        timer.setRepeats(false); //타이머 무한반복을 막음

        c.add(mylbl);
        c.addMouseWheelListener(new MouseWheelHandler());
        c.addMouseListener(new MouseHandler());
        c.addMouseMotionListener(new MouseDragHandler());
        setVisible(true);
    }


    class MouseWheelHandler implements MouseWheelListener {

        @Override
        //마우스 휠 증가 감소 로직
        public void mouseWheelMoved(MouseWheelEvent e) {
            if (e.getWheelRotation() > 0) {
                if (fontSize < 101) {
                    fontSize+=1;
                    width+=10;
                    height+=1;

                    System.out.println(mylbl.getFont());
                    mylbl.setSize(width,height);
                    mylbl.setFont(new Font("",Font.BOLD,fontSize));
                }
            } else if (e.getWheelRotation() <= -1) {
                if (fontSize > 10) {
                    fontSize-=1;
                    width-=10;
                    height-=1;

                    System.out.println(mylbl.getFont());
                    mylbl.setSize(width,height);
                    mylbl.setFont(new Font("",Font.BOLD,fontSize));
                }

            }
        }
    }

    class MouseDragHandler implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            //클릭시 마우스 떨림이 있을 수 있는 환경을 고려하여 좌표값 +-5만큼의 오차범위를 허용
            int dx = Math.abs(e.getX()-startX);
            int dy = Math.abs(e.getY()-startY);
            if (dx > TOLERANCE || dy > TOLERANCE)
                dragged=true;
            mylbl.setLocation(e.getX(),e.getY());
            setTitle("Drag X: "+e.getX()+" Y: "+e.getY());
            timer.restart();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            //드래그없이 움직일때 도한 좌표값을 표기
            // mouse Entered 입력이 바로 moved로 잡혀서 안보이기 떄문에 기능을 잠시제거
//            setTitle("Move X:"+e.getX()+"Y:"+e.getY());
//            timer.restart();

        }
    }

    class MouseHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            //마우스 클릭이벤트는 release로 이전됨
//            System.out.println("clicked 호출됨, dragged="+dragged);
//            if(dragged) {
//                return;
//            }
//            mylbl.setLocation(e.getX(),e.getY());
//            setTitle("Mouse Click X: "+e.getX()+" Y: "+e.getY());
//            timer.restart();
//            JOptionPane.showMessageDialog(null,"좌표가"+e.getX()+", "+e.getY()+"로 이동되었음.");

        }

        @Override
        public void mousePressed(MouseEvent e) {
            //클릭됐을때 현재 좌표값을 기록
            startY=e.getY(); startX=e.getX();
            dragged=false;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //clicked 데이터는 한번처리된 입력을 가져오기때문에 release로 순수데이터를 받아서 처리
            //clicked 내부에서는 AWT가 먼저 판단해버려 클릭이 드래그로 인식되는 문제점이 발생
            if (!dragged) {
                mylbl.setLocation(e.getX(), e.getY());
                setTitle("Mouse Click X: " + e.getX() + " Y: " + e.getY());
                timer.restart();
                JOptionPane.showMessageDialog(null, "좌표가" + e.getX() + ", " + e.getY() + "로 이동되었음.");
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            c.setBackground(Color.WHITE);
            setTitle("Mouse Entered X: "+e.getX()+" Y: "+e.getY());
            timer.restart();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            c.setBackground(Color.LIGHT_GRAY);
            setTitle("Mouse Exited X:"+e.getX()+" Y: "+e.getY());
            timer.restart();
        }
    }

    static void main() {
        new MouseEx();
    }
}
