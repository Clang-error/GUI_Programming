package ch11;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class JSliderEx extends JFrame {
    Container c =getContentPane();
    JSlider slider;
    JLabel lbl;
    public JSliderEx() {
        setTitle("JSliderEx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        slider = new JSlider(JSlider.VERTICAL,0,200,100);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.addChangeListener(new ChangeHander());
        lbl=new JLabel("Slider test");

        c.add(slider,BorderLayout.WEST);
        c.add(lbl);
        setSize(500,500);
        setVisible(true);
    }

    class ChangeHander implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            int size = slider.getValue();
            lbl.setFont(new Font("",Font.PLAIN,size));
        }
    }

    static void main() {
        new JSliderEx();
    }
}
