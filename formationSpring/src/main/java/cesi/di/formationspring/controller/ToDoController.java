package cesi.di.formationspring.controller;

import cesi.di.formationspring.model.Todo;
import cesi.di.formationspring.repositories.TodoRepository;
import cesi.di.formationspring.tools.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ToDoController {

    @Autowired
    private TodoRepository _todoRepository;

    /*public ToDoController(TodoRepository todoRepository) {
        _todoRepository = todoRepository;
    }*/

    @RequestMapping("/todos")
    public String getTodos(Model model) {
        /*Session session = HibernateUtil.getSessionFactory().openSession();
        TodoRepository todoRepository = new TodoRepository(session);*/
        List<Todo> todos = _todoRepository.findAll();
        model.addAttribute("todos", todos);
        return  "todos/index";
    }

    /*@RequestMapping("/todos/detail")
    public String getDetail(@RequestParam(name = "content") String content, Model model) {
        Todo todo = new Todo(content);
        model.addAttribute("todo", todo);
        return "todos/detail";
    }

    @GetMapping("/todos/form")
    public String from(Model model) {
        model.addAttribute("todo", new Todo());
        return "todos/form";
    }

    /*@PostMapping("/todos/submitForm")
    public String submitForm(@ModelAttribute Todo todo, Model model) {
        model.addAttribute("todo", todo);
        return "todos/detail";
    }

    @PostMapping("/todos/submitForm")
    public RedirectView submitForm(@ModelAttribute Todo todo, Model model) {
        model.addAttribute("todo", todo);
        return new RedirectView("/todos");
    }*/
}
