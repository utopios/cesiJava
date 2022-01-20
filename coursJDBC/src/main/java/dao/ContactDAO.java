package dao;

import models.Contact;
import tools.DataConnection;

import java.util.List;

public class ContactDAO extends BaseDao<Contact> {
    @Override
    public Contact save(Contact element) throws Exception{
        requestString = "INSERT INTO contact (nom, prenom) values (?, ?)";
        connection = new DataConnection().getConnection();
        prepared = connection.prepareStatement(requestString);
        prepared.setString(1, element.getNom());
        prepared.setString(2, element.getPrenom());
        prepared.executeUpdate();
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
