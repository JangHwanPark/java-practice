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
        // ResultSet(쿼리 결과) 객체로부터 데이터를 추출하여 DTO 객체로 변환
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
        String sql = "UPDATE db2451506_user_management.customer SET name = ?, email = ?, phone = ?, address = ? WHERE customer_id = ?";

        try (
                Connection conn = ConnProvider.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            // 파라미터 설정
            pstmt.setString(1, model.getName());
            pstmt.setString(2, model.getEmail());
            pstmt.setString(3, model.getPhone());
            pstmt.setString(4, model.getAddress());
            pstmt.setInt(5, model.getUserId());

            // 쿼리 실행
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("수정된 행의 수: " + rowsAffected);
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            e.getStackTrace();
        }

        // 오류가 발생하거나 쿼리결과가 없다면 null 반환
        return null;
    }

    // TODO: 추상 메서드로 구현
    public CustomerDTO findByProductId(int id) {
        String sql = "SELECT * FROM db2451506_user_management.customer WHERE customer_id = ?";

        // 자동 리소스 관리를 사용해 DB 연결, PreparedStatement 객체 생성 (쿼리 실행)
        try (
                Connection conn = ConnProvider.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            // 파라미터 설정 (? 에 값 할당)
            pstmt.setInt(1, id);

            // 쿼리를 실행하고 결과를 ResultSet(rs)에 저장
            ResultSet rs = pstmt.executeQuery();

            // 결과가 존재하면 DTO 객체로 변환하여 반환
            if (rs.next()) return modelsResultSet(rs);
        } catch (SQLException e) {
            // 쿼리 실행중 오류가 발생하면 메세지 출력
            System.err.println("Error executing query: " + e.getMessage());
            e.getStackTrace();
        }

        // 오류가 발생하거나 쿼리결과가 없다면 null 반환
        return null;
    }

    // 사용자 이름으로 검색
    public CustomerDTO findByCustomerName(String name) {
        String sql = "SELECT * FROM db2451506_user_management.customer WHERE name = ?";

        // 자동 리소스 관리를 사용해 DB 연결, PreparedStatement 객체 생성 (쿼리 실행)
        try (
                Connection conn = ConnProvider.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            // 쿼리 파라미터에 값 할당
            pstmt.setString(1, name);

            // 쿼리 실행 후 결과 ResultSet 객체에 저장
            ResultSet rs = pstmt.executeQuery();

            // 쿼리 결과가 존재한다면 DTO 객체로 변환하여 반환
            if (rs.next()) return modelsResultSet(rs);
        } catch (SQLException e) {
            // 쿼리 실행중 오류가 발생하면 메세지 출력
            System.err.println("Error executing query: " + e.getMessage());
            e.getStackTrace();
        }
        
        // 오류가 발생하거나 쿼리결과가 없다면 null 반환
        return null;
    }
}