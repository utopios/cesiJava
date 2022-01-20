package dao;

import models.Contact;
import tools.DataConnection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
    public Contact find(int id) throws Exception{
        Contact contact = null;
        connection = new DataConnection().getConnection();
        requestString = "SELECT * FROM contact where id = ?";
        prepared = connection.prepareStatement(requestString);
        prepared.setInt(1,id);
        ResultSet res = prepared.executeQuery();
        if(res.next()) {
            contact = new Contact(res.getInt("id"), res.getString("nom"), res.getString("prenom"));
        }
        prepared.close();
        connection.close();
        return contact;
    }

    @Override
    public List<Contact> findAll() throws  Exception{
        ArrayList<Contact> contacts = new ArrayList<>();
        connection = new DataConnection().getConnection();
        requestString = "SELECT * FROM contact";
        prepared = connection.prepareStatement(requestString);

        ResultSet res = prepared.executeQuery();
        while(res.next()) {
            Contact contact = new Contact(res.getInt("id"), res.getString("nom"), res.getString("prenom"));
            contacts.add(contact);
        }
        prepared.close();
        connection.close();
        return contacts;
    }
}
