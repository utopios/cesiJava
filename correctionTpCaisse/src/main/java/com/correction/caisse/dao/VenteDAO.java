package com.correction.caisse.dao;

import com.correction.caisse.models.Produit;
import com.correction.caisse.models.Vente;
import com.correction.caisse.tools.DbConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class VenteDAO extends BaseDAO<Vente>  {
    @Override
    public boolean create(Vente element) throws Exception {
        boolean response = false;
        request = "INSERT INTO vente (etat, total, paiement, date_et_heure) values (?,?,?,?)";
        connection = DbConnection.getConnection();
        connection.setAutoCommit(false);
        preparedStatement = connection.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, element.getEtat());
        preparedStatement.setBigDecimal(2, element.getTotal());
        preparedStatement.setString(3, element.getPaiement().toString());
        preparedStatement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
        preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()) {
            element.setNumero(resultSet.getInt(1));
            response = true;
        }
        preparedStatement.close();
        if(response) {
            for(Produit p: element.getProduits()) {
                request = "INSERT INTO vente_produit (vente_id, produit_id) values (?, ?)";
                preparedStatement = connection.prepareStatement(request);
                preparedStatement.setInt(1, element.getNumero());
                preparedStatement.setInt(2, p.getNumero());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            connection.commit();
        }
        connection.setAutoCommit(true);
        connection.close();
        return response;
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
