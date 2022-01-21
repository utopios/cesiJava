package repositories;

import models.ToDo;
import org.hibernate.Session;

public class TodoRepository extends BaseRepository<ToDo> {

    public TodoRepository(Session session) {
        super(session);
    }
    @Override
    public boolean create(ToDo element) {
        session.beginTransaction();
        session.save(element);
        session.getTransaction().commit();
        //session.close();
        return element.getId() > 0;
    }

    @Override
    public ToDo find(int id) {
        return (ToDo) (session.get(ToDo.class, id));
    }

    @Override
    public void delete(ToDo element) {
        session.beginTransaction();
        session.delete(element);
        session.getTransaction().commit();
        //session.close();
    }

    @Override
    public void update(ToDo element) {
        session.beginTransaction();
        session.update(element);
        session.getTransaction().commit();
    }
}
