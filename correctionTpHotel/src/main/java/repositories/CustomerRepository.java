package repositories;

import models.Customer;
import org.hibernate.Session;

import java.util.List;

public class CustomerRepository extends BaseRepository<Customer> {

    public CustomerRepository(Session session) {
        super(session);
    }

    @Override
    public boolean create(Customer element) {
        return false;
    }

    @Override
    public Customer find(int id) {
        return null;
    }

    @Override
    public void delete(Customer element) {

    }

    @Override
    public void update(Customer element) {

    }

    @Override
    public List<Customer> findAll() {
        return null;
    }
}
