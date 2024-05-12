package dao;

import dao.InterfaceDAO.ConnProvider;
import dao.abstractDAO.IModelDAO;
import models.CustomerDTO;

import java.sql.*;

public class CustomerDAO extends IModelDAO<CustomerDTO> {
    public CustomerDAO() {
        super("db2451506_user_management.customer");
    }

    @Override
    protected CustomerDTO modelsResultSet(ResultSet rset) throws SQLException {
        return new CustomerDTO(
                rset.getInt("customer_id"),
                rset.getString("name"),
                rset.getString("email"),
                rset.getString("phone"),
                rset.getString("address"),
                rset.getString("role")
        );
    }

    @Override
    public CustomerDTO insertModel(CustomerDTO customer) {
        String sql = """
                INSERT INTO db2451506_user_management.customer (name, email, phone, address, role) VALUES (?, ?, ?, ?, 'customer')
                """;

        try (Connection conn = ConnProvider.getConnection();
             Statement pstmt = conn.createStatement()) {
            pstmt.executeUpdate(sql);
            System.out.println("사용자 추가 작업이 완료되었습니다. 연결이 종료되었습니다.");
        } catch (Exception e) {
            e.getStackTrace();
        }
        return customer;
    }

    @Override
    public CustomerDTO deleteModel(CustomerDTO model) {
        String sql = """
                DELETE FROM db2451506_user_management.orders
                WHERE customer_id = ?;
        """;
        /*IN (SELECT customer_id FROM db2451506_user_management.customer WHERE customer_id = ?);*/
        try (
                Connection conn = ConnProvider.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            // 파라미터 설정
            pstmt.setInt(1, model.getUserId());

            // 쿼리 실행
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("삭제된 행의 수: " + rowsAffected);
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public CustomerDTO updateModel(CustomerDTO model) {
        return null;
    }

    // TODO: 추상 메서드로 구현
    public CustomerDTO findByProductId(int id) {
        String sql = "SELECT * FROM db2451506_user_management.customer WHERE customer_id = ?";
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