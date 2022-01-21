package repositories;

import models.ToDo;
import org.hibernate.Session;

import java.util.List;

public abstract class BaseRepository <T> {

    protected Session session;

    public abstract boolean create(T element);

    public abstract T find(int id);

    public abstract void delete(T element);

    public abstract void update(T element);

    public abstract List<ToDo> findAll();

    protected BaseRepository(Session session) {
        this.session = session;
    }
}
