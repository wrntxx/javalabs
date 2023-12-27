package com.education.ztu;

import java.sql.SQLException;
import java.util.List;

public interface ITable<T> {
    void createTable() throws SQLException;
    T getEntityById(int entityId) throws SQLException;
    List<T> getAllEntities() throws SQLException;
    void insertEntity(T entity) throws SQLException;
    void updateEntity(T entity) throws SQLException;
    void deleteEntity(int entityId) throws SQLException;
    void deleteEntities() throws SQLException;
}