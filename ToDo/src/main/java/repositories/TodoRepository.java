package repositories;

import models.ToDo;
import org.hibernate.Session;

public class TodoRepository extends BaseRepository<ToDo> {

    public TodoRepository(Session session) {
        super(session);
    }
    @Override
    public boolean create(ToDo element) {
        return false;
    }

    @Override
    public ToDo find(int id) {
        return null;
    }

    @Override
    public boolean delete(ToDo element) {
        return false;
    }

    @Override
    public boolean update(ToDo element) {
        return false;
    }
}
