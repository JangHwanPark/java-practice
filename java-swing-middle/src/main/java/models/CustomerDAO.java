package models;

import utils.ConnProvider;

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
        String sql = "INSERT INTO db2451506_user_management.customer (name, email, phone, address, role) VALUES (?, ?, ?, ?, 'customer')";

        try (Connection conn = ConnProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getEmail());
            pstmt.setString(3, customer.getPhone());
            pstmt.setString(4, customer.getAddress());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating customer failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    customer.setUserId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating customer failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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

    @Override
    public CustomerDTO findByModelId(int customerId) {
        String sql = "SELECT * FROM db2451506_user_management.customer WHERE customer_id = ?";
        try (Connection conn = ConnProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new CustomerDTO(
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("role")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            e.printStackTrace();
        }
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
}