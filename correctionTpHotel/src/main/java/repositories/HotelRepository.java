package repositories;

import models.Hotel;
import org.hibernate.Session;

import java.util.List;

public class HotelRepository extends BaseRepository<Hotel>{

    public HotelRepository(Session session) {
        super(session);
    }

    @Override
    public boolean create(Hotel element) {
        return false;
    }

    @Override
    public Hotel find(int id) {
        return null;
    }

    @Override
    public void delete(Hotel element) {

    }

    @Override
    public void update(Hotel element) {

    }

    @Override
    public List<Hotel> findAll() {
        return null;
    }
}
