package cesi.di.formationspring.repositories;

import cesi.di.formationspring.model.Todo;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TodoRepository extends BaseRepository<Todo> {

    public TodoRepository(Session session) {
        super(session);
    }
    @Override
    public boolean create(Todo element) {
        session.beginTransaction();
        session.save(element);
        session.getTransaction().commit();
        //session.close();
        return element.getId() > 0;
    }

    @Override
    public Todo find(int id) {
        return (Todo) (session.get(Todo.class, id));
    }

    @Override
    public void delete(Todo element) {
        session.beginTransaction();
        session.delete(element);
        session.getTransaction().commit();
        //session.close();
    }

    @Override
    public void update(Todo element) {
        session.beginTransaction();
        session.update(element);
        session.getTransaction().commit();
    }

    @Override
    public List<Todo> findAll() {
        Query query = session.createQuery("from Todo");
        return query.list();
    }
}
