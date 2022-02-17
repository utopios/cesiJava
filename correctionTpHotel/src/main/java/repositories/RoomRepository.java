package repositories;

import customException.NotUsedException;
import org.hibernate.Session;
import models.Room;
import org.hibernate.query.Query;
import tools.RoomStatus;

import java.util.List;

public class RoomRepository extends BaseRepository<Room>{

    public RoomRepository(Session session) {
        super(session);
    }

    @Override
    public boolean create(Room element) {
        _session.save(element);
        return element.getId() > 0;
    }

    @Override
    public Room find(int id) {
        //A ajouter
        return _session.get(Room.class, Integer.valueOf(id));
    }

    @Override
    public void delete(Room element) throws NotUsedException {
        //Non
        throw new NotUsedException();
    }

    @Override
    public void update(Room element) {
        //Pour mettre à jour le statut de la chambre
        _session.beginTransaction();
        _session.update(element);
        _session.getTransaction().commit();
    }

    @Override
    public List<Room> findAll() throws NotUsedException {
        throw new NotUsedException();
    }

    public List<Room> findByHotelId(int hotelId) {
        Query query = _session.createQuery("from Room r where r.hotel.id = :id");
        query.setParameter("id", hotelId);
        return query.list();
    }
    public List<Room> findByHotelIdAndStatus(int hotelId, RoomStatus status) {
        Query query = _session.createQuery("from Room r where r.hotel.id = :id and r.status = :status");
        query.setParameter("id", hotelId);
        query.setParameter("status", status);
        return query.list();

    }
}
