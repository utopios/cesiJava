package cesi.di.formationspring.controller;

import cesi.di.formationspring.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ToDoController {

    @RequestMapping("/todos")
    public String getTodos(Model model) {
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("todo 1"));
        todos.add(new Todo("todo 2"));
        todos.add(new Todo("todo 3"));
        model.addAttribute("todos", todos);
        return  "todos/index";
    }

    @RequestMapping("/todos/detail")
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
    }*/

    @PostMapping("/todos/submitForm")
    public RedirectView submitForm(@ModelAttribute Todo todo, Model model) {
        model.addAttribute("todo", todo);
        return new RedirectView("/todos");
    }
}
