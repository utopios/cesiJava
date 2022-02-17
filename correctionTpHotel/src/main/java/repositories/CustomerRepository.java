package repositories;

import models.Customer;
import org.hibernate.Session;
import customException.NotUsedException;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerRepository extends BaseRepository<Customer> {

    public CustomerRepository(Session session) {
        super(session);
    }

    @Override
    public boolean create(Customer element) {
        //Création du client
        _session.beginTransaction();
        _session.save(element);
        _session.getTransaction().commit();
        return element.getId() > 0;
    }

    @Override
    public Customer find(int id) {
        //Récupérer client par son id
        return _session.get(Customer.class, Integer.valueOf(id));
    }

    public List<Customer> findAllByHotelId(int hotelId) {
        Query query = _session.createQuery("select h.customers from Hotel h join h.customers where h.id = :id");
        query.setParameter("id", hotelId);
        return query.list();
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
