package ch11;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JTableAppendEx extends JFrame {
    Container c = getContentPane();
    JPanel northWapper = new JPanel(new BorderLayout());
    JPanel northInsertSec = new JPanel(new GridBagLayout());
    JPanel southBtn = new JPanel(new FlowLayout());
    JTable mainTable;
    DefaultTableModel model; //ADD/INSERT/EDIT/REMOVE 전부 이 모델 통해서 조작 !!

    JTextField idField = new JTextField();
    JTextField nameField = new JTextField();
    JTextField addressField = new JTextField();
    JTextField phoneField = new JTextField();
    JTextField[] Text = {idField,nameField,addressField,phoneField};

    JButton addBtn = new JButton("ADD");
    JButton insertBtn = new JButton("INSERT");
    JButton editBtn = new JButton("EDIT");
    JButton removeBtn = new JButton("REMOVE");
    JButton[] btnText = {addBtn,insertBtn,editBtn,removeBtn};

    public JTableAppendEx() {
        setTitle("JTableAppendEx");
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout());

        String[] colNames = {"ID", "이름", "주소", "연락처"};
        String[][] contents = {
                {"1001", "홍길동", "부산시 남구 신선로 428", "010-6577-0165"},
                {"1002", "전우치", "울산시 중구 태화로 123-4", "010-1234-5678"},
                {"1003", "임꺽정", "지리산 높은 곳", "010-5900-5932"},
                {"1004", "심순애", "양산시 새로지은 좋은 아파트", "010-8376-9332"},
        };
        model = new DefaultTableModel(contents, colNames) { //!!
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //더블클릭해서 셀 직접 수정하는거 막음, 수정은 EDIT버튼으로만
            }
        };
        mainTable = new JTable(model);
        mainTable.setAutoCreateRowSorter(true); //컬럼명 누르면 그 기준으로 정렬되게 !!
        ((DefaultTableCellRenderer) mainTable.getTableHeader().getDefaultRenderer()) //!!
                .setHorizontalAlignment(JLabel.CENTER);

        GridBagConstraints gbc = new GridBagConstraints(); //!!
        gbc.fill = GridBagConstraints.HORIZONTAL; //!!
        double[] weights = {60, 80, 130, 100};  //!!
        for (int i = 0; i<Text.length; i++) { //!!
            gbc.gridx = i;
            gbc.weightx = weights[i];
            northInsertSec.add(Text[i], gbc);
        }
        mainTable.setShowGrid(true);
        mainTable.setGridColor(Color.gray);
        mainTable.getColumnModel().getColumn(0).setPreferredWidth(30);   // ID
        mainTable.getColumnModel().getColumn(1).setPreferredWidth(80);   // 이름
        mainTable.getColumnModel().getColumn(2).setPreferredWidth(150);  // 주소
        mainTable.getColumnModel().getColumn(3).setPreferredWidth(100);  // 전화번호

        for (int i = 0; i<btnText.length; i++) {
            southBtn.add(btnText[i]);
        }

        //행 클릭하면 그 행 데이터를 텍스트필드로 뿌려줌 (수정하려면 여기서 고친 다음 EDIT 눌러야함) !!
        mainTable.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) return;
            int viewRow = mainTable.getSelectedRow();
            if (viewRow == -1) return;
            int row = mainTable.convertRowIndexToModel(viewRow); //정렬된 상태일수있어서 모델 인덱스로 변환
            for (int i = 0; i<Text.length; i++) {
                Text[i].setText((String) model.getValueAt(row, i));
            }
        });

        addBtn.addActionListener(e -> {
            model.addRow(new Object[]{idField.getText(), nameField.getText(), addressField.getText(), phoneField.getText()});
            clearFields();
        });

        insertBtn.addActionListener(e -> {
            Object[] newRow = {idField.getText(), nameField.getText(), addressField.getText(), phoneField.getText()};
            int viewRow = mainTable.getSelectedRow();
            if (viewRow == -1) { //!!
                model.addRow(newRow); //선택된 행 없으면 그냥 맨 아래 추가
            } else {
                int row = mainTable.convertRowIndexToModel(viewRow);
                model.insertRow(row + 1, newRow); //선택된 행 바로 아래에 삽입
            }
            clearFields();
        });

        editBtn.addActionListener(e -> {
            int viewRow = mainTable.getSelectedRow();
            if (viewRow == -1) return; //선택 안된 상태면 수정할 행이 없으니 무시
            int row = mainTable.convertRowIndexToModel(viewRow);
            for (int i = 0; i<Text.length; i++) {
                model.setValueAt(Text[i].getText(), row, i);
            }
            clearFields();
        });

        removeBtn.addActionListener(e -> {
            int viewRow = mainTable.getSelectedRow();
            if (viewRow == -1) return;
            int row = mainTable.convertRowIndexToModel(viewRow);
            model.removeRow(row);
            clearFields();
        });

        northWapper.add(northInsertSec,BorderLayout.NORTH);
        northWapper.add(new JScrollPane(mainTable),BorderLayout.CENTER);
        northWapper.add(southBtn,BorderLayout.SOUTH);

        c.add(northWapper);
        setVisible(true);
    }

    void clearFields() {
        for (JTextField tf : Text) {
            tf.setText("");
        }
        Text[0].requestFocus(); //첫번째 필드로 포커스 이동 (과제 힌트: tf[0].requestFocus())
    }

    static void main() {
        new JTableAppendEx();
    }
}
