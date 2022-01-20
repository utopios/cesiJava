package com.correction.caisse.dao;

import com.correction.caisse.models.Vente;

import java.sql.SQLException;

public class VenteDAO extends BaseDAO<Vente>  {
    @Override
    public boolean create(Vente element) throws SQLException {
        return false;
    }

    @Override
    public Vente find(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Vente element) throws SQLException {
        return false;
    }
}
