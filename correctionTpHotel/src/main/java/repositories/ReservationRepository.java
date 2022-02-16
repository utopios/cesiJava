package repositories;

import models.Reservation;
import org.hibernate.Session;

import java.util.List;

public class ReservationRepository extends BaseRepository<Reservation> {

    public ReservationRepository(Session session) {
        super(session);
    }

    @Override
    public boolean create(Reservation element) {
        return false;
    }

    @Override
    public Reservation find(int id) {
        return null;
    }

    @Override
    public void delete(Reservation element) {

    }

    @Override
    public void update(Reservation element) {

    }

    @Override
    public List<Reservation> findAll() {
        return null;
    }
}
