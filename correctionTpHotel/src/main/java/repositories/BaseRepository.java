package repositories;

import org.hibernate.Session;

import java.util.List;

public abstract class BaseRepository<T> {
    protected Session _session;
    public BaseRepository(Session session) {
        _session = session;
    }
    public abstract boolean create(T element);

    public abstract T find(int id);

    public abstract void delete(T element) throws Exception;

    public abstract void update(T element) throws Exception;

    public abstract List<T> findAll() throws Exception;
}
