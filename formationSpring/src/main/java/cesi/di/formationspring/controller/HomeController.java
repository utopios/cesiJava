package cesi.di.formationspring.controller;

import cesi.di.formationspring.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@ResponseBody
public class HomeController {

    @RequestMapping("/")
    public String getHome(Model model) {
        Person p = new Person("toto", "tata");
        model.addAttribute("person", p);
        return "home";
    }

    @RequestMapping("/second")
    public String getSecond(Model model) {
        return "second";
    }

    @GetMapping("/formPerson")
    public String getForm(Model model) {
        model.addAttribute("person", new Person());
        return "form";
    }

    @PostMapping("/submitForm")
    public String postForm(@ModelAttribute Person person, Model model) {
        model.addAttribute("person", person);
        return "home";
    }
}
