package ch09;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class InputEx extends JFrame {
    
    // 💡 각 컴포넌트들을 클래스 멤버(필드)로 구성
    private JLabel lblName;
    private JLabel lblAddress;
    private JLabel lblPhone;
    
    private JTextField tfName;
    private JTextField tfAddress;
    private JTextField tfPhone;
    
    private JButton btnSave;
    private JButton btnCancel;

    public InputEx() {
        // 프레임 기본 설정
        setTitle("정보 입력 폼");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setResizable(false); // 크기 조절 불가 (레이아웃 고정)

        // 메인 컨테이너 및 레이아웃 설정
        Container c = getContentPane();
        c.setLayout(new GridBagLayout());
        // 전체 폼에 안쪽 여백(상:20, 좌:20, 하:15, 우:20) 부여
        ((JComponent)c).setBorder(new EmptyBorder(20, 20, 15, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // 가로로 꽉 채우기
//        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 10, 0);   // 기본 컴포넌트 하단 간격 10px

        // 1. 멤버 변수 초기화 및 배치
        lblName = new JLabel("이 름");
        lblAddress = new JLabel("주 소");
        lblPhone = new JLabel("전화번호  ");

        tfName = new JTextField(10);
        tfAddress = new JTextField(15);
        tfPhone = new JTextField(15);

        btnSave = new JButton("저장");
        btnCancel = new JButton("취소");

        // --- [ 이름 입력 줄 ] ---
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.0;
        c.add(lblName, gbc);
        
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1.0;
        c.add(tfName, gbc);

        // --- [ 주소 입력 줄 ] ---
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.0;
        c.add(lblAddress, gbc);
        
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 1.0;
        c.add(tfAddress, gbc);

        // --- [ 전화번호 입력 줄 ] ---
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.0;
        c.add(lblPhone, gbc);
        
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 1.0;
        c.add(tfPhone, gbc);

        // --- [ 하단 버튼 영역 ] ---
        // 버튼 2개를 가로 박스로 묶고 사이에 간격을 부여
        gbc.anchor = GridBagConstraints.EAST;
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createHorizontalGlue()); // 버튼들을 우측으로 밀어내기
        buttonBox.add(btnSave);
        buttonBox.add(Box.createHorizontalStrut(10)); // 저장-취소 버튼 사이 10px 간격
        buttonBox.add(btnCancel);

        // 버튼 상자 배치 (맨 아래 행 전체 차지)
        gbc.gridx = 0; 
        gbc.gridy = 3; 
        gbc.gridwidth = 2; // 레이블과 텍스트필드 열을 모두 병합
        gbc.weightx = 1.0;
        gbc.insets = new Insets(20, 0, 0, 0); // 버튼 상단에 10px 여백 추가
        c.add(buttonBox, gbc);

        pack(); // 컴포넌트 크기에 맞춰 창 크기 자동 조절
        setLocationRelativeTo(null); // 화면 정중앙에 프레임 배치
        setVisible(true);
    }

    public static void main(String[] args) {
        // 프로그램 실행
        new InputEx();
    }
}
