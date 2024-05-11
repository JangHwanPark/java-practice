package dao;

import models.CustomerDTO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAO {
    private static CustomerDTO selectCustomerResultSet(ResultSet rset) throws SQLException {
        return new CustomerDTO(
                rset.getInt("customer_id"),
                rset.getString("name"),
                rset.getString("email"),
                rset.getString("phone"),
                rset.getString("address"),
                rset.getString("role")
        );
    }

    public static ArrayList<CustomerDTO> selectCustomerAll() throws SQLException {
        ArrayList<CustomerDTO> customers = new ArrayList<>();

        try (Connection conn = ConnProvider.getConnection()) {
            String sql = "SELECT * FROM db2451506_user_management.customer";

            try (Statement pstmt = conn.createStatement(); ResultSet rset = pstmt.executeQuery(sql)) {

                while (rset.next()) {
                    customers.add(selectCustomerResultSet(rset));
                }
            }

            System.out.println("전체 사용자 조회 작업이 완료되었습니다. 연결이 종료되었습니다.");
        } catch (Exception e) {
            e.getStackTrace();
        }
        return customers;
    }

    public static CustomerDTO insertCustomer(CustomerDTO customer) throws SQLException {
        try (Connection conn = ConnProvider.getConnection()) {
            String sql = "INSERT INTO db2451506_user_management.customer (name, email, phone, address, role) VALUES (?, ?, ?, ?, ?)";

            try (Statement pstmt = conn.createStatement()) {
                pstmt.executeUpdate(sql);
            }

            System.out.println("사용자 추가 작업이 완료되었습니다. 연결이 종료되었습니다.");
            JOptionPane.showMessageDialog(null, "사용자 추가 작업이 완료되었습니다.");
        } catch (Exception e) {
            e.getStackTrace();
        }
        return customer;
    }
}