package dao;

import models.Contact;
import tools.DataConnection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ContactDAO extends BaseDao<Contact> {
    @Override
    public Contact save(Contact element) throws Exception{
        requestString = "INSERT INTO contact (nom, prenom) values (?, ?)";
        connection = new DataConnection().getConnection();
        prepared = connection.prepareStatement(requestString, Statement.RETURN_GENERATED_KEYS);
        prepared.setString(1, element.getNom());
        prepared.setString(2, element.getPrenom());
        prepared.executeUpdate();
        ResultSet res = prepared.getGeneratedKeys();
        if(res.next()) {
            element.setId(res.getInt(1));
        }
        prepared.close();
        connection.close();
        return element;
    }

    @Override
    public Contact find(int id) {
        return null;
    }

    @Override
    public List<Contact> findAll() {
        return null;
    }
}
