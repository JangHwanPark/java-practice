package dao;

import dao.abstractDAO.IModelDAO;
import models.CustomerDTO;
import models.LexusDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LexusDAO extends IModelDAO<LexusDTO> {
    public LexusDAO() {
        super("db2451506_user_management.product");
    }

    @Override
    protected LexusDTO modelsResultSet(ResultSet rset) throws SQLException {
        return new LexusDTO(
            rset.getInt("product_id"),
            rset.getString("name"),
            rset.getString("description"),
            rset.getInt("price"),
            rset.getString("image"),
            rset.getString("category")
        );
    }

    @Override
    public LexusDTO insertModel(LexusDTO model) {
        return null;
    }

    @Override
    public LexusDTO deleteModel(LexusDTO model) {
        return null;
    }

    @Override
    public LexusDTO updateModel(LexusDTO model) {
        return null;
    }
}