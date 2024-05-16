package models;

import utils.ConnProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class IModelDAO<T> implements ConnProvider {
    private String tableName;

    public IModelDAO(String tableName) {
        this.tableName = tableName;
    }

    public ArrayList<T> getAllModels() {
        ArrayList<T> models = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;

        try (Connection conn = ConnProvider.getConnection();
            Statement pstmt = conn.createStatement();
            ResultSet rset = pstmt.executeQuery(sql)) {

            while (rset.next()) {
                models.add(modelsResultSet(rset));
            }

        } catch (Exception e) {
            System.err.println("Error executing query: " + e.getMessage());
            e.getStackTrace();
        }
        return models;
    }

    public abstract T insertModel(T model);

    public abstract T deleteModel(T model);

    public abstract T updateModel(T model);

    public abstract T findByModelId(int userId);

    protected abstract T modelsResultSet(ResultSet rset) throws SQLException;
}