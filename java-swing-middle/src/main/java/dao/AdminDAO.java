package dao;

import dao.InterfaceDAO.ConnProvider;
import dao.abstractDAO.IModelDAO;
import models.AdminDTO;

import java.sql.*;

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

    public void registerDBUser(String name, String email, String phone, String address, String password, String role) {
        String sql = """
                INSERT INTO db2451506_user_management.admin (name, email, phone, address, role, password) VALUES (?, ?, ?, ?, 'admin', ?)
                """;
        try (Connection conn = ConnProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            String[] values = {name, email, phone, address, password, role};
            for (int i = 0; i < values.length; i++) {
                pstmt.setString(i + 1, values[i]);
            }

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("사용자 추가 작업이 완료되었습니다. 연결이 종료되었습니다.");
            } else {
                System.out.println("사용자 추가 실패.");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public AdminDTO deleteModel(AdminDTO model) {
        return null;
    }

    @Override
    public AdminDTO updateModel(AdminDTO model) {
        return null;
    }

    // TODO: 추상 메서드로 구현
    public AdminDTO findByAdminId(int id) {
        String sql = "SELECT * FROM db2451506_user_management.admin WHERE admin_id = ?";
        try (
                Connection conn = ConnProvider.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, id);
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
}