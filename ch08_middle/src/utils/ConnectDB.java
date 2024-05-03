package src.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public ConnectDB() {}

    public static Connection initDB() {
        Connection conn;

        try {
            // DB 드라이버 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            // DB 연결 객체의 참조값 얻어와서 필드에 담기
            conn = DriverManager.getConnection(
                    System.getenv("DB_URL"),
                    System.getenv("DB_USER"),
                    System.getenv("DB_PASS")
            );

            if (conn != null) {
                // DebugLog
                System.out.println("DB 연결 OK");
                return conn;
            }

        } catch (ClassNotFoundException e) {
            // DebugLog
            System.out.println("MySQL JDBC 드라이버를 찾을 수 없습니다.");
            e.getStackTrace();
        } catch (SQLException e) {
            // DebugLog
            System.out.println("데이터베이스 연결에 실패했습니다.");
            e.getStackTrace();
        }

        return null;
    }
}