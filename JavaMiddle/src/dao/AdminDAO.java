package dao;

import dao.abstractDAO.IModelDAO;
import models.AdminDTO;
import java.sql.*;
import java.util.ArrayList;

public class AdminDAO extends IModelDAO<AdminDTO> {
    public AdminDAO() {
        super("db2451506_user_management.admin");
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
    public AdminDTO insertModel(AdminDTO model) {
        return null;
    }

    @Override
    public AdminDTO deleteModel(AdminDTO model) {
        return null;
    }

    @Override
    public AdminDTO updateModel(AdminDTO model) {
        return null;
    }

    public static void main (String[]args) throws SQLException {
        AdminDAO adminDAO = new AdminDAO();
        ArrayList<AdminDTO> admins = adminDAO.getAllModels();
        System.out.println("Retrieved " + admins.size() + " admins:");
        for (AdminDTO admin : admins) {
            System.out.println(admin);
        }
    }
}