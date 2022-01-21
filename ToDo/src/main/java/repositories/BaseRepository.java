package repositories;

import org.hibernate.Session;

public abstract class BaseRepository <T> {

    protected Session session;

    public abstract boolean create(T element);

    public abstract T find(int id);

    public abstract boolean delete(T element);

    public abstract boolean update(T element);

    protected BaseRepository(Session session) {
        this.session = session;
    }
}
