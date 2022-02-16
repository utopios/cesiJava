import dao.ContactDAO;
import models.Adresse;
import models.Contact;
import models.Email;
import org.hibernate.Session;
import org.hibernate.query.Query;
import tools.DataConnection;
import tools.HibernateUtil;

import javax.persistence.EntityManagerFactory;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public  static void main(String[] args) throws Exception {
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
        //save hibernates
        Session session = HibernateUtil.getSessionFactory().openSession();

        //session.beginTransaction();


        /*try {
            Contact c = new Contact();
            c.setNom("toto");
            c.setPrenom("tata");


            Email e1 = new Email("toto@tata.fr");
            c.getEmails().add(e1);
            e1.setContact(c);


            Email e2 = new Email("tata@toto.fr");
            c.getEmails().add(e2);
            e2.setContact(c);

            session.save(c);
            session.save(e1);
            session.save(e2);
            session.getTransaction().commit();
        }catch(Exception ex) {
            session.getTransaction().rollback();
        }*/

       /* Contact c = new Contact();
        c.setNom("toto");
        c.setPrenom("tata");

        Adresse a = new Adresse("rue", "tourcoing", "59200");
        a.getContacts().add(c);
        session.save(a);
        c.getAdresses().add(a);
        session.save(c);
        session.getTransaction().commit();*/
        //Récupération d'une seul valeur
        Contact contact = (Contact) session.get(Contact.class, Integer.valueOf(20));
        contact.setPrenom("titi");

        session.beginTransaction();
        //update
        //session.update(contact);
        //suppression
        session.delete(contact);
        session.getTransaction().commit();

        //Récupération de plusieurs valeurs, HQL
       /* Query query = session.createQuery("select c.nom, c.prenom from Contact as c");
        List result = query.list();*/
        /*Query query = session.createQuery("from Contact as c where c.id > :id");
        query.setInteger("id", 3);
        List result = query.list();
        HibernateUtil.closeSessionFactory();*/


    }
}
