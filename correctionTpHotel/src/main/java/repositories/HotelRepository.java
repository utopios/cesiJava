package repositories;

import models.Hotel;
import models.Room;
import org.hibernate.Session;

import java.util.List;

public class HotelRepository extends BaseRepository<Hotel>{

    public HotelRepository(Session session) {
        super(session);
    }

    @Override
    public boolean create(Hotel element) {
        //Création de l'hôtel
        //Enregistrer un nombre de chambre
        _session.beginTransaction();
        try {
        _session.save(element);
        RoomRepository roomRepository = new RoomRepository(_session);
        for(Room room : element.getRooms()) {
            room.setHotel(element);
            roomRepository.create(room);
        }
        _session.getTransaction().commit();
        }catch (Exception ex) {
            _session.getTransaction().rollback();
        }
        return element.getId() > 0;
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
