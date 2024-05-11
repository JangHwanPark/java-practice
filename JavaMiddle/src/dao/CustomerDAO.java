package dao;

import dao.InterfaceDAO.ConnProvider;
import dao.abstractDAO.IModelDAO;
import models.AdminDTO;
import models.CustomerDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        return null;
    }

    @Override
    public CustomerDTO updateModel(CustomerDTO model) {
        return null;
    }
}