package repositories;

import org.hibernate.Session;
import models.Room;
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
        return null;
    }

    @Override
    public void delete(Room element) {

    }

    @Override
    public void update(Room element) {

    }

    @Override
    public List<Room> findAll() {
        return null;
    }
}
