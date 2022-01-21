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

    public abstract boolean create(T element) throws Exception;

    public abstract T find(int id) throws  Exception;

    public abstract boolean update(T element) throws Exception;

}
