package com.correction.caisse.dao;

import com.correction.caisse.models.Produit;

import java.sql.SQLException;

public class ProduitDAO extends BaseDAO<Produit> {
    @Override
    public boolean create(Produit element) throws SQLException {
        return false;
    }

    @Override
    public Produit find(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Produit element) throws SQLException {
        return false;
    }
}
