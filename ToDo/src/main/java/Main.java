import models.ToDo;
import org.hibernate.Session;
import repositories.TodoRepository;
import tools.HibernateUtil;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        TodoRepository todoRepository  = new TodoRepository(session);
        //Test la création.
        /*ToDo todo = new ToDo();
        todo.setTitle("todo 1");
        todo.setDescription("description todo 1");
        todo.setDateTime(LocalDateTime.now());
        todoRepository.create(todo);*/
        //Test la récupération
        //ToDo todo = todoRepository.find(1);
        //todo.setTitle(todo.getTitle() + " done");
        //Mise à jour du todo
        //todoRepository.update(todo);
        //Suppression du todo
        //todoRepository.delete(todo);
        List todos = todoRepository.findAll();
        HibernateUtil.closeSessionFactory();
    }
}
