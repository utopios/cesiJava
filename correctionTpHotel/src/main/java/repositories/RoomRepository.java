package repositories;

import org.hibernate.Session;
import models.Room;
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
        return null;
    }

    @Override
    public void delete(Room element) {
        //Non
    }

    @Override
    public void update(Room element) {
        //Pour mettre à jour le statut de la chambre
    }

    @Override
    public List<Room> findAll() {
        //Non utilisé
        return null;
    }

    public List<Room> findByHotelId(int hotelId) {
        return null;
    }
    public List<Room> findByHotelIdAndStatus(int hotelId, RoomStatus status) {
        return null;
    }
}
