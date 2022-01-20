package com.correction.caisse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO<T> {
    protected Connection connection;
    protected PreparedStatement preparedStatement;
    protected String request;
    protected ResultSet resultSet;

    public abstract boolean create(T element) throws SQLException;

    public abstract T find(int id) throws  SQLException;

    public abstract boolean update(T element) throws SQLException;

}
