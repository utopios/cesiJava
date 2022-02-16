package repositories;

import org.hibernate.Session;

import java.util.List;

public class RoomRepository extends BaseRepository<RoomRepository>{

    public RoomRepository(Session session) {
        super(session);
    }

    @Override
    public boolean create(RoomRepository element) {
        return false;
    }

    @Override
    public RoomRepository find(int id) {
        return null;
    }

    @Override
    public void delete(RoomRepository element) {

    }

    @Override
    public void update(RoomRepository element) {

    }

    @Override
    public List<RoomRepository> findAll() {
        return null;
    }
}
