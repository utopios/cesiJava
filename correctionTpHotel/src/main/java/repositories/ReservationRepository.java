package repositories;

import customException.NotUsedException;
import models.Reservation;
import models.Room;
import org.hibernate.Session;

import java.util.List;

public class ReservationRepository extends BaseRepository<Reservation> {

    public ReservationRepository(Session session) {
        super(session);
    }

    @Override
    public boolean create(Reservation element) {
        //Ajout la réservation dans la base de données
        //mettre à jour les chambres
        _session.beginTransaction();
        _session.save(element);
        RoomRepository roomRepository = new RoomRepository(_session);
        for(Room r : element.getRooms()) {
            roomRepository.update(r);
        }
        _session.getTransaction().commit();
        return element.getId() > 0;
    }

    @Override
    public Reservation find(int id) {
        //Récupérer une réservation par son id;
        return _session.get(Reservation.class, Integer.valueOf(id));
    }

    @Override
    public void delete(Reservation element) throws NotUsedException {
        throw new NotUsedException();
    }

    @Override
    public void update(Reservation element) {
        //Mettre à jour le statut de la réservation
        //Mettre à jour les chambres de la réservation
        _session.beginTransaction();
        _session.update(element);
        RoomRepository roomRepository = new RoomRepository(_session);
        for(Room r: element.getRooms()) {
            roomRepository.update(r);
        }
        _session.getTransaction().commit();
    }

    @Override
    public List<Reservation> findAll() throws NotUsedException {
        throw new NotUsedException();
    }
}
