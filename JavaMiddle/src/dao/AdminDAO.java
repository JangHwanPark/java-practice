package dao;

import models.AdminDTO;
import java.sql.*;
import java.util.ArrayList;

public class AdminDAO implements ConnProvider{
    private static AdminDTO selectAdminResultSet(ResultSet rset) throws SQLException {
        return new AdminDTO(
            rset.getInt("admin_id"),
            rset.getString("name"),
            rset.getString("email"),
            rset.getString("phone"),
            rset.getString("address"),
            rset.getString("role")
        );
    }

    public static ArrayList<AdminDTO> selectAdminAll() throws SQLException {
        ArrayList<AdminDTO> admins = new ArrayList<>();

        try (Connection conn = ConnProvider.getConnection()) {
            String sql = "SELECT * FROM db2451506_user_management.admin";

            try (Statement pstmt = conn.createStatement();
                ResultSet rset = pstmt.executeQuery(sql)) {

                while (rset.next()) {
                    admins.add(selectAdminResultSet(rset));
                }
            }

            System.out.println("전체 관리자 조회 작업이 완료되었습니다. 연결이 종료되었습니다.");
        } catch (Exception e) {
            e.getStackTrace();
        }
        return admins;
    }

    public static void main (String[]args) throws SQLException {
        ArrayList<AdminDTO> admins = selectAdminAll();
        System.out.println("Retrieved " + admins.size() + " admins:");
        for (AdminDTO admin : admins) {
            System.out.println(admin);
        }
    }
}