import dao.ContactDAO;
import models.Contact;
import tools.DataConnection;

import java.sql.Connection;

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

        Contact contact = new Contact("toto", "tata");
        try {
            ContactDAO dao = new ContactDAO();
            dao.save(contact);
            System.out.println(contact.getId());
        }catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
