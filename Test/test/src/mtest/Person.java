package mtest;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Person  extends JFrame {
    Container c = getContentPane();

    JPanel Wrapper = new JPanel(new BorderLayout());
    JPanel nPnl = new JPanel(new FlowLayout());
    JPanel n2Pnl = new JPanel(new FlowLayout());

    JLabel nolbl = new JLabel("No:");
    JLabel namelbl = new JLabel("Name:");
    JLabel addr = new JLabel("Addr:");
    JLabel job = new JLabel("Job:");

    JTextField nofld = new JTextField(5);
    JTextField namefld = new JTextField(6);
    JTextField addrfld = new JTextField(12);
    JTextField[] Text = {nofld,namefld,addrfld};

    JComboBox<String> jobs;

    JButton addBtn = new JButton("추가");
    JButton removeBtn = new JButton("삭제");
    JButton getvalueBtn = new JButton("값가져오기");

    JTable mainTable;
    DefaultTableModel model;

    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

    public Person() {
        String[] colNames = {"No", "Name", "Address", "Job"};
        String[][] contents = {
                {"1001", "윤소라", "부산시 남구 신선로 428", "Professor"},
                {"1002", "전우치", "울산시 중구 태화로 123-4", "Student"},
        };

        model = new DefaultTableModel(contents, colNames) { //!!
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //더블클릭해서 셀 직접 수정하는거 막음, 수정은 EDIT버튼으로만
            }
        };
        setSize(600,400);
        setTitle("테스팅의 행의 갯수:"+model.getRowCount());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] jobname ={"Professor","Student","Staff","Other"};
        jobs = new JComboBox<>(jobname);
        mainTable = new JTable(model);
        mainTable.setAutoCreateRowSorter(true); //컬럼명 누르면 그 기준으로 정렬되게 !!
        ((DefaultTableCellRenderer) mainTable.getTableHeader().getDefaultRenderer()) //!!
                .setHorizontalAlignment(JLabel.CENTER);

        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        mainTable.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        mainTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        mainTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        mainTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        mainTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        mainTable.getColumnModel().getColumn(3).setPreferredWidth(100);

        addBtn.addActionListener(e -> {
            model.addRow(new Object[]{nofld.getText(),namefld.getText(), addrfld.getText(), jobs.getSelectedItem()});
            setTitle("테스팅의 행의 갯수: "+ model.getRowCount()) ;


            //이건 요구에 없는 기능인데 입력하고나서 필드에 입력한 값 삭제하게.
            //기본 직업 세팅은 교수로
            for (int i = 0; i<Text.length; i++) {
                Text[i].setText(null);
            }
            jobs.setSelectedItem("Professor");
        });

        removeBtn.addActionListener(e->{
            int viewRow = mainTable.getSelectedRow();
            if (viewRow == -1) return;
            int row = mainTable.convertRowIndexToModel(viewRow);
            model.removeRow(row);
            setTitle("테스팅의 행의 갯수: "+ model.getRowCount()) ;
        });

        getvalueBtn.addActionListener(e->{
            int viewRow = mainTable.getSelectedRow();
            if (viewRow == -1) return;
            int row = mainTable.convertRowIndexToModel(viewRow); //정렬된 상태일수있어서 모델 인덱스로 변환
            for (int i = 0; i<Text.length; i++) {
                Text[i].setText((String) model.getValueAt(row, i));
            }
            jobs.setSelectedItem(model.getValueAt(row,3));
            setTitle("테스팅의 행의 갯수: "+ model.getRowCount()) ;
        });


        nPnl.add(nolbl);
        nPnl.add(nofld);
        nPnl.add(namelbl);
        nPnl.add(namefld);
        nPnl.add(addr);
        nPnl.add(addrfld);
        nPnl.add(job);
        nPnl.add(jobs);

        n2Pnl.add(addBtn);
        n2Pnl.add(removeBtn);
        n2Pnl.add(getvalueBtn);

        Wrapper.add(nPnl,BorderLayout.NORTH);
        Wrapper.add(n2Pnl,BorderLayout.CENTER);

        c.add(Wrapper, BorderLayout.NORTH);
        c.add(new JScrollPane(mainTable));


        setVisible(true);
    }

    static void main() {
        new Person();
    }
}
