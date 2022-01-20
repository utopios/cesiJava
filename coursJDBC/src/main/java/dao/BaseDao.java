package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public abstract class BaseDao<T> {

    protected Connection connection;

    protected String requestString;

    protected PreparedStatement prepared;

    public abstract T save(T element) throws Exception;

    public abstract T find(int id) throws Exception;

    public  abstract List<T> findAll() throws Exception;


}
