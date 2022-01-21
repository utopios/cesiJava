package com.correction.caisse.dao;

import com.correction.caisse.models.Produit;
import com.correction.caisse.tools.DbConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProduitDAO extends BaseDAO<Produit> {
    @Override
    public boolean create(Produit element) throws Exception {
        boolean response = false;
        request = "INSERT INTO produit (titre, prix, stock) values (?,?,?)";
        connection = DbConnection.getConnection();
        preparedStatement = connection.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, element.getTitre());
        preparedStatement.setBigDecimal(2, element.getPrix());
        preparedStatement.setInt(3, element.getStock());
        preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()) {
            element.setNumero(resultSet.getInt(1));
            response = true;
        }
        preparedStatement.close();
        connection.close();
        return response;
    }

    @Override
    public Produit find(int id) throws Exception {
        Produit produit = null;
        request = "SELECT * FROM produit where id = ?";
        connection = DbConnection.getConnection();
        preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1, id);
        preparedStatement.executeQuery();
        resultSet = preparedStatement.getResultSet();
        if(resultSet.next()) {
            produit = new Produit(resultSet.getInt("id"), resultSet.getBigDecimal("prix"), resultSet.getInt("stock"), resultSet.getString("titre"));
        }
        preparedStatement.close();
        connection.close();
        return produit;
    }

    @Override
    public boolean update(Produit element) throws Exception {
        boolean response = false;
        request = "update produit set stock = ? where id = ?";
        connection = DbConnection.getConnection();
        preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1, element.getStock());
        preparedStatement.setInt(2, element.getNumero());
        if(preparedStatement.executeUpdate() > 0) {
            response = true;
        }
        preparedStatement.close();
        connection.close();
        return response;
    }
}
