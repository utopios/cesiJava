package repositories;

import models.Customer;
import org.hibernate.Session;
import customException.NotUsedException;
import java.util.List;

public class CustomerRepository extends BaseRepository<Customer> {

    public CustomerRepository(Session session) {
        super(session);
    }

    @Override
    public boolean create(Customer element) {
        //Création du client
        return false;
    }

    @Override
    public Customer find(int id) {
        //Récupérer client par son id
        return null;
    }

    public List<Customer> findAllByHotelId(int hotelId) {
        return null;
    }

    @Override
    public void delete(Customer element) throws Exception {
        throw new NotUsedException();
    }

    @Override
    public void update(Customer element) throws Exception{
        throw new NotUsedException();
    }

    @Override
    public List<Customer> findAll() throws Exception {
        throw new NotUsedException();
    }


}
