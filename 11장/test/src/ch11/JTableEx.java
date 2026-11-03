package ch11;

import javax.swing.*;
import java.awt.*;

public class JTableEx extends JFrame {
    Container c = getContentPane();
    String[] colNames = {"ID", "이름", "주소", "연락처"};
    String[][] contents = {
            {"1001", "홍길동", "부산시 남구 신선로 428", "010-6577-0165"},
            {"1002", "전우치", "울산시 중구 태화로 123-4", "010-1234-5678"},
            {"1003", "임꺽정", "지리산 높은 곳", "010-5900-5932"},
            {"1004", "심순애", "양산시 새로지은 좋은 아파트", "010-8376-9332"},
    };
    JTable tableEx;

    public JTableEx() {
        setTitle("JTable Test");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableEx = new JTable(contents,colNames);

        tableEx.setShowGrid(true);
        tableEx.setGridColor(Color.GRAY);

        c.add(new JScrollPane(tableEx));

        setVisible(true);
    }

    static void main() {
        new JTableEx();
    }
}
