package cesi.di.formationspring.repositories;


import cesi.di.formationspring.tools.ServiceHibernate;
import org.hibernate.Session;

import java.util.List;

public abstract class BaseRepository <T> {

    protected Session session;

    public abstract boolean create(T element);

    public abstract T find(int id);

    public abstract void delete(T element);

    public abstract void update(T element);

    public abstract List<T> findAll();

    protected BaseRepository(ServiceHibernate serviceHibernate) {
        this.session = serviceHibernate.getSession();
    }
}
