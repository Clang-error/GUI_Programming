package ch16;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class JDBC_Ext {
    static String url = "jdbc:mysql://localhost:3306/book_db";
    static String id = "root";
    static String passwd ="YOUR_PASSWORD";
    public static void main() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, id, passwd);
            System.out.println("DB 연결 완료");
        } catch(ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
        } catch(SQLException e) {
            System.out.println("DB 연결 오류");
        }
    }
}
