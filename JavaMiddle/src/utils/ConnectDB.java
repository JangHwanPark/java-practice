package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public ConnectDB() {}

    public static Connection initDB() {
        Connection conn = null;

        try {
            // DB 드라이버 등록
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("org.mariadb.jdbc.Driver");

            // DB 연결 객체의 참조값 얻어와서 필드에 담기
            conn = DriverManager.getConnection(
                    System.getenv("DB_URL"),
                    System.getenv("DB_USER"),
                    System.getenv("DB_PASS")
            );
            System.out.println("DB URL: " + System.getenv("DB_URL"));
            System.out.println("DB USER: " + System.getenv("DB_USER"));
            System.out.println("DB PASS: " + System.getenv("DB_PASS"));
            System.out.println("DB Connection Reference Value: " + conn);

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결에 실패했습니다.");
            e.printStackTrace();
        }
        System.out.println("DB 연결 OK");
        return conn;
    }
}