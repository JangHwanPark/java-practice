package models;

import utils.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LexusDAO {
    public List<LexusDTO> getAllLexus() {
        String query = "SELECT * FROM product";
        List<LexusDTO> lexusList = new ArrayList<>();

        try (Connection conn = ConnectDB.initDB();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                LexusDTO car = new LexusDTO(
                        rs.getString("carId"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getString("color"),
                        rs.getString("vin")
                );
                lexusList.add(car);
            }
        } catch (SQLException e) {
            System.out.println("데이터베이스 쿼리 실행 중 오류가 발생했습니다.");
            e.printStackTrace();
        }

        return lexusList;
    }
}