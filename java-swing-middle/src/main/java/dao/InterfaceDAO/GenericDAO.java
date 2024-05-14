package dao.InterfaceDAO;

import java.util.ArrayList;

public interface GenericDAO<T> {
    ArrayList<T> getAllModels();
    T insertModel(T model);
    T deleteModel(T model);
    T updateModel(T model);
}