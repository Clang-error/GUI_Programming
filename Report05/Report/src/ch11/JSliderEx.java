package ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class JSliderEx extends JFrame {
    Container c = getContentPane();
    //메인 라벨이랑 조절패널 간격 합치기를 위해 한 패널에 다시 감싸기
    JPanel northWrapper = new JPanel(new BorderLayout());
    JPanel northPnl = new JPanel(new FlowLayout());
    JComboBox<String> fontCombo;
    JSlider slider;
    JTextField sizeTf;
    JLabel mainLbl;
    Checkbox italicBox;
    Checkbox boldBox;


    int fontSize =24;
    public JSliderEx() {
        setTitle("JSlider Test");
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(new BorderLayout());

        String[] systemFonts;
        GraphicsEnvironment g= GraphicsEnvironment.getLocalGraphicsEnvironment(); //시스템 폰트 가져오기
        systemFonts=g.getAvailableFontFamilyNames();

        Font font = new Font("", Font.PLAIN,fontSize);

        fontCombo = new JComboBox<>(systemFonts);
        fontCombo.addActionListener(e->{
            String fontName = (String) fontCombo.getSelectedItem();
            Font current = mainLbl.getFont();
            mainLbl.setFont(new Font(fontName,current.getStyle(),current.getSize()));
        });

        slider = new JSlider(JSlider.HORIZONTAL, 10,100,24);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
//        slider.setMinorTickSpacing(10);
        slider.addChangeListener(e->{
            fontSize = slider.getValue();
            mainLbl.setFont(mainLbl.getFont().deriveFont((float)fontSize));
            sizeTf.setText(""+slider.getValue());
        });

        sizeTf = new JTextField(""+slider.getValue(),3); //2번째 인자에 3을 넣어 3열기준으로 사이즈지정
//        sizeTf.setPreferredSize(new Dimension(40,20)); //new Dimeension으로 사이즈 강제지정 (다른방식)
        sizeTf.addActionListener(e->{ //텍스트필드 액션 리스너
            int v = Integer.parseInt(sizeTf.getText());
            if(  v > 10 && v <100) //최소,최대 범위내라면 세팅
                slider.setValue(v);
            else if( v <= 10 ) // 최소값보다 작으면 최소값으로 강제재지정
                slider.setValue(10);
            else // 최댓값보다 크면 최대값으로 강제 재지정
                slider.setValue(100);
            sizeTf.setText(""+slider.getValue()); //slider는 ChangeListener에게의존중
            // 그 리스너는 슬라이더 값이 실제로 바뀔 때  만 실행되는데 그래서 같은 값으로 clamp 될 땐
            // 리스너가 안돌아서 화면 갱신이안된다,.
            // 위 코드를 추가하지 않았더라면 한번은 텍스트필드가 값을 따라 전환될 것이지만
            // 그 다음부터는 changelistener가 동작하지 않아서 값이 안바뀌는 문제가 발생함
        });

        italicBox = new Checkbox("italic");
        italicBox.addItemListener(e -> {
            if(e.getStateChange()== ItemEvent.SELECTED) { // 선택됐을때
                mainLbl.setFont(mainLbl.getFont().deriveFont(Font.ITALIC));
            }
            if (boldBox.getState()) {
                boldBox.setState(false);
            }
            if(e.getStateChange()==ItemEvent.DESELECTED) { //선택이 풀렸을때 위에서 무조건적으로 다른 체크박스 체크가 풀리니까 추가검증없기 검사
                mainLbl.setFont(mainLbl.getFont().deriveFont(Font.PLAIN));
            }

        });

        boldBox = new Checkbox("Bold");
        boldBox.addItemListener(e->{
            if(e.getStateChange()==ItemEvent.SELECTED) {
                mainLbl.setFont(mainLbl.getFont().deriveFont(Font.BOLD));
            }
            if (italicBox.getState()) {
                italicBox.setState(false);
            }
            if(e.getStateChange()==ItemEvent.DESELECTED) {
                mainLbl.setFont(mainLbl.getFont().deriveFont(Font.PLAIN));
            }

        });

        northPnl.add(fontCombo);
        northPnl.add(slider);
        northPnl.add(sizeTf);
        northPnl.add(italicBox);
        northPnl.add(boldBox);


        mainLbl = new JLabel("자바 코딩의 고수가 되자. I want  be a good Java Programmer");
        mainLbl.setHorizontalAlignment(JLabel.CENTER); //가운데 배치
        mainLbl.setFont(font);

        northWrapper.add(northPnl,BorderLayout.NORTH);
        northWrapper.add(mainLbl,BorderLayout.CENTER);

        c.add(northWrapper, BorderLayout.NORTH);
        setVisible(true);
    }

    static void main() {
        new JSliderEx();
    }
}
