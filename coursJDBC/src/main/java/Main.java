import dao.ContactDAO;
import models.Contact;
import org.hibernate.Session;
import tools.DataConnection;
import tools.HibernateUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public  static void main(String[] args) {
       /* try {
            Connection connection = new DataConnection().getConnection();
            if(connection != null) {
                System.out.println("Connection OK");
            }
        }catch (Exception ex) {
            System.out.println(ex);
        }*/

        /*Contact contact = new Contact("toto", "tata");
        try {
            ContactDAO dao = new ContactDAO();
            dao.save(contact);
            System.out.println(contact.getId());
        }catch (Exception ex) {
            System.out.println(ex);
        }*/

//        try {
//            ContactDAO dao = new ContactDAO();
//            List<Contact> contacts = dao.findAll();
//            Contact contact = dao.find(2);
//        }catch (Exception ex) {
//            System.out.println(ex);
//        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Contact c = new Contact();
        c.setNom("toto");
        c.setPrenom("tata");
        session.save(c);
        session.getTransaction().commit();
        HibernateUtil.closeSessionFactory();
    }
}
