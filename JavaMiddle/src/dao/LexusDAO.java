package dao;

import models.LexusDTO;
import utils.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LexusDAO implements ConnProvider {
    public ArrayList<LexusDTO> getAllLexus() {
        String query = "SELECT * FROM db2451506_user_management.product";
        ArrayList<LexusDTO> lexusList = new ArrayList<>();

        try (Connection conn = ConnProvider.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            System.out.println("DB conn: " + conn);
            System.out.println("DB query: " + query);
            System.out.println("DB rs: " + rs);
            System.out.println("데이터베이스 쿼리를 실행합니다.");

            while (rs.next()) {
                LexusDTO car = new LexusDTO(
                        rs.getString("product_id"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getString("color"),
                        rs.getString("vin")
                );
                System.out.println("car: " + car);
                lexusList.add(car);
            }
        } catch (SQLException e) {
            System.out.println("데이터베이스 쿼리 실행 중 오류가 발생했습니다.");
            e.getStackTrace();
        }

        return lexusList;
    }
}