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
        //Utiliser hibernate pour aller chercher notre hotel
        return _session.get(Hotel.class, Integer.valueOf(id));
    }

    @Override
    public void delete(Hotel element) throws Exception {
        throw new Exception("Not used");
    }

    @Override
    public void update(Hotel element) throws Exception {
        throw new Exception("Not used");
    }

    @Override
    public List<Hotel> findAll() throws Exception {
        throw new Exception("Not used");
    }
}
