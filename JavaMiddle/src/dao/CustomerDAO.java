package dao;

import models.AdminDTO;
import models.CustomerDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

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

            try (Statement pstmt = conn.createStatement();
                 ResultSet rset = pstmt.executeQuery(sql)) {

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

    public static void main(String[] args) throws SQLException {
        ArrayList<CustomerDTO> customers = selectCustomerAll();
        System.out.println("Retrieved " + customers.size() + " admins:");
        for (CustomerDTO customer : customers) {
            System.out.println(customer);
        }
    }
}