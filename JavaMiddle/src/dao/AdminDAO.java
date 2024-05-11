package dao;

import dao.InterfaceDAO.ConnProvider;
import dao.abstractDAO.IModelDAO;
import models.AdminDTO;
import java.sql.*;
import java.util.ArrayList;

public class AdminDAO extends IModelDAO<AdminDTO> {
    public AdminDAO() {
        super("db2451506_user_management.admin");
    }

    public AdminDTO selectLoginUser(String email, String password) {
        String sql = "SELECT * FROM db2451506_user_management.admin WHERE email = ? AND password = ?";
        try (Connection conn = ConnProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return modelsResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            e.getStackTrace();
        }
        return null;
    }


    @Override
    protected AdminDTO modelsResultSet(ResultSet rset) throws SQLException {
        return new AdminDTO(
            rset.getInt("admin_id"),
            rset.getString("name"),
            rset.getString("email"),
            rset.getString("phone"),
            rset.getString("address"),
            rset.getString("role")
        );
    }

    @Override
    public AdminDTO insertModel(AdminDTO admin) {
        String sql = """
                INSERT INTO db2451506_user_management.admin (name, email, phone, address, role) VALUES (?, ?, ?, ?, 'admin')
                """;

        try (Connection conn = ConnProvider.getConnection();
             Statement pstmt = conn.createStatement()) {
            pstmt.executeUpdate(sql);
            System.out.println("사용자 추가 작업이 완료되었습니다. 연결이 종료되었습니다.");
        } catch (Exception e) {
            e.getStackTrace();
        }
        return admin;
    }

    @Override
    public AdminDTO deleteModel(AdminDTO model) {
        return null;
    }

    @Override
    public AdminDTO updateModel(AdminDTO model) {
        return null;
    }

    public static void main (String[]args) throws SQLException {
        AdminDAO adminDAO = new AdminDAO();
        ArrayList<AdminDTO> admins = adminDAO.getAllModels();
        System.out.println("Retrieved " + admins.size() + " admins:");

        for (AdminDTO admin : admins) {
            System.out.println(admin);
        }
    }
}