import javax.swing.*;
import java.awt.*;
import java.lang.management.ManagementFactory;
import java.util.jar.JarEntry;


public class Cputest extends JFrame {
    com.sun.management.OperatingSystemMXBean os =
            (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    GraphPanel graph = new GraphPanel();
    Container c = getContentPane();
    JPanel northPnl = new JPanel(new FlowLayout());
    JPanel stackPnl = new JPanel();
    JLabel cpuLabel = new JLabel("Cpu --%");
    JLabel memLabel = new JLabel("Free --GB");
    JLabel osNameLbl = new JLabel("OS:"+os.getName());
    JLabel osVersionNameLbl = new JLabel("Version:"+os.getVersion());

    int[] history = new int[60];
    Timer timer =new Timer(1000, e->{
        double load = os.getCpuLoad();
        int percent = (int)(load * 100);
        cpuLabel.setText("Cpu "+percent+"%");
        long freeBytes = os.getFreeMemorySize();
        double freeGB = (int)(freeBytes / 1073741824.0 * 10)/10.0;
        memLabel.setText("Free"+freeGB+"GB");
        for (int i = 0; i < history.length - 1; i++) {
            history[i] = history[i + 1];        // 한 칸씩 왼쪽으로 당기기
        }
        history[history.length - 1] = percent;  // 맨 끝 칸에 새 값 넣기
        graph.repaint();
    });


    public Cputest() {
        setTitle("CpuTest");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        stackPnl.setLayout(new BoxLayout(stackPnl,BoxLayout.Y_AXIS));

        northPnl.add(cpuLabel);
        northPnl.add(memLabel);
        stackPnl.add(osNameLbl);
        stackPnl.add(osVersionNameLbl);
        northPnl.add(stackPnl);
        c.add(northPnl,BorderLayout.NORTH);
        c.add(graph,BorderLayout.CENTER);
        timer.start();
        setVisible(true);
    }
    class GraphPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            int w = getWidth();
            int h = getHeight();
            for (int i = 0; i<history.length-1; i++) {
                int x1=i * w / (history.length-1);
                int y1= h- history[i] * h / 100;
                int x2 = (i + 1) * w / (history.length - 1);
                int y2 = h - history[i + 1] * h / 100;
                g.drawLine(x1, y1, x2, y2);
            }
        }
    }

    static void main() {
        new Cputest();

    }
}
